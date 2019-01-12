package com.tallpeople.keeptalking;

import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.Terminal;

public abstract class Module {
    private final int XOFFSET;
    private final int YOFFSET;
    private Engine engine;
    private TerminalScreen screen;

    public Module(int XOFFSET, int YOFFSET, Engine engine, TerminalScreen screen) {
        this.XOFFSET = XOFFSET;
        this.YOFFSET = YOFFSET;
        this.engine = engine;
        this.screen = screen;
    }

    public abstract void intialize();
    public abstract void run();
}
