package com.scottejames.aoc2020;

import com.scottejames.utils.Direction;
import com.scottejames.utils.FileHelper;
import com.scottejames.utils.Point;

import java.util.List;

import static com.scottejames.utils.Direction.EAST;

public class DayTwelve {

    public static void main(String[] args){
        FileHelper fh = new FileHelper("2020/DayTwelve.txt");
        List<String> data = fh.getFileAsList();
       // partOne(data);
        partTwo(data);

    }
    private static void partTwo(List<String> data) {
        Point ship = new Point(0, 0);
        Point waypoint = new Point(10, -1);

        for (String line: data) {
            char dir = Character.toUpperCase(line.charAt(0));
            int distance = Integer.parseInt(line.substring(1));
            System.out.println("Processing " + dir + " / " + distance);
            switch (dir) {
                case 'L':
                case 'R': {
                    for (int i = 0; i < distance/90 ; i++)
                        waypoint = turn(waypoint,dir);
                    break;
                }

                case 'F':
                    Point moveDistance = waypoint.multiply(distance);
                    ship = ship.add(moveDistance);
                    break;

                case 'N':
                case 'S':
                case 'E':
                case 'W': {
                    Direction cardDirection = Direction.getByDir(dir);
                    waypoint = cardDirection.move(waypoint,distance);
                    break;
                }
            }
            System.out.println("Ship " + ship);
            System.out.println("Waypoint " + waypoint);
        }
        System.out.println(ship.manHattenDistance());
    }

    private static void partOne(List<String> data) {
        Point p = new Point(0,0);
        Direction facing = EAST;

        for (String line: data){
            char dir = Character.toUpperCase(line.charAt(0));
            int distance = Integer.parseInt(line.substring(1));
            System.out.println("Processing " + dir + " / " + distance);
            switch (dir){
                case 'L':
                case 'R': {
                    for (int i = 0; i < distance/90 ; i++)
                        facing = facing.turnNintyDegrees(dir == 'R');
                    break;

                }
                case 'F': {
                    p = facing.move(p, distance);
                    break;
                }
                case 'N':
                case 'S':
                case 'E':
                case 'W': {
                    Direction cardDirection = Direction.getByDir(dir);
                    p = cardDirection.move(p,distance);
                    break;
                }
                default:
                    System.err.println("INVALID CODE FOUND");

            }
            System.out.println("Facing " + facing);
            System.out.println("Moves to " + p);
        }
        System.out.println(p.manHattenDistance());
    }

    private static Point turn(Point p, char c) {
        if (c == 'R')
            return new Point(-p.y, p.x);
        else
           return new Point(p.y, -p.x);
    }
}
