import java.util.*;

//Functions: Functions in Java are called methods, which runs a specified block of code each time it is called.
//Functions are useful when you need to reuse a line of code.
//Values that you put into functions are called parameters
//Ex: public String printName(String name) {
//	System.out.println(name);
//}

//Classes: Classes are lines of code that give the parameters for how to construct objects and what methods the objects will have.
//Classes are helpful because they allow you to create multiple objects without having to reuse the same code over and over

public class shapes {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while(true) {
			System.out.println("Would you like to analyze shapes or students?"); //asks what type of class the user wants to use
				String answer1 = input.next().toLowerCase();
				if(answer1.contains("stud")) {
					System.out.println("Enter student's name:");
					String name = input.next();
					System.out.println("Enter students grade level:");
					String gradeLevel = input.next();
					System.out.println("Enter the number of grades you would like to average:");
					int grades = input.nextInt();
					student stud = new student(name, gradeLevel, grades);
					System.out.println(stud.getName() + ", in grade " + stud.getGrade() +", has an average grade of " + stud.getAverage());
				}
				else if(answer1.contains("shap")) {
					System.out.println("What shape would you like to find the area of? (triangle, rectangle, circle, or trapezoid?");
					String shape = input.next().toLowerCase();
					if(shape.contains("tri")) { //checks if the user inputs a triangle then asks for parameters
						System.out.println("Enter base length:");
						double base = input.nextDouble();
						System.out.println("Enter height:");
						double height = input.nextDouble();
						triangle tri = new triangle(base, height);
						System.out.println("Your triangle's area is " + tri.getArea());
					}
					else if(shape.contains("rect")) { //checks if the user inputs a rectangle and asks for parameters
						System.out.println("Enter length:");
						double base = input.nextDouble();
						System.out.println("Enter Width:");
						double width = input.nextDouble();
						rectangle rect = new rectangle(base, width);
						System.out.println("Your rectangle's area is " + rect.getArea());
					}
					else if(shape.contains("circ")) { //checks if the user inputs a circle and asks for radius
						System.out.println("Enter radius:");
						double radius = input.nextDouble();
						circle circ = new circle(radius);
						System.out.println("Your circle's area is " + circ.getArea());
					}
					else if(shape.contains("trap")) { //checks if the user inputs a trapezoid and asks for parameters
						System.out.println("Enter base one length:");
						double base1 = input.nextDouble();
						System.out.println("Enter base two length:");
						double base2 = input.nextDouble();
						System.out.println("Enter height:");
						double height = input.nextDouble();
						trapezoid trap = new trapezoid(base1, base2, height);
						System.out.println("Your trapezoids's area is " + trap.getArea());
					}
					else {
						System.out.println("Shape not detected"); //indicates if one of the text the user enters isn't and option
					}
				}
				else {
					System.out.println("No proper input detected");
				}
				System.out.println("Would you like to continue? [y/n]"); //checks if user wants to continues
				String next = input.next().toLowerCase();
				if(next.contains("n")) {
					break; //Ends the loop if the user doesn't want to continue
				}	
			}
		}
	
	}

