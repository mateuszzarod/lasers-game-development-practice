package com.game.main;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable {

    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
    private Thread thread;
    private boolean running;
    private Random r;
    private Handler handler;


    public Game() {

        //handler initialize first compiles from top to bottom

        //window -> start -> run -> render (inside run) -> render method callas handler.render

        handler = new Handler();
        this.addKeyListener(new KeyInput(handler));//creates object that listens to the keys

        new Window(WIDTH, HEIGHT, "Let's build a game!", this);

        r = new Random();

            //x, y is position where object starts
            //handler.addObject(new Player(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.Player));
            //handler.addObject(new Player(0, 0, ID.Player));

            handler.addObject(new Player(WIDTH/2-32, HEIGHT/2-32, ID.Player));
            handler.addObject(new Player(WIDTH/2+64, HEIGHT/2-20, ID.Player2));
            //2+64 -> 64 pixels to the right
        }

    public synchronized void start() { //this starts our Thread
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    //this stops thread and try catch'
    //thread.join is killing thread

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    //game loop
    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running)
                render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS" + frames);
                frames = 0;
            }
        }
        stop();
    }

    //this handler runs through all game objects
    private void tick() {
        handler.tick();

    }

    //creating 3 buffers in game
    //handler render object renders all objects
    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.green);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        handler.render(g);

        g.dispose();
        bs.show();
    }

    public static void main(String[] args) {
        new Game();
    }
}
