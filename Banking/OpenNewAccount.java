package Banking;

import java.io.*;
import java.util.Scanner;

public class OpenNewAccount extends BankAccount{
    public OpenNewAccount(String accId, double accBalance){
        super(accId,accBalance);
    }
    public String recordAccount() throws IOException {
        FileWriter filename = new FileWriter(getFilename(),true);
        PrintWriter writer = new PrintWriter(filename);
        if (isExistingAccount(getAccId())) {
            return "This account has been created!!";
        }
        else {
            writer.println(super.toString());
            writer.close();
            return "Created account success!!";
        }
    }
    private boolean isExistingAccount(String account_name) throws FileNotFoundException {
        File filename = new File(getFilename());
        Scanner scanner = new Scanner(filename);
        while (scanner.hasNext()){
            String[] data =scanner.nextLine().split(",");
            String accId = data[0];
            double accBalance = Double.parseDouble(data[1]);
            if (accId == account_name){
                scanner.close();
                return true;
            }
        }
        scanner.close();
        return false;
    }
}
