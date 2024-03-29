package net.liopyu.liolib.animatable;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.network.PacketDistributor;
import net.liopyu.liolib.LioLib;
import net.liopyu.liolib.core.animatable.GeoAnimatable;
import net.liopyu.liolib.core.animation.AnimatableManager;
import net.liopyu.liolib.network.GeckoLibNetwork;
import net.liopyu.liolib.network.SerializableDataTicket;
import net.liopyu.liolib.network.packet.BlockEntityAnimDataSyncPacket;
import net.liopyu.liolib.network.packet.BlockEntityAnimTriggerPacket;
import net.liopyu.liolib.util.RenderUtils;

import javax.annotation.Nullable;

/**
 * The {@link GeoAnimatable} interface specific to {@link BlockEntity BlockEntities}
 * @see <a href="https://github.com/bernie-g/geckolib/wiki/Block-Animations">GeckoLib Wiki - Block Animations</a>
 */
public interface GeoBlockEntity extends GeoAnimatable {
	/**
	 * Get server-synced animation data via its relevant {@link SerializableDataTicket}.<br>
	 * Should only be used on the <u>client-side</u>.<br>
	 * <b><u>DO NOT OVERRIDE</u></b>
	 * @param dataTicket The data ticket for the data to retrieve
	 * @return The synced data, or null if no data of that type has been synced
	 */
	@Nullable
	default <D> D getAnimData(SerializableDataTicket<D> dataTicket) {
		return getAnimatableInstanceCache().getManagerForId(0).getData(dataTicket);
	}

	/**
	 * Saves an arbitrary piece of data to this animatable's {@link AnimatableManager}.<br>
	 * <b><u>DO NOT OVERRIDE</u></b>
	 * @param dataTicket The DataTicket to sync the data for
	 * @param data The data to sync
	 */
	default <D> void setAnimData(SerializableDataTicket<D> dataTicket, D data) {
		BlockEntity blockEntity = (BlockEntity)this;
		Level level = blockEntity.getLevel();

		if (level == null) {
			LioLib.LOGGER.error("Attempting to set animation data for BlockEntity too early! Must wait until after the BlockEntity has been set in the world. (" + blockEntity.getClass().toString() + ")");

			return;
		}

		if (level.isClientSide()) {
			getAnimatableInstanceCache().getManagerForId(0).setData(dataTicket, data);
		}
		else {
			BlockPos pos = blockEntity.getBlockPos();

			GeckoLibNetwork.send(new BlockEntityAnimDataSyncPacket<>(pos, dataTicket, data), PacketDistributor.TRACKING_CHUNK.with(() -> level.getChunkAt(pos)));
		}
	}

	/**
	 * Trigger an animation for this BlockEntity, based on the controller name and animation name.<br>
	 * <b><u>DO NOT OVERRIDE</u></b>
	 * @param controllerName The name of the controller name the animation belongs to, or null to do an inefficient lazy search
	 * @param animName The name of animation to trigger. This needs to have been registered with the controller via {@link net.liopyu.liolib.core.animation.AnimationController#triggerableAnim AnimationController.triggerableAnim}
	 */
	default void triggerAnim(@Nullable String controllerName, String animName) {
		BlockEntity blockEntity = (BlockEntity)this;
		Level level = blockEntity.getLevel();

		if (level == null) {
			LioLib.LOGGER.error("Attempting to trigger an animation for a BlockEntity too early! Must wait until after the BlockEntity has been set in the world. (" + blockEntity.getClass().toString() + ")");

			return;
		}

		if (level.isClientSide()) {
			getAnimatableInstanceCache().getManagerForId(0).tryTriggerAnimation(controllerName, animName);
		}
		else {
			BlockPos pos = blockEntity.getBlockPos();

			GeckoLibNetwork.send(new BlockEntityAnimTriggerPacket<>(pos, controllerName, animName), PacketDistributor.TRACKING_CHUNK.with(() -> level.getChunkAt(pos)));
		}
	}

	/**
	 * Returns the current age/tick of the animatable instance.<br>
	 * By default this is just the animatable's age in ticks, but this method allows for non-ticking custom animatables to provide their own values
	 * @param blockEntity The BlockEntity representing this animatable
	 * @return The current tick/age of the animatable, for animation purposes
	 */
	@Override
	default double getTick(Object blockEntity) {
		return RenderUtils.getCurrentTick();
	}
}
