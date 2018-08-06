package com.game.main;

import java.awt.*;
import java.util.LinkedList;

//maintain update render of all objects (loop+render)
//Linked list of all objects
public class Handler {
    LinkedList<GameObject> object = new LinkedList<>();

    //updates all game objects
    public void tick(){
        for(int i = 0; i < object.size(); i++){
            GameObject tempObject = object.get(i);
            tempObject.tick();
        }

    }

    //renders all game objects
    public void render(Graphics g){
        for (int i = 0; i < object.size(); i++){
            GameObject tempObject = object.get(i);
            tempObject.render(g);
        }
    }

    public void addObject(GameObject object){
        this.object.add(object);
    }

    public void removeObject(GameObject object){
        this.object.remove(object);
    }

}
