import java.util.Scanner;

public class CakeOrder2 {
    public static String selecFlavor(){
        Scanner scanner = new Scanner(System.in);
        String[] flavors = {"Chocolate","Vanilla","Strawberry","Lemon","Red Velvet"};
        int choice;
        for(int i = 0; i < flavors.length; i++){
            System.out.println("Press " + (i+1) + " for " + flavors[i]);
        }
        do{
            System.out.print("Enter a flavor number : ");
            choice = scanner.nextInt();
        }while(choice < 1 || choice > flavors.length);
        switch (choice) {
            case 1:
                return flavors[0];
            case 2:
                return flavors[1];
            case 3:
                return flavors[2];
            case 4:
                return flavors[3];
            default:
                return flavors[4];
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press 1 to order Birthday Cake");
        System.out.println("Press 2 to order Cup Cake");
        System.out.println("Press 3 for Cheese Cake");
        System.out.print("Enter an option: ");
        int choice = scanner.nextInt();
        System.out.println();

        switch (choice) {
            case 1:
                String Flavor = selecFlavor();
                scanner.nextLine();
                System.out.print("\nEnter a message: ");
                String message = scanner.nextLine();
                System.out.print("How many pounds: ");
                int pound = scanner.nextInt();
                BirthdayCake BirthdayCake = new BirthdayCake(message, pound, Flavor, 350);
                System.out.println();
                System.out.println(BirthdayCake);
                break;
            case 2:
                Flavor = selecFlavor();
                scanner.nextLine();
                System.out.print("\nHow many pieces: ");
                int piece = scanner.nextInt();
                CupCake CupCake = new CupCake(piece, Flavor, 65);
                System.out.println();
                System.out.println(CupCake);
                break;
            case 3:
                Flavor =selecFlavor();
                scanner.nextLine();
                System.out.print("\nHow many pieces: ");
                piece = scanner.nextInt();
                CheeseCake cheeseCake = new CheeseCake(piece, Flavor, 350);
                System.out.println();
                System.out.println(cheeseCake);
                break;
            default:
                System.out.println("Wrong option!! Try again!!");
                break;
        }
    }
}
