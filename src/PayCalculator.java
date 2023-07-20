import java.text.NumberFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class PayCalculator {

    private static final int REGULAR_HOUR = 40;
    private static final double OVERTIME_PAY_RATE = 1.5;

    private double taxRate;
    private int hoursRendered;
    private int ratePerHour;

    public PayCalculator(double taxRate, int hoursRendered, int ratePerHour) {
        this.taxRate = taxRate;
        this.hoursRendered = hoursRendered;
        this.ratePerHour = ratePerHour;
    }

    public double getRegularEarnings() {
        return ratePerHour * REGULAR_HOUR;
    }

    public double getOvertimeEarnings() {
        int overtimeHours = Math.max(0, hoursRendered - REGULAR_HOUR);
        return overtimeHours * OVERTIME_PAY_RATE * ratePerHour;
    }

    public double getTaxWithheld() {
        return getRegularEarnings() * taxRate;
    }

    public double getTotalNetEarnings() {
        return getRegularEarnings() + getOvertimeEarnings() - getTaxWithheld();
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            double taxRate = getValidTaxRate(scanner);
            int hoursRendered = getValidHoursRendered(scanner);
            int ratePerHour = getValidRatePerHour(scanner);

            PayCalculator payCalculator = new PayCalculator(taxRate, hoursRendered, ratePerHour);

            System.out.println("The Regular hour is: " + REGULAR_HOUR);
            System.out.println("The Overtime pay rate is: " + OVERTIME_PAY_RATE);
            System.out.println("The Overtime hour is: " + (hoursRendered - REGULAR_HOUR));
            System.out.println("The Regular earnings is: " + formatCurrency(payCalculator.getRegularEarnings()));
            System.out.println("The Overtime earnings is: " + formatCurrency(payCalculator.getOvertimeEarnings()));
            System.out.println("The Tax withheld is: " + formatCurrency(payCalculator.getTaxWithheld()));
            System.out.println("The Total net earnings is: " + formatCurrency(payCalculator.getTotalNetEarnings()));
        }
    }

    private static double getValidTaxRate(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Enter the tax rate (in decimal form, e.g., 0.1 for 10%): ");
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid decimal number.");
                scanner.nextLine(); // Clear the input buffer
            }
        }
    }

    private static int getValidHoursRendered(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Enter the hours rendered: ");
                int hoursRendered = scanner.nextInt();
                if (hoursRendered >= 0) {
                    return hoursRendered;
                } else {
                    System.out.println("Invalid input. Hours rendered cannot be negative.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine(); // Clear the input buffer
            }
        }
    }

    private static int getValidRatePerHour(Scanner scanner) {
        while (true) {
            try {
                System.out.print("Enter the rate per hour: ");
                int ratePerHour = scanner.nextInt();
                if (ratePerHour >= 0) {
                    return ratePerHour;
                } else {
                    System.out.println("Invalid input. Rate per hour cannot be negative.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
                scanner.nextLine(); // Clear the input buffer
            }
        }
    }

    private static String formatCurrency(double value) {
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
        return currencyFormat.format(value);
    }
}
