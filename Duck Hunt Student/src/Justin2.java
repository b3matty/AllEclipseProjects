import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Justin2 implements MouseListener{
	private int x = (int)(Math.random()*700-0)+100, y = (int)(Math.random()*400-0)+100;
	private int vx, vy;
	private Image img; // image of the frog
	private AffineTransform tx = AffineTransform.getTranslateInstance(x, y);

	public Justin2() {
		img = getImage("faces.png"); //load the image for Tree
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
		
		if(x < -50) {
			x = -50;
			vx *=-1;
		}
		if(x > 750) {
			x = 750;
			vx *=-1;
		}
		
		tx.setToTranslation(x,y);
		g2.drawImage(img, tx, null);   
		
		if(y < -250) {
			x = (int)(Math.random()*700-0)+100;
			y = (int)(Math.random()*300-0)+100;
		}
	}
	

	public boolean collided(int mX, int mY) {
		System.out.println(mX+":"+mY);
		
		Rectangle a = new Rectangle(x,y,200,200);
		Rectangle a1 = new Rectangle(0,0,1000,1000);
		if(a.contains(mX,mY)) {
			Music bang = new Music("cyka.wav",false);
			System.out.println("ouch");
			bang.play();
		}
		else if(a1.contains(mX,mY)) {
			Music bab = new Music("bab.wav",false);
			System.out.println("you missed");
			bab.play();
		}
		return false;
	}
	
	public void reset() {
		x = (int)(Math.random()*800)+100;
		y = 450;
		if(Math.random()<.4) {
			vx = -3;
		}
		else {
			vx = 3;
		}
	}
	
	
	public void update() {
		
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
		System.out.println("ouch");
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
