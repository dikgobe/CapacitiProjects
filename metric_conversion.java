import java.util.Scanner;

public class UnitConverter {

    public static void main(String[] args) {
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);

        // Get user input for the conversion
        System.out.print("Enter the unit you want to convert from (Feet, Pounds, Fahrenheit): ");
        String unitFrom = scanner.nextLine().toLowerCase();

        System.out.print("Enter the unit you want to convert to (Meters, Kgs, Celsius): ");
        String unitTo = scanner.nextLine().toLowerCase();

        System.out.print("Enter the quantity to be converted: ");
        double quantity = scanner.nextDouble();

        // Perform the conversion based on user input
        double result = 0.0;

        switch (unitFrom) {
            case "feet":
                if (unitTo.equals("meters")) {
                    result = feetToMeters(quantity);
                } else {
                    invalidUnits();
                    return;
                }
                break;

            case "pounds":
                if (unitTo.equals("kgs")) {
                    result = poundsToKgs(quantity);
                } else {
                    invalidUnits();
                    return;
                }
                break;

            case "fahrenheit":
                if (unitTo.equals("celsius")) {
                    result = fahrenheitToCelsius(quantity);
                } else {
                    invalidUnits();
                    return;
                }
                break;

            default:
                invalidUnits();
                return;
        }

        // Display the result
        System.out.printf("%.2f %s is equal to %.2f %s%n", quantity, unitFrom, result, unitTo);
    }

    // Conversion functions
    private static double feetToMeters(double feet) {
        return feet * 0.3048;
    }

    private static double poundsToKgs(double pounds) {
        return pounds * 0.453592;
    }

    private static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    private static void invalidUnits() {
        System.out.println("Invalid units selected. Please choose valid conversion units.");
    }
}

