import java.util.*;
public class student {

	private String name;
	private String gradeNum;
	private int numOfGrades;
	Scanner input = new Scanner(System.in);
	private ArrayList<Integer> grades = new ArrayList<Integer>();
	public student(String name, String gradeNum, int numOfGrades) {
		this.name = name;
		this.gradeNum = gradeNum;
		this.numOfGrades = numOfGrades;
		
		for(int i = 0; i < numOfGrades; i ++) {
			System.out.println("Enter grade #" + (i + 1));
			grades.add(input.nextInt());
		}
	}
	
	public String getName() {
		return name;
	}
	
	public String getGrade() {
		return gradeNum;
	}
	
	public double getAverage() {
		int total = 0;
		for(int i = 0; i < grades.size(); i ++) {
			total += grades.get(i);
		}
		
		return total / grades.size();
	}

}
