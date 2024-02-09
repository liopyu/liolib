package net.liopyu.example.client.renderer.block;

import net.liopyu.example.block.entity.GeckoHabitatBlockEntity;
import net.liopyu.example.client.model.block.GeckoHabitatModel;
import net.liopyu.geckojs.renderer.GeoBlockRenderer;

/**
 * Example {@link net.minecraft.world.level.block.entity.BlockEntity} renderer for {@link GeckoHabitatBlockEntity}
 * @see GeckoHabitatModel
 * @see GeckoHabitatBlockEntity
 */
public class GeckoHabitatBlockRenderer extends GeoBlockRenderer<GeckoHabitatBlockEntity> {
	public GeckoHabitatBlockRenderer() {
		super(new GeckoHabitatModel());
	}
}
