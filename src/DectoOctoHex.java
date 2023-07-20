import java.util.InputMismatchException;
import java.util.Scanner;

public class DectoOctoHex {
    private int input;

    public DectoOctoHex() {
        Scanner scan = new Scanner(System.in);
        try {
            System.out.println("Enter a number: ");
            input = scan.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid integer.");
        } finally {
            scan.close(); // Use try-with-resources to automatically close the Scanner.
        }
    }

    public static void main(String[] args) {
        DectoOctoHex userinput = new DectoOctoHex();

        System.out.println("Decimal to Octal and Hexadecimal:");

        Convert converter = new Convert();
        System.out.print("Decimal to Octal: ");
        converter.decToOct(userinput.input);

        System.out.println("\n");

        System.out.print("Decimal to Hexadecimal: ");
        converter.decToHex(userinput.input);

        System.out.println("\n");
    }

    static class Convert {
        void decToOct(int input) {
            if (input == 0) {
                System.out.print("0");
                return;
            }

            StringBuilder octalNum = new StringBuilder();

            while (input != 0) {
                int rem = input % 8;
                octalNum.insert(0, rem);
                input /= 8;
            }

            System.out.print(octalNum);
        }

        void decToHex(int input) {
            if (input == 0) {
                System.out.print("0");
                return;
            }

            StringBuilder hexaDeciNum = new StringBuilder();

            while (input != 0) {
                int temp = input % 16;
                char digit = (temp < 10) ? (char) (temp + '0') : (char) (temp - 10 + 'A');
                hexaDeciNum.insert(0, digit);
                input /= 16;
            }

            System.out.print(hexaDeciNum);
        }
    }
}
