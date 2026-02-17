package Banking;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class BankSystem2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your bank account: ");
        String accId = scanner.next();
        AccountTransaction account = new AccountTransaction(accId);
        if (account.hasAccountId()){
            System.out.println();
            System.out.println("Press 1 to deposit");
            System.out.println("Press 2 to withdraw");
            System.out.println("Press 3 to check balance");
            System.out.println("Press 4 to exit");
            System.out.println();
            boolean is_loop = true;
            int amount =0;
            while (is_loop){
                System.out.print("Enter a menu: ");
                int menu = scanner.nextInt();
                if (menu == 1){
                    System.out.print("Enter amount to deposit: ");
                    amount = scanner.nextInt();
                    account.deposit(amount);
                    System.out.println("You balance = " + account.checkBalance());
                }
                if (menu == 2 ){
                    System.out.print("Enter amount to withdraw: ");
                    amount = scanner.nextInt();
                    account.withdraw(amount);
                    System.out.println("You balance = " +account.checkBalance());
                }
                if (menu == 3){
                    System.out.print("You balance = " + account.checkBalance());
                }
                if (menu == 4) is_loop = false;
                System.out.println();
            }
        }
        else System.out.println("Bank account not found...");
    }
}
