package com.tallpeople.keeptalking;

import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.Terminal;

public abstract class Module {
    public final int XOFFSET;
    public final int YOFFSET;

    public Module(int XOFFSET, int YOFFSET) {
        this.XOFFSET = XOFFSET;
        this.YOFFSET = YOFFSET;
    }

    public abstract void intialize(Engine engine, TerminalScreen screen);
    public abstract void run(Engine engine, TerminalScreen screen);
}
