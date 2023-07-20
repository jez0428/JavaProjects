import java.util.Scanner;

public class TowerOfHanoi {
    static String pegA = "", pegB = "", pegC = "";
    public static int moveCount = 0;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the number of disks: ");
            int numDisks = scanner.nextInt();

            for (int i = numDisks; i > 0; i--) {
                pegA += i;
            }

            towerOfHanoi(numDisks, 'A', 'B', 'C');
        }
        System.out.println("Total moves: " + moveCount);
    }

    public static void towerOfHanoi(int numDisks, char source, char auxiliary, char destination) {
        if (numDisks == 1) {
            // Move the top disk from the source to the destination peg
            moveDisk(source, destination);
            moveCount++;
        } else {
            // Move (numDisks-1) disks from the source peg to the auxiliary peg
            towerOfHanoi(numDisks - 1, source, destination, auxiliary);
            // Move the remaining disk from the source to the destination peg
            moveDisk(source, destination);
            moveCount++;
            // Move (numDisks-1) disks from the auxiliary peg to the destination peg
            towerOfHanoi(numDisks - 1, auxiliary, source, destination);
        }
    }

    public static void moveDisk(char fromPeg, char toPeg) {
        try {
            String disk = pegA.substring(pegA.length() - 1);
            pegA = pegA.substring(0, pegA.length() - 1);

            switch (toPeg) {
                case 'A':
                    pegA = disk + pegA;
                    break;
                case 'B':
                    pegB = disk + pegB;
                    break;
                case 'C':
                    pegC = disk + pegC;
                    break;
            }

            System.out.println("A: " + pegA + "\nB: " + pegB + "\nC: " + pegC);
            System.out.println("------");
        } catch (StringIndexOutOfBoundsException e) {
            // If the peg is empty, do nothing and proceed to the next step
        }
    }
}
