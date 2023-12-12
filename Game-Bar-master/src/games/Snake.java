/**
 *  set this file visible in code to start snake game
 *  snake.setVisible(true);
 *  
 *  snake play is implementation of game file this initialize the game;
 */
package games;

import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author Yashraj Balidani
 * @author Milind Jain
 * @version 1.0
 * 
 */
public class Snake 
{
    public static void main(String[] args)
    {
        snakeplay splay = new snakeplay();
        snakeFrame(splay);
        
    }

	private static void snakeFrame(snakeplay splay) {
		JFrame obj = new JFrame("Snake Xenzia");
        obj.setBounds(10, 10, 905, 700);
        obj.setResizable(false);
        obj.setVisible(true);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        obj.add(splay);
	}
}
