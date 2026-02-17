package Banking;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BankSystem1 {
    public static String input_account_id(){
        Scanner scanner = new Scanner(System.in);
        String accId = "";
        boolean is_loop = true;
        while (is_loop){
            System.out.print("Enter account id: ");
            accId = scanner.next();
            if (accId.length() == 10) is_loop = false;
        }
        return accId;
    }
    public static double input_initial_balance(){
        Scanner scanner = new Scanner(System.in);
        int amount = 0;
        System.out.print("Enter your initial deposit amount: ");
        boolean is_loop = true;
        while (is_loop){
            try {
                amount = scanner.nextInt();
                is_loop = false;
            }catch (InputMismatchException e){
                scanner.next();
                System.out.print("Try again!! Enter your initial deposit amount: ");
            }
        }
        return amount;
    }

    public static void main(String[] args) throws IOException {
        String account_bank = input_account_id();
        System.out.println();
        double initial_balance = input_initial_balance();
        System.out.println();
        OpenNewAccount account = new OpenNewAccount(account_bank,initial_balance);
        account.recordAccount();
        System.out.println("Created account success!!");
    }
}
