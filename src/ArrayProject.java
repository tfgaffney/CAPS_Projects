import java.util.*;

public class ArrayProject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Object>> people = new ArrayList<ArrayList<Object>>();
		Scanner input = new Scanner(System.in);;
		
		ArrayList<Object> bob = new ArrayList<Object>();
		bob.add("Billy");
		bob.add("Bob");
		bob.add(73);
		bob.add(84);
		bob.add("123-456-7890");
		people.add(bob);
		ArrayList<Object> rob = new ArrayList<Object>();
		rob.add("Rob");
		rob.add("Robertson");
		rob.add(12);
		rob.add(48);
		rob.add("012-345-6789");
		people.add(rob);
		ArrayList<Object> pob = new ArrayList<Object>();
		pob.add("Pob");
		pob.add("Pobertson");
		pob.add(15);
		pob.add(60);
		pob.add("999-999-9999");
		people.add(pob);
		
		while(true) {
			System.out.println("Would you like to search your array, add entries, or stop? [search/add/stop]");
			String answer = input.next().toLowerCase();
			if(answer.contains("search")) {
				if(answer.length() == 0) {
					System.out.println("You have no entries in your array");
				}
				else {
					System.out.println("Would you like to search by entries or values? [entries/values]");
					String search = input.next().toLowerCase();
					if(search.contains("entries")) {
						while(true) {
							System.out.println("Your Array Has " + people.size() + " Entries. Enter the Index You Would Like to View [1-" + people.size() + "]");
							int index = input.nextInt();
							if(index > people.size()) {
								System.out.println("Value too High. Try Again.");
							}
							else {
								System.out.println((String)people.get(index-1).get(0) + " " + (String)people.get(index-1).get(1) + ", " + (int)people.get(index-1).get(2) + " Years Old, " + (int)people.get(index-1).get(3) + " Inches Tall, " + (String)people.get(index-1).get(4));
								break;
							}
						}
					}
					if(search.contains("values")) {
						System.out.println("Would like you like to search by first name [1], last name [2], age [3], height[4], or phone number [5]");
						int searchChoice = input.nextInt();
						if(searchChoice == 1) {
							System.out.println("Enter First Name:");
							String name = input.next();
							int index = -1;
							for(int i = 0; i < people.size(); i ++) {
								if(name.contains((String)people.get(i).get(0))) {
									index = i;
								}
							}
							if(index < 0) {
								System.out.println("No Person Found");
							}
							else {
								System.out.println((String)people.get(index).get(0) + " " + (String)people.get(index).get(1) + ", " + (int)people.get(index).get(2) + " Years Old, " + (int)people.get(index).get(3) + " Inches Tall, " + (String)people.get(index).get(4));						
							}
						}
						else if(searchChoice == 2) {
							System.out.println("Enter Last Name:");
							String name = input.next();
							int index = -1;
							for(int i = 0; i < people.size(); i ++) {
								if(name.contains((String)people.get(i).get(1))) {
									index = i;
								}
							}
							if(index < 0) {
								System.out.println("No Person Found");
							}
							else {
								System.out.println((String)people.get(index).get(0) + " " + (String)people.get(index).get(1) + ", " + (int)people.get(index).get(2) + " Years Old, " + (int)people.get(index).get(3) + " Inches Tall, " + (String)people.get(index).get(4));						
							}
						}
						else if(searchChoice == 3) {
							System.out.println("Enter Age:");
							int name = input.nextInt();
							int index = -1;
							for(int i = 0; i < people.size(); i ++) {
								if(name == (int)people.get(i).get(2)) {
									index = i;
								}
							}
							if(index < 0) {
								System.out.println("No Person Found");
							}
							else {
								System.out.println((String)people.get(index).get(0) + " " + (String)people.get(index).get(1) + ", " + (int)people.get(index).get(2) + " Years Old, " + (int)people.get(index).get(3) + " Inches Tall, " + (String)people.get(index).get(4));						
							}
						}
						else if(searchChoice == 4) {
							System.out.println("Enter Height in Inches:");
							int name = input.nextInt();
							int index = -1;
							for(int i = 0; i < people.size(); i ++) {
								if(name == (int)people.get(i).get(3)) {
									index = i;
								}
							}
							if(index < 0) {
								System.out.println("No Person Found");
							}
							else {
								System.out.println((String)people.get(index).get(0) + " " + (String)people.get(index).get(1) + ", " + (int)people.get(index).get(2) + " Years Old, " + (int)people.get(index).get(3) + " Inches Tall, " + (String)people.get(index).get(4));						
							}
						}
						else if(searchChoice == 5) {
							System.out.println("Enter Phone Number:");
							String name = input.next();
							int index = -1;
							for(int i = 0; i < people.size(); i ++) {
								if(name.contains((String)people.get(i).get(4))) {
									index = i;
								}
							}
							if(index < 0) {
								System.out.println("No Person Found");
							}
							else {
								System.out.println((String)people.get(index).get(0) + " " + (String)people.get(index).get(1) + ", " + (int)people.get(index).get(2) + " Years Old, " + (int)people.get(index).get(3) + " Inches Tall, " + (String)people.get(index).get(4));						
							}
						}
						else {
							System.out.println("Not a Valid Choice");
						}
					}
				}
			}
			else if(answer.contains("add")) {
				System.out.println("Enter First Name");
				String fName = input.next();
				System.out.println("Enter Last Name");
				String lName = input.next();
				System.out.println("Enter Age");
				int age = input.nextInt();
				System.out.println("Enter Height [inches]");
				int height = input.nextInt();
				System.out.println("Enter Phone Number");
				String number = input.next();
				ArrayList<Object> person = new ArrayList<Object>();
				person.add(fName);
				person.add(lName);
				person.add(age);
				person.add(height);
				person.add(number);
				people.add(person);
				}
			else if (answer.contains("stop")) {
				break;
			}
			}
		}
	}

