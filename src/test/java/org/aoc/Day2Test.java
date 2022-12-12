package org.aoc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Day2Test {


    @Test
    void day2A() throws IOException {

        //1 för rock (A)(X)
        //2 för paper (B)(Y)
        //3 scissor  (C)(Z)
        //3 för lika 6 för vinst
        System.out.println(Util.readInputToString("src/test/resources/2_test.txt"));
        Assertions.assertEquals(8, Day2.getSumOfFight("A Y"));
        Assertions.assertEquals(1, Day2.getSumOfFight("B X"));
        Assertions.assertEquals(6, Day2.getSumOfFight("C Z"));
    }

    @Test
    void rockFight() {
        Assertions.assertEquals(4, Day2.rockFight("X"));
        Assertions.assertEquals(8, Day2.rockFight("Y"));
        Assertions.assertEquals(3, Day2.rockFight("Z"));
    }


    @Test
    void fightRiggedRock() {
        Assertions.assertEquals(3, Day2.rockFightRigged("X"));
        Assertions.assertEquals(4, Day2.rockFightRigged("Y"));
        Assertions.assertEquals(8, Day2.rockFightRigged("Z"));
    }

}
