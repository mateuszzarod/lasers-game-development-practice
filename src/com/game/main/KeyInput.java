package com.game.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    private Handler handler;

    public KeyInput(Handler handler) {
        this.handler = handler;
    }

    public void keyPressed(KeyEvent e) {
        //letterbind
        //how to move player?
        int key = e.getKeyCode();

        //go through objects and check which object is player
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);
            if (tempObject.getId() == ID.Player) {
               //key events to player1
                //to set Y to current move 10 up, and then set to current position and doesent stop
                /* if (key == KeyEvent.VK_W) tempObject.setY(tempObject.getY() - 10);*/
                if(key == KeyEvent.VK_W) tempObject.setVelY(-5);
                if(key == KeyEvent.VK_S) tempObject.setVelY(5);
                if(key == KeyEvent.VK_D) tempObject.setVelX(5);
                if(key == KeyEvent.VK_A) tempObject.setVelX(-5);
            }

            if (tempObject.getId() == ID.Player2) {
                //key events for player2
                /*                if (key == KeyEvent.VK_UP) tempObject.setY(tempObject.getY() - 10);*/
                if (key == KeyEvent.VK_UP) tempObject.setVelY(-10);
                if (key == KeyEvent.VK_DOWN) tempObject.setVelY(10);
                if (key == KeyEvent.VK_RIGHT) tempObject.setVelX(10);
                if (key == KeyEvent.VK_LEFT) tempObject.setVelX(-10);
            }

        }

    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        for (int i = 0; i < handler.object.size(); i++) {
            GameObject tempObject = handler.object.get(i);

            if (tempObject.getId() == ID.Player) {
                //Whats going on when key is released
                if (key == KeyEvent.VK_W) tempObject.setVelX(0);
                if (key == KeyEvent.VK_S) tempObject.setVelX(0);
                if (key == KeyEvent.VK_A) tempObject.setVelX(0);
                if (key == KeyEvent.VK_D) tempObject.setVelX(0);
            }

            if (tempObject.getId() == ID.Player2) {
                //Whats happening on when a key is released for player2
                if (key == KeyEvent.VK_UP) tempObject.setVelX(0);
                if (key == KeyEvent.VK_DOWN) tempObject.setVelX(0);
                if (key == KeyEvent.VK_LEFT) tempObject.setVelX(0);
                if (key == KeyEvent.VK_RIGHT) tempObject.setVelX(0);
            }
        }
    }

}

