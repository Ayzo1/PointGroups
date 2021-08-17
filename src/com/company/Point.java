package com.company;

public class Point {
    private int x;
    private int y;
    public int X(){return x;}
    public int Y(){return y;}

    public Point(int X, int Y){
        this.x = X;
        this.y = Y;
    }

    public String toString(){
        return x + " " + y;
    }
}
