package _08_LeagueSnake;

import java.awt.Color;
import java.util.ArrayList;

import processing.core.PApplet;

public class LeagueSnake extends PApplet {
    static final int WIDTH = 500;
    static final int HEIGHT = 500;
    
    /*
     * Game variables
     * 
     * Put all the game variables here.
     */
    Segment snakeHead;
    int foodX;
    int foodY;
    int direction = UP;
    int snakeEater =0;
ArrayList<Segment> tail = new ArrayList<>();
    
    /*
     * Setup methods
     * 
     * These methods are called at the start of the game.
     */
    @Override
    public void settings() {
        setSize(WIDTH,HEIGHT);
    }

    @Override
    public void setup() {
    	snakeHead= new Segment(200,100);
    		 frameRate(20);
    		 dropFood();
    }

    void dropFood() {
        // Set the food in a new random location
    	foodX = ((int)random(50)*10);
    	foodY = ((int)random(50)*10);
    }

    /*
     * Draw Methods
     * 
     * These methods are used to draw the snake and its food
     */

    @Override
    public void draw() {
    background(0,0,0);
    drawFood();
    move();
    drawSnake();
    eat();
    }

    void drawFood() {
        // Draw the food
       fill(255,0,0);
    	rect(foodX, foodY, 10, 10);
    }

    void drawSnake() {
        // Draw the head of the snake followed by its tail
    	fill(0,255,0);
    	rect(snakeHead.x,snakeHead.y, 10,10);
    }

	void drawTail() {
        // Draw each segment of the tail
        for(int i =0; i >= 0; i++) {
        	
        }
    }

    /*
     * Tail Management methods
     * 
     * These methods make sure the tail is the correct length.
     */

    void manageTail() {
        // After drawing the tail, add a new segment at the "start" of the tail and
        // remove the one at the "end"
        // This produces the illusion of the snake tail moving.

    }

    void checkTailCollision() {
        // If the snake crosses its own tail, shrink the tail back to one segment
        
    }

    /*
     * Control methods
     * 
     * These methods are used to change what is happening to the snake
     */

    @Override
    public void keyPressed() {
        // Set the direction of the snake according to the arrow keys pressed
        if(UP == keyCode) {
        	//System.out.println("UP pressed");
        	direction = UP;
        }
        else if(LEFT == keyCode) {
        	//System.out.println("LEFT pressed");
        	direction = LEFT;
        }
        else if(DOWN == keyCode) {
        	//System.out.println("DOWN pressed");
        	direction = DOWN;
        }
        else if(RIGHT == keyCode) {
        	//System.out.println("RIGHT pressed");
        	direction = RIGHT;
        }
        
        
    }

    void move() {
        // Change the location of the Snake head based on the direction it is moving.

        
        if (direction == UP) {
            // Move head up
        snakeHead.y-=10;
        
        } else if (direction == DOWN) {
            // Move head down
                snakeHead.y+=10;
                
        } else if (direction == LEFT) {
            snakeHead.x-=10;
           
        } else if (direction == RIGHT) {
            snakeHead.x+= 10;
           
        }
        checkBoundaries();
    }

    void checkBoundaries() {
        // If the snake leaves the frame, make it reappear on the other side
        if(snakeHead.x>=WIDTH) {
        	snakeHead.x = 0;
        }
        else if(snakeHead.x<0) {
        	snakeHead.x = WIDTH;
        }
        else if(snakeHead.y>=HEIGHT) {
        	snakeHead.y=0;
        }
        else if(snakeHead.y<0) {
        	snakeHead.y=HEIGHT;
        }
    }

    void eat() {
        // When the snake eats the food, its tail should grow and more
        // food appear
        if(snakeHead.x == foodX && snakeHead.y == foodY) {
        	snakeEater++;
        	dropFood();
        }
    	
    }

    static public void main(String[] passedArgs) {
        PApplet.main(LeagueSnake.class.getName());
    }
}
