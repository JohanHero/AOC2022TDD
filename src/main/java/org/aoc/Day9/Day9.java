package org.aoc.Day9;


import org.aoc.Util;

import java.awt.*;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class Day9 {
    public static List<Point> points = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        Point t = new Point(0,0);
        Point h = new Point(1,1);
        System.out.println(Point.distance(h.x,h.y,t.x,t.y));

        run("src/main/resources/9.txt");
        System.out.println("Part 1: " + Day9.points.size());
    }

    public static void moveRight(Point h, Point t, int steps) {

        int lastHeadX = 0;
        int lastHeadY = 0;

        for (int i = 0; i < steps; i++) {
            lastHeadX = h.x;
            lastHeadY = h.y;
            h.move(h.x + 1, h.y);
            if ((Point.distance(h.x, h.y, t.x, t.y)) >= 2) {
                t.move(lastHeadX, lastHeadY);
            }
            if(!points.contains(t))
                points.add(new Point(t));
        }

    }

    public static void moveLeft(Point h, Point t, int steps) {

        int lastHeadX = 0;
        int lastHeadY = 0;
        for (int i = 0; i < steps; i++) {
            lastHeadX = h.x;
            lastHeadY = h.y;
            h.move(h.x - 1, h.y);
            if ((Point.distance(h.x, h.y, t.x, t.y)) >= 2) {
                t.move(lastHeadX, lastHeadY);
            }
            if(!points.contains(t))
                points.add(new Point(t));
        }
    }


    public static void moveUp(Point h, Point t, int steps) {

        int lastHeadX = 0;
        int lastHeadY = 0;
        for (int i = 0; i < steps; i++) {
            lastHeadX = h.x;
            lastHeadY = h.y;
            h.move(h.x, h.y + 1);
            if ((Point.distance(h.x, h.y, t.x, t.y)) >= 2) {
                t.move(lastHeadX, lastHeadY);
            }
            if(!points.contains(t))
                points.add(new Point(t));
        }
    }

    public static void moveDown(Point h, Point t, int steps) {

        int lastHeadX = 0;
        int lastHeadY = 0;

        for (int i = 0; i < steps; i++) {
            lastHeadX = h.x;
            lastHeadY = h.y;
            h.move(h.x, h.y - 1);
            if ((Point.distance(h.x, h.y, t.x, t.y)) >= 2) {
                t.move(lastHeadX, lastHeadY);
            }
            if(!points.contains(t))
                points.add(new Point(t));
        }
    }

    public static void run(String path) throws IOException {

        String input = Util.readInputToString(path);

        Scanner scanner = new Scanner(input);
        Point head = new Point(0, 0);
        Point tail = new Point(0, 0);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String direction = line.substring(0, line.indexOf(" "));
            int steps = Integer.parseInt(line.substring(line.indexOf(" ") + 1));
            switch (direction) {
                case ("R") -> moveRight(head, tail, steps);
                case ("L") -> moveLeft(head, tail, steps);
                case ("U") -> moveUp(head, tail, steps);
                case ("D") -> moveDown(head, tail, steps);
                default ->
                        throw new IllegalStateException("Nu blev något galet va? Direction: " + direction + " steps: " + steps);
            }
        }
    }
}
