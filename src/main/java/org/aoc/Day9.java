package org.aoc;


import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class Day9 {
    public static Set points = new HashSet();

    public static void moveRight(Point h, Point t, int steps) {

        int lastHeadX = 0;
        int lastHeadY = 0;

        for (int i = 0; i < steps; i++) {
            lastHeadX = h.x;
            lastHeadY = h.y;
            h.move(h.x + 1, h.y);
            if (Math.abs(h.x + h.y - t.x + t.y) > 1) {
                t.move(lastHeadX, lastHeadY);
            }
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
            if (Math.abs(h.x + h.y - t.x + t.y) > 1) {
                t.move(lastHeadX, lastHeadY);
                points.add(new Point(t));
            }
        }
    }

    public static void moveUp(Point h, Point t, int steps) {

        int lastHeadX = 0;
        int lastHeadY = 0;
        for (int i = 0; i < steps; i++) {
            lastHeadX = h.x;
            lastHeadY = h.y;
            h.move(h.x, h.y + 1);
            if (Math.abs(h.x + h.y - t.x + t.y) > 1) {
                t.move(lastHeadX, lastHeadY);
            }
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
            if (Math.abs(h.x + h.y - t.x + t.y) > 1) {
                t.move(lastHeadX, lastHeadY);
            }
            points.add(new Point(t));
        }
    }
}
