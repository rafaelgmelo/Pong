/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

/**
 *
 * @author Bel e Bia
 */
public class Bar{
    public static final int DOWN_RIGHT = 0;
    public static final int UP_RIGHT = 1;
    public static final int DOWN_LEFT = 2;
    public static final int UP_LEFT = 3;
    int bar_xpos;
    int bar_ypos;
    int speed;
    int size;
    int points;
    int up;
    int down;
    public Bar(){
        bar_ypos = 140;
        speed = 10;
        size = 160;
        points = 0;
        up = KeyEvent.VK_UP;
        down =  KeyEvent.VK_DOWN;
    }
    public void draw(Graphics2D g2d){
        g2d.fillRect(bar_xpos, bar_ypos, 20, size);
    }
    public void keyPressed(KeyEvent e){
        int key = e.getKeyCode();
        if(key == up){
            bar_ypos -= speed;
        }else if(key == down){
            bar_ypos += speed;
        
        }
    }
    public void checkCollision(Ball ball){
          if(ball.ball_x == bar_xpos){
              if(ball.ball_y > bar_ypos && ball.ball_y < bar_ypos + size){
                  
                  switch(ball.direction){

                      case DOWN_LEFT:
                          ball.direction = DOWN_RIGHT;
                          break;
                      case UP_LEFT:
                          ball.direction = UP_RIGHT;
                          break;
                      case DOWN_RIGHT:
                          ball.direction = DOWN_LEFT;
                          break;
                      case UP_RIGHT:
                          ball.direction = UP_LEFT;
                          break;
                  }
                  }
              }
          }
          
               
}

