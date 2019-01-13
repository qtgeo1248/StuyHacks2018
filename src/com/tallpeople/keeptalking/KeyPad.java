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
        char[] ans2 = key[Math.abs(gen.nextInt()) % 6];
        ArrayList<Character> answer = new ArrayList<Character>();
        ArrayList<Character> actual = new ArrayList<Character>();
        for (int i = 0; i < ans2.length; i++) {
            answer.add(ans2[i]);
            actual.add(' ');
        }
        //ans = new char[4];
        ans = new Character[4];
        key1 = answer.get(Math.abs(gen.nextInt()) % 7);
        actual.set(answer.indexOf(key1), key1);
        answer.remove(Character.valueOf(key1));
        key2 = answer.get(Math.abs(gen.nextInt()) % 6);
        actual.set(answer.indexOf(key2), key2);
        answer.remove(Character.valueOf(key2));
        key3 = answer.get(Math.abs(gen.nextInt()) % 5);
        actual.set(answer.indexOf(key3), key3);
        answer.remove(Character.valueOf(key3));
        key4 = answer.get(Math.abs(gen.nextInt()) % 4);
        actual.set(answer.indexOf(key4), key4);
        answer.remove(Character.valueOf(key4));
        for (int i = 0; i < actual.size(); i++) {
            if (actual.get(i) == ' ') {
                actual.remove(i);
                i--;
            }
        }
        for (int i = 0; i < ans.length; i++) {
            ans[i] = actual.get(i);
        }
        System.out.println(ans);
    }
    public void initialize(Engine engine, TerminalScreen screen, TerminalPosition cursorPos) {
    }
    public void run(Engine engine, TerminalScreen screen, TerminalPosition cursorPos) {
        TextGraphics textGraphics = screen.newTextGraphics();
        //textGraphics.putString(0,0 , screen.getTerminalSize().getColumns() + ", " + screen.getTerminalSize().getRows());
        //System.out.println(new TerminalPosition(XOFFSET + 10, YOFFSET + 10).toString());
        textGraphics.drawRectangle(new TerminalPosition(XOFFSET + 10, YOFFSET + 10), new TerminalSize(15, 15), new TextCharacter(key1).withForegroundColor(TextColor.ANSI.WHITE));
        textGraphics.drawRectangle(new TerminalPosition(XOFFSET + 29, YOFFSET + 10), new TerminalSize(15, 15), new TextCharacter(key2).withForegroundColor(TextColor.ANSI.WHITE));
        textGraphics.drawRectangle(new TerminalPosition(XOFFSET + 10, YOFFSET + 32), new TerminalSize(15, 15), new TextCharacter(key3).withForegroundColor(TextColor.ANSI.WHITE));
        textGraphics.drawRectangle(new TerminalPosition(XOFFSET + 29, YOFFSET + 32), new TerminalSize(15, 15), new TextCharacter(key4).withForegroundColor(TextColor.ANSI.WHITE));
        textGraphics.drawRectangle(new TerminalPosition(XOFFSET + 50, YOFFSET), new TerminalSize(4,4), new TextCharacter('*').withForegroundColor(TextColor.ANSI.WHITE));
        screen.setCharacter(XOFFSET + 17, YOFFSET + 17, new TextCharacter(key1).withForegroundColor(TextColor.ANSI.WHITE));
        screen.setCharacter(XOFFSET + 36, YOFFSET + 17, new TextCharacter(key2).withForegroundColor(TextColor.ANSI.WHITE));
        screen.setCharacter(XOFFSET + 17, YOFFSET + 39, new TextCharacter(key3).withForegroundColor(TextColor.ANSI.WHITE));
        screen.setCharacter(XOFFSET + 36, YOFFSET + 39, new TextCharacter(key4).withForegroundColor(TextColor.ANSI.WHITE));
        if (presses == 4) {
            textGraphics.fillRectangle(new TerminalPosition(XOFFSET + 51, YOFFSET + 1), new TerminalSize(2, 2), new TextCharacter('#').withForegroundColor(TextColor.ANSI.GREEN));
        } else {
            if (KeyType.Enter.equals(engine.getKey())) {
                int x = cursorPos.getColumn();
                int y = cursorPos.getRow();
                if (x > XOFFSET + 10 && x < XOFFSET + 24 && y > YOFFSET + 10 && y < YOFFSET + 24) {
                    if (key1 == ans[presses]) {
                        presses++;
                    } else {
                        strikes++;
                        textGraphics.fillRectangle(new TerminalPosition(XOFFSET + 51, YOFFSET + 1), new TerminalSize(2, 2), new TextCharacter('#').withForegroundColor(TextColor.ANSI.RED));
                    }
                } if (x > XOFFSET + 29 && x < XOFFSET + 43 && y > YOFFSET + 10 && y < YOFFSET + 24) {
                    if (key2 == ans[presses]) {
                        presses++;
                    } else {
                        strikes++;
                        textGraphics.fillRectangle(new TerminalPosition(XOFFSET + 51, YOFFSET + 1), new TerminalSize(2, 2), new TextCharacter('#').withForegroundColor(TextColor.ANSI.RED));
                    }
                } if (x > XOFFSET + 10 && x < XOFFSET + 24 && y > YOFFSET + 32 && y < YOFFSET + 46) {
                    if (key3 == ans[presses]) {
                        presses++;
                    } else {
                        strikes++;
                        textGraphics.fillRectangle(new TerminalPosition(XOFFSET + 51, YOFFSET + 1), new TerminalSize(2, 2), new TextCharacter('#').withForegroundColor(TextColor.ANSI.RED));
                    }
                } if (x > XOFFSET + 29 && x < XOFFSET + 43 && y > YOFFSET + 32 && y < YOFFSET + 46) {
                    if (key4 == ans[presses]) {
                        presses++;
                    } else {
                        strikes++;
                        textGraphics.fillRectangle(new TerminalPosition(XOFFSET + 51, YOFFSET + 1), new TerminalSize(2, 2), new TextCharacter('#').withForegroundColor(TextColor.ANSI.RED));
                    }
                }
            }
        }
    }

    public int getStrikes() {
        return strikes;
    }

    public boolean isDone() {
        return presses == 4;
    }
}
