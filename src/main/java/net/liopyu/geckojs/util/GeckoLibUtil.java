package net.liopyu.geckojs.util;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.liopyu.geckojs.constant.DataTickets;
import net.liopyu.geckojs.core.animatable.GeoAnimatable;
import net.liopyu.geckojs.core.animation.Animation;
import net.liopyu.geckojs.core.animation.EasingType;
import net.liopyu.geckojs.core.animatable.instance.AnimatableInstanceCache;
import net.liopyu.geckojs.core.animatable.instance.InstancedAnimatableInstanceCache;
import net.liopyu.geckojs.core.animatable.instance.SingletonAnimatableInstanceCache;
import net.liopyu.geckojs.loading.object.BakedModelFactory;
import net.liopyu.geckojs.network.SerializableDataTicket;

/**
 * Helper class for various GeckoLib-specific functions.
 */
public final class GeckoLibUtil {
	/**
	 * Creates a new AnimatableInstanceCache for the given animatable object
	 * @param animatable The animatable object
	 */
	public static AnimatableInstanceCache createInstanceCache(GeoAnimatable animatable) {
		return createInstanceCache(animatable, !(animatable instanceof Entity) && !(animatable instanceof BlockEntity));
	}

	/**
	 * Creates a new AnimatableInstanceCache for the given animatable object. <br>
	 * Recommended to use {@link GeckoLibUtil#createInstanceCache(GeoAnimatable)} unless you know what you're doing.
	 * @param animatable The animatable object
	 * @param singletonObject Whether the object is a singleton/flyweight object, and uses ints to differentiate animatable instances
	 */
	public static AnimatableInstanceCache createInstanceCache(GeoAnimatable animatable, boolean singletonObject) {
		return singletonObject ? new SingletonAnimatableInstanceCache(animatable) : new InstancedAnimatableInstanceCache(animatable);
	}

	/**
	 * Register a custom {@link net.liopyu.geckojs.core.animation.Animation.LoopType} with GeckoLib,
	 * allowing for dynamic handling of post-animation looping.<br>
	 * <b><u>MUST be called during mod construct</u></b><br>
	 * @param name The name of the {@code LoopType} handler
	 * @param loopType The {@code LoopType} implementation to use for the given name
	 */
	synchronized public static Animation.LoopType addCustomLoopType(String name, Animation.LoopType loopType) {
		return Animation.LoopType.register(name, loopType);
	}

	/**
	 * Register a custom {@link net.liopyu.geckojs.core.animation.EasingType} with GeckoLib,
	 * allowing for dynamic handling of animation transitions and curves.<br>
	 * <b><u>MUST be called during mod construct</u></b><br>
	 * @param name The name of the {@code EasingType} handler
	 * @param easingType The {@code EasingType} implementation to use for the given name
	 */
	synchronized public static EasingType addCustomEasingType(String name, EasingType easingType) {
		return EasingType.register(name, easingType);
	}

	/**
	 * Register a custom {@link net.liopyu.geckojs.loading.object.BakedModelFactory} with GeckoLib,
	 * allowing for dynamic handling of geo model loading.<br>
	 * <b><u>MUST be called during mod construct</u></b><br>
	 * @param namespace The namespace (modid) to register the factory for
	 * @param factory The factory responsible for model loading under the given namespace
	 */
	synchronized public static void addCustomBakedModelFactory(String namespace, BakedModelFactory factory) {
		BakedModelFactory.register(namespace, factory);
	}

	/**
	 * Register a custom {@link SerializableDataTicket} with GeckoLib for handling custom data transmission.<br>
	 * NOTE: You do not need to register non-serializable {@link net.liopyu.geckojs.core.object.DataTicket DataTickets}.
	 * @param dataTicket The SerializableDataTicket to register
	 * @return The dataTicket you passed in
	 */
	synchronized public static <D> SerializableDataTicket<D> addDataTicket(SerializableDataTicket<D> dataTicket) {
		return DataTickets.registerSerializable(dataTicket);
	}
}
