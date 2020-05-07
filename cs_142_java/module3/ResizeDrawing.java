import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ResizeDrawing {
	public static void draw(Graphics g, int width, int height) {
//		drawing code goes here!
		// g.setColor(Color.red);
		// g.drawOval(width / 4, height / 4, width / 2, height / 2);

		// g.setColor(Color.blue);
		// g.drawRect(width / 4, height / 4, width / 2, height / 2);

		// g.setColor(Color.green);
		// g.drawLine(0, height / 2, width, height / 2);
		// g.drawLine(width / 2, 0, width / 2, height);
		//drawDiamond(g, 100, 100, 300);
		
		int diameter = 100;
		// for (int x = 0; x <= width; x += 100) {
		// 	g.drawOval(x , 0, diameter, diameter);
		// }

		//Draw a row of circles, use a counter variable for the loop instead of x
		for (int j = 0; j < 5; j++) {
			for (int i = 0; i < width / diameter; i++) {
				if ( i == j) {
					g.setColor(Color.red);
					drawDiamond(g, i * diameter, j * diameter, diameter);
				} else {
					g.setColor(Color.blue);
					g.drawOval(i * diameter, j * diameter, diameter, diameter);
				}
			}
		}	
	}
		
	public static void drawDiamond(Graphics g, int x, int y, int boxWidth) {
		// draw a diamond in a square bounding box with the upper left (x, y) and side length box width
		int halfWidth = boxWidth / 2;
		int x1 = halfWidth + x;
		int y1 = y;
		int x2 = boxWidth + x;
		int y2 = halfWidth + y;
		int x3 = halfWidth + x;
		int y3 = boxWidth + y;
		int x4 = x;
		int y4 = halfWidth + y;
		//Draw bounding box
		g.drawRect(x, y, boxWidth, boxWidth);
		
		//Draw diamond
		g.drawLine(x1, y1, x2, y2);
		g.drawLine(x2, y2, x3, y3);
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
