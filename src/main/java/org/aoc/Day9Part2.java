package org.aoc;

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

    public static void moveRight(List<Point> points, int steps) {


        for (int i = 0; i < steps; i++) {
            points.get(0).move(points.get(0).x + 1, points.get(0).y);
            for (int index = 1; index < points.size(); index++) {
                Point current = points.get(index);
                Point before = points.get(index - 1);
                double distance = Point.distance(current.x, current.y, before.x, before.y);
                if (distance > 1.5 && distance <= 2.0) {
                    points.get(index).move(points.get(index).x + 1, points.get(index).y);
                } else if (distance > 2 && distance < 2.83) {
                    if (before.y > current.y)
                        points.get(index).move(points.get(index).x + 1, points.get(index).y + 1);
                    if (before.y < current.y)
                        points.get(index).move(points.get(index).x + 1, points.get(index).y + -1);
                } else if (distance > 2.83) {
                    throw new RuntimeException("nu blev något fel när vi skulle gå höger du");
                }
            }
            if (!sumPoints.contains(points.get(9)))
                sumPoints.add(new Point(points.get(9)));
        }
    }

    public static void moveLeft(List<Point> points, int steps) {
        for (int i = 0; i < steps; i++) {
            points.get(0).move(points.get(0).x - 1, points.get(0).y);
            for (int index = 1; index < points.size(); index++) {
                Point current = points.get(index);
                Point before = points.get(index - 1);
                double distance = Point.distance(current.x, current.y, before.x, before.y);
                if (distance > 1.5 && distance <= 2.0) {
                    points.get(index).move(points.get(index).x - 1, points.get(index).y);
                } else if (distance > 2 && distance < 2.83) {
                    if (before.y > current.y)
                        points.get(index).move(points.get(index).x - 1, points.get(index).y + 1);
                    else {
                        points.get(index).move(points.get(index).x - 1, points.get(index).y - 1);
                    }
                } else if (distance > 2.83) {
                    throw new RuntimeException("något blev fel här du");
                }

            }
        }
        if (!sumPoints.contains(points.get(9)))
            sumPoints.add(new Point(points.get(9)));
    }


    public static void moveUp(List<Point> points, int steps) {

        for (int i = 0; i < steps; i++) {
            points.get(0).move(points.get(0).x, points.get(0).y + 1);
            for (int index = 1; index < points.size(); index++) {

                Point current = points.get(index);
                Point before = points.get(index - 1);
                double distance = Point.distance(current.x, current.y, before.x, before.y);
                if (distance > 1.5 && distance <= 2.0) {
                    points.get(index).move(points.get(index).x, points.get(index).y + 1);
                } else if (distance > 2 && distance < 2.83) {
                    if (before.x > current.x)
                        points.get(index).move(points.get(index).x + 1, points.get(index).y + 1);
                    else if (before.x < current.x) {
                        points.get(index).move(points.get(index).x - 1, points.get(index).y + 1);

                    }
                } else if (distance > 2.83) {
                    throw new RuntimeException("nu blev något fel när vi skulle upp");
                }
            }
        }
        if (!sumPoints.contains(points.get(9)))
            sumPoints.add(new Point(points.get(9)));
    }

    public static void moveDown(List<Point> points, int steps) {
        for (int i = 0; i < steps; i++) {
            points.get(0).move(points.get(0).x, points.get(0).y - 1);

            for (int index = 1; index < points.size(); index++) {
                Point current = points.get(index);
                Point before = points.get(index - 1);
                double distance = Point.distance(current.x, current.y, before.x, before.y);
                if (distance > 1.5 && distance <= 2.0) {
                    points.get(index).move(points.get(index).x, points.get(index).y - 1);
                } else if (distance > 2 && distance < 2.83) {
                    points.get(index).move(points.get(index).x - 1, points.get(index).y - 1);
                } else if (distance > 2.83) {
                    throw new RuntimeException("nu blev något fel när vi skulle ner");
                }

            }
        }
        if (!sumPoints.contains(points.get(9)))
            sumPoints.add(new Point(points.get(9)));
    }

    public static void run(String path) throws IOException {

        String input = Util.readInputToString(path);

        Scanner scanner = new Scanner(input);
        Point head = new Point(0, 0);
        Point tail = new Point(0, 0);
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            points.add(new Point(0, 0));

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String direction = line.substring(0, line.indexOf(" "));
            int steps = Integer.parseInt(line.substring(line.indexOf(" ") + 1));
            switch (direction) {
                case ("R") -> moveRight(points, steps);
                case ("L") -> moveLeft(points, steps);
                case ("U") -> moveUp(points, steps);
                case ("D") -> moveDown(points, steps);
                default ->
                        throw new IllegalStateException("Nu blev något galet va? Direction: " + direction + " steps: " + steps);
            }
        }
    }
}



