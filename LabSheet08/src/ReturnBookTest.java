import javax.swing.*;

public class ReturnBookTest {
    public static void main(String[] args) {
        Book book = new Book("Java Programmimng", 5);
        while (true){
            int yes_no = JOptionPane.showConfirmDialog(null,"Do you want to borrow/return book?", "Borrow/Return Book", JOptionPane.YES_NO_OPTION);
            if (yes_no == JOptionPane.YES_OPTION){
                int menu = Integer.parseInt(JOptionPane.showInputDialog(null, "Press 1 to borrow book" + "\n" +
                        "Press 2 to return book"));
                if (menu == 1 ){
                    if (book.getAvailableBook() == 0){
                        JOptionPane.showMessageDialog(null,"No books available to borrow...", "Warning Message", JOptionPane.WARNING_MESSAGE);
                        break;
                    }
                    else {
                        book.borrowBook();
                        System.out.println("Borrowed 1 book, available " + book.getAvailableBook() + " books.");
                    }
                }
                else if (menu == 2){
                    if (book.getTotalBook() == book.getAvailableBook()){
                        JOptionPane.showMessageDialog(null,"Cannot return! All books are already here.", "Warning Message", JOptionPane.WARNING_MESSAGE);
                        break;
                    }
                    else {
                        book.returnBook();
                        System.out.println("Returned 1 book, available " + book.getAvailableBook() + " books.");
                    }
                }
                else break;
            } else break;
        }
        JOptionPane.showMessageDialog(null,"END PROGRAM");
    }
}
