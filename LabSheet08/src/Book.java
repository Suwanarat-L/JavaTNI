public class Book {
    private String title;
    private int totalBook;
    private int availableBook;

    Book(String title, int totalBook){
        this.title = title;
        this.totalBook = totalBook;
        this.availableBook = totalBook;
    }

    Book(String title){
        this(title,0);
    }

    Book(){
        this("",0);
    }

    String getTitle(){
        return this.title;
    }

    int getTotalBook(){
        return this.totalBook;
    }

    int getAvailableBook(){
        return this.availableBook;
    }

    void borrowBook(){
        if (availableBook > 0){
            this.availableBook -= 1;
        }
    }

    void returnBook(){
        if (availableBook < totalBook){
            this.availableBook += 1;
        }
    }
}
