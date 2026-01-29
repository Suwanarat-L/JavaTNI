import javax.swing.JOptionPane;

public class TicketBooking {
    public static String select_showtime(Movie movie){
        int num = Integer.parseInt(JOptionPane.showInputDialog((movie.toString()+ "\nPress 1 to select show tome = 13:00"
            + "\nPress 2 to select show time = 14:30" + "\nPress 3 to select show time = 15:00"
            + "\nEnter a number")));
            if (num == 1) return "13:00";
            if (num == 2) return "14:30";
            if (num == 3) return "15:00";
            return "Error time";
    }

    public static String select_seat_number(){
        String row = JOptionPane.showInputDialog("Selcet seat row [A-G]");
        char rowChar = row.toUpperCase().charAt(0);
        int num =  Integer.parseInt(JOptionPane.showInputDialog("Select seat number [1-12]"));
        return  rowChar + Integer.toString(num);
    }

    public static void main(String[] args) {
        Movie movie = new Movie("Titanic",120,"PG-13");
        String show_time = select_showtime(movie);
        String seat_number = select_seat_number();
        Ticket ticket = new Ticket("T001",movie,show_time,seat_number,240);
        int booked = JOptionPane.showConfirmDialog(null, "Do you want to book a " + movie.getTitle() + " ticket?",
    "Book Ticket",JOptionPane.YES_NO_OPTION);
        if (booked == JOptionPane.YES_OPTION) {
            ticket.bookTicket();
            JOptionPane.showMessageDialog(null, "Ticket booked successfully!!");
        }
        JOptionPane.showMessageDialog(null, ticket.toString());
    }
}
