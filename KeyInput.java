import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyInput implements KeyListener{
	
	JGeoGame game = new JGeoGame();
	
	public KeyInput(JGeoGame game){
		this.game = game;
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		 switch(e.getKeyCode())
		 {
		 	case KeyEvent.VK_R ://game.balls[0].posX = 200;	//game.balls[0].posY = 200; 
		 		break;
		 		
		 	case KeyEvent.VK_LEFT:
		 		game.balls[0].angleDirection -= 0.025;
		 		if(game.balls[0].angleDirection<0){game.balls[0].angleDirection = 360;}
		 		break;		
		 		
		 	case KeyEvent.VK_RIGHT:
		 		game.balls[0].angleDirection += 0.025;
		 		if(game.balls[0].angleDirection>360){game.balls[0].angleDirection = 0;}
		 		break;	
		 		
		 	case KeyEvent.VK_UP:	if(game.powerHit<game.balls[0].size*4){game.powerHit += 5;}
		 		break;	
		 		
		 	case KeyEvent.VK_DOWN:	if(game.powerHit>=5){game.powerHit -= 5;}
		 		break;	
		 		
		 	case KeyEvent.VK_SPACE:
				game.balls[0].speedX = (int)game.powerHit;
				game.balls[0].speedY = (int)game.powerHit;	
				game.balls[0].friction = 0.95f;				
				game.powerHit = 5;
				Sound.BALL.play();
				break;
	     }
	}

	@Override
	public void keyReleased(KeyEvent e) {	}

	@Override
	public void keyTyped(KeyEvent e) {	}

}


