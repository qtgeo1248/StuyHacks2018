package com.tallpeople.keeptalking;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;

public class Game implements IGame{

    public final int MODULE_WIDTH = 56;
    public final int MODULE_HEIGHT = 50;

    int cursorX = 1;
    int cursorY = 1;

    public final ViewManager viewManager;

    public Game() {

        Module[] frontModules = new Module[3];
        //frontModules[1] = new Timer(XOffset);

        viewManager = new ViewManager(ViewManager.ViewType.FRONT);
        viewManager.setModules(ViewManager.ViewType.FRONT, frontModules);
    }

    public void initialize(Engine engine, TerminalScreen screen) {
        drawUI(engine, screen);
    }

    public void update(Engine engine, TerminalScreen screen) {
        screen.clear();
        drawUI(engine, screen);
        screen.setCursorPosition(null);
    }

    public void drawUI(Engine engine, TerminalScreen screen) {
        TextGraphics textGraphics = screen.newTextGraphics();
        textGraphics.drawRectangle(new TerminalPosition(0,0), new TerminalSize(56, 50), new TextCharacter('#').withForegroundColor(TextColor.ANSI.YELLOW));
        textGraphics.drawRectangle(new TerminalPosition(56,0), new TerminalSize(56, 50), new TextCharacter('#').withForegroundColor(TextColor.ANSI.YELLOW));
        textGraphics.drawRectangle(new TerminalPosition(112,0), new TerminalSize(56, 50), new TextCharacter('#').withForegroundColor(TextColor.ANSI.YELLOW));

        for (int i = 0; i < viewManager.getCurrentModules().length; i++) {
            Module module = viewManager.getCurrentModules()[i];
            if (module != null) {
                viewManager.getCurrentModules()[i].initialize(engine, screen, new TerminalPosition(cursorX, cursorY));
            }
        }
    }
}
