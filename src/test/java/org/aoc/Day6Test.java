package org.aoc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class Day6Test {

    @Test
    void findStarterPacket() throws IOException {
        int find4DistinctChars = Day6.findDifferentCharactersInString(Util.readInputToString("src/test/resources/6_test.txt"),4);
        int find14DistinctChars = Day6.findDifferentCharactersInString(Util.readInputToString("src/test/resources/6_test.txt"),14);

        Assertions.assertEquals(1707, find4DistinctChars);
        Assertions.assertEquals(3697, find14DistinctChars);
    }
}
