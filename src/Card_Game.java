import java.util.*;

public class Card_Game {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int chips = 100;
		deck game = new deck();
		int bet = 0;
		int tBet = 0;
	
		while (chips > 0) { 	
			bet = 0;
			tBet = 0;
			hand player = new hand(game, 2);
			hand cpu = new hand(game, 2);
			hand dealer = new hand(game, 3);
	        int pScore = 0;
	        String pName = "Player";
	        int cScore = 0;
	        String cName = "CPU";
	        String dName = "Community Cards";
	        cpu.sort();
	        player.sort();
	        player.printHand(pName + "'s hand");
	        bet = bet(chips, tBet);
			tBet += bet;
	        chips -= bet;
	        System.out.println();
	        player.printHand(pName + "'s hand:");
	        dealer.printHand(dName);
	        cpu.printHand(cName);
	        bet = bet(chips, tBet);
			tBet += bet;
	        chips -= bet;
	        dealer.getHand().add(game.getRandomCard());
	        System.out.println();
	        player.printHand(pName + "'s hand");
	        dealer.printHand(dName);
	        cpu.printHand(cName);
	        bet = bet(chips, tBet);
			tBet += bet;
	        chips -= bet;
	        dealer.getHand().add(game.getRandomCard());
	        System.out.println();
	        player.printHand(pName + "'s hand");
			dealer.printHand(dName);
			cpu.printHand(cName);
			cpu.printHand(cName);
			bet = bet(chips, tBet);
			tBet += bet;
	        chips -= bet;
	        computerHand(cpu, dealer);
	        playerHand(player, dealer);
	        player.sort();
	        cpu.sort();
	        System.out.println();
	        player.printHand(pName + "'s hand");
	        checkAll(pName, player);
	        cpu.printHand(cName + "'s hand");
	        checkAll(cName, cpu);
	        pScore = player.getScore();
	        cScore = cpu.getScore();
	        if (pScore > cScore) {
	        	System.out.println("Player Wins!");
	        	chips += bet * 2;
	        }
	        else if (pScore < cScore) {
	        	System.out.println("Player loses!");
	        }
	        else {
	        	System.out.println("It's a draw!");
	        	chips += bet;
	        }
	        if (chips > 0 ) {
	        	System.out.println("Would you like to stop playing? [y/n]");
		        String answer = scanner.next().toLowerCase();
		        	if (answer.contains("y")) {
		        		break;
		        	}
		        System.out.println();
	        }
	        else {
	        	System.out.println("You have no more chips to bet...");
	        }    
		}
	}
	
	public static int bet(int chips, int cBet) {
		Scanner scanner = new Scanner(System.in);
		int bet = 0;
		while (true) {
			System.out.println("You have " + chips + " chips, and your current bet is " + cBet);
        	System.out.println("How many chips would you like to bet?");
        	bet += (int) scanner.nextDouble();
        	if (bet > chips) {
        		System.out.println("You cannot bet more chips than you have!");
        		continue;
        	}
        	else {
        		break;
        	}
        }
		return bet;
	}
	
	public static void checkAll(String name, hand check) {
		check.checkForMatch(name);
		check.checkForStraight(name);
		check.checkForFlush(name);
		check.checkForRoyalFlush(name);
		if (check.getScore() == 0) {
			System.out.println(name + " has nothing..." + "\n");
		}
	}
	
	public static void playerHand(hand user, hand flop) {
		Scanner input = new Scanner(System.in);
		deck tempD = new deck();
		hand temp = new hand(tempD, 0);
		for (int i = 0; i < 5; i ++) {
			temp.getHand().add(flop.getHand().get(i));
		}
		temp.getHand().add(user.getHand().get(0));
		temp.getHand().add(user.getHand().get(1));
		temp.sort();
		user.getHand().clear();
		for (int i = 0; i < 5; i ++) {
			temp.printHand("\n" + "Playable Cards");
			System.out.println("Which card would you like to play? [1 - " + temp.getHand().size() + "]");
			int play = input.nextInt();
			user.getHand().add(temp.getHand().get(play - 1));
			temp.getHand().remove(play - 1);
		}
	}
	
	public static void computerHand(hand com, hand flop) {
		deck tempD = new deck();
		hand temp = new hand(tempD, 0);
		for (int i = 0; i < 5; i ++) {
			temp.getHand().add(flop.getHand().get(i));
		}
		temp.getHand().add(com.getHand().get(0));
		temp.getHand().add(com.getHand().get(1));
		temp.sort();
		com.getHand().clear();
		for (int i = 0; i < 5; i ++) {
			int play = (int) (Math.random() * temp.getHand().size());
			com.getHand().add(temp.getHand().get(play));
			temp.getHand().remove(play);
		}
	}
}
