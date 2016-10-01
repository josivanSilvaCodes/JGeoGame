
/*=====================================================================================
 *  
 *  Write by Josivan Pereira da Silva - Professor at Impacta FIT - Digital Games Course
 *  Compilation:  javac JggPool.java
 *  Execution:    java JggPool 
 *  Dependencies: KeyInput.java MouseInput.java Ball.java Hole.java Sound.java
 *  
 *  Controlls: SPACE, UP, DOWN, LEFT and RIGHT Keys.
 *  2016
 *=====================================================================================*/

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.JFrame;

// Table of RGB colors values
//http://erikasarti.net/html/tabela-cores/

public class JggPool extends JFrame {
 
	private static final long serialVersionUID = 1L; //Eclipse indicates this long...
 
	BufferedImage background; 
	int FPS = 30;
	int windowWidth = 400;
	int windowHeight = 500;
	int powerHit;
  
	Ball balls[] = new Ball[10]; 
	Hole holes[] = new Hole[6];
	
	static KeyInput keys;
	static MouseInput mousePad; 
	static JggPool game;

  
	public void update() {	 
		for(int i=0; i<balls.length; i++){		  
			balls[i].move();
		    balls[i].ballsCollisions(balls);
	    } 
	}
 
	public void drawAllGrphics() {
		Graphics g = getGraphics(); 
		Graphics bgg = background.getGraphics();
		bgg.setColor(new Color(34,139,34));
		bgg.fillRect(0, 0, windowWidth, windowHeight); 
   		bgg.setColor(Color.RED);
		bgg.setFont(new Font("helvica",Font.BOLD,20));
  
		for(int i=0; i<balls.length; i++){	 
			if(i==0){	balls[i].showControlTarget(bgg);	}	 
			balls[i].draw(bgg);  
		}   
		holes[0].draw(bgg);		
		holes[1].draw(bgg);
		holes[2].draw(bgg);		
		holes[3].draw(bgg);
		holes[4].draw(bgg);
		holes[5].draw(bgg);
		//================================================================================== 
		g.drawImage(background, 0, 0, this);
	}
 
	public void init() {
		setTitle("IMPACTA JAVA POOL");
		setSize(windowWidth, windowHeight);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(null);
		setVisible(true);
		background = new BufferedImage(windowWidth, windowHeight, BufferedImage.TYPE_INT_RGB);
		
		//========= setting the window position at the middle screen ====================
		Dimension ds = Toolkit.getDefaultToolkit().getScreenSize();                    //|
		Dimension dw = getSize();													   //|
		setLocation((ds.width - dw.width) / 2, (ds.height - dw.height) / 2);           //|
		// ==============================================================================
   
		addKeyListener(keys);
		addMouseListener(mousePad);
		addMouseMotionListener(mousePad);
  
		balls[0] = new Ball(200, 120, new Color(255, 255, 255), this);  
		for(int i=1; i<balls.length; i++){	  
			Random gerador = new Random();		  
			int numero = gerador.nextInt(400);
			int numero2 = gerador.nextInt(500);
			balls[i] = new Ball(numero-(Ball.radius), numero2-(Ball.radius), new Color(255,215,0), this);
		}

		holes[0] = new Hole(-5, -5, 30, new Color(0, 0, 0));
		holes[1] = new Hole(windowWidth-(25), -5, 30, new Color(0, 0, 0));
		
		holes[2] = new Hole(-5, (windowWidth/2)+30, 30, new Color(0, 0, 0));
		holes[3] = new Hole(windowWidth-(25), (windowWidth/2)+30, 30, new Color(0, 0, 0));
		
		holes[4] = new Hole(-5, (windowHeight)-25, 30, new Color(0, 0, 0));
		holes[5] = new Hole(windowWidth-(25), (windowHeight)-25, 30, new Color(0, 0, 0));		
	}
 
	public void play() {
		init();
		Sound.BACK.play();
		while (true) {
			update();
			drawAllGrphics();
			try {
				Thread.sleep(1000/FPS);
			} catch (Exception e) {
				System.out.println("Thread Exception...");
			}
		}
	}
 
	public static void main(String[] args) {
		game = new JggPool();
		keys = new KeyInput(game);
		mousePad = new MouseInput(game);
		game.play();
	}
}
   

   

