/*
 * Copyright (c) 2020.
 * Author: Bernie G. (Gecko)
 */

package net.liopyu.example;

import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.world.entity.EntityType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.liopyu.example.client.renderer.block.FertilizerBlockRenderer;
import net.liopyu.example.client.renderer.block.GeckoHabitatBlockRenderer;
import net.liopyu.example.client.renderer.entity.BikeRenderer;
import net.liopyu.example.client.renderer.entity.CoolKidRenderer;
import net.liopyu.example.client.renderer.entity.ParasiteRenderer;
import net.liopyu.example.client.renderer.entity.RaceCarRenderer;
import net.liopyu.example.registry.BlockEntityRegistry;
import net.liopyu.example.registry.BlockRegistry;
import net.liopyu.example.registry.EntityRegistry;
import net.liopyu.geckojs.GeckoLib;

@Mod.EventBusSubscriber(modid = GeckoLib.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public final class ClientListener {

	@SubscribeEvent
	public static void registerRenderers(final EntityRenderersEvent.RegisterRenderers event) {
		if (GeckoLibMod.shouldRegisterExamples()) {
			event.registerEntityRenderer(EntityRegistry.BIKE.get(), BikeRenderer::new);
			event.registerEntityRenderer(EntityRegistry.RACE_CAR.get(), RaceCarRenderer::new);
			event.registerEntityRenderer(EntityRegistry.PARASITE.get(), ParasiteRenderer::new);
			event.registerEntityRenderer(EntityRegistry.COOL_KID.get(), CoolKidRenderer::new);

			event.registerBlockEntityRenderer(BlockEntityRegistry.GECKO_HABITAT.get(), context -> new GeckoHabitatBlockRenderer());
			event.registerBlockEntityRenderer(BlockEntityRegistry.FERTILIZER_BLOCK.get(), context -> new FertilizerBlockRenderer());
		}
	}


}