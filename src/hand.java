import java.util.*;
public class hand {

	ArrayList<card> hand = new ArrayList<card>();
	int handValue = 0;
	
	public hand(deck deck, int total) {
		for (int i = 0; i < total; i ++) {
			hand.add(deck.getRandomCard());
		}
	}
	
	public void sort() {
    	ArrayList<card> sorted = new ArrayList<card>();
    	ArrayList<card> temp = hand;
    	while (temp.size() > 0) {
    		int temp1 = hand.get(0).getNumVal();
    		int tempIndex = 0;
    		for (int j = 1; j < hand.size(); j ++) {
    			int temp2 = hand.get(j).getNumVal();
    			if (temp2 < temp1) {
    				temp1 = temp2;
    				tempIndex = j;
    			}
    		}
    		sorted.add(temp.get(tempIndex));
    		temp.remove(tempIndex);
    	}
    	hand = sorted;
    }
	
	public void checkForMatch(String name) {
    	int twos = 0;
    	int threes = 0;
    	int fours = 0;
    	int matchIndex = 0;
    	for (int i = 0; i < hand.size(); i += matchIndex) {
    		int matchStreak = 0;
    		matchIndex = 0;
    		for (int j = i + 1; j < hand.size(); j ++) {
    			if (hand.get(j).getNumVal() == hand.get(i).getNumVal()) {
    				matchStreak += 1;
    				
    			}
    		}
    		if (matchStreak == 1) {
				twos += 1;
				matchIndex += 1;
			}
			else if (matchStreak == 2) {
				threes += 1;
				matchIndex += 2; 
			}
			else if (matchStreak == 3) {
				fours += 1;
				matchIndex += 3;
			}
			matchIndex += 1;
    	}
    	if (twos == 1 && threes == 0) {
    		handValue = 1;
    		System.out.println(name + " has one pair" + "\n");
    	}
    	else if (twos == 2) {
    		handValue = 2;
    		System.out.println(name + " has two pairs" + "\n");
    	}
    	else if (threes == 1 && twos == 0) {
    		handValue = 3;
    		System.out.println(name + " has three of a kind" + "\n");
    	}
    	else if (fours == 1) {
    		handValue = 7;
    		System.out.println(name + " has four of a kind" + "\n");
    	}
    	else if (twos == 1 && threes == 1) {
    		handValue = 6;
    		System.out.println(name + " has a full house" + "\n");
    	}
    }
    
    public void checkForFlush(String name) {
    	boolean flush = true;
    	for (int i = 0; i < hand.size() - 1; i ++) {
    		if (hand.get(i).getSuit() != hand.get(i + 1).getSuit()) {
    			flush = false;
    			break;
    		}
    	}
    	if (flush == true) {
    		handValue = 5;
    		System.out.println(name + " has a flush" + "\n");
    	}
    }
    
    public void checkForStraight(String name) {
    	boolean straight = true;
    	for (int i = 0; i < hand.size() - 1; i ++) {
    		if (hand.get(i).getNumVal() != (hand.get(i + 1).getNumVal() - 1)) {
				straight = false;
				break;
			}
    	}
    	if (straight == true) {
    		this.handValue = 4;
    		System.out.println(name + " has a straight" + "\n");
    	}
    }
    
    public void checkForRoyalFlush(String name) {
    	if(hand.get(0).getNumVal() == 1 && hand.get(1).getNumVal() == 10 && hand.get(2).getNumVal() == 11 && hand.get(3).getNumVal() == 12 && hand.get(4).getNumVal() == 13) {
    		for (int i = 0; i < hand.size() - 1; i ++) {
    			if(hand.get(i).getSuit() != hand.get(i + 1).getSuit()) {
    				break;
    			}
    		}
    		handValue = 10;
    		System.out.println(name + " has a royal flush" + "\n");
    	}
    }
    
    public int getScore() {
    	return handValue;
    }
    
    public void replaceHand(deck deck) {
    	Scanner input = new Scanner(System.in);
    	System.out.println("Would you like to replace any cards? [y/n]");
    	String draw = input.next();
    	if (draw.contains("y")) {
    		System.out.println("How many cards would you like to replace?");
    		int replaceVal = input.nextInt();
    		for (int i = 0; i < replaceVal; i ++) {
    			System.out.println("Which number card would you like to replace");
    			int replaceIndex = input.nextInt();
    			hand.remove(replaceIndex - 1); 
    			hand.add(replaceIndex - 1, deck.getRandomCard());
    		}
    	}
    }
    
    public ArrayList<card> getHand() {
    	return hand;
    }
    
    public void printHand(String name) {
    	System.out.println(name + ":");
    	for (int i = 0; i < hand.size(); i ++) {
    		System.out.println(hand.get(i).getValue() + " of " + hand.get(i).getSuit() + "s,");
    	}
    	System.out.println();
    }
}
