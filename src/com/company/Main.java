package com.company;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Start");
        MyThread pingThread = new MyThread("ping", 10, (int)(Math.random() * 999 + 100));
        MyThread pongThread = new MyThread("  Pong", 10, (int)(Math.random() * 999 + 100));
        MyThread pengThread = new MyThread("    PENG", 10, (int)(Math.random() * 999 + 100));

        pingThread.start();
        pongThread.start();
        pengThread.start();

        pingThread.join();
        pongThread.join();
        pengThread.join();
        System.out.println("Stop");
    }
}

class MyThread extends Thread {
    private final String _message;
    private final int _counter;
    private final int _delay;

    public MyThread(String message, int counter, int delay) {
        _message = message;
        _counter = counter;
        _delay = delay;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < _counter; i++) {
                Thread.sleep((long)_delay);
                System.out.println(_message);
            }
        } catch (InterruptedException ex) { }
    }
}
