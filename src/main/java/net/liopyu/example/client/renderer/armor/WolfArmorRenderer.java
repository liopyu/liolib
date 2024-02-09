package net.liopyu.example.client.renderer.armor;

import net.minecraft.resources.ResourceLocation;
import net.liopyu.example.item.WolfArmorItem;
import net.liopyu.geckojs.GeckoLib;
import net.liopyu.geckojs.model.DefaultedItemGeoModel;
import net.liopyu.geckojs.renderer.GeoArmorRenderer;
import net.liopyu.geckojs.renderer.GeoRenderer;

/**
 * Example {@link GeoRenderer} for the {@link WolfArmorItem} example item
 */
public final class WolfArmorRenderer extends GeoArmorRenderer<WolfArmorItem> {
	public WolfArmorRenderer() {
		super(new DefaultedItemGeoModel<>(new ResourceLocation(GeckoLib.MOD_ID, "armor/wolf_armor")));
	}
}
