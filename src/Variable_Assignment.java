import java.util.*;
public class Variable_Assignment {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		while (true) {
			System.out.println("Would you like to enter strings or numbers, or would you like to stop");
			String answer = input.next();
			answer = answer.toLowerCase();
			
			if (answer.contains("num")) {
				System.out.println("Enter Number One:");
				int num1 = input.nextInt();
				System.out.println("Enter Number Two:");
				int num2 = input.nextInt();
				System.out.println(num1 + num2);
			}
			else if (answer.contains("str") || answer.contains("text")) {
				//System.out.println("Enter Text:");
				//String text = input();
				String name = input.nextLine();
				System.out.println("Enter Text: "+ name);
				name += input.nextLine();
				System.out.println("You said, \"" + name + "\"");
			}
			
			else if (answer.contains("stop") || answer.contains("end"))
			{
				break;
			}
			System.out.println();
		}	
	}
}
