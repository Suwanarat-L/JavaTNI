public class Ticket {
    private String ticket_id;
    private Movie movie;
    private String show_time;
    private String seat_number;
    private double price;
    private boolean is_booked;
    private boolean is_used;

    public Ticket(String ticket_id, Movie movie, String show_time, String seat_number, double price){
        this.ticket_id = ticket_id;
        this.movie = movie;
        this.show_time = show_time;
        this.seat_number = seat_number;
        this.price = price;
        this.is_booked = false;
        this.is_used = false;
    }

    public Ticket(){
        this("", null, "", "", 0.0);
    }

    public String getTicket_id(){
        return this.ticket_id;
    }

    public Movie getMovie(){
        return this.movie;
    }

    public String bookTicket(){
        if (is_booked) return "This ticket is already booked";
        is_booked = true;
        return "Ticket booked successfully!!";
    }

    public String useTicket(){
        if (is_booked == false) return "Please book the ticket first";
        if (is_used) return "Ticket already used!";
        is_used = true;
        return "Enjoy the moive!!";
    }

    public String toString(){
        return "Ticket Id : " + this.ticket_id +
        "\nMoive : " + this.movie +
        "\nShow time : " + this.show_time +
        "\nSeat Number : " + this.seat_number +
        "\nTicker Price : " + this.price +
        "\nBooked : " + (is_booked ? "Yes" : "No") +
        "\nUsed : " + (is_used ? "Yes" : "No");
    }
}
