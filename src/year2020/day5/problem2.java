package year2020.day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class problem2 {
    static int rowSeat, columnSeat;
    static long maxID = -1;

    static void binarySearch(char[] input) {
        int leftRow = 0, rightRow = 127, middleRow, leftColumn = 0, rightColumn = 7, middleColumn;
        for (char c : input) {
            middleRow = (leftRow + rightRow + 1) / 2;
            middleColumn = (leftColumn + rightColumn + 1) / 2;
            if (c == 'F') {
                rightRow = middleRow;
            } else if (c == 'B')
                leftRow = middleRow;
            else if (c == 'L') {
                rightColumn = middleColumn;
            } else if (c == 'R') {
                leftColumn = middleColumn;
            }
        }
        rowSeat = leftRow;
        columnSeat = leftColumn;
    }

    public static void main(String[] args) {
        try (Scanner cin = new Scanner(new File("src/year2020/day5/givenInput.txt"))) {
            Set<Integer> seatIds = new HashSet<>();
            while (cin.hasNextLine()) {
                rowSeat = 0;
                columnSeat = 0;
                char[] input = cin.nextLine().toCharArray();
                binarySearch(input);
                seatIds.add(rowSeat * 8 + columnSeat);
            }
            Integer[] seats= seatIds.toArray(new Integer[0]);
            for (int i = 0; i < seats.length - 1; i++) {
                if(seats[i+1] != seats[i] + 1)
                    System.out.println(seats[i]+1);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
