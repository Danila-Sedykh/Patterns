package org.example.state;

import java.awt.*;

public class StateTest implements State {
    private State state = new BreakState();

    @Override
    public void doAction() {
        this.state.doAction();
    }

    @Override
    public Image getImage() {
        return state.getImage();
    }

    public void setState(State state) {
        this.state = state;
    }
}
