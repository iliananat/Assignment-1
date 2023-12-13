package games;

public class Collision {
	private boolean collision;
	private int timePassedFromCollision;

	public Collision(boolean collision, int timePassedFromCollision) {
		this.collision = collision;
		this.timePassedFromCollision = timePassedFromCollision;
	}

	boolean checkForCollision(Shape shape) {
		return collision && timePassedFromCollision > 500;
	}

	void collision(Shape shape) {
	    collision = true;
	    timePassedFromCollision = 0;
	}

	public int getTimePassedFromCollision() {
		return timePassedFromCollision;
	}

	public void setTimePassedFromCollision(int timePassedFromCollision) {
		this.timePassedFromCollision = timePassedFromCollision;
	}
	
}