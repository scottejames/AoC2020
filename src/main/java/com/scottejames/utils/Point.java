package com.scottejames.utils;

public class Point {
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point p) {
        this.x = p.x;
        this.y = p.y;
    }

    public Point add(Point p) {
        return new Point(x + p.x, y + p.y);
    }
    public Point multiply(int i) {
        return new Point (x*i , y*i);
    }
    public int manHattenDistance(){
        return Math.abs(x) + Math.abs(y);
    }
    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
