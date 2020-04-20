package com.snooper.dto;

public class Plateau {
    private int minX;
    private int minY;
    private int maxX;
    private int maxY;

    public Plateau(int minX, int minY, int maxX, int maxY) {
        if (minX > maxX) {
            throw new IllegalArgumentException("Invalid minX and maxX");
        }

        if (minY > maxY) {
            throw new IllegalArgumentException("Invalid minY and maxY");
        }

        this.minX = minX;
        this.maxX = maxX;
        this.minY = minY;
        this.maxY = maxY;
    }

    public int getMinX() {
        return minX;
    }

    public void setMinX(int minX) {
        this.minX = minX;
    }

    public int getMinY() {
        return minY;
    }

    public void setMinY(int minY) {
        this.minY = minY;
    }

    public int getMaxX() {
        return maxX;
    }

    public void setMaxX(int maxX) {
        this.maxX = maxX;
    }

    public int getMaxY() {
        return maxY;
    }

    public void setMaxY(int maxY) {
        this.maxY = maxY;
    }
}
