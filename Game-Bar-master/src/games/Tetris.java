package games;

import javax.swing.JFrame;

public class Tetris {
	public Title title;
	public JFrame window;

	public Tetris() {
	}

	public void startTetris(WindowGame windowGame) {
	    window.remove(title);
	    windowGame.windowListener();
	}
}