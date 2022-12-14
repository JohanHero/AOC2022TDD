package org.aoc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day10 {
    public static List<Integer> sums = new ArrayList<>();
    public static int crtPos = 0;


    public static void main(String[] args) throws IOException {
        run(Util.readInputToString("src/main/resources/10.txt"));
        System.out.println("Part 1: " + sums.stream().mapToInt(i -> i).sum());
    }

    public static void run(String input) {
        Scanner scanner = new Scanner(input);

        StringBuilder stringBuilder = new StringBuilder();

        int cycles = 0;
        int value = 1;
        crtPos = 1;
        int collectSumThreshold = 20;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            if (line.contains("noop")) {
                cycles = getCyclesAndWritePixel(stringBuilder, cycles);
                if (cycles == collectSumThreshold) {
                    sums.add(value * cycles);
                    collectSumThreshold += 40;

                }
            }

            if (line.contains("addx")) {
                cycles = getCyclesAndWritePixel(stringBuilder, cycles);
                if (cycles == collectSumThreshold) {
                    sums.add(value * cycles);
                    collectSumThreshold += 40;
                }

                cycles = getCyclesAndWritePixel(stringBuilder, cycles);
                if (cycles == collectSumThreshold) {
                    sums.add(value * cycles);
                    collectSumThreshold += 40;
                }
                value += Integer.parseInt(line.substring(line.indexOf(" ") + 1));
                crtPos += Integer.parseInt(line.substring(line.indexOf(" ") + 1));
            }
        }
        System.out.println(stringBuilder.toString());
    }

    private static int getCyclesAndWritePixel(StringBuilder stringBuilder, int cycles) {
        if (cycles == crtPos - 1 || cycles == crtPos || cycles == crtPos + 1){
            stringBuilder.append("#");
        }
        else{
            stringBuilder.append(".");
        }
        cycles++;

        if (cycles == 40 || cycles == 80 || cycles == 120 || cycles == 160 || cycles == 200){
            stringBuilder.append("\n");
            crtPos += 40;
        }
        return cycles;
    }
}
