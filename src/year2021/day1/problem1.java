package year2021.day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class problem1 {
    public static void main(String[] args) {
        try (Scanner cin = new Scanner(new File("src/year2021/day1/givenInput.txt"))) {
            int previousMeasurement = -100, countNumberOfChanges = 0;
            while (cin.hasNextLine()) {
                int currentMeasurement = Integer.parseInt(cin.nextLine());
                if (previousMeasurement != -100 && previousMeasurement < currentMeasurement) {
                    countNumberOfChanges++;
                }
                previousMeasurement = currentMeasurement;
            }
            System.out.println("Number of measurements: " + countNumberOfChanges);
        } catch (FileNotFoundException ex) {
        }
    }
}
