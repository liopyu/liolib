package net.liopyu.example.client.model.entity;

import net.minecraft.resources.ResourceLocation;
import net.liopyu.example.entity.DynamicExampleEntity;
import net.liopyu.geckojs.GeckoLib;
import net.liopyu.geckojs.model.DefaultedEntityGeoModel;
import net.liopyu.geckojs.model.GeoModel;

/**
 * Example {@link GeoModel} for the {@link DynamicExampleEntity}
 * @see net.liopyu.example.client.renderer.entity.GremlinRenderer
 */
public class GremlinModel extends DefaultedEntityGeoModel<DynamicExampleEntity> {
	public GremlinModel() {
		super(new ResourceLocation(GeckoLib.MOD_ID, "gremlin"));
	}
}