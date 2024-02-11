package net.liopyu.example.client.model.entity;

import net.minecraft.resources.ResourceLocation;
import net.liopyu.example.entity.ReplacedCreeperEntity;
import net.liopyu.liolib.GeckoLib;
import net.liopyu.liolib.model.DefaultedEntityGeoModel;

/**
 * Example {@link net.liopyu.liolib.model.GeoModel} for dynamically replacing an
 * existing entity's renderer with a GeckoLib model (in this case, {@link net.minecraft.world.entity.monster.Creeper}
 * @see net.liopyu.liolib.renderer.GeoReplacedEntityRenderer
 * @see net.liopyu.example.client.renderer.entity.ReplacedCreeperRenderer
 */
public class ReplacedCreeperModel extends DefaultedEntityGeoModel<ReplacedCreeperEntity> {
	public ReplacedCreeperModel() {
		super(new ResourceLocation(GeckoLib.MOD_ID, "creeper"));
	}
}
