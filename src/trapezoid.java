
public class trapezoid {

	private double base1;
	private double base2;
	private double height;
	
	public trapezoid(double base1, double base2, double height) {
		this.base1 = base1;
		this.base2 = base2;
		this.height = height;
	}
	
	public double getBase1() {
		return base1;
	}
	
	public double getBase2() {
		return base2;
	}
	
	public double getHeight() {
		return height;
	}
	
	public void setBase1(double base1) {
		this.base1 = base1;
	}
	
	public void setBase2(double base2) {
		this.base2 = base2;
	}
	
	public void setHeight(double height) {
		this.height = height;
	}
	
	public double getArea() {
		return (base1 + base2) / 2 * height;
	}

}
