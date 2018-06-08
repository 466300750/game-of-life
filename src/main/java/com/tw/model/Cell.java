package com.tw.model;

public class Cell {
    private int live;
    private int liveNeighborNums;

    public Cell(int live) {
        this.live = live;
    }

    public boolean isLive() {
        return live == 1;
    }

    public void setLive(int live) {
        this.live = live;
    }

    public int getLive() {
        return live;
    }

    public int getLiveNeighborNums() {
        return liveNeighborNums;
    }

    public void setLiveNeighborNums(int liveNeighborNums) {
        this.liveNeighborNums = liveNeighborNums;
    }
}
