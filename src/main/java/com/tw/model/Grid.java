package com.tw.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Grid {
    private static int BIRTH_CONDITION = 3;
    private static int SURVIVE_CONDITION = 2;

    private int width;
    private int height;
    private List<List<Cell>> currentStep;

    public Grid(int width, int height) {
        this.width = width;
        this.height = height;
        currentStep = new ArrayList<>(height);
        for (int i = 0; i < width; i++ ) {
            currentStep.add(i, new ArrayList<>(width));
        }
        randomGrid();
    }

    private void randomGrid() {
        Random random = new Random();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Cell cell = null;
                if (random.nextBoolean()) {
                    cell = new Cell(1);
                } else {
                    cell = new Cell(0);
                }
                currentStep.get(i).add(j, cell);
            }
        }
    }

    public void nextGeneration() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Cell cell = currentStep.get(i).get(j);
                int liveNeighbors = countLiveNeighbors(i, j);
                if (liveNeighbors == BIRTH_CONDITION) {
                    cell.setLive(1);
                } else if (liveNeighbors != SURVIVE_CONDITION) {
                    currentStep.get(i).get(j).setLive(0);
                }
            }
        }
    }

    private int countLiveNeighbors(int x, int y) {
        int count = 0;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (x + i >= 0 && x + i < height && y + j >= 0 && y + j < width) {
                    if (currentStep.get(x + i).get(y + j).isLive()) {
                        count++ ;
                    }
                }
            }
        }
        return count;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public List<List<Cell>> getCurrentStep() {
        return currentStep;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (List<Cell> cells : currentStep) {
            for (Cell cell : cells) {
                sb.append(" ").append(cell.getLive());
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
