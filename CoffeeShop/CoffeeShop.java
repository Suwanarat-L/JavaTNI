package CoffeeShop;

import java.util.Scanner;

public class CoffeeShop {
    static Espresso orderEspresso() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a size: ");
        String size = scanner.next();
        Espresso espresso = new Espresso(size);
        System.out.print("Press 'y' or 'Y' for adding a shot: ");
        String addingShot = scanner.next();
        if (addingShot.equalsIgnoreCase("y")) {
            System.out.print("How many short for adding in Espresso: ");
            int shot = scanner.nextInt();
            espresso.addShot(shot);
        }
        return espresso;
    }

    static Frappuccino orderFrappuccino(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a size: ");
        String size = scanner.next();
        System.out.print("Do you would like to add whipped cream [y/Y]? ");
        String addwhipped = scanner.next();
        boolean whipped;
        if (addwhipped.equalsIgnoreCase("y")) {
            whipped = true;
        }
        else {
            whipped = false;
        }
        Frappuccino frappuccino = new Frappuccino(size,whipped);
        return frappuccino;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String orderMore;
        int countEspresso =0;
        int countFrappuccino =0;
        double totalPrice=0.0;
        do {
            System.out.println("Press 1 for ordering Espresso");
            System.out.println("Press 2 for ordering Frappuccino");
            System.out.print("Enter an option: ");
            int option = scanner.nextInt();
            if (option==1){
                Espresso espresso = orderEspresso();
                countEspresso++;
                totalPrice += espresso.calculateFinalPrice();
                System.out.println(espresso);
            }
            else if (option==2) {
                Frappuccino frappuccino = orderFrappuccino();
                countFrappuccino++;
                totalPrice += frappuccino.calculateFinalPrice();
                System.out.println(frappuccino);
            }
            else break;
            System.out.print("\nDo you want to order more [y/Y]?");
            orderMore = scanner.next();
        }while (orderMore.equalsIgnoreCase("y"));
        System.out.println("\nYou ordered " + countEspresso + " Espresso");
        System.out.println("You ordered " + countFrappuccino +" Frappuccino");
        System.out.println("Total Price = " + totalPrice );
    }
}