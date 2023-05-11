
public class triangle {

	private double base;
	private double height;

	public triangle(double base, double height) {
		this.base = base;
		this.height = height;
		
	}
	
	public double getBase() {
		return base;
	}
	
	public double getHeight() {
		return height;
	}
	
	public void setBase(double base) {
		this.base = base;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	public double getArea() {
		return base * height / 2;
	}

}
