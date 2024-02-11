package net.liopyu.example.client.renderer.armor;

import net.minecraft.resources.ResourceLocation;
import net.liopyu.example.item.WolfArmorItem;
import net.liopyu.liolib.GeckoLib;
import net.liopyu.liolib.model.DefaultedItemGeoModel;
import net.liopyu.liolib.renderer.GeoArmorRenderer;
import net.liopyu.liolib.renderer.GeoRenderer;

/**
 * Example {@link GeoRenderer} for the {@link WolfArmorItem} example item
 */
public final class WolfArmorRenderer extends GeoArmorRenderer<WolfArmorItem> {
	public WolfArmorRenderer() {
		super(new DefaultedItemGeoModel<>(new ResourceLocation(GeckoLib.MOD_ID, "armor/wolf_armor")));
	}
}
