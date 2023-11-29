import java.util.InputMismatchException;
import java.util.Scanner;
 
public class UnitConverter {
 
    public static void main(String[] args) {
 
        // Create a Scanner object to read user input
        Scanner scanner = new Scanner(System.in);
 
        // Keep asking the user for input until they choose to exit
        while (true) {
          System.out.printf("\n\n-------WELCOME TO MIDNIGHT CODERS UNIT CONVERTER-------\n");
            try {
                // Display conversion options to the user
                System.out.println("\n\nChoose the unit you want to convert from:");
                System.out.println("1. Feet");
                System.out.println("2. Pounds");
                System.out.println("3. Fahrenheit");
                System.out.println("4. Exit");
 
                // Get user input for the conversion option
                int conversionOption = scanner.nextInt();
 
                // Validate user input
                if (conversionOption == 4) {
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                } else if (conversionOption < 1 || conversionOption > 3) {
                    System.out.println("Invalid option. Please choose a valid conversion option (1, 2, 3, or 4 to exit).");
                    continue;
                }
 
                // Get user input for the quantity to be converted
                System.out.print("Enter the quantity to be converted:");
                double quantity = scanner.nextDouble();
                System.out.printf("\n\n");
                // Perform the conversion based on the user's selected option
                double result = 0.0;
                String unitFrom = "";
                String unitTo = "";
 
                switch (conversionOption) {
                    case 1:
                        unitFrom = "Feet";
                        unitTo = "Meters";
                        result = feetToMeters(quantity);
                        break;
                    case 2:
                        unitFrom = "Pounds";
                        unitTo = "Kgs";
                        result = poundsToKgs(quantity);
                        break;
                    case 3:
                        unitFrom = "Fahrenheit";
                        unitTo = "Celsius";
                        result = fahrenheitToCelsius(quantity);
                        break;
                }
                System.out.printf("-------------results-----------------");
                // Display the result
                System.out.printf("\n\n%.2f %s is equal to %.2f %s%n", quantity, unitFrom, result, unitTo);
            } catch (InputMismatchException e) {
                // Handle the case where the user enters a non-numeric value
                System.out.println("Invalid input. Please enter a numeric value.");
                scanner.nextLine(); // Consume the invalid input to prevent an infinite loop
            }
        }
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
}

