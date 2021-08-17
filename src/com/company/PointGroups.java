package com.company;
import java.util.ArrayList;
import java.util.Arrays;

public class PointGroups {

    private ArrayList<ArrayList<Point>> groups = new ArrayList<ArrayList<Point>>();

    public PointGroups() {
        for (var i = 0; i < 4; i++){
            groups.add(new ArrayList<Point>());
        }
    }

    public void Add(Point point) {
        if(point.Y() >= Math.pow(point.X(), 1))
            groups.get(0).add(point);
        if(point.Y() >= Math.pow(point.X(), 2))
            groups.get(1).add(point);
        if(point.Y() >= Math.pow(point.X(), 3))
            groups.get(2).add(point);
        if(point.Y() < Math.pow(point.X(), 1)) groups.get(3).add(point);
    }

    public ArrayList<String> Print() {
        var list = new ArrayList<String>();
        for (var i = 0; i < 3; i++)
            list.add(Arrays.toString(groups.get(i).toArray()));
        return list;
    }

    public ArrayList<String> Print(int... numbers) {
        var list = new ArrayList<String>();
        for (var number: numbers)
            list.add(Arrays.toString(groups.get(number - 1).toArray()));
        return list;
    }

    public void Remove(int... numbers) {
        for (var number: numbers)
            groups.get(number-1).clear();
    }

    public void Clear() {
        for (var i = 0; i < 4; i++)
            groups.get(i).clear();
    }
}
