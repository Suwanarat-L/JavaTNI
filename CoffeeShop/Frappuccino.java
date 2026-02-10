package CoffeeShop;

public class Frappuccino extends Drink {
    private boolean whipped;
    Frappuccino(String size, boolean whipped){
        super("Frappuccino",40,size);
        this.whipped = whipped;
    }
    public String toString(){
        return super.toString() + (whipped?"\nAdd whipped 15 Baht":"") +
                "\nTotal price = " + calculateFinalPrice() + " Baht";
    }
    @Override
    double calculateFinalPrice() {
        return getBasePrice()+(whipped?15:0)+getSizeExtra();
    }
}
