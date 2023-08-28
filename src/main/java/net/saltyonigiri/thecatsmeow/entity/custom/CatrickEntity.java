package net.saltyonigiri.thecatsmeow.entity.custom;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.LookAtEntityGoal;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.MerchantEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.village.TradeOffer;
import net.minecraft.world.World;
import net.saltyonigiri.thecatsmeow.gui.CatrickGui;
import net.saltyonigiri.thecatsmeow.gui.CatrickScreen;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.builder.ILoopType;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;


// Define a custom entity class 'CatrickEntity' which extends 'MerchantEntity' and implements 'IAnimatable'
public class CatrickEntity extends MerchantEntity implements IAnimatable {
    // Create an animation factory using GeckoLib utility for this entity
    private final AnimationFactory factory = GeckoLibUtil.createFactory(this);

    // Define constants for animation reset delay and player detection radius
    private final double RESET_DELAY = 5.0; // Delay in seconds before resetting animation
    private static final double DETECTION_RADIUS = 2.0; // Sets the radius a player must enter to be seen by Catrick

    // Track whether a player entered the radius and last time a player entered
    private boolean playerEnteredRadius = false; // Track whether the player entered the radius
    private long lastPlayerEnteredTime = 0L;

    // Constructor for CatrickEntity
    public CatrickEntity(EntityType<? extends MerchantEntity> entityType, World world) {
        super(entityType, world);
    }

    // Method called after using a trade offer
    @Override
    protected void afterUsing(TradeOffer offer) {}

    // Method to fill merchant's trade recipes
    @Override
    protected void fillRecipes() {}

    // Method to create a child entity, not implemented here
    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return null;
    }

    //Open Gui Screen On click
    @Override
    public ActionResult interactAt(PlayerEntity player, Vec3d hitPos, Hand hand) {
        if (hand == Hand.MAIN_HAND && player instanceof ClientPlayerEntity) {
            MinecraftClient.getInstance().setScreen(new CatrickScreen(new CatrickGui()));
            return ActionResult.SUCCESS;
        }
        return super.interactAt(player, hitPos, hand);
    }

    // Method to set the attributes for the entity
    public static DefaultAttributeContainer.Builder setAttributes() {
        return MerchantEntity.createMobAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 100.00) // Nuuu don't kill Catrick
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.0f); // Catrick is a receptionist and doesn't move much
    }

    // Method to initialize entity's goals
    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new LookAtEntityGoal(this, MobEntity.class, 8.0f));
    }

    // Animation predicate method that controls the entity's animations
    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
        AnimationController<E> controller = event.getController();

        // Check if the entity detects a player within the specified radius
        if (detectsPlayer()) {
            long currentTime = System.currentTimeMillis();
            if (!playerEnteredRadius || currentTime - lastPlayerEnteredTime > RESET_DELAY * 1000) {
                // Set first animation to play once and then a second animation to loop
                controller.setAnimation(new AnimationBuilder().addAnimation("animation.kittycat.idle", ILoopType.EDefaultLoopTypes.PLAY_ONCE).addAnimation("animation.kittycat.idleb", ILoopType.EDefaultLoopTypes.LOOP));
                playerEnteredRadius = true;
                lastPlayerEnteredTime = currentTime;
            }
        } else {
            // No player detected, set animation to loop and reset tracking
            playerEnteredRadius = false;
            lastPlayerEnteredTime = 0L;
            controller.setAnimation(new AnimationBuilder().addAnimation("animation.kittycat.idleb", ILoopType.EDefaultLoopTypes.LOOP));
        }

        return PlayState.CONTINUE; // Continue animation
    }

    // Method to check if a player is within the detection radius
    private boolean detectsPlayer() {
        // Expand the entity's bounding box and check if it intersects with any player's bounding box
        Box detectionBox = this.getBoundingBox().expand(DETECTION_RADIUS);
        return world.getPlayers().stream().anyMatch(player -> detectionBox.intersects(player.getBoundingBox()));
    }

    // Register animation controllers using provided animation data
    @Override
    public void registerControllers(AnimationData animationData) {
        animationData.addAnimationController(new AnimationController<>(this, "controller", 0, this::predicate));
    }

    // Return the animation factory associated with this entity
    @Override
    public AnimationFactory getFactory() {
        return factory;
    }
}