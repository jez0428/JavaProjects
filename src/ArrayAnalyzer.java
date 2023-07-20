import java.util.Scanner;

public class ArrayAnalyzer {

    public static void main(String[] args) {
        char answer;

        Scanner scan = new Scanner(System.in);
        do {
            int array[] = new int[10];

            for (int i = 0; i < array.length; i++) {
                System.out.print("Input " + (i + 1) + ": ");
                array[i] = scan.nextInt();
            }

            int max = getMax(array);
            System.out.println("The Highest Value is: " + max);

            int min = getMin(array);
            System.out.println("The Lowest Value is: " + min);

            int highestDiff = getHighestDifference(array);
            System.out.println("The difference between the lowest and highest is " + highestDiff);

            System.out.println();
            System.out.println("Try again? Y or N");
            answer = scan.next().charAt(0);
        } while (answer == 'Y' || answer == 'y');

        scan.close();
    }

    public static int getHighestDifference(int[] inputArray) {
        int highestDifference = 0;
        for (int firstIndex = 0; firstIndex < inputArray.length; firstIndex++) {
            for (int secondIndex = firstIndex + 1; secondIndex < inputArray.length; secondIndex++) {
                int difference = Math.abs(inputArray[firstIndex] - inputArray[secondIndex]);
                highestDifference = Math.max(highestDifference, difference);
            }
        }
        return highestDifference;
    }

    public static int getMax(int[] inputArray) {
        int maxValue = inputArray[0];
        for (int value : inputArray) {
            maxValue = Math.max(maxValue, value);
        }
        return maxValue;
    }

    public static int getMin(int[] inputArray) {
        int minValue = inputArray[0];
        for (int value : inputArray) {
            minValue = Math.min(minValue, value);
        }
        return minValue;
    }
}
