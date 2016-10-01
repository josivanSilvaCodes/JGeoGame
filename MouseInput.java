/*=====================================================================================
 *  
 *  Write by Josivan Pereira da Silva - Professor at Impacta FIT - Digital Games Course
 *  Compilation:  javac MouseInput.java
 *  Dependencies: JggPool.java Sound.java
 *  
 *  2016
 *=====================================================================================*/

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseInput implements MouseListener, MouseMotionListener {
	
	JggPool game = new JggPool();
	
	public MouseInput(JggPool game){
		this.game = game;
		
	}
	
	int posX;
	int posY;

	// by MouseListener ============================================================
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		 
			
		
       

	}
	// ==================================================================================
	

	// by MouseMotionListener ============================================================
	@Override
	public void mouseDragged(MouseEvent e) {


		//game.whiteBall.isDragging = true;
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		

	}
	// ==================================================================================
}
