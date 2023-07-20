import java.util.Scanner;

public class PalindromeChecker {

    public static void main(String[] args) {
        checkPalindrome();
    }

    public static void checkPalindrome() {
        String original, reverse = "";
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string to check if it is a palindrome: ");
        original = scanner.nextLine();

        int length = original.length();

        for (int i = length - 1; i >= 0; i--) {
            reverse = reverse + original.charAt(i);
        }

        if (original.equalsIgnoreCase(reverse)) {
            System.out.println("The string is a palindrome.");
        } else {
            System.out.println("The string isn't a palindrome.");
        }

        scanner.close();
    }
}
