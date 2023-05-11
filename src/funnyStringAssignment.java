import java.util.*;

public class funnyStringAssignment {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (true) {
			System.out.println("Input a string:");
			String text = input.nextLine();
			System.out.println();
			System.out.println("Reversed string: " + reverse(text));
			System.out.println();
			System.out.println("Total number of charcters: " + totalChars(text));
			System.out.println();
			charNumbers(text);
			System.out.println();
			System.out.println("Would you like to enter another string? [y/n]");
			String answer = input.nextLine();
			if (answer.charAt(0) == 'n') {
				break;
			}
		}
	}
	
	public static int findLength(String text) {
	      int i = 0;
	      try {
	         for(i=0; ; i++)
	            text.charAt(i);
	      } catch(Exception e) {
	         // no operation
	      }
	      return i;
	   }
	
	public static String reverse(String text) {
		String revText = "";
		for(int i = findLength(text) - 1; i >= 0; i --) {
			revText += text.charAt(i);
		}
		return revText;
	}
	
	public static int totalChars(String text) {
		int charNum = 0;
		for (int i = 0; i < findLength(text); i ++) {
			charNum += 1;
		}
		return charNum;
	}
	
	public static void charNumbers(String text) {
		int length = findLength(text);
		char[] charArray = new char[length]; 
		int[] arr = new int[length];
		for (int i = 0; i < length; i ++) {
			charArray[i] = text.charAt(i);
		}
		for(int i = 0; i < length; i ++) {
				arr[i] += 1;
	            for(int j = i+1; j < length; j ++) {
	                if(charArray[i] == charArray[j]) {
	                	arr[i] += 1;
	                	charArray[j] = '`';
	                }
	            }
	        }
		System.out.println("Occurrences of each character in the string: ");
        for(int i = 0; i < length; i++) {
            if(charArray[i] != ' ' && charArray[i] != '`')
                System.out.println(charArray[i] + ": " + arr[i]);
            else if(charArray[i] == ' ' && charArray[i] != '`')
                System.out.println("Spaces: " + arr[i]);
        }
	}
}