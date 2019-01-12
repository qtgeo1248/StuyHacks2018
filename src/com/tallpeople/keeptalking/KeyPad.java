package com.tallpeople.keeptalking;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.tallpeople.keeptalking.Engine;
import com.tallpeople.keeptalking.Module;

import java.util.Random;
import java.lang.Math;
import java.util.ArrayList;
import java.util.Arrays;

public class KeyPad extends Module {

    Character[] ans;
    char key1, key2, key3, key4;
    int strikes;
    int presses;

    public KeyPad(int xOffset, int yOffset) {
        super(xOffset, yOffset);
        strikes = 0;
        presses = 0;
        char[][] key = new char[6][7];
        char[] map1 = {'Ϙ', 'Ѧ', 'ƛ', 'Ϟ', 'Ѭ', 'ϗ', 'Ͽ'};
        char[] map2 = {'Ӭ', 'Ϙ', 'Ͽ', 'Ҩ', '☆', 'ϗ', '¿'};
        char[] map3 = {'©', 'Ѽ', 'Ҩ', 'Җ', 'Ԇ', 'ƛ', '☆'};
        char[] map4 = {'б', '¶', 'Ѣ', 'Ѭ', 'Җ', '¿', 'ټ'};
        char[] map5 = {'Ψ', 'ټ', 'Ѣ', 'Ͼ', '¶', 'Ѯ', '★'};
        char[] map6 = {'б', 'Ӭ', '҂', 'æ', 'Ψ', 'Ҋ', 'Ω'};
        key[0] = map1;
        key[1] = map2;
        key[2] = map3;
        key[3] = map4;
        key[4] = map5;
        key[5] = map6;
        Random gen = new Random();
        char[] ans = key[Math.abs(gen.nextInt()) % 6];
        ArrayList<Character> answer = new ArrayList<Character>();
        for (int i = 0; i < ans.length; i++) {
            answer.add(ans[i]);
        }
        key1 = answer.get(Math.abs(gen.nextInt()) % 7);
        answer.remove(Character.valueOf(key1));
        key2 = answer.get(Math.abs(gen.nextInt()) % 6);
        answer.remove(Character.valueOf(key2));
        key3 = answer.get(Math.abs(gen.nextInt()) % 5);
        answer.remove(Character.valueOf(key3));
        key4 = answer.get(Math.abs(gen.nextInt()) % 4);
        answer.remove(Character.valueOf(key4));
    }
<<<<<<< HEAD
    public void initialize(Engine engine, TerminalScreen screen, TerminalPosition cursorPos) {
    }
    public void run(Engine engine, TerminalScreen screen, TerminalPosition cursorPos) {
=======
    public void initialize(Engine engine, TerminalScreen screen, TerminalPosition pos) {
    }
    public void run(Engine engine, TerminalScreen screen, TerminalPosition pos) {
>>>>>>> master
        TextGraphics textGraphics = screen.newTextGraphics();
        textGraphics.putString(0,0 , screen.getTerminalSize().getColumns() + ", " + screen.getTerminalSize().getRows());
        //System.out.println(new TerminalPosition(XOFFSET + 10, YOFFSET + 10).toString());
        textGraphics.drawRectangle(new TerminalPosition(XOFFSET + 10, YOFFSET + 10), new TerminalSize(15, 15), new TextCharacter(key1).withForegroundColor(TextColor.ANSI.BLACK));
        textGraphics.drawRectangle(new TerminalPosition(XOFFSET + 29, YOFFSET + 10), new TerminalSize(15, 15), new TextCharacter(key2).withForegroundColor(TextColor.ANSI.BLACK));
        textGraphics.drawRectangle(new TerminalPosition(XOFFSET + 10, YOFFSET + 32), new TerminalSize(15, 15), new TextCharacter(key3).withForegroundColor(TextColor.ANSI.BLACK));
        textGraphics.drawRectangle(new TerminalPosition(XOFFSET + 29, YOFFSET + 32), new TerminalSize(15, 15), new TextCharacter(key4).withForegroundColor(TextColor.ANSI.BLACK));
        textGraphics.drawRectangle(new TerminalPosition(XOFFSET + 50, YOFFSET), new TerminalSize(4,4), new TextCharacter('*').withForegroundColor(TextColor.ANSI.BLACK));
        screen.setCharacter(XOFFSET + 17, YOFFSET + 17, new TextCharacter(key1).withForegroundColor(TextColor.ANSI.BLACK));
        screen.setCharacter(XOFFSET + 36, YOFFSET + 17, new TextCharacter(key2).withForegroundColor(TextColor.ANSI.BLACK));
        screen.setCharacter(XOFFSET + 17, YOFFSET + 39, new TextCharacter(key3).withForegroundColor(TextColor.ANSI.BLACK));
        screen.setCharacter(XOFFSET + 36, YOFFSET + 39, new TextCharacter(key4).withForegroundColor(TextColor.ANSI.BLACK));
        if (presses == 4) {
            textGraphics.fillRectangle(new TerminalPosition(XOFFSET + 51, YOFFSET + 1), new TerminalSize(2, 2), new TextCharacter('#').withForegroundColor(TextColor.ANSI.GREEN));
        } else {
            System.out.println(engine.getKey());
            if (KeyType.ArrowUp.equals(engine.getKey())) {
                System.out.println("oooof");
                presses = 4;
            }
        }
    }

    public int getStrikes() {
        return strikes;
    }

    public boolean isDone() {
        return true;
    }
}
