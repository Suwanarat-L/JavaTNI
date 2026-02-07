import javax.swing.JOptionPane;

public class CakeOrder3 {
    public static void main(String[] args) {
        int comfirm;
        double pound = Double.parseDouble(JOptionPane.showInputDialog(null,"How many pounds do you want?"));
        String flavor = JOptionPane.showInputDialog(null,"Enter a flavor birthday cake:");
        String message = JOptionPane.showInputDialog(null,"Enter a message on cake:");
        BirthdayCake order = new BirthdayCake(message, pound, flavor, 400);
        do{
            comfirm = JOptionPane.showConfirmDialog(null,order + "\n\nComfirm this order?");
            if (comfirm != JOptionPane.YES_OPTION) {
            message = JOptionPane.showInputDialog(null,"Enter a new message for changing:");
            }
        }while(comfirm != JOptionPane.YES_OPTION);
        JOptionPane.showMessageDialog(null, order);
    }
}
