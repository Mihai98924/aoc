package year2020.day7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class problem1 {
    public static void main(String[] args) {
        try (Scanner cin = new Scanner(new File("src/year2020/day7/generatedInput.txt"))) {
            int counter = 0;
            while (cin.hasNextLine()) {
                String[] input = cin.nextLine().split("[,. ]");
                System.out.println(Arrays.toString(input));
                for (int i = 2; i < input.length; i++) {
                    if (input[i].equals("shiny") && input[i + 1].equals("gold")) {
                        counter++;
                    }
                }
            }
            System.out.println("Total bags: " + counter);
        } catch (FileNotFoundException ignored) {
        }
    }
}
