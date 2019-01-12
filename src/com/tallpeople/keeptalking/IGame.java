package com.tallpeople.keeptalking;

import com.googlecode.lanterna.screen.TerminalScreen;

public interface IGame {
    public void initialize(Engine engine, TerminalScreen screen);
    public void update(Engine engine, TerminalScreen screen);
}
