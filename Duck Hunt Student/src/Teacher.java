import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.geom.AffineTransform;
import java.net.URL;

public class Teacher {
	private int  x = 650,y = -500; //320
	private Image img1; // image of the frog
	private Image img2;
	private Image img;
	private AffineTransform tx = AffineTransform.getTranslateInstance(x, y);
	
	Justin justin = new Justin();
	public Teacher() {
		img1 = getImage("teacher.png"); //load the image for Tree
		img2 = getImage("teacher2.png");
		img = img1;
		init(x, y); 				//initialize the location of the image
	}
	
	public void paint(Graphics g) {
		
		//these are the 2 lines of code needed draw an image on the screen
		Graphics2D g2 = (Graphics2D) g;
		double x = (Math.random());
		
		if(x<.5) {
			img = img1;
			}
			else {
			img = img2;
			}
		
		/* to be completed by student */
		/* currently, img1 and img2 represent two different of the dog.
		 * If you continually swap between the two images, you end up with an animation of a laughing dog. 
		 * 
		 * The third Image instance variable is img, whatever this variable points to (img1 or img2) it is drawn on the screen
		 * 
		 * Add the block of code necessary to alternate what img reference, which is either img1 or img2.
		 * For example, maybe within a span of time, img is reference img1 half the time and referencing img2 the other half.
		 * You will need to code it so that the animation looks as natural as possible. 
		 */

		
		g2.drawImage(img, tx, null);   
	}
	
	
	public void moveUp(int x, int y) {
		if(!justin.collided(x,y)) {
			y += 820;
		}
	}
	private void init(double a, double b) {
		tx.setToTranslation(a, b);
		tx.scale(1, 1);
	}

	private Image getImage(String path) {
		Image tempImage = null;
		try {
			URL imageURL = Teacher.class.getResource(path);
			tempImage = Toolkit.getDefaultToolkit().getImage(imageURL);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempImage;
	}
}
