public class CheeseCake extends Bakery{
    private int piece;
    CheeseCake(int piece, String flavor, double unitPrice){
        super(flavor,unitPrice);
        this.piece = piece;
    }
    boolean is_whole(){
        return this.piece >= 8;
    }
    int getCakeBoxNumber(){
        if (is_whole()) return this.piece/8;
        return 0;
    }
    int getMiniCakeBoxNumber(){
        return (this.piece%8)/2;
    }
    @Override
    public int getPackingCost(){
        if (is_whole()) return 10;
        return super.getPackingCost(); 
    }
    public double calcucalteTotalPrice(){
        return (getUnitPrice()*this.piece) + getPackingCost() + (getMiniCakeBoxNumber()*0.5) + (getCakeBoxNumber()*2);
    }
    public String toString(){
        return super.toString() + "\n" +
        getFlavor() + " Cheese cake with " + (is_whole() ? "Cake box " + getCakeBoxNumber() + " Box " : "") +
        (getMiniCakeBoxNumber()>=1 ? "Mini cake box " + getMiniCakeBoxNumber() + " Box " : "") + "\n" +
        "Total price of Cheese Cake = " + this.calcucalteTotalPrice();
    }
}
