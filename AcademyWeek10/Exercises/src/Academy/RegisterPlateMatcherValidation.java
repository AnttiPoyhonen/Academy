package Academy;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterPlateMatcherValidation {

    private static String plate = null;
    private static String regex = "[A-ZÅÄÖ]{1,3}-[1-9][0-9]{0,2}";

    public static void main(String[] args) {

        while (true) {

            // query licence plate (XXX-XXX, letters-numbers, numbers cannot start with 0)
            queryPlate();
            if ("".equals(plate)) {
                continue;
            }

            // check plate against regex & report validation results
            checkPlate();

        }

    }

    private static void queryPlate() {

        Scanner in = new Scanner(System.in);

        plate = "";

        System.out.println("\nWhat is the license plate of your car? (XYZ-123, 'quit' ends)");
        plate = in.nextLine();
        plate = plate.toUpperCase();

        if ("".equals(plate)) {
            validationFail("The entry was empty.");
            return;
        } else if ("QUIT".equals(plate)) {
            System.out.println("\nQuitting...\n");
            System.exit(0);
        }

    }

    private static void validationFail(String reason) {

        System.out.println("\nNot a valid license. " + reason);

    }

    private static void checkPlate() {

        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(plate);

        if (m.matches()) System.out.println("\nThe license '" + plate.toUpperCase() + "' was valid.");
        else validationFail("Regex check failed.");

    }

}
