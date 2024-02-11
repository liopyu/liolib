package net.liopyu.example.client.model.entity;

import net.minecraft.resources.ResourceLocation;
import net.liopyu.example.client.renderer.entity.MutantZombieRenderer;
import net.liopyu.example.entity.DynamicExampleEntity;
import net.liopyu.liolib.GeckoLib;
import net.liopyu.liolib.model.DefaultedEntityGeoModel;
import net.liopyu.liolib.model.GeoModel;

/**
 * Example {@link GeoModel} for the {@link DynamicExampleEntity}
 * @see MutantZombieRenderer
 */
public class MutantZombieModel extends DefaultedEntityGeoModel<DynamicExampleEntity> {
	public MutantZombieModel() {
		super(new ResourceLocation(GeckoLib.MOD_ID, "mutant_zombie"));
	}
}