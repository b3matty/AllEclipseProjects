
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class DrawingLab extends JPanel  {
	public void paint(Graphics g) {
		super.paintComponent(g); 
		
		// Draw Grid
		g.drawRect(10,10,780,580);
		g.drawLine(400,10,400,590);
		g.drawLine(10,300,790,300);
		
		
		int counter = 0; //set up counter
		while(counter<100) { //parameter
		
			//red [0 255]
			//(int)(Math.random()*(range+1)+min);
			
			//generate a red hue
			int red = (int)(Math.random()*(255-0+1)+0);
			
			//generate green hue
			int green = (int)(Math.random()*(255-0+1)+0);
			
			//generate blue hue
			int blue = (int)(Math.random()*(255-0+1)+0);
			
			Color randomColor = new Color(red, green, blue);
			g.setColor(randomColor); //set drawing tool color
		
		//draw lines
			//generate line related values
			int x1 = (int)(Math.random()*(400-10+1)+10);
			int y1 = (int)(Math.random()*(300-10+1)+10);
			int x2 = (int)(Math.random()*(400-10+1)+10);
			int y2 = (int)(Math.random()*(300-10+1)+10);
			g.drawLine(x1, y1, x2, y2);
			
			counter++; //increment counter
			
				
			
		// Draw Random Squares
			int rx = (int)(Math.random()*(740-400+1)+400);
			int ry = (int)(Math.random()*(250-10+1)+10);
			g.fillRect(rx, ry, 50, 50);
			g.setColor(randomColor);
			
			
			
		// Draw Random Circles
			//randomized coordinates
			int cx = (int)(Math.random()*(250-10+1)+10); 
			int cy = (int)(Math.random()*(445-300+1)+300);
			
			//randomized width and height
			int cr = (int)(Math.random()*(150-5+1)+5);
			g.drawOval(cx, cy, cr, cr);
			g.setColor(randomColor);
			
			
			
		// Draw 3-D Box
			
			
			
			
			
			
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	// do not touch
	public DrawingLab() {
		JFrame frame = new JFrame("Loops");
		frame.setSize(850, 700);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.add(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


	} // end of MainFrame



} // end of class curly - do not delete
