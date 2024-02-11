/*
 * Copyright (c) 2020.
 * Author: Bernie G. (Gecko)
 */

package net.liopyu.liolib.core.keyframe.event;

import net.liopyu.liolib.core.animatable.GeoAnimatable;
import net.liopyu.liolib.core.animation.AnimationController;
import net.liopyu.liolib.core.keyframe.event.data.SoundKeyframeData;

/**
 * The {@link KeyFrameEvent} specific to the {@link AnimationController#soundKeyframeHandler}.<br>
 * Called when a sound instruction keyframe is encountered
 */
public class SoundKeyframeEvent<T extends GeoAnimatable> extends KeyFrameEvent<T, SoundKeyframeData> {
	/**
	 * This stores all the fields that are needed in the AnimationTestEvent
	 *
	 * @param entity        the entity
	 * @param animationTick The amount of ticks that have passed in either the
	 *                      current transition or animation, depending on the
	 *                      controller's AnimationState.
	 * @param controller    the controller
	 */
	public SoundKeyframeEvent(T entity, double animationTick, AnimationController<T> controller, SoundKeyframeData keyFrameData) {
		super(entity, animationTick, controller, keyFrameData);
	}

	@Override
	public SoundKeyframeData getKeyframeData() {
		return super.getKeyframeData();
	}
}
