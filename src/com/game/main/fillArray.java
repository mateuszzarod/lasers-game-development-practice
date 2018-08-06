package com.game.main;

import java.util.Arrays;

public class fillArray {

    public static String[] exampleTwist() {
        String[] websites = new String[1000];
        Arrays.fill(websites, "codewars");
        return websites;
    }

    public static String[] exampleClassic(){
        String[] websites = new String[1000];
        for (int i = 0; i < 1000; i++){
            websites[i] = "codewars";
        }
        return websites;
    }

    public static void main(String[] args) {
        Arrays.stream(fillArray.exampleClassic())
                .forEach(System.out::println);

        Arrays.stream(fillArray.exampleTwist())
                .forEach(System.out::println);
    }
}

