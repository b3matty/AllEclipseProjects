import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;



public class Justin implements MouseListener{
	private int x = (int)(Math.random()*700-0)+100, y = (int)(Math.random()*400-0)+100;
	private int vx, vy;
	private Image img; // image of the frog
	private AffineTransform tx = AffineTransform.getTranslateInstance(x, y);
	Teacher teacher = new Teacher();
	
	public Justin() {
		img = getImage("faces.png"); //load the image for justins face
		init(x, y); 				//initialize the location of the image
		vy = (int)(Math.random()*(7-4)-4);
		vx = (int)(Math.random()*(7-4)+3);
		if((Math.random())<.5){
			vx*=-1;
		}
	}
	
	public void paint(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
		y+=vy; 
		x+=vx;
		
		if(x < -50) { //velocity changes directions when hitting left side of screen
			x = -50;
			vx *=-1;
		}
		if(x > 750) { //changes directions when hitting right side of screen
			x = 750;
			vx *=-1;
		}
		
		tx.setToTranslation(x,y);
		g2.drawImage(img, tx, null);   
		
		//when justin passes top of screen he resets back to a random 
		//starting location at the bottom of the screen
		if(y < -250) {
			x = (int)(Math.random()*700-0)+100;
			y = (int)(Math.random()*300-0)+100;
		}
		
		
	}
	

	public boolean collided(int mX, int mY) {
		System.out.println(mX+":"+mY); //prints coordinates of mouse clicks in console
		
		//hitbox for when you hit justin
		Rectangle a = new Rectangle(x,y,200,200);
		
		
		if(a.contains(mX,mY)) { //if your mouse click coords are in hitbox play bang sound
			Music bang = new Music("ck2.wav",false); 
			System.out.println("ouch"); //prints ouch when conditions met
			bang.play();
			x = (int)(Math.random()*800)+100; //resets justin when hit
			y = 450;
			if(Math.random()<.4) { //randomizes x velocity
				vx = -3;
			}
			else {
				vx = 3;
			}
		}
		else if(!a.contains(mX,mY)) { //if shot misses hitbox play bababooey sfx
			Music bab = new Music("bab.wav",false);
			System.out.println("you missed");
			bab.play();
		}
		return false;
	}
	
	//intention was to make cristian appear after 3 misses
		
		public boolean miss(int mX, int mY) {
			Rectangle a = new Rectangle(x,y,200,200);
			int counter = 0;
			while(counter <= 3){
				
				if(!a.contains(mX,mY)) {
					counter++;
				}
			}
			if(counter > 3) {
				
				teacher.setDogP(650, 320);
				tx.setToTranslation(x,y);
				return true;
			}
			return false;
		}
	

	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(1, 1);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Justin.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}