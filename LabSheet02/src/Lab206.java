import javax.swing.*;
import java.text.DecimalFormat;

public class Lab206 {
    public static void main(String[] args) {
        final int buffet = 299;
        DecimalFormat frm = new DecimalFormat("#,###.00");
        int costomer = Integer.parseInt(JOptionPane.showInputDialog("How many costomer?"));
        double total = buffet * costomer + ((buffet * costomer)* 0.07);
        int discount = Integer.parseInt(JOptionPane.showInputDialog("Price with NET is " + frm.format(total) + " baht."
        + "\nHow much of discount(%) on your coupon?"));
        double total_price = total - (total*(discount/100.0));
        int customer_Paid = Integer.parseInt(JOptionPane.showInputDialog("Total price is " + frm.format(total_price) + " baht."
        + "\nEnter the amount the customer paid:"));
        double chang = customer_Paid - total_price;
        JOptionPane.showMessageDialog(null, "Total price is " + frm.format(total_price) + " baht."
        + "\nCustomer paid " + frm.format(customer_Paid) + " baht."
        + "\nGet change " + frm.format(chang) + " baht.");
    }
}
