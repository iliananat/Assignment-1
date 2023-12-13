package games;

import javax.swing.JFrame;

public class Tetris {
	private Title title;
	public JFrame window;

	public Tetris() {
	}

	public void startTetris(WindowGame windowGame) {
	    window.remove(title);
	    windowGame.windowListener();
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}
	
}