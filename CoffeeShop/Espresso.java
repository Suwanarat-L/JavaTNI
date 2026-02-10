package CoffeeShop;

public class Espresso extends Drink {
    private int shot;

    Espresso(String size){
        super("Espresso",35,size);
    }

    void addShot(int shot){
        this.shot += shot;
    }

    int getShot() {
        return shot;
    }

    public String toString(){
        return super.toString() + (getShot()>0 ? "\nAdd " + shot + " shot" : "") +
                "\nTotal price = " + calculateFinalPrice() + " Baht";
    }

    @Override
    double calculateFinalPrice() {
        return getBasePrice()+(shot*15)+getSizeExtra();
    }
}
