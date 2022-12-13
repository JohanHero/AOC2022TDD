package org.aoc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;

public class Day9Part2Test {


    @BeforeEach
    void clearPoints(){
        Day9.points.clear();
    }
    @Test
    void moveRight(){



    }
    @Test
    void run() throws IOException {

        Day9Part2.run("src/test/resources/9Part2_test.txt");
        System.out.println(Day9Part2.sumPoints.size());

    }

}
