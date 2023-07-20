import java.util.InputMismatchException;
import java.util.Scanner;

public class CelsiusFahrenheit {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Convert converter = new Convert();

        System.out.print("Input 1 for Celsius or 2 for Fahrenheit: ");
        int choice = 0;
        try {
            choice = scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid integer.");
            System.exit(0);
        } finally {
            scan.close(); // Use try-with-resources to automatically close the Scanner.
        }

        switch (choice) {
            case 1:
                System.out.print("Input Temperature in Fahrenheit: ");
                double fahrenheit = scan.nextDouble();
                converter.setFahrenheit(fahrenheit);
                System.out.println("The Temperature in Celsius is: " + converter.fahrenheitToCelsius());
                break;
            case 2:
                System.out.print("Input Temperature in Celsius: ");
                double celsius = scan.nextDouble();
                converter.setCelsius(celsius);
                System.out.println("The Temperature in Fahrenheit is: " + converter.celsiusToFahrenheit());
                break;
            default:
                System.out.println("Invalid choice. Please select 1 or 2.");
        }
    }

    static class Convert {
        private double fahrenheit;
        private double celsius;
        private static final double FAHRENHEIT_TO_CELSIUS_FACTOR = 5.0 / 9.0;
        private static final double CELSIUS_TO_FAHRENHEIT_FACTOR = 9.0 / 5.0;

        public void setFahrenheit(double fahrenheit) {
            this.fahrenheit = fahrenheit;
        }

        public void setCelsius(double celsius) {
            this.celsius = celsius;
        }

        public double fahrenheitToCelsius() {
            return (fahrenheit - 32) * FAHRENHEIT_TO_CELSIUS_FACTOR;
        }

        public double celsiusToFahrenheit() {
            return celsius * CELSIUS_TO_FAHRENHEIT_FACTOR + 32;
        }
    }
}
