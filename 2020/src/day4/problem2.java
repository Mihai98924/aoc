package year2020.day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class problem2 {
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

    static void verifyConditions(String[] input) {
        try {
            for (int i = 0; i < input.length; i += 2) {
                if (input[i].equals("byr")) {
                    int year = Integer.parseInt(input[i + 1]);
                    if (1920 <= year && year <= 2002)
                        isOk[0] = true;
                } else if (input[i].equals("iyr")) {
                    int year = Integer.parseInt(input[i + 1]);
                    if (2010 <= year && year <= 2020)
                        isOk[1] = true;
                } else if (input[i].equals("eyr")) {
                    int year = Integer.parseInt(input[i + 1]);
                    if (2020 <= year && year <= 2030)
                        isOk[2] = true;
                } else if (input[i].equals("hgt")) {
                    String height = input[i + 1];
                    if (height.contains("in")) {
                        int heightNumber = Integer.parseInt(height.substring(0, 2));
                        if (59 <= heightNumber && heightNumber <= 76)
                            isOk[3] = true;
                    } else if (height.contains("cm")) {
                        int heightNumber = Integer.parseInt(height.substring(0, 3));
                        if (150 <= heightNumber && heightNumber <= 193)
                            isOk[3] = true;
                    }
                } else if (input[i].equals("hcl")) {
                    char[] color = input[i + 1].toCharArray();
                    if (color[0] == '#' && color.length == 7) {
                        boolean ok = true;
                        for (int j = 1; j < color.length; j++) {
                            if (!(('a' <= color[j] && color[j] <= 'f') || Character.isDigit(color[j]))) {
                                ok = false;
                                break;
                            }
                        }
                        if (ok)
                            isOk[4] = true;
                    }
                } else if (input[i].equals("ecl")) {
                    String eyeColors = "amb blu brn gry grn hzl oth";
                    if (eyeColors.contains(input[i + 1]))
                        isOk[5] = true;
                } else if (input[i].equals("pid")) {
                    char[] pidNumber = input[i + 1].toCharArray();
                    if (pidNumber.length == 9) {
                        boolean ok = true;
                        for (char c : pidNumber) {
                            if (!Character.isDigit(c)) {
                                ok = false;
                                break;
                            }
                        }
                        if (ok)
                            isOk[6] = true;
                    }
                }
            }
        } catch (NumberFormatException ignored) {

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
            if (!cin.hasNextLine())
                passValidation();
            System.out.println(totalValidPassports);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
