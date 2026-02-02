import javax.swing.JOptionPane;

public class TicketUsed {
    public static String show_moive_list(Ticket...tickets){
        String list = "";
        for (Ticket t : tickets) {
        list += t.getTicket_id() + ": " + t.getMovie() + "\n";
        }
        return list;
    }

    public static void main(String[] args) {
        Ticket[] tickets = new Ticket[] {
            new Ticket("T001", new Movie("Titanic", 120,"PG-13"),"12:00", "B7", 280),
            new Ticket("T002", new Movie("Pokemon", 102, "PG"), "11:00", "G11", 240),
            new Ticket("T003", new Movie("Silent Hill", 125, "R-13"), "14:30", "H2", 240)
        };
         int want_book_used = JOptionPane.showConfirmDialog(null, "Do you want to book or used a ticket?","Ticket",JOptionPane.YES_NO_OPTION);
        do{
        if (want_book_used == JOptionPane.YES_OPTION) {
            String ticketId_iuput = JOptionPane.showInputDialog(show_moive_list(tickets) + "\nEnter a ticket id for booking:");
            for(Ticket t : tickets){
                if (t.getTicket_id().equalsIgnoreCase(ticketId_iuput)) {
                int menu = Integer.parseInt(JOptionPane.showInputDialog (t.getTicket_id() + ": " + t.getMovie() + "\n\nPress 1 to book a ticket" + "\nPress 2 to use a ticket" + "\nPress 3 to see a ticket status\n" +"\nEnter a menu:"));
                if (menu == 1) {
                    JOptionPane.showMessageDialog(null, t.bookTicket() + "\n--------------------\n" + t.toString());
                }
                if (menu == 2) {
                    JOptionPane.showMessageDialog(null, t.useTicket() + "\n--------------------\n" + t.toString());
                }
                if (menu == 3) {
                    JOptionPane.showMessageDialog(null, t.toString());
                }
            }
            }
        }
        else break;
        want_book_used = JOptionPane.showConfirmDialog(null, "Do you want to book or used other ticket?","Ticket",JOptionPane.YES_NO_OPTION);
        }while(true);
    }
}