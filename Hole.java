import java.awt.Color;
import java.awt.Graphics;

public class Hole {
	
	int posX;
	int posY;
	int size;
	Color c;
	
	public Hole(int posX, int posY, int size, Color c){		
		this.posX = posX;
		this.posY = posY;
		this.size = size;
		this.c = c;			
	}
	
	void draw(Graphics g){		  
		g.setColor(c);
		g.fillOval(posX, posY, size, size);		  
	}
	

}
