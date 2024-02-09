package net.liopyu.example.client.renderer.entity;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.liopyu.example.client.model.entity.BikeModel;
import net.liopyu.example.entity.BikeEntity;
import net.liopyu.geckojs.renderer.GeoEntityRenderer;

/**
 * Example {@link net.liopyu.geckojs.renderer.GeoRenderer} for {@link BikeEntity}
 * @see BikeModel
 */
public class BikeRenderer extends GeoEntityRenderer<BikeEntity> {
	public BikeRenderer(EntityRendererProvider.Context context) {
		super(context, new BikeModel());
	}
}
