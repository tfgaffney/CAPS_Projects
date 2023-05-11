public class card {
    
	private String suit;
    private String value;
    private int numVal;

    public card(String suit, String value, int numVal) {
        this.suit = suit;
        this.value = value;
        this.numVal = numVal;
    }
    
    public String getSuit() {
        return suit;
    }
    
    public void setSuit(String suit) {
        this.suit = suit;
    }
    
    public String getValue() {
        return value;
    }
    
    public int getNumVal() {
        return numVal;
    }
   
    public void setValue(String value, int numVal) {
        this.value = value;
        this.numVal = numVal;
    }

    public String toString() {
        return "\n"+value + " of "+ suit;
    }
}