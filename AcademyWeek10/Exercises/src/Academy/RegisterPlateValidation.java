package Academy;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterPlateValidation {

    private static String plate = null;

    public static void main(String[] args) {

        while (true) {

            // query licence plate (XXX-XXX, letters-numbers, numbers cannot start with 0)
            queryPlate();
            if ("".equals(plate)) continue;

            // check plate against regex & report if validation does not fail and exit program
            checkPlate();

            System.out.println("\nThe license '" + plate.toUpperCase() + "' was valid.\n");

        }

    }

    private static void queryPlate() {

        Scanner in = new Scanner(System.in);

        plate = "";

        System.out.println("\nWhat is the license plate of your car? (XYZ-123, 'quit' ends)");
        plate = in.nextLine();

        if ("".equals(plate)) {
            validationFail("The entry was empty.");
            return;
        } else if ("quit".equals(plate)) {
            System.out.println("\nQuitting...\n");
            System.exit(0);
        }

    }

    private static void validationFail(String reason) {

        System.out.println("\nNot a valid license. " + reason + "\n");

    }

    private static void checkPlate() {

        if (plate.length() < 3) {
            validationFail("The entry is not long enough.");
        } else if (plate.length() > 7) {
            validationFail("The entry is too long.");
        }

        int dash = plate.indexOf('-');

        if (!(dash > 0 && dash < 4)) {
            validationFail("A license has a '-' character between letter(s) and number(s).");
        }

        String letters = plate.substring(0, dash);
        Matcher letterMatcher = Pattern.compile("[^a-z^A-Z]").matcher(plate);
        letters = letterMatcher.replaceAll("");

        if (letters.length() == 0 || letters.length() > 3) {
            validationFail("The first 1-3 characters at the beginning have to be letters!");
        }

        String numbers = plate.substring(dash + 1);
        Matcher numberMatcher = Pattern.compile("\\D{1}").matcher(plate);
        numbers = numberMatcher.replaceAll("");
        
        System.out.println("Letters: " + letters + ", Numbers: " + numbers);

        if (numbers.length() == 0 || numbers.length() > 3) {
            validationFail("The last 1-3 characters at the end have to be numbers!");
        }
        if (numbers.charAt(0) == '0') {
            validationFail("The first number of the numbers cannot be '0'!");
        }

    }

}
