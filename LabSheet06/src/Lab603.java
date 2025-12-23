import java.util.Random;
import java.util.Scanner;

public class Lab603 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = random_aray();
        System.out.print("Enter your guess (0-20): ");
        int guess_number = scanner.nextInt();
        int count = count_element(numbers, guess_number);
        if (count > 0){
            System.out.println("\nCongratulation!! " + guess_number + " is an element in the array!!");
            if (count > 1) System.out.println("Fantastic!! It also appears more than once!!");
        }
        else{
            System.out.println("\nSorry, try again next time...");
            display_array(numbers);
        }
    }
    static int[] random_aray(){
        Random random = new Random();
        int[] number = new int[10];
        for (int i = 0; i<=number.length-1; i++){
            number[i] = random.nextInt(20);
        }
        return number;
    }
    static void display_array(int[] numbers){
        System.out.print("Here are the elements in the array: ");
        for (int i = 0; i <= numbers.length-1; i++){
            System.out.print(numbers[i] + " ");
        }
    }
    static int count_element(int[] numbers, int element){
        int count = 0;
        for (int i = 0; i <= numbers.length-1; i++){
            if (numbers[i] == element) count++;
        }
        return count;
    }
}
