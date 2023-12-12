package games;

public class Speed {
	public int fast;
	public int normal;
	public int delay;

	public Speed(int fast, int normal) {
		this.fast = fast;
		this.normal = normal;
	}

	public void speedUp(Shape shape) {
	    delay = fast;
	}

	public void speedDown(Shape shape) {
	    delay = normal;
	}
}