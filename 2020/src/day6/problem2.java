package year2020.day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class problem2 {
    public static void main(String[] args) {
        int[] letters = new int[27]; //for letters
        int sum = 0, numberOfPersons = 0;
        try (Scanner cin = new Scanner(new File("src/year2020/day6/generatedInput.txt"))) {
            while (cin.hasNextLine()) {
                String[] input = cin.nextLine().split("");
                if (input[0].equals("")) {
                    System.out.println("New group");
                    for (int i = 0; i < 27; i++)
                        if (letters[i] == numberOfPersons) {
                            sum++;
                        }
                    System.out.println("Current sum: " + sum);
                    letters = new int[27];
                    numberOfPersons = 0;
                    continue;
                } else {
                    numberOfPersons++;
                    for (String c : input) {
                        letters[c.toCharArray()[0] - 'a']++;
                    }
                    System.out.println(Arrays.toString(Arrays.stream(input).toArray()));
                }
            }
            for (int i = 0; i < 27; i++)
                if (letters[i] == numberOfPersons) {
                    sum++;
                }
            System.out.println("The sum is: " + sum);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
