package games;
/**
 *
 * @author Yashraj Balidani
 * @author Milind Jain
 * @version 1.0
 * 
 */
import javax.swing.JFrame;

public class WindowGame {
    public static final int WIDTH = 445, HEIGHT = 629;

    private Board board;
    Tetris data = new Tetris();

	public WindowGame() {

        data.window = new JFrame("Tetris");
        data.window.setSize(WIDTH, HEIGHT);
        data.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        data.window.setLocationRelativeTo(null);
        data.window.setResizable(false);

        board = new Board();
        data.title = new Title(this);

        data.window.addKeyListener(board);
        data.window.addKeyListener(data.title);

        data.window.add(data.title);

        data.window.setVisible(true);
    }

    void windowListener() {
		data.window.addMouseMotionListener(board);
        data.window.addMouseListener(board);
        data.window.add(board);
        board.startGame();
        data.window.revalidate();
	}

    public static void main(String[] args) {
        new WindowGame();
    }

}