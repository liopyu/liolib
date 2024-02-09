package net.liopyu.example.client.model.entity;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.liopyu.example.client.renderer.entity.ParasiteRenderer;
import net.liopyu.example.entity.ParasiteEntity;
import net.liopyu.geckojs.GeckoLib;
import net.liopyu.geckojs.model.DefaultedEntityGeoModel;
import net.liopyu.geckojs.model.GeoModel;

/**
 * Example {@link GeoModel} for the {@link ParasiteEntity}
 * @see ParasiteRenderer
 */
public class ParasiteModel extends DefaultedEntityGeoModel<ParasiteEntity> {
	public ParasiteModel() {
		super(new ResourceLocation(GeckoLib.MOD_ID, "parasite"));
	}

	// We want our model to render using the translucent render type
	@Override
	public RenderType getRenderType(ParasiteEntity animatable, ResourceLocation texture) {
		return RenderType.entityTranslucent(getTextureResource(animatable));
	}
}