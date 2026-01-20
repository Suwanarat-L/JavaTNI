import javax.swing.*;

public class BorrowBookTest {
    public static void main(String[] args) {
        Book book = new Book("C# Programming", 5);
        while (true){
            int borrow = JOptionPane.showConfirmDialog(null,"Do you want to borrow books?", "Borrow Books", JOptionPane.YES_NO_OPTION);
            if (borrow == JOptionPane.YES_OPTION){
                if (book.getAvailableBook() != 0){
                    book.borrowBook();
                    System.out.println("Borrowed 1 book, available " + book.getAvailableBook() + " books.");
                }
                else {
                    JOptionPane.showMessageDialog(null,"No books available to borrow...", "Warning Message", JOptionPane.WARNING_MESSAGE);
                    break;
                }
            }
            else break;
        }
        JOptionPane.showMessageDialog(null,"END PROGRAM");
    }
}
