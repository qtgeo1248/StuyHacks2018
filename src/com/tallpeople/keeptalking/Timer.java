package com.tallpeople.keeptalking;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;
import org.w3c.dom.Text;

public class Timer extends Module {

    private double timeLeft = 150;

    private int strikes = 0;

    boolean win = false;

    public Timer(int XOFFSET, int YOFFSET) {
        super(XOFFSET, YOFFSET);
    }

    @Override
    public void initialize(Engine engine, TerminalScreen screen, TerminalPosition cursorPos) {

    }

    @Override
    public void run(Engine engine, TerminalScreen screen, TerminalPosition cursorPos) {
        timeLeft -= engine.deltaTime();
        double tempTime = Math.max(0, timeLeft);
        int seconds = (int) (tempTime % 60);
        int minutes = (int) (tempTime / 60);
        TextGraphics textGraphics = screen.newTextGraphics();
        textGraphics.drawRectangle(new TerminalPosition(23+XOFFSET, 29+YOFFSET), new TerminalSize(7, 3), new TextCharacter('#').withForegroundColor(TextColor.ANSI.YELLOW));
        textGraphics.setForegroundColor(TextColor.ANSI.RED);
        textGraphics.putString(new TerminalPosition(24 + XOFFSET, 30 + YOFFSET), String.format("%02d", minutes) + ":" + String.format("%02d", seconds));

        if (win) {
            textGraphics.putString(new TerminalPosition(22 + XOFFSET, 30 + YOFFSET), "BOMB DEFUSED!");
        } else if (timeLeft <= 0) {

            textGraphics.putString(new TerminalPosition(22 + XOFFSET, 30 + YOFFSET), "GAME OVER!");
        }

        textGraphics.setForegroundColor(TextColor.ANSI.DEFAULT);
    }

    @Override
    public boolean isDone() {
        return false;
    }

    @Override
    public int getStrikes() {
        return 0;
    }

    public void setStrikes(int strikes) {
        this.strikes = strikes;
    }

    public void win() {
        win = true;
    }
}
