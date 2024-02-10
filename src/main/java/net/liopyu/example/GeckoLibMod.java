/*
 * Copyright (c) 2020.
 * Author: Bernie G. (Gecko)
 */

package net.liopyu.example;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.liopyu.example.registry.*;
import net.liopyu.geckojs.GeckoLib;

@EventBusSubscriber
@Mod(GeckoLib.MOD_ID)
public final class GeckoLibMod {
	public static CreativeModeTab geckolibItemGroup;
	public static final String DISABLE_EXAMPLES_PROPERTY_KEY = "geckojs.disable_examples";

	public GeckoLibMod() {
		GeckoLib.initialize();

		if (shouldRegisterExamples()) {
			IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
			EntityRegistry.ENTITIES.register(bus);
			ItemRegistry.ITEMS.register(bus);
			BlockEntityRegistry.TILES.register(bus);
			BlockRegistry.BLOCKS.register(bus);
			SoundRegistry.SOUNDS.register(bus);
			geckolibItemGroup = new CreativeModeTab(CreativeModeTab.getGroupCountSafe(), "geckojs") {
				@Override
				public ItemStack makeIcon() {
					return new ItemStack(ItemRegistry.JACK_IN_THE_BOX.get());
				}
			};
		}
	}



	/**
	 * By default, GeckoLib will register and activate several example entities,
	 * items, and blocks when in dev.<br>
	 * These examples are <u>not</u> present when in a production environment
	 * (normal players).<br>
	 * This can be disabled by setting the
	 * {@link GeckoLibMod#DISABLE_EXAMPLES_PROPERTY_KEY} to false in your run args
	 */
	static boolean shouldRegisterExamples() {
		return true;//!FMLEnvironment.production && !Boolean.getBoolean(DISABLE_EXAMPLES_PROPERTY_KEY);
	}
}
