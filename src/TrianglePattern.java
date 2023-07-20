import java.util.Scanner;

public class TrianglePattern {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of levels for the triangle pattern: ");
        int levels = getInputLevel(scanner);
        scanner.close();

        printTrianglePattern(levels);
    }

    static int getInputLevel(Scanner scanner) {
        int levels;
        while (true) {
            try {
                levels = Integer.parseInt(scanner.nextLine());
                if (levels <= 0) {
                    System.out.print("Please enter a positive integer: ");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.print("Invalid input! Please enter a positive integer: ");
            }
        }
        return levels;
    }

    static void printTrianglePattern(int levels) {
        for (int i = levels; i >= 1; i--) {
            printSpaces(levels - i);
            printHalfTriangle(i);
            printSupplement(i);
            System.out.println();
        }
    }

    static void printSpaces(int spaces) {
        for (int space = 1; space <= spaces; space++) {
            System.out.print("  ");
        }
    }

    static void printHalfTriangle(int i) {
        for (int j = i; j <= 2 * i - 1; j++) {
            System.out.print("* ");
        }
    }

    static void printSupplement(int i) {
        for (int j = 0; j < i - 1; j++) {
            System.out.print("* ");
        }
    }
}
