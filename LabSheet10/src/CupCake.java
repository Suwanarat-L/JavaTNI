public class CupCake extends Bakery{
    int piece;
    CupCake(int piece, String flavor, double unitPrice){
        super(flavor,unitPrice);
        this.piece = piece;
    }
    boolean isPackingBox(){
        return this.piece >=6;
    }
    int getBoxNumber(){
        return this.piece/6;
    }
    int getBagNumber(){
        return this.piece%6;
    }
    @Override
    public int getPackingCost(){
        if(isPackingBox()) return getBoxNumber() * super.getPackingCost();
        return 0;
    }
    public double calcucalteTotalPrice(){
        return (getUnitPrice()*this.piece) + getPackingCost() +(getBagNumber()*0.5);
    }
    public String toString(){
        return super.toString() +
        "\nCup cake (" + this.getFlavor() + ") with " + (this.isPackingBox()?this.getBoxNumber()+" Box " : "") + this.getBagNumber() + " Bag\n" +
        "Total price of Cup Cake = " + this.calcucalteTotalPrice();
    }
}
