package year2022.day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day1 {

    static void problem1(Scanner cin) {
        long maxElf = -1, elfSum = 0;
        while (cin.hasNextLine()) {
            String input = cin.nextLine();
            if (input.equals("")) {
                if (maxElf < elfSum) {
                    maxElf = elfSum;
                }
                elfSum = 0;
            } else {
                elfSum += Integer.parseInt(input);
            }
        }
        System.out.println(maxElf);
    }

    static void problem2(Scanner cin) {
        long[] maxElf = new long[]{-1, -1, -1};
        long elfSum = 0;

        while (cin.hasNextLine()) {
            String input = cin.nextLine();
            if (input.equals("")) {
                if (maxElf[0] < elfSum) {
                    maxElf[2] = maxElf[1];
                    maxElf[1] = maxElf[0];
                    maxElf[0] = elfSum;
                } else if (maxElf[1] < elfSum) {
                    maxElf[2] = maxElf[1];
                    maxElf[1] = elfSum;
                } else if (maxElf[2] < elfSum) {
                    maxElf[2] = elfSum;
                }
                elfSum = 0;
            } else {
                elfSum += Integer.parseInt(input);
            }
        }
        if (maxElf[0] < elfSum) {
            maxElf[2] = maxElf[1];
            maxElf[1] = maxElf[0];
            maxElf[0] = elfSum;
        } else if (maxElf[1] < elfSum) {
            maxElf[2] = maxElf[1];
            maxElf[1] = elfSum;
        } else if (maxElf[2] < elfSum) {
            maxElf[2] = elfSum;
        }
        System.out.println(maxElf[0] + maxElf[1] + maxElf[2]);
    }

    public static void main(String[] args) {
        try (Scanner cin = new Scanner(new File("src/year2022/day1/input.txt"))) {
            problem1(cin);
            problem2(cin);
        } catch (FileNotFoundException ignored) {
        }
    }
}
