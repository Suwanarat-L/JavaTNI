import javax.swing.*;
import java.text.DecimalFormat;

public class Lab307 {
    public static void main(String[] args) {
        DecimalFormat df = new DecimalFormat("#,###.0");
        int price = 0, total_price = 0;
        do {
            price = Integer.parseInt(JOptionPane.showInputDialog(null,"Input price [press 0 to stop]:"));
            if (price > 0) total_price += price;
            while (price < 0){
                price = Integer.parseInt(JOptionPane.showInputDialog(null,"Invalid price!!\nInput price [press 0 to stop]:"));
                total_price += price;
            }
        }while (price != 0);
        JOptionPane.showMessageDialog(null,"Total price is " + df.format(total_price) + " baht.");
    }
}
