package year2021.day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class problem2 {
    public static void main(String[] args) {
        try (Scanner cin = new Scanner(new File("src/year2021/day1/givenInput.txt"))) {
            int countNumberOfChanges = 0, sumOne = 0, sumTwo = 0, sumThree = 0, sumFour = 0, i = 0, j = 0;
            boolean done = false;
            while (cin.hasNextLine()) {
                int currentMeasurement = Integer.parseInt(cin.nextLine());
//                sumOne += currentMeasurement;
//                for (int j = 1; j <= 3; j++) {
//                    currentMeasurement = Integer.parseInt(cin.nextLine());
//                    sumOne+=currentMeasurement;
//                    sumTwo+= currentMeasurement;
//                    if(j>1) {
//                        for(int k = 1;k<3;k++) {
//
//                        }
//                    }
//                }
                i++;
                if (i == 1) {
                    sumOne += currentMeasurement;
                } else if (i == 2) {
                    sumOne += currentMeasurement;
                    j++;
                    sumTwo += currentMeasurement;
                } else if (i == 3) {
                    sumOne += currentMeasurement;
                    j++;
                    sumTwo += currentMeasurement;
                    sumThree += currentMeasurement;
                } else {
                    j++;
                    sumTwo += currentMeasurement;
                    sumThree += currentMeasurement;
                    sumFour += currentMeasurement;
                    if (sumOne < sumTwo && j == 3) {
                        countNumberOfChanges++;
                    }
                    sumOne = sumTwo;
                    sumTwo = sumThree;
                    sumThree = sumFour;
                    sumFour = 0;
                    i = 3;
                    j = 2;
                }
            }
            System.out.println("Number of measurements: " + countNumberOfChanges);
        } catch (FileNotFoundException ignored) {
        }
    }
}
