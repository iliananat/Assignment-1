package games;

public class Collision {
	public boolean collision;
	public int timePassedFromCollision;

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
}