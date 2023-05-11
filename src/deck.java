import java.util.*;
import static java.lang.System.out;

public class deck {
    ArrayList<card> cards = new ArrayList<card>();
    ArrayList<card> backup = new ArrayList<card>();
    ArrayList<card> hand = new ArrayList<card>();
    int handValue;

    int[] numVals = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    String[] values = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
    String[] suit = {"Club", "Spade", "Diamond", "Heart"};

    public deck() {
        for(int i = 0; i < suit.length; i++) {
            for(int j=0; j < values.length; j++) {
                this.cards.add(new card(suit[i], values[j], numVals[j]));
            }
        }
        
        for(int i = 0; i < suit.length; i++) {
            for(int j=0; j < values.length; j++) {
                this.backup.add(new card(suit[i], values[j], numVals[j]));
            }
        }
        handValue = 0;
    }
    
    public void reset() {
    	cards = backup;
    }
    
    public ArrayList<card> getDeck() {
        return cards;
    }
    
    public card getRandomCard() {
    	int ran = (int) Math.floor(Math.random() * cards.size());
        card drawn = cards.get(ran);
        cards.remove(ran);
        if (cards.size() < 2) {
        	reset();
        }
    	return drawn;
    }
}