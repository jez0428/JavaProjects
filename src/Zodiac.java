import java.util.Scanner;

public class Zodiac {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int birthMonth;
        do {
            System.out.print("Input Your Birth Month (1-12): ");
            birthMonth = scanner.nextInt();
            if (birthMonth < 1 || birthMonth > 12) {
                System.out.println("Invalid birth month. Please try again.");
            }
        } while (birthMonth < 1 || birthMonth > 12);

        int day;
        do {
            System.out.print("Input the day (1-31): ");
            day = scanner.nextInt();
            if (day < 1 || day > 31) {
                System.out.println("Invalid day. Please try again.");
            }
        } while (day < 1 || day > 31);

        scanner.close();

        String zodiacSign = getZodiacSign(birthMonth, day);
        System.out.println("Your Zodiac sign is " + zodiacSign);
    }

    private static String getZodiacSign(int month, int day) {
        final int[][] zodiacRanges = {
            {3, 21, 4, 19}, // Aries
            {4, 20, 5, 20}, // Taurus
            {5, 21, 6, 20}, // Gemini
            {6, 21, 7, 22}, // Cancer
            {7, 23, 8, 22}, // Leo
            {8, 23, 9, 22}, // Virgo
            {9, 23, 10, 22}, // Libra
            {10, 23, 11, 21}, // Scorpio
            {11, 22, 12, 21}, // Sagittarius
            {12, 22, 1, 19}, // Capricorn
            {1, 20, 2, 18}, // Aquarius
            {2, 19, 3, 20} // Pisces
        };

        String zodiacSign = "Invalid";
        for (int[] range : zodiacRanges) {
            if ((month == range[0] && day >= range[1]) || (month == range[2] && day <= range[3])) {
                switch (range[2]) {
                    case 1: zodiacSign = "Capricorn"; break;
                    case 2: zodiacSign = "Aquarius"; break;
                    case 3: zodiacSign = "Pisces"; break;
                    case 4: zodiacSign = "Aries"; break;
                    case 5: zodiacSign = "Taurus"; break;
                    case 6: zodiacSign = "Gemini"; break;
                    case 7: zodiacSign = "Cancer"; break;
                    case 8: zodiacSign = "Leo"; break;
                    case 9: zodiacSign = "Virgo"; break;
                    case 10: zodiacSign = "Libra"; break;
                    case 11: zodiacSign = "Scorpio"; break;
                    case 12: zodiacSign = "Sagittarius"; break;
                }
                break;
            }
        }

        return zodiacSign;
    }
}
