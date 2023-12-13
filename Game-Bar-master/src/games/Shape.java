package games;
/**
 *
 * @author Yashraj Balidani
 * @author Milind Jain
 * @version 1.0
 * 
 */
import java.awt.Color;
import java.awt.Graphics;

public class Shape {

    Color color;

    int x;

	int y;

    long time;

	long lastTime;

    Speed Speed = new Speed(50, 600);

	RotateMatrix RotateMatrix = new RotateMatrix();

	private int[][] reference;

    int deltaX;

    Board board;

    boolean moveX = false;

    Collision data = new Collision(false, -1);

	public Shape(int[][] coords, Board board, Color color) {
        this.RotateMatrix.coords = coords;
        this.board = board;
        this.color = color;
        deltaX = 0;
        x = 4;
        y = 0;
        Speed.setDelay(Speed.getNormal());
        time = 0;
        lastTime = System.currentTimeMillis();
        reference = new int[coords.length][coords[0].length];

        System.arraycopy(coords, 0, reference, 0, coords.length);

    }

    long deltaTime;

    public void render(Graphics g) {

        g.setColor(color);
        for (int row = 0; row < RotateMatrix.coords.length; row++) {
            for (int col = 0; col < RotateMatrix.coords[0].length; col++) {
                if (RotateMatrix.coords[row][col] != 0) {
                    g.fillRect(col * 30 + x * 30, row * 30 + y * 30, Board.blockSize, Board.blockSize);
                }
            }
        }

//        for (int row = 0; row < reference.length; row++) {
//            for (int col = 0; col < reference[0].length; col++) {
//                if (reference[row][col] != 0) {
//                    g.fillRect(col * 30 + 320, row * 30 + 160, Board.blockSize, Board.blockSize);
//                }
//
//            }
//
//        }

    }

    public void rotateShape() {

        int[][] rotatedShape = RotateMatrix.initialRotation(this);

        if ((x + rotatedShape[0].length > 10) || (y + rotatedShape.length > 20)) {
            return;
        }

        for (int row = 0; row < rotatedShape.length; row++) {
            for (int col = 0; col < rotatedShape[row].length; col++) {
                if (rotatedShape[row][col] != 0) {
                    if (board.getBoard()[y + row][x + col] != null) {
                        return;
                    }
                }
            }
        }
        RotateMatrix.coords = rotatedShape;
    }

	public Color getColor() {
        return color;
    }

    public void setDeltaX(int deltaX) {
        this.deltaX = deltaX;
    }

    public int[][] getCoords() {
        return RotateMatrix.coords;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

	public void update(Collision collision2, Collision collision) {
	    moveX = true;
	    deltaTime = System.currentTimeMillis() - lastTime;
	    time += deltaTime;
	    lastTime = System.currentTimeMillis();
	
	    if (collision.checkForCollision(this)) {
	        for (int row = 0; row < RotateMatrix.coords.length; row++) {
	            for (int col = 0; col < RotateMatrix.coords[0].length; col++) {
	                if (RotateMatrix.coords[row][col] != 0) {
	                    board.getBoard()[y + row][x + col] = color;
	                }
	            }
	        }
	        int size = board.checkLine(this);
	        board.updateBoard();
	        collision.setTimePassedFromCollision(-1);
	    }
	
	    // check moving horizontal
	    if (!(x + deltaX + RotateMatrix.coords[0].length > 10) && !(x + deltaX < 0)) {
	
	        for (int row = 0; row < RotateMatrix.coords.length; row++) {
	            for (int col = 0; col < RotateMatrix.coords[row].length; col++) {
	                if (RotateMatrix.coords[row][col] != 0) {
	                    if (board.getBoard()[y + row][x + deltaX + col] != null) {
	                        moveX = false;
	                    }
	
	                }
	            }
	        }
	
	        if (moveX) {
	            x += deltaX;
	        }
	
	    }
	
	    // Check position + height(number of row) of shape
	    if (collision.getTimePassedFromCollision() == -1) {
	        if (!(y + 1 + RotateMatrix.coords.length > 20)) {
	
	            for (int row = 0; row < RotateMatrix.coords.length; row++) {
	                for (int col = 0; col < RotateMatrix.coords[row].length; col++) {
	                    if (RotateMatrix.coords[row][col] != 0) {
	
	                        if (board.getBoard()[y + 1 + row][x + col] != null) {
	                            collision.collision(this);
	                        }
	                    }
	                }
	            }
	            if (time > Speed.getDelay()) {
	                y++;
	                time = 0;
	            }
	        } else {
	            collision.collision(this);
	        }
	    } else {
	    	int temp = (int) (collision.getTimePassedFromCollision()+deltaTime);
	        collision.setTimePassedFromCollision(temp);
	    }
	
	    deltaX = 0;
	}

	public void setCurrentShape(Board board) {
	    Board.currentShape = this;
	    board.setNextShape();
	
	    for (int row = 0; row < Board.currentShape.getCoords().length; row++) {
	        for (int col = 0; col < Board.currentShape.getCoords()[0].length; col++) {
	            if (Board.currentShape.getCoords()[row][col] != 0) {
	                if (board.board[Board.currentShape.getY() + row][Board.currentShape.getX() + col] != null) {
	                    board.gameOver = true;
	                }
	            }
	        }
	    }
	
	}
}
