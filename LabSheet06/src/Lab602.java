import java.util.Scanner;

public class Lab602 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] movie = {"Me Before You", "Titanic", "Before Sunrise","The Holiday", "A Walk to Remember"};
        double[] rate_scores = {4.2, 4.9, 4.4,3.7,4.3};
        System.out.print("Enter a movie title: ");
        String title = scanner.nextLine();
        boolean found = false;
        int index = 0;
        for (int i = 0; i <= movie.length-1 ; i++){
            if (movie[i].equalsIgnoreCase(title)){
                index = i;
                found = true;
                break;
            }
        }
        if (found){
            System.out.println("\nThe rating score of \"" + movie[index] + "\" is " + rate_scores[index]);
            System.out.println("This movie is ranked number " + find_rank(rate_scores, rate_scores[index]));
        }
        else System.out.println("\nCannot found this movie title...");
    }
    static int find_rank(double[] scores, double movie_score){
        int rank = 1;
        for (double s : scores){
            if (s > movie_score) rank++;
        }
        return rank;
    }
}
