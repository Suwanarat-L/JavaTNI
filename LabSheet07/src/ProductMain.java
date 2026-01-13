import javax.swing.*;

public class ProductMain {
    public static void main(String[] args) {
        Product product = new Product();
        JOptionPane.showMessageDialog(null,"Welcome to Product Stock System");
        product.name = JOptionPane.showInputDialog("Enter product name:");
        product.price = Double.parseDouble(JOptionPane.showInputDialog("Enter product price per item:"));
        product.quantity = Integer.parseInt(JOptionPane.showInputDialog("Enter product stock:"));
        product.showInfo();
        System.out.println();

        int addStock = JOptionPane.showConfirmDialog(null,"Do you want to add more item?",
                "Select an Option" ,JOptionPane.YES_NO_CANCEL_OPTION);
        if (addStock == 0)
            product.addStock(Integer.parseInt(JOptionPane.showInputDialog("How many items to add in stock?")));

        int changePrice = JOptionPane.showConfirmDialog(null,"Do you want to change price?",
                "Select an Option" ,JOptionPane.YES_NO_CANCEL_OPTION);
        if (changePrice == 0)
            product.changePrice(Double.parseDouble(JOptionPane.showInputDialog("How much is the new price per item?")));

        System.out.println();
        product.showInfo();
    }
}
