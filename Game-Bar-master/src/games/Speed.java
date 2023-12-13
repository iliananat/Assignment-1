package games;

public class Speed {
	private int fast;
	private int normal;
	private int delay;

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

	public int getDelay() {
		return delay;
	}

	public void setDelay(int delay) {
		this.delay = delay;
	}

	public int getNormal() {
		return normal;
	}
	
}