import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

// Kevin Chung

public class StarsAndStripes {
	public static void drawFlag(int stars, int stripes, java.awt.Graphics g, int x, int y, int width, int height) {
		// Draw a filled white rectangle for the canvas
		g.setColor(Color.white);
		g.fillRect(x, y, width, height);

		// Draw red stripes
		int stripeHeight = height / stripes; // Evenly divided stripe height, rounded down
		int numberOfRedEven = stripes / 2;
		int numberOfRedOdd = stripes / 2 + 1; // Number of red stripes is half the stripes, rounded up

		//Blue starfield variables
		int baseRatio = (width / height);

		if (stripes % 2 == 0) { // even number of stripes
			for (int i = 0; i < numberOfRedEven; i++) {
				int verticalPosition = y + (2 * i * stripeHeight); 
				g.setColor(Color.red);
				g.fillRect(x, verticalPosition, width, stripeHeight);
			}
			//blue starfield - even
			g.setColor(Color.blue);
			int blueHeight = numberOfRedEven * stripeHeight;
			int blueWidth =  blueHeight * baseRatio;
			g.fillRect(x, y, blueWidth, blueHeight);

		} else if (stripes % 2 != 0) { // odd number of stripes
			for (int i = 0; i < numberOfRedOdd; i++) {
				int verticalPosition = y + (2 * i * stripeHeight); 
				g.setColor(Color.red);
				g.fillRect(x, verticalPosition, width, stripeHeight);
			}
			//blue starfield - odd
			g.setColor(Color.blue);
			int blueHeight = numberOfRedOdd * stripeHeight;
			int blueWidth = blueHeight * baseRatio;
			g.fillRect(x, y, blueWidth, blueHeight);
		}
		
		//Testing
		//System.out.println("This is the number of stars: " + stars);
		//System.out.println("This is the number of stripes: " + stripes);
		//System.out.println("This is the number of red stripes: " + stripes / 2);
		System.out.println("This is the stripe height: " + stripeHeight);
		System.out.println("This is the blue starfield height: " + stripeHeight * numberOfRedOdd);
		System.out.println("This is the blue starfield width: " + (stripeHeight * numberOfRedOdd) * (width / height));
		//System.out.println(y + i * stripeHeight + " and the i value: " + i);
		// System.out.println("This is the starting x-coordinate: " + x);
		// System.out.println("This is the starting y-coordinate: " + y);
		 System.out.println("This is the width of the flag: " + width);
		 System.out.println("This is the height of the flag: " + height);
	}

	public static void drawStar(java.awt.Graphics g, int x, int y, int size) {
		// Fill this in according to the assignment!
		int dividedSize5 = size / 5;
		int dividedSize10 = size / 10;

		g.setColor(Color.white);
		int x1 = x + dividedSize5;
		int y1 = y + size;

		int x2 = x + size;
		int y2 = y + dividedSize5 * 2;

		int x3 = x;
		int y3 = y + dividedSize5 * 2;

		int x4 = x + dividedSize5 * 4;
		int y4 = y + size;

		int x5 = x + dividedSize10 * 5;
		int y5 = y;

		g.drawLine(x1, y1, x2, y2); //bottom left to top right line
		g.drawLine(x2, y2, x3, y3); // top right line to the top left corner (opposite side)
		g.drawLine(x3, y3, x4, y4); // top left corner to the bottom right corner
		g.drawLine(x4, y4, x5, y5); // bottom right corner to the top center
		g.drawLine(x5, y5, x1, y1); // top center to the bottom left corner - completed star

	}

	// Only alter the "drawFlag" part of the paintComponent code to call it in different ways. You can also test drawing multiple flags at once!
	public static void main(String[] args) {
		JFrame window = new JFrame("Graphics window");
		window.setLocationByPlatform(true);
		final JLabel coords = new JLabel(" ");
		@SuppressWarnings("serial")
		final JPanel panel = new JPanel() {

			protected void paintComponent(Graphics gx) {
				coords.setText(" ");
				Graphics2D g = (Graphics2D) gx;
				int width = getWidth();
				int height = getHeight();
				g.setBackground(Color.GREEN); // To make sure you cover the base rectangle!
				g.clearRect(0, 0, width, height);
				g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
				g.setColor(Color.BLACK);

				// You could alter this code to try different flags!
				//drawFlag(15, 13, g, 0, 0, width/2, height/2);
				//drawFlag(20, 14, g, width/2, 0, width/2, height/2);
				//drawFlag(24, 15, g, 0, height/2, width/2, height/2);
				//drawFlag(48, 16, g, width/2, height/2, width/2, height/2);

			}
		};
		panel.addMouseMotionListener(new MouseMotionListener() {


			@Override
			public void mouseDragged(MouseEvent e) {
				
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				coords.setText(e.getX()+", "+e.getY());				
			}
			
		});
		window.setLayout(new BorderLayout());
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		window.setSize(d.width / 2, d.height / 2);

		JPanel coordPanel = new JPanel();
		coordPanel.setLayout(new BorderLayout());
		coordPanel.setBorder(new BevelBorder(BevelBorder.LOWERED));
		window.add(coordPanel, BorderLayout.SOUTH);
		coordPanel.add(coords, BorderLayout.WEST);
		
		window.setBackground(Color.WHITE); // To make sure you cover the base rectangle!		
		panel.setBackground(Color.BLACK);
		window.add(panel, BorderLayout.CENTER);
		//window.setContentPane(panel);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
