import java.util.Scanner;

public class ProductMain4 {
    public static void setting_product(Product... products) {
        String[] names = {"Pens", "Pencils", "Markers", "Highlighters"};
        double[] prices = {25.5, 17.25, 30, 35};
        int[] quantities = {20, 35, 10, 40};
        for (int i=0; i<products.length; i++) {
            products[i] = new Product();
            products[i].name = names[i];
            products[i].price = prices[i];
            products[i].quantity = quantities[i];
        }
    }

    public static void main(String[] args) {
        Product[] products = new Product[4];
        setting_product(products);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to MINI SHOP!!");
        System.out.println("------------------------------------");
        System.out.println("Press 1 to buy Pens (items=20)");
        System.out.println("Press 2 to buy Pencils (items=35)");
        System.out.println("Press 3 to buy Markers (items=10)");
        System.out.println("Press 4 to buy Highlighters (items=40)");
        System.out.println("------------------------------------");
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        while (number < 1 ||number > 5){
            System.out.print("Invalid number! Enter a number, again: ");
            number = scanner.nextInt();
        }
        System.out.println("------------------------------------");
        if (number >=1 && number <= 5){
            System.out.print("How many " + products[number-1].name + " do you want to buy? ");
            products[number-1].sell(scanner.nextInt());
        }
        System.out.println();
        products[number-1].showInfo();
    }
}
