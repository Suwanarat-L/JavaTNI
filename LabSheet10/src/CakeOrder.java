
import java.util.Scanner;

public class CakeOrder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Birthday Cake's Details :");
        System.out.print("Enter a message on cake : ");
        String message = scanner.nextLine();
        System.out.print("Enter a flavor : ");
        String flavor = scanner.next();
        System.out.print("How many pound : ");
        double pound = scanner.nextDouble();
        BirthdayCake order1 = new BirthdayCake(message,pound,flavor, 350);
        System.out.println(order1);

        System.out.println("\nCup Cake's Details : ");
        System.out.print("Enter a flavor : ");
        String cup_flavor = scanner.next();
        System.out.print("How many piece : ");
        int piece = scanner.nextInt();
        CupCake order2 = new CupCake(piece, cup_flavor, 65);
        System.out.println(order2);

        System.out.println("\nCheese cake's Details : ");
        System.out.print("Enter a flavor : ");
        String cheesecake_flavor = scanner.next();
        System.out.print("Hwo many pieces : ");
        int cheesecake_piece = scanner.nextInt();
        CheeseCake order3 = new CheeseCake(cheesecake_piece, cheesecake_flavor, 350);
        System.out.println(order3);

        System.out.println("\nTotal price = " + (order1.calcucalteTotalPrice() + order2.calcucalteTotalPrice() + order3.calcucalteTotalPrice()));
    }
}
