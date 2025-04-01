import java.util.Scanner;
import java.util.regex.Pattern;

public class SafeInput {
    public static String getString(Scanner pipe, String prompt) {
        System.out.print(prompt);
        return pipe.nextLine();
    }

    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        String input;
        boolean valid;
        do {
            System.out.print(prompt);
            input = pipe.nextLine();
            valid = Pattern.matches(regEx, input);
            if (!valid) {
                System.out.println("Invalid input. Please try again.");
            }
        } while (!valid);
        return input;
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int input = 0;
        boolean valid;
        do {
            System.out.print(prompt);
            if (pipe.hasNextInt()) {
                input = pipe.nextInt();
                pipe.nextLine(); // clear the buffer
                if (input >= low && input <= high) {
                    valid = true;
                } else {
                    System.out.println("Invalid input. Please enter a number between " + low + " and " + high + ".");
                    valid = false;
                }
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                valid = false;
                pipe.nextLine(); // clear the buffer
            }
        } while (!valid);
        return input;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        String input;
        boolean valid;
        do {
            System.out.print(prompt + " [Y/N]: ");
            input = pipe.nextLine();
            valid = input.equalsIgnoreCase("Y") || input.equalsIgnoreCase("N");
            if (!valid) {
                System.out.println("Invalid input. Please enter Y or N.");
            }
        } while (!valid);
        return input.equalsIgnoreCase("Y");
    }
}