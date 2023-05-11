
public class circle {

	private double radius;
	
	public circle(double radius) {
		this.radius = radius;
	}
	
	public double getRadius() {
		return radius;
	}
	
	public void setRadius(double radius) {
		this.radius = radius;
	}

	public double getCircumference() {
		return 2 * Math.PI * radius;
	}
	
	public double getArea() {
		return Math.PI * Math.pow(radius, 2);
	}
}
