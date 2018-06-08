package com.tw;

import com.tw.model.Grid;
import com.tw.ui.Frame;

public class Game {

    public static void main(String[] args) {
        Grid grid = new Grid(100, 100);
        Frame frame = new Frame(grid);
        frame.run();
    }
}
