package com.tallpeople.keeptalking;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException{
        Engine e = new Engine(new Game(), "My Game");
        e.initialize();
    }
}
