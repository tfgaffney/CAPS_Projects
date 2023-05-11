import java.util.*;

public class CAPS_Final {
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ArrayList<String> employeeFirstNames = new ArrayList<String>();
		ArrayList<String> employeeLastNames = new ArrayList<String>();
		ArrayList<Integer> employeeWages = new ArrayList<Integer>();
		ArrayList<String> employeeStartTimes = new ArrayList<String>();
		ArrayList<String> employeeEndTimes = new ArrayList<String>();
		ArrayList<String> startIndex = new ArrayList<String>();
		ArrayList<String> endIndex = new ArrayList<String>();
		
		//Checks if user wants to use the program
		System.out.println("Welcome to the GaffneyCo Employee Banking System!");
		System.out.println("To begin, you must enter information for at least one employee");
		System.out.println("Would you like to continue? [y/n]");
		String answer = input.next();
		if (answer.contains("n")) {
			System.exit(0);
		}
		//Asks user to input the first employee
		else {
			System.out.println("\nEnter Employee First Name:");
			String fName = input.next();
			System.out.println("Enter Employee Last Name:");
			String lName = input.next();
			System.out.println("Enter Employee Hourly Wage:");
			Integer wage = (int)(input.nextDouble() * 100);
			System.out.println("Enter Employee Start Time [hh:mm]:");
			String sTime = input.next();
			System.out.println("Does the Employee Start in AM or PM?:");
			String sInd = input.next();
			System.out.println("Enter Employee End Time [hh:mm]:");
			String eTime = input.next();
			System.out.println("Does the Employee End in AM or PM?:");
			String eInd = input.next();
			employeeFirstNames.add(fName);
			employeeLastNames.add(lName);
			employeeWages.add(wage);
			employeeStartTimes.add(sTime);
			employeeEndTimes.add(eTime);
			startIndex.add(sInd);
			endIndex.add(eInd);
		}
		
		while(true) {
			//Asks user to add or search
			System.out.println("\nWould you like to add more employees [1] or search existing employees [2]?");
			String choice1 = input.next().toLowerCase();
			
			//Case for add
			if(choice1.contains("1")) {
				System.out.println("\nEnter Employee First Name:");
				String fName = input.next();
				System.out.println("Enter Employee Last Name:");
				String lName = input.next();
				System.out.println("Enter Employee Hourly Wage:");
				Integer wage = (int)(input.nextDouble() * 100);
				System.out.println("Enter Employee Start Time [hh:mm]:");
				String sTime = input.next();
				System.out.println("Does the Employee Start in AM or PM?:");
				String sInd = input.next();
				System.out.println("Enter Employee End Time [hh:mm]:");
				String eTime = input.next();
				System.out.println("Does the Employee End in AM or PM?:");
				String eInd = input.next();
				employeeFirstNames.add(fName);
				employeeLastNames.add(lName);
				employeeWages.add(wage);
				employeeStartTimes.add(sTime);
				employeeEndTimes.add(eTime);
				startIndex.add(sInd);
				endIndex.add(eInd);
			}
			//Case for search
			else if(choice1.contains("2")) {
				System.out.println("\nEnter an employee's first name to find their hourly, daily, and weekly wages:");
				String eName = input.next();
				ArrayList<Integer> options = new ArrayList<Integer>();
				for(int i = 0; i < employeeFirstNames.size(); i ++) {
					if(employeeFirstNames.get(i).contains(eName)) {
						options.add(i);
					}
				}
				if(options.size() == 0) {
					System.out.println("\nNo Employee Found");
				}
				else if(options.size() == 1) {
					int index = options.get(0);
					System.out.println("\n" + employeeFirstNames.get(index) + " " + employeeLastNames.get(index) + ":");
					System.out.println("Hourly Wage: $" + ((double)(employeeWages.get(index)) / 100));
					double dailyWage = getDailyWage(getMinuteWage((double)(employeeWages.get(index)) / 100), getMinutesWorked(employeeStartTimes.get(index), employeeEndTimes.get(index), startIndex.get(index), endIndex.get(index)));
					System.out.println("Daily Wage: $" + dailyWage);
					System.out.println("Weekly Wage: $" + (dailyWage * 5));
				}
				//Case for multiple employees with the same name
				else {
					System.out.println("Multiple Employees Found. Enter Employee Last Name:");
					eName = input.next();
					int index = -1;
					for(int i = 0; i < employeeLastNames.size(); i ++) {
						if(employeeLastNames.get(i).contains(eName)) {
							index = i;
						}
					}
					if(index >= 0) {
						System.out.println("\n" + employeeFirstNames.get(index) + " " + employeeLastNames.get(index) + ":");
						System.out.println("Hourly Wage: $" + ((double)(employeeWages.get(index)) / 100));
						double dailyWage = getDailyWage(getMinuteWage((double)(employeeWages.get(index)) / 100), getMinutesWorked(employeeStartTimes.get(index), employeeEndTimes.get(index), startIndex.get(index), endIndex.get(index)));
						System.out.println("Daily Wage: $" + dailyWage);
						System.out.println("Weekly Wage: $" + (dailyWage * 5));
					}
					//case for not found
					else {
						System.out.println("Employee Not Found");
					}
				}
			}
			//Case for not choosing to add (1) or search (2)
			else {
				System.out.println("Not a valid option. Try Again");
				continue;
			}
			System.out.println("Would you like to continue viewing and adding employees? [y/n]");
			String next = input.next().toLowerCase();
			if(next.contains("n")) {
				break;
			}
		}
	}
	
	//Gets money made in a minute (hourly wage / 60)
	public static double getMinuteWage(double hourWage) {
		double minuteWage = (double)(hourWage) / 60;
		return minuteWage;
	}
	
	//Gets the number of minutes worked using start and stop time
	public static double getMinutesWorked(String startTime, String endTime, String startInd, String endInd) {	
		int hoursOne = ((int)(startTime.charAt(0) - 48) * 10) + (int)(startTime.charAt(1) - 48);
		int hoursTwo = ((int)(endTime.charAt(0) - 48) * 10) + (int)(endTime.charAt(1) - 48);
		int minutesOne = ((int)(startTime.charAt(3) - 48) * 10) + (int)(startTime.charAt(4) - 48);
		int minutesTwo = ((int)(endTime.charAt(3) - 48) * 10) + (int)(endTime.charAt(4) - 48);;
		
		if(startTime.substring(0, 2).contains("12") && startInd.contains("AM")) {
			hoursOne = 0;
		}
		if(endTime.substring(0, 2).contains("12") && endInd.contains("AM")) {
			hoursTwo = 0;
		}
		
		int timeStart = (hoursOne * 60) + minutesOne;
		int timeEnd = (hoursTwo * 60) + minutesTwo;
		
		if(startInd.contains("P")) {
			timeStart += 720;
		}
		if(endInd.contains("P")) {
			timeEnd += 720;
		}
		
		return timeEnd - timeStart;
	}
	
	//Gets total money made in one day
	public static double getDailyWage(double minuteWage, double minutesWorked) {
		double dailyEarnings = minuteWage * minutesWorked;
		dailyEarnings = (int)(dailyEarnings * 100);
		dailyEarnings = dailyEarnings / 100;
		return dailyEarnings;
	}
	
}
