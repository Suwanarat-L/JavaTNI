public class BirthdayCake extends Bakery{
    private String message;
    private double pound;
    BirthdayCake(String message, double pound, String flavor, double unitPrice){
        super(flavor,unitPrice);
        this.message = message;
        this.pound = pound;
    }
    String getMessage(){
        return this.message;
    }
    void changeMessage(String new_message){
        this.message = new_message;
    }
    @Override
    public int getPackingCost(){
        if (this.pound >= 3) return 10;
        return super.getPackingCost();
    }
    public double calcucalteTotalPrice(){
        return (getUnitPrice()*this.pound) +getPackingCost();
    }
    public String toString(){
        return super.toString() +
        "\n" + getFlavor() + "birthday cake (message = " + this.message + ")\n"
        + "Total price of Birthday Cake = " + this.calcucalteTotalPrice();
    }
}
