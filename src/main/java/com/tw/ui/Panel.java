package com.tw.ui;

import com.tw.model.Grid;

import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {
    private final int GRID_SCALING_FACTOR = 8;

    private Grid grid;

    public Panel(Grid grid) {
        this.grid = grid;
        setSize(grid.getWidth() * GRID_SCALING_FACTOR, grid.getHeight() * GRID_SCALING_FACTOR);
        setBackground(Color.WHITE);
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        int xPosition = 0;
        int yPosition = 0;

        for (int i = 0; i < grid.getHeight(); i++) {
            for (int j = 0; j < grid.getWidth(); j++) {
                if (grid.getCurrentStep().get(i).get(j).isLive()) {
                    graphics.setColor(Color.CYAN);
                } else {
                    graphics.setColor(Color.white);
                }

                graphics.fillRect(xPosition, yPosition, xPosition + GRID_SCALING_FACTOR, yPosition + GRID_SCALING_FACTOR);
                xPosition += GRID_SCALING_FACTOR;
            }
            yPosition += GRID_SCALING_FACTOR;
            xPosition = 0;
        }

        drawGrid(graphics);
    }

    private void drawGrid(Graphics g2) {
        g2.setColor(Color.GRAY);
        for(int w = GRID_SCALING_FACTOR; w < getSize().getWidth(); w += GRID_SCALING_FACTOR) {
            g2.drawLine(w, 0, w, (int)getSize().getHeight() - 1);
        }
        for(int h = GRID_SCALING_FACTOR; h < getSize().getHeight(); h += GRID_SCALING_FACTOR) {
            g2.drawLine(0, h, (int)getSize().getWidth() - 1, h);
        }
    }

    public Grid getGrid() {
        return grid;
    }

    public void nextGeneration() {
        grid.nextGeneration();
        repaint();
    }
}
