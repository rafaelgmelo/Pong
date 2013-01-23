package pong;

import java.awt.BorderLayout;
import javax.swing.JFrame;



public class Pong extends JFrame{
       
	public Pong(){
	
		add(new Board());
 		setTitle("Pong Game");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(640, 480);
		setLocationRelativeTo(null);
		setVisible(true);
		setResizable(false);
	}
	public static void main(String[] args){
		new Pong();
	}
}