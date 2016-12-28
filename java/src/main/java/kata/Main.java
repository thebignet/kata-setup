package kata;

import java.util.Scanner;
public class Main {


    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();
        int number = validateInputIsNumber(input);
        new Lcd().displayDigitList(number);
    }

    private static Integer validateInputIsNumber(String input) {
        return Integer.valueOf(input);
    }
}
