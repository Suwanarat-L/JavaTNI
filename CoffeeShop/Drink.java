package CoffeeShop;

public abstract class Drink implements Priceable {
    private String drinkName;
    private double basePrice;
    private String size;
    Drink(String drinkName,double basePrice,String size){
        this.drinkName = drinkName;
        this.basePrice = basePrice;
        this.size = size;
    }

    String getDrinkName(){
        return drinkName;
    }

    abstract double calculateFinalPrice();

    public String toString(){
        return "Your order: " + drinkName + " (size: " + size.toUpperCase() + ")";
    }
    @Override
    public double getBasePrice(){
        return basePrice;
    }
    @Override
    public double getSizeExtra(){
        if (size.equalsIgnoreCase("s")) return 0;
        if (size.equalsIgnoreCase("m")) return 10;
        if (size.equalsIgnoreCase("l")) return 15;
        return -1;
    }
}
