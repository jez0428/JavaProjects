import java.util.Scanner;

public class PrimeAndCompositeNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char answer;

        do {
            System.out.println("Prime numbers between 1 to 100");
            printPrimeNumbers(100);

            System.out.println();
            System.out.println("Composite numbers between 1 to 100");
            printCompositeNumbers(100);

            System.out.println();
            System.out.print("Run again? (Y/N): ");
            answer = scanner.next().charAt(0);

        } while (answer == 'Y' || answer == 'y');

        scanner.close();
    }

    public static void printPrimeNumbers(int limit) {
        for (int number = 2; number <= limit; number++) {
            if (isPrime(number)) {
                System.out.print(number + " ");
            }
        }
    }

    public static void printCompositeNumbers(int limit) {
        for (int number = 4; number <= limit; number++) {
            if (!isPrime(number)) {
                System.out.print(number + " ");
            }
        }
    }

    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}
