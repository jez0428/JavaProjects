import java.util.Scanner;

public class StringSorting {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a string: ");
        char[] userInput = scanner.nextLine().toCharArray();

        for (int i = 0; i < userInput.length; i++) {
            for (int j = i + 1; j < userInput.length; j++) {
                if (userInput[i] >= userInput[j]) {
                    swapCharacters(i, j, userInput);
                }
            }
        }
        System.out.println("Ascending order: " + String.valueOf(userInput));

        scanner.close();
    }

    public static void swapCharacters(int i, int j, char[] userInput) {
        char temp = userInput[i];
        userInput[i] = userInput[j];
        userInput[j] = temp;
    }

}
