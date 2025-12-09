import java.util.Scanner;

public class Lab405 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input some sentence: ");
        String sentence = scanner.nextLine();
        while (sentence.endsWith(".") == false){
            System.out.print("The sentence must end with full stop point: ");
            sentence = scanner.nextLine();
        }
        String[] text =sentence.split(" ");
        System.out.println();
        for (String word : text) System.out.println(word);
    }
}
