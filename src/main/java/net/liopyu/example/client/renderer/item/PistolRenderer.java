package net.liopyu.example.client.renderer.item;

import net.minecraft.resources.ResourceLocation;
import net.liopyu.example.item.PistolItem;
import net.liopyu.geckojs.GeckoLib;
import net.liopyu.geckojs.model.DefaultedItemGeoModel;
import net.liopyu.geckojs.renderer.GeoItemRenderer;

/**
 * Example {@link net.liopyu.geckojs.renderer.GeoItemRenderer} for {@link PistolItem}
 */
public class PistolRenderer extends GeoItemRenderer<PistolItem> {
	public PistolRenderer() {
		super(new DefaultedItemGeoModel<>(new ResourceLocation(GeckoLib.MOD_ID, "pistol")));
	}
}