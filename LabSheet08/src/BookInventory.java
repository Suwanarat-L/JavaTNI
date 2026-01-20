import javax.swing.*;

public class BookInventory {
    public static void main(String[] args) {
        Book[] books = new Book[3];

        for (int i = 0; i < books.length; i++){
            String title = JOptionPane.showInputDialog(null,"Enter book title:");
            int total = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the total number:"));
            books[i] = new Book(title, total);
        }

        for (Book book : books){
            System.out.println(book.getTitle() + " has " + book.getTotalBook() + " books, can borrow " + book.getAvailableBook() + " books.");
        }
    }
}
