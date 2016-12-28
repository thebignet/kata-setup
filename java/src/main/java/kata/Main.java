package kata;

import java.util.Scanner;

/**
 * Created by johan on 28/12/16.
 */
public class Main {


    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();
        int number = validateInputIsNumber(input);
        new Lcd().display(number);
    }

    private static Integer validateInputIsNumber(String input) {
        return Integer.valueOf(input);
    }
}
