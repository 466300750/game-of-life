package com.tw.ui;

import com.tw.model.Grid;

import javax.swing.*;

public class Frame extends JFrame{
    private Panel panel;

    public Frame(Grid grid) {
        super("Game Started");

        panel = new Panel(grid);
        panel.setPreferredSize(panel.getSize());

        add(panel);

        pack();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public void run() {
        while(true) {
            panel.nextGeneration();

            try {
                Thread.sleep(100);
            } catch (Exception ignored) {
            }
        }
    }
}
