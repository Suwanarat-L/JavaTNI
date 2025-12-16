import java.util.Scanner;

public class Lab503 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a message: ");
        String message = scanner.nextLine();
        System.out.println("\nList of vowel in \"" + message + "\"");
        System.out.println("The letter 'A' appears " + count_vowel(message, 'a') + " time(s).");
        System.out.println("The letter 'E' appears " + count_vowel(message, 'e') + " time(s).");
        System.out.println("The letter 'I' appears " + count_vowel(message, 'i') + " time(s).");
        System.out.println("The letter 'O' appears " + count_vowel(message, 'o') + " time(s).");
        System.out.println("The letter 'U' appears " + count_vowel(message, 'u') + " time(s).");
    }
    static int count_vowel(String message, char leter){
        int count = 0;
        String lower_message = message.toLowerCase();
        for (int i = 0; i<lower_message.length(); i++){
            if (lower_message.charAt(i) == leter) count++;
        }
        return count;
    }
}
