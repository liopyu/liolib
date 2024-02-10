package net.liopyu.example.client.renderer.item;

import net.minecraft.resources.ResourceLocation;
import net.liopyu.example.item.JackInTheBoxItem;
import net.liopyu.geckojs.GeckoLib;
import net.liopyu.geckojs.model.DefaultedItemGeoModel;
import net.liopyu.geckojs.renderer.GeoItemRenderer;

/**
 * Example {@link net.liopyu.geckojs.renderer.GeoItemRenderer} for {@link JackInTheBoxItem}
 */
public class JackInTheBoxRenderer extends GeoItemRenderer<JackInTheBoxItem> {
	public JackInTheBoxRenderer() {
		super(new DefaultedItemGeoModel<>(new ResourceLocation(GeckoLib.MOD_ID, "jack_in_the_box")));
	}
}
