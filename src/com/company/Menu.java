package com.company;

import java.util.Scanner;

public class Menu {

    private PointGroups pointGroups;

    public Menu(){
        pointGroups = new PointGroups();
    }

    public void Start(){
        var in = new Scanner(System.in);
        while (true) {
            System.out.println("Введите команду:");
            var input = in.nextLine();
            var a = input.split(" ");
            switch (a[0]) {
                case "add":
                    Add(a);
                    break;
                case "print":
                    Print(a);
                    break;
                case "exit":
                    return;
                case "remove":
                    Remove(a);
                    break;
                case "clear":
                    Clear(a);
                    break;
                case "help":
                    Help();
                    break;
            }
        }
    }

    private void Help() {
        System.out.println("add <point>        - добавить в память программы точки, координаты передаются парами чисел через пробел");
        System.out.println("print              - напечатать построчно каждую из трех групп (входящие в них точки)");
        System.out.println("print <group_num>  - напечатать одним списком точки, входящие в группу(ы) переданную(ые) параметром <group_num>");
        System.out.println("remove <group_num> - удалить из памяти все точки, входящие в группу(ы) <group_num>");
        System.out.println("clear              - очистить память");
        System.out.println("exit               - завершить работу программы");
    }

    private void Add(String[] command){
        if(command.length % 2 == 0)
        {
            System.out.println("Введите правильную команду");
            return;
        }
        for (var i = 1; i < command.length - 1; i = i + 2)
        {
            try {
                pointGroups.Add(new Point(Integer.parseInt(command[i]), Integer.parseInt(command[i + 1])));
            }
            catch (NumberFormatException e) {
                System.out.println("Введите правильные координаты точек");
                return;
            }
        }
    }

    private void Print(String[] command){
        if(command.length == 1) {
            for (var group: pointGroups.Print()) {
                System.out.println(group);
            }
            return;
        }
        for (var i = 1; i < command.length; i++)
        {
            int groupNumber;
            try {
                groupNumber = Integer.parseInt(command[i]);
            }
            catch (NumberFormatException e) {
                System.out.println("Введите правильные координаты точек");
                return;
            }
            if (groupNumber > 3 || groupNumber < 1) {
                System.out.println("Введите правильные номера групп");
                return;
            }
            System.out.println(pointGroups.Print(groupNumber));
        }
    }

    private void Remove(String[] command){
        if(command.length < 2) {
            System.out.println("Введите правильную команду");
            return;
        }
        for (var i = 1; i < command.length; i++)
        {
            int groupNumber;
            try {
                groupNumber = Integer.parseInt(command[i]);
            }
            catch (NumberFormatException e) {
                System.out.println("Введите правильные координаты точек");
                return;
            }
            if (groupNumber > 3 || groupNumber < 1) {
                System.out.println("Введите правильные номера групп");
                return;
            }
            pointGroups.Remove(i);
        }
    }

    private void Clear(String[] command)
    {
        if(command.length != 1) {
            System.out.println("Введите правильную команду");
            return;
        }
        pointGroups.Clear();
    }
}
