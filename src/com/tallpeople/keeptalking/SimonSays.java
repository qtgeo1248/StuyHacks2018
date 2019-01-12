package com.tallpeople.keeptalking;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.tallpeople.keeptalking.Engine;
import com.tallpeople.keeptalking.Module;

public class SimonSays extends Module {
    private int strikes = 0;
    private boolean serialVowel = true;
    private static String[] colors = {"red", "green", "blue", "yellow"};
    private static int[] sequence = new int[4];
    private String[] colorSequence = new String[4];
    private String[] presses = new String[4];
    private TextColor currentRedColor = TextColor.ANSI.RED;
    private TextColor currentYellowColor = TextColor.ANSI.YELLOW;
    private TextColor currentBlueColor = TextColor.ANSI.BLUE;
    private TextColor currentGreenColor = TextColor.ANSI.GREEN;
    public SimonSays(int XOFFSET, int YOFFSET, Engine engine, TerminalScreen screen) {
        super(XOFFSET, YOFFSET);
        for(int i = 0; i < 4; i++){
            sequence[i] = (int) (Math.random() * 4);
            colorSequence[i] = colors[sequence[i]];
        }
        correctPress();
    }

    public void initialize(Engine engine, TerminalScreen screen) {
    }

    public boolean needsBlink(String color ) {
        if (color.equals(colorSequence[0])) {
            return true;
        }
        if (hasBeenCorrect("color")) {
            return true;
        }
        return false;
    }

    public boolean hasBeenCorrect(String color) {
       // if it is the first step, then the first color needs to be clicked
        //        if its clicked, then
          //      flash the first and second colors
            //    else
              //      flash the first color
                    //increase strikes
        // if it is the second step, then the first, and second needs to be clicked  \
            // if first and second are clicked, then
                //flash the first, second, and third colors
                // else
                    //flash the first and second
                    //increase strikes
        // if it is the third step, then the first, second, and third are clicked
            // if first and second and third are clicked,
                // then isDone = true
                //else
                    //increase strikes
        return false;
    }




    public void drawRectangle(Engine engine, TerminalScreen screen) {
        TextGraphics myGraphics = screen.newTextGraphics();
        TerminalSize size = new TerminalSize(7,4);
        TerminalPosition upLeft = new TerminalPosition(20 + XOFFSET ,-20 + YOFFSET); //red
        TerminalPosition upMid = new TerminalPosition(27 + XOFFSET, -20 + YOFFSET); //green
        TerminalPosition downLeft = new TerminalPosition(20 + XOFFSET, -24 + YOFFSET); //blue
        TerminalPosition downMid = new TerminalPosition(27 + XOFFSET, -24 + YOFFSET); //yellow

        TextCharacter rectangle = new TextCharacter('#').withForegroundColor(TextColor.ANSI.WHITE);
        if (engine.deltaTime() / 1000 >= + 3000000 && needsBlink("red")) {
            if (currentRedColor.equals(TextColor.ANSI.RED) ){
                rectangle = new TextCharacter('#').withForegroundColor(TextColor.ANSI.WHITE);
                currentRedColor = TextColor.ANSI.WHITE;
            }
            else {
                rectangle = new TextCharacter('#').withForegroundColor(TextColor.ANSI.RED);
                currentRedColor = TextColor.ANSI.RED;
            }
        }

        myGraphics.drawRectangle(upLeft, size, rectangle);

        if (engine.deltaTime() / 1000 >= 4000000 && needsBlink("green")) {
            if (currentGreenColor.equals(TextColor.ANSI.GREEN) ){
                rectangle = new TextCharacter('#').withForegroundColor(TextColor.ANSI.WHITE);
                currentGreenColor = TextColor.ANSI.WHITE;
            }
            else {
                rectangle = new TextCharacter('#').withForegroundColor(TextColor.ANSI.GREEN);
                currentGreenColor = TextColor.ANSI.GREEN;
            }
        }

        myGraphics.drawRectangle(upMid, size, rectangle);

        if (engine.deltaTime() / 1000 >= 5000000 && needsBlink("blue")) {
            if (currentBlueColor.equals(TextColor.ANSI.BLUE) ){
                rectangle = new TextCharacter('#').withForegroundColor(TextColor.ANSI.WHITE);
                currentBlueColor = TextColor.ANSI.WHITE;
            }
            else {
                rectangle = new TextCharacter('#').withForegroundColor(TextColor.ANSI.BLUE);
                currentBlueColor = TextColor.ANSI.BLUE;
            }
        }

        myGraphics.drawRectangle(downLeft, size, rectangle);

        if (engine.deltaTime() / 1000 >= 6000000 && needsBlink("yellow")) {
            if (currentYellowColor.equals(TextColor.ANSI.YELLOW) ){
                rectangle = new TextCharacter('#').withForegroundColor(TextColor.ANSI.WHITE);
                currentYellowColor = TextColor.ANSI.WHITE;
            }
            else {
                rectangle = new TextCharacter('#').withForegroundColor(TextColor.ANSI.YELLOW);
                currentYellowColor = TextColor.ANSI.YELLOW;
            }
        }

        myGraphics.drawRectangle(downMid, size, rectangle);
    }
    
    public void run(Engine engine, TerminalScreen screen) {

        drawRectangle(engine, screen);
    }
    public void correctPress() {
        if (serialVowel) {
            for (int i = 0; i < 4; i++) {
                if (strikes == 0) {
                    if (colorSequence[i].equals("red"))
                        presses[i] = "blue";
                    if (colorSequence[i].equals("blue"))
                        presses[i] = "red";
                    if (colorSequence[i].equals("green"))
                        presses[i] = "yellow";
                    if (colorSequence[i].equals("yellow"))
                        presses[i] = "green";
                }
                if (strikes == 1) {
                    if (colorSequence[i].equals("red"))
                        presses[i] = "yellow";
                    if (colorSequence[i].equals("blue"))
                        presses[i] = "green";
                    if (colorSequence[i].equals("green"))
                        presses[i] = "blue";
                    if (colorSequence[i].equals("yellow"))
                        presses[i] = "red";
                }
                if (strikes == 2) {
                    if (colorSequence[i].equals("red"))
                        presses[i] = "green";
                    if (colorSequence[i].equals("blue"))
                        presses[i] = "red";
                    if (colorSequence[i].equals("green"))
                        presses[i] = "yellow";
                    if (colorSequence[i].equals("yellow"))
                        presses[i] = "blue";
                }
            }
        } else {
            for (int i = 0; i < 4; i++) {
                if (strikes == 0) {
                    if (colorSequence[i].equals("red"))
                        presses[i] = "blue";
                    if (colorSequence[i].equals("blue"))
                        presses[i] = "yellow";
                    if (colorSequence[i].equals("green"))
                        presses[i] = "green";
                    if (colorSequence[i].equals("yellow"))
                        presses[i] = "red";
                }
                if (strikes == 1) {
                    if (colorSequence[i].equals("red"))
                        presses[i] = "red";
                    if (colorSequence[i].equals("blue"))
                        presses[i] = "blue";
                    if (colorSequence[i].equals("green"))
                        presses[i] = "yellow";
                    if (colorSequence[i].equals("yellow"))
                        presses[i] = "green";
                }
                if (strikes == 2) {
                    if (colorSequence[i].equals("red"))
                        presses[i] = "yellow";
                    if (colorSequence[i].equals("blue"))
                        presses[i] = "green";
                    if (colorSequence[i].equals("green"))
                        presses[i] = "blue";
                    if (colorSequence[i].equals("yellow"))
                        presses[i] = "red";
                }
            }
        }
    }

    
}