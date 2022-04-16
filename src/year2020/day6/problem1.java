package year2020.day6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class problem1 {
    public static void main(String[] args) {
        boolean[] letters = new boolean[27]; //for letters
        int sum = 0;
        try (Scanner cin = new Scanner(new File("src/year2020/day6/generatedInput.txt"))) {
            while (cin.hasNextLine()) {
                String[] input = cin.nextLine().split("");
                if (input[0].equals("")) {
                    System.out.println("New group");
                    for (int i = 0; i < 27; i++)
                        if (letters[i]) {
                            sum++;
                        }
                    System.out.println("Current sum: " + sum);
                    letters = new boolean[27];
                    continue;
                } else {
                    for (String c : input) {
                        letters[c.toCharArray()[0] - 'a'] = true;
                    }
                    System.out.println(Arrays.toString(Arrays.stream(input).toArray()));
                }
            }
            for (int i = 0; i < 27; i++)
                if (letters[i]) {
                    sum++;
                }
            System.out.println("The sum is: " + sum);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
