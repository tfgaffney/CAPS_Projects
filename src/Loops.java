import java.util.*;
public class Loops {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("Enter lower bound:");
			int x = scanner.nextInt();
			System.out.println("Enter upper bound:");
			int y = scanner.nextInt();
			System.out.println("Would you like odd or even numbers?");
			String answer = scanner.next();
			answer = answer.toLowerCase();
			if(answer.contains("even")) {
				while(x <= y) {
					if(x % 2 == 0) {
						System.out.println(x);
					}
					x ++;
				}
			}
			else if (answer.contains("odd")) {
				for(int i = x; i <=y; i ++) {
					if(i % 2 == 1) {
						System.out.println(i);
					}
				}
			}
			System.out.println("Would you like to stop?");
			String next = scanner.next();
			next = next.toLowerCase();
			if(next.contains("y")) {
				break;
			}
		}
	}
}