import java.util.Scanner;

public class Lab308 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many number to input: ");
        int cardinal_number = scanner.nextInt();
        int maxNumber = 0, minNumber = 0, evenNumber = 0, oddNumber = 0;
        for (int i = 1; i <= cardinal_number ; i++){
            System.out.print("Enter number " + i + ": ");
            int number = scanner.nextInt();
            if (number > maxNumber) maxNumber = number;
            if (number < minNumber) minNumber = number;
            if (number % 2 == 0 ) evenNumber++;
            else oddNumber++;
        }
        System.out.print("\nMaximum = " + maxNumber +
                "\nMinimum = " + minNumber +
                "\nEven number = " + evenNumber +
                "\nOdd number = " + oddNumber);
    }
}
