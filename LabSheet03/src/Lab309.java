import javax.swing.*;

public class Lab309 {
    public static void main(String[] args) {
        int order_Menu = 0;
        do {
            int total_price = 0;
            order_Menu = JOptionPane.showConfirmDialog(null,
                    "Do you want to order menu?",
                    "Yakitori Shop",
                    JOptionPane.YES_NO_OPTION);
            if (order_Menu == JOptionPane.YES_OPTION){
                int menu_number;
                do {
                    menu_number = Integer.parseInt(JOptionPane.showInputDialog(null,
                            "Yakitori Menu\n" +
                                    "[1] Chcken Wing 99 B.\n" +
                                    "[2] Pork with Leek 89 B.\n" +
                                    "[3] Beef Tongue 109 B.\n" +
                                    "[0] Exit and Calculate\n" +
                                    "Enter menu number:"));
                    if (menu_number == 1) total_price += 99;
                    if (menu_number == 2) total_price += 89;
                    if (menu_number == 3) total_price += 109;
                }while (menu_number != 0);
                JOptionPane.showMessageDialog(null,"Total price is " + total_price + " Baht.");
            }
        }while (order_Menu != 1);
    }
}
