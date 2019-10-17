package com.arkhampepe.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class Animation {
    private Array<TextureRegion> frames;
    private float maxFrameTime;
    private float currentFrameTime; // time that the animation has been in the current frame
    private int frameCount; // num of frames in this animation
    private int frame; // the index of the currently displayed frame

    public Animation(Texture texture, int frameCount, float cycleTime) {
        this(new TextureRegion(texture), frameCount, cycleTime);
    }
    public Animation(TextureRegion region, int frameCount, float cycleTime) {
        frames = new Array<TextureRegion>();
        int frameWidth = region.getRegionWidth() / frameCount;
        for (int i = 0; i < frameCount; i++) {
            frames.add(new TextureRegion(region, i * frameWidth, 0, frameWidth, region.getRegionHeight()));
        }
        this.frameCount = frameCount;
        maxFrameTime = cycleTime / frameCount;
        frame = 0;
    }

    public void update(float dt) {
        currentFrameTime += dt;
        if (currentFrameTime > maxFrameTime && frame < frameCount - 1) {
            frame++;
            currentFrameTime = 0;
        }
        /*if (frame >= frameCount) {
            frame = 0;
        }*/
    }

    public void reset() {
        frame = 0;
    }

    public TextureRegion getFrame() {
        return frames.get(frame);
    }
}
