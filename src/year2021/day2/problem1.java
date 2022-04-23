package year2021.day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class problem1 {
    public static void main(String[] args) {
        try (Scanner cin = new Scanner(new File("src/year2021/day2/givenInput.txt"))) {
            long product = 1, horizontal = 0, depth = 0;
            while (cin.hasNextLine()) {
                String[] input = cin.nextLine().split(" ");
                int numericalValue = Integer.parseInt(input[1]);
                switch (input[0]) {
                    case "forward":
                        horizontal += numericalValue;
                        break;
                    case "up":
                        depth -= numericalValue;
                        break;
                    case "down":
                        depth += numericalValue;
                        break;
                }
            }
            product = horizontal * depth;
            System.out.println("Total product: " + product);
        } catch (FileNotFoundException ignored) {
        }
    }
}
