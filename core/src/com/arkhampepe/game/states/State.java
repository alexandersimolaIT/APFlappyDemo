package com.arkhampepe.game.states;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;

public abstract class State {
    protected OrthographicCamera cam; // needed to locate a position in the world
    protected Vector3 mouse;
    protected GameStateManager gsm; // a way to manage our state, we can put a state on top of another, like a pause state on top of the game

    public State(GameStateManager gsm) {
        this.gsm = gsm;
        cam = new OrthographicCamera();
        mouse = new Vector3();


    }

    public abstract void handleInput();
    public abstract void update(float dt);
    public abstract void render(SpriteBatch sb); // a container for everything we need to render, so that everything is rendered at the same time
    public abstract void dispose();
}
