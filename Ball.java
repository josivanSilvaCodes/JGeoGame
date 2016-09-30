//https://www.youtube.com/watch?v=JM0p488r4sg

import java.awt.Color;
import java.awt.Graphics;

public class Ball {
	
	int windowWidth = 400; //tableSize
	int windowHeight = 500;	 //tableSize
	int posX;
	int posY;
	int size;	
	static int  radius = 10;
	
	float speedX ;
	float speedY ;	
	float angleDirection;
	float friction ;       //deceleration factor
	
	Color color;
	boolean choosingMove; 
	
	static JGeoGame game;	
	
	
	public Ball(int posx, int posy, Color c, JGeoGame game ){ 
		this.posX = posx;
		this.posY = posy;
		this.color = new Color(c.getRed(), c.getGreen(), c.getBlue());
		this.size = 2*radius; //diameter
		this.game = game;
	}

	void move() {				
		this.posX -= (int) (speedX*Math.cos(angleDirection) );
		this.posY -= (int) (speedY*Math.sin(angleDirection) );			
		speedX *= friction;     //decreasing velocity
		speedY *= friction;    			
		wallCollisions();			
	}	
	 
	void ballsCollisions(Ball [] myBalls){
	   for(int i=0; i<myBalls.length; i++){
	      if(myBalls[i] != this){
	        
	    	 float distance = (float) Math.sqrt(
	    			             (Math.pow((this.posX - myBalls[i].posX), 2) + 
	    			              Math.pow((this.posY - myBalls[i].posY), 2))	);
	                               
	         if(distance <= (radius + myBalls[i].radius)){
	        	myBalls[i].speedX = speedX;
	        	myBalls[i].speedY = speedY;	        	
	        	myBalls[i].friction = 0.95f;
	        
	            speedX *= -1;
	            speedY *= -1;     
	         }  
	       }
	    }
	  }	

	  void wallCollisions(){		  
		  if(posX - radius <= 0){	posX = radius;	speedX *= -1;	}	    
	      if(posX + radius >= windowWidth){	posX = windowWidth - radius;  speedX *= -1; }	    
	      if(posY  - radius <= 0){	posY = radius;	speedY *= -1;  }	    
	      if(posY + radius >= windowHeight){	posY = windowHeight - radius;	speedY *= -1; }     
	  }
	  
	  void draw(Graphics g){		  
		  g.setColor(color);
		  g.fillOval(posX-radius, posY-radius, size, size);		  
	  }
	  
	  void showControlTarget(Graphics g){		  
		  g.setColor(this.color);
		  g.fillOval(this.posX-this.radius, this.posY-this.radius, this.size, this.size);
		  
		  if(Math.abs(this.speedX)<0.5 && Math.abs(this.speedY)<0.5){	
			  int endX   = (int) (this.posX + 40 * Math.cos(this.angleDirection ));
			  int endY   = (int) (this.posY + 40 * Math.sin(this.angleDirection ));
			  g.drawLine(this.posX, this.posY, endX, endY);

			  g.fillOval(endX-game.powerHit/8, endY-game.powerHit/8, game.powerHit/4, game.powerHit/4);
			  
			  for(int i=20; i<500; i+=16){
				  int beginLineX   = (int) (this.posX - i * Math.cos(this.angleDirection ));
				  int beginLineY   = (int) (this.posY - i * Math.sin(this.angleDirection ));
				  int endLineX   = (int) (this.posX - (i+8) * Math.cos(this.angleDirection ));
				  int endLineY   = (int) (this.posY - (i+8) * Math.sin(this.angleDirection ));
				  g.drawLine(beginLineX, beginLineY, endLineX, endLineY);
			  }			  
		   }		  
	   }
}


