package com.tallpeople.keeptalking;

import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;

public class Game implements IGame{

    public final int MODULE_WIDTH = 56;
    public final int MODULE_HEIGHT = 50;

    public final ViewManager viewManager;

    public Game() {

        Module[] frontModules = new Module[3];
        //frontModules[1] = new Timer(XOffset);

        viewManager = new ViewManager(ViewManager.ViewType.FRONT);
        viewManager.setModules(ViewManager.ViewType.FRONT, frontModules);
    }

    public void initialize(Engine engine, TerminalScreen screen) {

    }

    public void update(Engine engine, TerminalScreen screen) {
        screen.clear();
        TextGraphics text = screen.newTextGraphics();
        text.putString(0,0 , screen.getTerminalSize().getColumns() + ", " + screen.getTerminalSize().getRows());
        screen.setCursorPosition(null);
    }
}
