package com.tallpeople.keeptalking;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.TerminalScreen;

import java.io.IOException;

public class Game implements IGame{

    public final int MODULE_WIDTH = 56;
    public final int MODULE_HEIGHT = 50;

    int cursorX = 1;
    int cursorY = 1;

    public final ViewManager viewManager;

    public Game() {

        Module[] frontModules = new Module[3];
        frontModules[0] = new WhosOnFirst(1, 1);
        frontModules[2] = new Timer(MODULE_WIDTH + 2, 1);
        frontModules[1] = new KeyPad(MODULE_WIDTH * 1 + 1, 1);

        viewManager = new ViewManager(ViewManager.ViewType.FRONT);
        viewManager.setModules(ViewManager.ViewType.FRONT, frontModules);
    }

    public void initialize(Engine engine, TerminalScreen screen) {
        drawUI(engine, screen, true);
    }

    public void update(Engine engine, TerminalScreen screen) {
        screen.clear();
        drawUI(engine, screen, false);

        //System.out.println(engine.getCharacter());

        if ("w".equalsIgnoreCase(engine.getCharacter())) {
            cursorY-=1;
        } else if ("s".equalsIgnoreCase(engine.getCharacter())) {
            cursorY+=1;
        } else if ("a".equalsIgnoreCase(engine.getCharacter())) {
            cursorX-=1;
        } else if ("d".equalsIgnoreCase(engine.getCharacter())) {
            cursorX+=1;
        }

        if (KeyType.Enter.equals(engine.getKey())) {
            try {
                screen.getTerminal().bell();
            }
            catch (IOException e) {
                System.err.println(e);
            }
        }

        cursorX = Math.max(0, Math.min(cursorX, screen.getTerminalSize().getColumns() - 1));
        cursorY = Math.max(0, Math.min(cursorY, screen.getTerminalSize().getRows() - 1));
        TextGraphics textGraphics = screen.newTextGraphics();
        textGraphics.setCharacter(new TerminalPosition(cursorX, cursorY), new TextCharacter('⬛').withForegroundColor(TextColor.ANSI.RED));

        screen.setCursorPosition(new TerminalPosition(0,0));
    }

    public void drawUI(Engine engine, TerminalScreen screen, boolean isInit) {
        TextGraphics textGraphics = screen.newTextGraphics();
        textGraphics.drawRectangle(new TerminalPosition(0,0), new TerminalSize(56, 50), new TextCharacter('#').withForegroundColor(TextColor.ANSI.YELLOW));
        textGraphics.drawRectangle(new TerminalPosition(56,0), new TerminalSize(56, 50), new TextCharacter('#').withForegroundColor(TextColor.ANSI.YELLOW));
        textGraphics.drawRectangle(new TerminalPosition(112,0), new TerminalSize(56, 50), new TextCharacter('#').withForegroundColor(TextColor.ANSI.YELLOW));

        for (int i = 0; i < viewManager.getCurrentModules().length; i++) {
            Module module = viewManager.getCurrentModules()[i];
            if (module != null) {
                if (isInit) {
                    viewManager.getCurrentModules()[i].initialize(engine, screen, new TerminalPosition(cursorX, cursorY));
                } else {
                    viewManager.getCurrentModules()[i].run(engine, screen, new TerminalPosition(cursorX, cursorY));
                }
            }
        }
    }
}
