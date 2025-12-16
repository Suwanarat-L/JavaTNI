import javax.swing.*;

public class Lab505 {
    public static void main(String[] args) {
        String word = JOptionPane.showInputDialog("Enter some word:");
        JOptionPane.showMessageDialog(null, word + " is" + (is_palindrome(word) ? " " : " NOT ") + "Palindrome");
    }
    static boolean is_palindrome(String word){
        word = word.trim().toLowerCase();
        String reversed_word = "";
        for (int i = word.length()-1; i >= 0; i--){
            reversed_word += word.charAt(i);
        }
        return word.equals(reversed_word);
    }
}
