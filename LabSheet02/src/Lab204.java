import java.util.Scanner;

public class Lab204 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hour, minute;
        System.out.print("Input hour   : ");
        hour = Integer.parseInt(scanner.next());
        System.out.print("Input minute : ");
        minute = Integer.parseInt(scanner.next());
        int total_time = (hour * 60) + minute;
        System.out.println("Total time is " + total_time + " minutes");
    }
}
