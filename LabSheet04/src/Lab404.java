import java.util.Scanner;

public class Lab404 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = "", message = "";
        int i=1;
        do {
            System.out.print("Enter word: ");
            word = scanner.nextLine();
            if (word.equalsIgnoreCase("stop")){
                break;
            }
            else message += word.trim() + " ";
        }while (true);
        System.out.println(message);
    }
}
