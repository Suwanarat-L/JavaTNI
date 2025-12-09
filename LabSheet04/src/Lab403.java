import javax.swing.*;

public class Lab403 {
    public static void main(String[] args) {
        final String USERNAME = "admin", PASSWORD = "Admin1234";
        do {
            String username = JOptionPane.showInputDialog(null,"Enter username:");
            String password = JOptionPane.showInputDialog(null,"Enter password:");
            if (username.equalsIgnoreCase(USERNAME) && password.equals(PASSWORD)){
                JOptionPane.showMessageDialog(null,"Login Success!!");
                break;
            }
            else {
                JOptionPane.showMessageDialog(null,"Login Fail...", "Incorrect username or password", JOptionPane.WARNING_MESSAGE);
            }
        }while (true);
    }
}
