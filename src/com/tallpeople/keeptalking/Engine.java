package com.tallpeople.keeptalking;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.MouseCaptureMode;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;
import com.googlecode.lanterna.terminal.swing.TerminalEmulatorDeviceConfiguration;

import java.awt.*;
import java.io.IOException;
import java.security.Key;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Engine implements Runnable{

    private final long NANOSECONDS_PER_SECOND = 1000000000;

    private String title;

    private IGame game;
    private boolean running;
    private long previousNanoSeconds;
    private double deltaTime;

    private TerminalScreen screen;
    private TerminalSize terminalSize;
    private long waitTime;

    private KeyType keyPressed = null;
    private String charPressed = null;

    private final ScheduledExecutorService scheduler =
            Executors.newScheduledThreadPool(1);
    private ScheduledFuture<?> task;

    public Engine(IGame game, String title) throws IOException{
        this.game = game;
        this.title = title;
    }

    public void initialize() throws IOException {

        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
        terminalFactory.setInitialTerminalSize(new TerminalSize(200, 54));
        //terminalFactory.setTerminalEmulatorTitle(title);
        terminalFactory.setTerminalEmulatorDeviceConfiguration(new TerminalEmulatorDeviceConfiguration().withCursorStyle(TerminalEmulatorDeviceConfiguration.CursorStyle.VERTICAL_BAR));
        terminalFactory.setMouseCaptureMode(MouseCaptureMode.CLICK_RELEASE_DRAG_MOVE);
        //AWTTerminalFontConfiguration fontConfiguration = new AWTTerminalFontConfiguration(false, AWTTerminalFontConfiguration.BoldMode.EVERYTHING, Font.getFont(Font.MONOSPACED));
        //Font font = Font.getFont(Font.SERIF);
        //GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        //String[] fontNames = ge.getAvailableFontFamilyNames();
        //for (String font : fontNames) {
        //    System.err.println(font);
        //}
        //System.err.println(Font.getFont(Font.MONOSPACED));
        Font font = new Font("Monospaced", Font.PLAIN, 100);
        System.err.println(font.getSize());
        AWTTerminalFontConfiguration fontConfiguration = AWTTerminalFontConfiguration.newInstance(font);
        System.err.println(fontConfiguration);
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfiguration);
        //terminalFactory.addTerminalEmulatorFrameAutoCloseTrigger(TerminalEmulatorAutoCloseTrigger.CloseOnEscape);

        screen = terminalFactory.createScreen();
        System.out.println(screen.getClass().toString());
        screen.doResizeIfNecessary();

        waitTime = NANOSECONDS_PER_SECOND/10;
        running = true;
        previousNanoSeconds = System.nanoTime();

        screen.startScreen();
        game.initialize(this, screen);
        task = scheduler.scheduleAtFixedRate(this, 0, this.waitTime, TimeUnit.NANOSECONDS);
    }

    @Override
    public void run() {
        try {
            update();
        } catch (IOException e) {
            System.err.println(e);
        }
    }

    public void update () throws IOException {
        deltaTime = (double) (System.nanoTime() - previousNanoSeconds) / NANOSECONDS_PER_SECOND;
        previousNanoSeconds = System.nanoTime();

        screen.doResizeIfNecessary();

        KeyStroke keyStroke = screen.pollInput();

        if (keyStroke != null) {
            if (keyStroke.getKeyType() == KeyType.Character) {
                keyPressed = null;
                charPressed = keyStroke.getCharacter().toString();
            } else {
                charPressed = null;
                keyPressed = keyStroke.getKeyType();
            }
        } else {
            keyPressed = null;
            charPressed = null;
        }

        while((keyStroke = screen.pollInput()) != null) {
            if (keyStroke.getKeyType() == KeyType.Character) {
                keyPressed = null;
                charPressed = keyStroke.getCharacter().toString();
            } else {
                charPressed = null;
                keyPressed = keyStroke.getKeyType();
            }
        }
        //System.out.println(charPressed);
        game.update(this, screen);
        screen.refresh();

        if (!running) {
            screen.stopScreen();
            task.cancel(false);
        }
    }

    public void stop() {
        running = false;
    }

    public double deltaTime() {
        return deltaTime;
    }

    public void setTargetFPS(double targetFPS) {
        this.waitTime = (long) (NANOSECONDS_PER_SECOND / targetFPS);
        if (task != null) {
            task.cancel(false);
            task = scheduler.scheduleAtFixedRate(this, 0, this.waitTime, TimeUnit.NANOSECONDS);
        }
    }

    public KeyType getKey() {
        return keyPressed;
    }

    public String getCharacter() {
        return charPressed;
    }
}
