package com.tallpeople.keeptalking;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.Terminal;

public abstract class Module {
    public final int XOFFSET;
    public final int YOFFSET;

    public Module(int XOFFSET, int YOFFSET) {
        this.XOFFSET = XOFFSET;
        this.YOFFSET = YOFFSET;
    }

    public abstract void initialize(Engine engine, TerminalScreen screen, TerminalPosition cursorPos);
    public abstract void run(Engine engine, TerminalScreen screen, TerminalPosition cursorPos);

    public abstract int getStrikes();
    public abstract boolean isDone();
}
