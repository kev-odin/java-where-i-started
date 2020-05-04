import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class DiamondDrawing {
	public static void draw(Graphics g, int width, int height) {
//		//drawing code goes here!
		g.setColor(Color.blue);
		int diameter = 100;
//		for (int x = 0; x < width; x += diameter) { // the loop variable is the left side coordinate of each circle
//			g.drawOval(x, 0, diameter, diameter);
//		}
		
		//draw a row of circles, use a counter variable for the loop instead of x
		for (int j = 0; j < height / diameter; j++) {
			for (int i = 0; i < width / diameter; i++) {
				
				if ((i + j) % 3 == 0) { //sets the colors based on the location
					g.setColor(Color.black);
				} else { 
					g.setColor(Color.red);
				}
				
				if (i == j) {
					drawDiamond(g, i * diameter, j * diameter, diameter);
				} else {
					g.drawOval(i * diameter , j * diameter, diameter, diameter);
				}
			}
		}
	}

	public static void drawDiamond(Graphics g, int x, int y, int boxWidth) {
		//draws a diamond in a square bounding box with upper left corner (x,y) and side length boxWidth
		int half = boxWidth/2; // half the box width
		
		//define the corner coordinates
		int x1 = x + half;
		int y1 = y;
		int x2 = x + boxWidth;
		int y2 = y + half;
		int x3 = x + half;
	    int y3 = y + boxWidth;
	    int x4 = x;
	    int y4 = y + half;
	    
	    //g.setColor(Color.green);
	    //g.drawRect(x,y,boxWidth, boxWidth); // draw the bounding box for testing
	    
	    //draw the four sides
	    g.drawLine(x1, y1, x2, y2);
	    g.drawLine(x2, y2,  x3, y3);
	    g.drawLine(x3, y3, x4, y4);
	    g.drawLine(x4, y4, x1, y1);
	    
	}
			
	// Leave the main method alone! It just sets up the drawing window for you.
	public static void main(String[] args) {
		JFrame window = new JFrame("Graphics window");
		window.setLocationByPlatform(true);
		@SuppressWarnings("serial")
		final JPanel panel = new JPanel() {

			protected void paintComponent(Graphics gx) {
				Graphics2D g = (Graphics2D) gx;
				int width = getWidth();
				int height = getHeight();
				g.clearRect(0, 0, width, height);
				g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g.setBackground(Color.WHITE);
				g.setColor(Color.BLACK);

				draw(g, width, height);
			}
		};
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		window.setSize(d.width / 2, d.height / 2);
		window.setBackground(Color.WHITE);
		panel.setBackground(Color.WHITE);
		window.setContentPane(panel);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
