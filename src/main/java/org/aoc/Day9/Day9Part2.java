package org.aoc.Day9;

import org.aoc.Util;

import java.awt.*;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class Day9Part2 {

    public static List<Point> sumPoints = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        Point t = new Point(0, 0);
        Point h = new Point(1, 1);
        System.out.println(Point.distance(h.x, h.y, t.x, t.y));

        run("src/main/resources/9.txt");
        System.out.println("Part 1: " + Day9.points.size());
    }

    public static void followHead(List<Point> points) {

        for (int current = 1; current < points.size(); current++) {
            Point lastPoint = points.get(current - 1);
            Point currentPoint = points.get(current);
            double distance = Point.distance(currentPoint.x, currentPoint.y, lastPoint.x, lastPoint.y);
            if (distance == 2.0) {
                if (lastPoint.x > currentPoint.x) {
                    currentPoint.move(currentPoint.x + 1, currentPoint.y);
                } else if (lastPoint.x < currentPoint.x) {
                    currentPoint.move(currentPoint.x - 1, currentPoint.y);
                } else if (lastPoint.y > currentPoint.y) {
                    currentPoint.move(currentPoint.x, currentPoint.y + 1);
                } else if (lastPoint.y < currentPoint.y) {
                    currentPoint.move(currentPoint.x, currentPoint.y - 1);
                }
            } else if (distance == 2.23606797749979 || distance == 2.8284271247461903) {
                if (lastPoint.x > currentPoint.x) {
                    currentPoint.move(currentPoint.x + 1, currentPoint.y);
                } else if (lastPoint.x < currentPoint.x) {
                    currentPoint.move(currentPoint.x - 1, currentPoint.y);
                }
                if (lastPoint.y > currentPoint.y) {
                    currentPoint.move(currentPoint.x, currentPoint.y + 1);
                } else if (lastPoint.y < currentPoint.y) {
                    currentPoint.move(currentPoint.x, currentPoint.y - 1);
                }
            } else if (distance > 2.8284271247461903) {
                throw new RuntimeException("NÅGOT BLIR FEL, det ska aldrig skilja mer mellan två punkter");
            }
        }
        if (!sumPoints.contains(points.get(9)))
            sumPoints.add(new Point(points.get(9)));
    }


    public static void run(String path) throws IOException {

        String input = Util.readInputToString(path);

        Scanner scanner = new Scanner(input);
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            points.add(new Point(0, 0));

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String direction = line.substring(0, line.indexOf(" "));
            int steps = Integer.parseInt(line.substring(line.indexOf(" ") + 1));
            Point head = points.get(0);
            switch (direction) {
                case ("R") -> {
                    for (int i = 0; i < steps; i++) {
                        head.move(head.x + 1, head.y);
                        followHead(points);
                    }
                }
                case ("L") -> {
                    for (int i = 0; i < steps; i++) {
                        head.move(head.x - 1, head.y);
                        followHead(points);
                    }
                }
                case ("U") -> {
                    for (int i = 0; i < steps; i++) {
                        head.move(head.x, head.y + 1);
                        followHead(points);
                    }
                }
                case ("D") -> {
                    for (int i = 0; i < steps; i++) {
                        head.move(head.x, head.y - 1);
                        followHead(points);
                    }
                }
                default ->
                        throw new IllegalStateException("Nu blev något galet va? Direction: " + direction + " steps: " + steps);
            }
        }
        System.out.println(Day9Part2.sumPoints.size());
    }
}



