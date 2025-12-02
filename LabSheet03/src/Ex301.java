import javax.swing.*;

public class Ex301 {
    public static void main(String[] args) {
        double total_price = Double.parseDouble(JOptionPane.showInputDialog("Enter total price:"));
        int coupou = JOptionPane.showConfirmDialog(null,"Do you have coupon?","Coupon",JOptionPane.YES_NO_OPTION);
        if (coupou == JOptionPane.YES_OPTION){
            int discount_coupon = Integer.parseInt(JOptionPane.showInputDialog("How many discount(%)?"));
            double discount = total_price * discount_coupon /100;
            double pay = total_price - discount;
            JOptionPane.showMessageDialog(null,
                    "You get discount " + discount + " baht.\n" +
                    "Total price is " + pay + " baht.");
        }
        else {
            if (total_price >= 1500) {
                double discount = total_price * 10 /100;
                double pay = total_price - discount;
                JOptionPane.showMessageDialog(null,
                        "You get discount 10% (" + discount + ")" +
                                "\nTotal price is " + pay + " baht.");
            }
            }
            JOptionPane.showMessageDialog(null,
                    "Total price is " + total_price + " baht.");
        }
    }