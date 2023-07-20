import java.util.Scanner;

public class ReverseWord {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter a word:");
            String word = scanner.nextLine();
            word = word.trim();

            String reversedWord = reverseWord(word);
            System.out.println("The reverse: " + reversedWord);
        }
    }

    public static String reverseWord(String word) {
        char[] charArray = word.toCharArray();
        int start = 0;
        int end = charArray.length - 1;

        while (start < end) {
            char temp = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = temp;

            start++;
            end--;
        }

        return new String(charArray).trim();
    }
}
