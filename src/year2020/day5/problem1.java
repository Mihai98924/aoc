package year2020.day5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class problem1 {
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
            while (cin.hasNextLine()) {
                rowSeat = 0;
                columnSeat = 0;
                char[] input = cin.nextLine().toCharArray();
                binarySearch(input);
                if (maxID < (rowSeat * 8 + columnSeat))
                    maxID = (rowSeat * 8 + columnSeat);
            }
            System.out.println(maxID);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
