
public class rectangle {

	private double length;
	private double width;
	
	public rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}
	
	public double getWidth() {
		return width;
	}
	
	public double getLength() {
		return length;
	}
	
	public void setWidth(double width) {
		this.width = width;
	}
	
	public void setLength(double length) {
		this.length = length;
	}
	
	public double getArea() {
		return length * width;
	}

}
