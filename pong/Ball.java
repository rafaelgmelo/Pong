/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pong;

import java.awt.Graphics2D;

/**
 *
 * @author Bel e Bia
 */
public class Ball {
    public static final int DOWN_RIGHT = 0;
    public static final int UP_RIGHT = 1;
    public static final int DOWN_LEFT = 2;
    public static final int UP_LEFT = 3;
    int ball_x = 300;
    int ball_y = 35;
    int speed = 2;
    int direction;
    
    public void draw(Graphics2D g2d){
           g2d.fillOval(ball_x, ball_y, 20, 20);
    }
    public void move(Bar bar1, Bar bar2){
           switch(direction){
               case DOWN_RIGHT:
                   ball_x += speed;
                   ball_y += speed;
                   if(ball_y > 420){
                        direction=UP_RIGHT;
                   }
                   if(ball_x > 635){
                        addPoint(bar1);
                        newGame();
                   }
                break;
               case UP_LEFT:
                   ball_x -= speed;
                   ball_y -= speed;
                   if(ball_y < 5){
                       direction=DOWN_LEFT;
                   }
                   if(ball_x < 5){
                       addPoint(bar2);
                       newGame();
                   }
                   break;
                case UP_RIGHT:
                   ball_x += speed;
                   ball_y -= speed;
                   if(ball_y < 5){
                        direction=DOWN_RIGHT;
                   }
                   if(ball_x > 635){
                       addPoint(bar1);
                       newGame();
                   }
                    break;
                case DOWN_LEFT:
                   ball_x -= speed;
                   ball_y += speed;
                   if(ball_y > 440){
                        direction=UP_LEFT;
                   }
                   if(ball_x < 5){
                       addPoint(bar2);
                       newGame();
                   }
                    break;
                          
           }
    }
    public void addPoint(Bar bar){
        bar.points += 1;
    }
    public void newGame(){
        ball_x = 300;
        ball_y = 35;
        
        direction = 0;      
    }
           
}
