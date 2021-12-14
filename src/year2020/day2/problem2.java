package year2020.day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class problem2 {
    public static void main(String[] args) {
        try (Scanner cin = new Scanner(new File("src/year2020/day2/generatedInput.txt"))) {
            int totalCorrectPasswords = 0;
            while (cin.hasNextLine()) {
                String[] input = cin.nextLine().split("[: -]");
                int firstPosition = Integer.parseInt(input[0]), secondPosition = Integer.parseInt(input[1]);
                boolean isOk = false;
                char[] password = input[4].toCharArray();
                char character = input[2].toCharArray()[0];
                for (int i = 0; i < password.length; i++) {
                    if ((password[firstPosition - 1] == character && password[secondPosition - 1] != character) || (password[firstPosition - 1] != character && password[secondPosition - 1] == character)) {
                        isOk = true;
                    }
                }
                if (isOk) {
                    totalCorrectPasswords++;
                }
            }
            System.out.println(totalCorrectPasswords);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}