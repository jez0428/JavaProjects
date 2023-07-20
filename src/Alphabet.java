import java.util.Scanner;

public class Alphabet {
    char input;

    public Alphabet() {
        try (Scanner scan = new Scanner(System.in)) {
            System.out.println("Enter a character: ");
            input = scan.next().charAt(0);
        }
    }

    public static void main(String[] args) {
        Alphabet userinput = new Alphabet();
        alphaCheck(userinput.input);
    }

    static void alphaCheck(char input) {
        if ((input >= 'A' && input <= 'Z') || (input >= 'a' && input <= 'z'))
            System.out.println(input + " is an Alphabet");
        else
            System.out.println(input + " is not an Alphabet");
    }
}
