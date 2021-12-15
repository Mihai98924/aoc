package year2020.day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class problem1 {
    static boolean[] isOk = new boolean[7];
    static int totalValidPassports = 0;

    static void passValidation() {
        for (boolean value : isOk) {
            if (!value) {
                return;
            }
        }
        totalValidPassports++;
    }

    static void verifyConditions(String[] input){
        for (String s : input) {
            if (s.equals("byr"))
                isOk[0] = true;
            else if (s.equals("iyr"))
                isOk[1] = true;
            else if (s.equals("eyr"))
                isOk[2] = true;
            else if (s.equals("hgt"))
                isOk[3] = true;
            else if (s.equals("hcl"))
                isOk[4] = true;
            else if (s.equals("ecl"))
                isOk[5] = true;
            else if (s.equals("pid"))
                isOk[6] = true;
        }
    }

    public static void main(String[] args) {
        try (Scanner cin = new Scanner(new File("src/year2020/day4/generatedInput.txt"))) {
            Arrays.fill(isOk, false);
            while (cin.hasNextLine()) {
                String[] input = cin.nextLine().split("[: ]");
                if (input[0].equals("")) {
                    passValidation();
                    Arrays.fill(isOk, false);
                } else {
                    verifyConditions(input);
                }
            }
            if(!cin.hasNextLine())
                passValidation();
            System.out.println(totalValidPassports);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
