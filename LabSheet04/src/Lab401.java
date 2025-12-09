import javax.swing.*;

public class Lab401 {
    public static void main(String[] args) {
        String fullname, firstname = "", lastname = "";
        boolean check = false;
        do {
            fullname = JOptionPane.showInputDialog("Enter you full name:");
            fullname = fullname.trim();
            int space = fullname.indexOf(" ");
            if (space >= 1){
                firstname = fullname.substring(0,space);
                lastname = fullname.substring(space);
                lastname = lastname.toUpperCase();
                check = true;
            }
        }while (!check);

        JOptionPane.showMessageDialog(null,"Welcome, " + firstname + lastname);
    }
}
