package year2021.day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class problem2 {
    public static void main(String[] args) {
        try (Scanner cin = new Scanner(new File("src/year2021/day2/givenInput.txt"))) {
            long product = 1, horizontal = 0, depth = 0, aim = 0;
            while (cin.hasNextLine()) {
                String[] input = cin.nextLine().split(" ");
                int numericalValue = Integer.parseInt(input[1]);
                switch (input[0]) {
                    case "forward":
                        horizontal += numericalValue;
                        depth = depth + aim * numericalValue;
                        break;
                    case "up":
                        aim -= numericalValue;
                        break;
                    case "down":
                        aim += numericalValue;
                        break;
                }
            }
            product = horizontal * depth;
            System.out.println("Total product: " + product);
        } catch (FileNotFoundException ignored) {
        }
    }
}
