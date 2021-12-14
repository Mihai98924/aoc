package year2020.day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class problem1 {
    public static void main(String[] args) {
        try (Scanner cin = new Scanner(new File("src/year2020/day2/generatedInput.txt"))) {
            int totalCorrectPasswords = 0;
            while (cin.hasNextLine()) {
                String[] input = cin.nextLine().split("[: -]");
                int min = Integer.parseInt(input[0]), max = Integer.parseInt(input[1]), numberOfTotalApparitions = 0;
                char[] password = input[4].toCharArray();
                char character = input[2].toCharArray()[0];
                for (char c : password) {
                    if (c == character) {
                        numberOfTotalApparitions++;
                    }
                }
                if (numberOfTotalApparitions >= min && numberOfTotalApparitions <= max)
                    totalCorrectPasswords++;
            }
            System.out.println(totalCorrectPasswords);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
