package com.tw;

import com.tw.model.Grid;

public class Game {

    public static void main(String[] args) {
        Grid grid = new Grid(50, 50);
        while (true) {
            System.out.println(grid);
            grid.nextGeneration();

            try {
                Thread.sleep(100);
            } catch (Exception ignored) {
            }
        }
    }
}
