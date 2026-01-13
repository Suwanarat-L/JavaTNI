import java.util.Scanner;

public class ProductMain2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Product product1 = new Product();
        product1.name = "Pens";
        product1.price = 10.5;
        product1.quantity = 50;
        Product product2 = new Product();
        product2.name = "Notebooks";
        product2.price = 25.75;
        product2.quantity = 20;

        System.out.println("Welcome to Mini Shop");
        System.out.println("------------------------------------");
        System.out.println("Press [1] to buy Pen");
        System.out.println("Press [2] to buy Notebook");
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        while (number < 1 ||number > 2){
            System.out.print("Invalid number! Enter a number, again: ");
            number = scanner.nextInt();
        }
        System.out.println();

        if (number == 1){
            product1.showInfo();
            System.out.println("------------------------------------");
            System.out.print("How many Pens do you want to buy? ");
            product1.sell(scanner.nextInt());
            System.out.println("------------------------------------");
            product1.showInfo();
        }

        if (number == 2){
            product2.showInfo();
            System.out.println("------------------------------------");
            System.out.print("How many Pens do you want to buy? ");
            product2.sell(scanner.nextInt());
            System.out.println("------------------------------------");
            product2.showInfo();
        }
    }
}
