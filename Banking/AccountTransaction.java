package Banking;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class AccountTransaction extends BankAccount implements Transactionable{

    public AccountTransaction(String accId){
        super(accId);
    }
    public boolean hasAccountId() throws FileNotFoundException {
        File filename = new File(getFilename());
        Scanner scanner = new Scanner(filename);
        while (scanner.hasNext()){
            String[] data =scanner.nextLine().split(",");
            String accId = data[0];
            double accBalance = Double.parseDouble(data[1]);
            if (accId.equalsIgnoreCase(getAccId())){
                setAccBalance(accBalance);
                scanner.close();
                return true;
            }
        }
        scanner.close();
        return false;
    }
    @Override
    public void deposit(double amount) {
        setAccBalance(getAccBalance()+amount);
    }

    @Override
    public void withdraw(double amount) {
        if (getAccBalance() >= amount) setAccBalance(getAccBalance()-amount);
    }

    @Override
    public double checkBalance() {
        return getAccBalance();
    }
}
