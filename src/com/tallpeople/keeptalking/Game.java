package com.tallpeople.keeptalking;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;

public class Game implements IGame{
    public void initialize(Engine engine, TerminalScreen screen) {

    }

    public void update(Engine engine, TerminalScreen screen) {
        screen.clear();
        TextGraphics text = screen.newTextGraphics();
        text.putString(0,0 , screen.getTerminalSize().getColumns() + ", " + screen.getTerminalSize().getRows());
        screen.setCursorPosition(null);
    }
}
