package pong;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPanel;
import javax.swing.Timer;




public class Board extends JPanel implements ActionListener{

	Graphics2D g2d;

        Timer timer;
	int x, y;
        Ball ball = new Ball();
        Bar bar1 = new Bar();
        Bar bar2 = new Bar();
 
	
        
	public Board(){
                addKeyListener(new TAdapter());
                setFocusable(true);
                setBackground(Color.BLACK);
		setDoubleBuffered(true);

                timer = new Timer(5, this);
                timer.start();		                             
                
                bar1.bar_xpos = 50;
                bar2.bar_xpos = 550;
                
               // bar2.up = KeyEvent.VK_W;
               // bar2.down = KeyEvent.VK_S;
	}
    
    @Override
	public void paint(Graphics g){
		super.paint(g);
		
		g2d = (Graphics2D)g;

		
               
		g2d.setColor(Color.WHITE);
                ball.draw(g2d);
               
                bar1.draw(g2d);
                bar2.draw(g2d);
                Points();
                
		Toolkit.getDefaultToolkit().sync();
		g.dispose();
	}

    @Override
        public void actionPerformed(ActionEvent e){

            ball.move(bar1, bar2);
            bar2.bar_ypos = ball.ball_y - bar2.size/2;
            bar1.checkCollision(ball);
            bar2.checkCollision(ball);
            repaint();
            
        }
        private class TAdapter extends KeyAdapter{
            @Override
            public void keyReleased(KeyEvent e){
            }
            @Override
            public void keyPressed(KeyEvent e){
                bar1.keyPressed(e);
                bar2.keyPressed(e);
            }
        }
        public void Points(){
            Font font = new Font("Verdana", Font.BOLD, 40);
            String pointsmsg = bar1.points + " - " + bar2.points;
            g2d.setColor(Color.WHITE);
            g2d.setFont(font);
            g2d.drawString(pointsmsg, 265, 50);
        }
        
        
}


        


		