package org.aoc;

import org.aoc.Day9.Day9;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;

public class Day9Test {


    @BeforeEach
    void clearPoints(){
        Day9.points.clear();
    }
    @Test
    void moveRight(){

        Point h = new Point(0,0);
        Point t = new Point(0,0);
        Day9.moveRight(h,t, 100);
        Assertions.assertEquals(100,h.x);
        Assertions.assertEquals(99,t.x);
    }

    @Test
    void moveLeft(){
        Point h = new Point(0,0);
        Point t = new Point(0,0);
        Day9.moveLeft(h,t, 100);
        Assertions.assertEquals(-100,h.x);
        Assertions.assertEquals(-99,t.x);
    }

    @Test
    void moveUp(){
        Point h = new Point(0,0);
        Point t = new Point(0,0);
        Day9.moveUp(h,t, 100);
        Assertions.assertEquals(100,h.y);
        Assertions.assertEquals(99,t.y);
    }

    @Test
    void moveDown(){
        Point h = new Point(0,0);
        Point t = new Point(0,0);
        Day9.moveDown(h,t, 100);
        Assertions.assertEquals(-100,h.y);
        Assertions.assertEquals(-99,t.y);
    }

    @Test
    void moveUpAndDown(){
        Point h = new Point(0,0);
        Point t = new Point(0,0);
        Day9.moveDown(h,t, 1);
        Day9.moveUp(h,t, 1);
        Assertions.assertEquals(0,h.y);
        Assertions.assertEquals(0,t.y);
        Assertions.assertEquals(1,Day9.points.size());
        Point p = (Point) Day9.points.stream().findFirst().get();
        Assertions.assertEquals(0,p.x);
        Assertions.assertEquals(0,p.y);
    }

    @Test
    void run() throws IOException {

        Day9.run("src/test/resources/9_test.txt");
        Assertions.assertEquals(13, Day9.points.size());
    }

}
