import java.util.*;
public class Conditional {

	//Tommy Gaffney, 2/6/23, Purpose: Create a program to to read user input for number and 
	//tell if the number is positive, negative, or zero
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			System.out.println("Would you like to analyze numbers or time?");
			String answer1 = scanner.next();
			if (answer1.contains("num" )) {
				System.out.println("Enter a number:");
				int num = 0;
				String text = scanner.next();
				try {
					   int x = Integer.parseInt(text);
					   num = x;
					 }
				catch(NumberFormatException e) {
					   System.out.println(text + " is not a number"); 
					   continue;
					 } 
				if (num > 0) {
					System.out.println(num + " is positive");
				}
				else if (num < 0) {
					System.out.println(num + " is negative");
				}
				if (num == 0) {
					System.out.println(num + " equals zero");
				}
			}
			if (answer1.contains("time")) {
				while (true) {
					System.out.println("Enter hours [1-12]:");
					int hours = scanner.nextInt();
					if (hours > 12) {
						System.out.println("Not a valid time");
						break;
					}
					System.out.println("Enter minutes [1-59]:");
					int minutes = scanner.nextInt();
					if (minutes > 59) {
						System.out.println("Not a valid time");
						break;
					}
					System.out.println("AM or PM?");
					String time = scanner.next().toLowerCase();
					if (time.contains("p") && hours < 12) {
						hours += 12;
					}
					else if (time.contains("a") && hours == 12) {
						hours = 0;
					}
					if (minutes < 10) {
						System.out.println("Millitary time is " + hours + ":0" + minutes);
					}
					else {
						System.out.println("Millitary time is " + hours + ":" + minutes);
					}
					break;
				}
			}
			System.out.println("Would you like to stop?");
			String answer = scanner.next().toLowerCase();
			if (answer.contains("y")) {
				break;
			}
		}
	}
}
