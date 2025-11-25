import java.text.DecimalFormat;
import java.util.Scanner;
public class Lab202 {
    public static void main(String[] args) {
        DecimalFormat frm = new DecimalFormat("#");
        Scanner scanner = new Scanner(System.in);
        double number1, number2;
        System.out.print("Enter number 1: ");
        number1 = Double.parseDouble(scanner.next());
        System.out.print("Enter number 2: ");
        number2 = Double.parseDouble(scanner.next());

        System.out.println("\nSummation = " + frm.format(number1+number2));
        System.out.println("Subtraction = " + frm.format(number1-number2));
        System.out.println("Multiplication = " + frm.format(number1*number2));
        System.out.println("Division = " + (number1/number2));
        System.out.println("Modulus = " + frm.format(number1%number2));
    }
}
