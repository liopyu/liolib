package net.liopyu.example.client.renderer.block;

import net.liopyu.example.block.entity.FertilizerBlockEntity;
import net.liopyu.example.client.model.block.FertilizerModel;
import net.liopyu.geckojs.renderer.GeoBlockRenderer;

/**
 * Example {@link net.minecraft.world.level.block.entity.BlockEntity} renderer for {@link FertilizerBlockEntity}
 * @see FertilizerModel
 * @see FertilizerBlockEntity
 */
public class FertilizerBlockRenderer extends GeoBlockRenderer<FertilizerBlockEntity> {
	public FertilizerBlockRenderer() {
		super(new FertilizerModel());
	}
}
