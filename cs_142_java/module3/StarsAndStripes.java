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

		// Red stripe position and dimensions
		int stripeHeight = (int) Math.floor(height / stripes); // Evenly divided stripe height, rounded down
		int numberOfRed = (int) Math.ceil((double) stripes / 2); // Number of red stripes rounded up, casted to double to use Math.ceil 

		// Draw red stripes
		for (int i = 0; i < numberOfRed; i++) {
			int verticalPosition = i * stripeHeight * 2; 
			g.setColor(Color.red);
			if (stripes % 2 == 1 && i == numberOfRed - 1) { // Odd red stripe
				g.fillRect(x, y + verticalPosition, width, height - verticalPosition);
			} else {
				g.fillRect(x, y + verticalPosition, width, stripeHeight);
			}
		}
			//Blue starfield, based on the number of red stripes
			g.setColor(Color.blue);
			int starfieldHeight = numberOfRed * stripeHeight;
			int starfieldWidth =  starfieldHeight * width / height;
			g.fillRect(x, y, starfieldWidth, starfieldHeight);

		// Determine the number of row and columns for the stars, to be used for the star grid
		int row = 1;
		int col = 1;

		while ((row * col != stars) || (col < row) || (row > 2 * col)) {
			if (row > stars) {
				row = 1;
				col++;
			} else {
				row++;
			}
		}

		// Determine the grid size for the stars
		// vertical - number of rows
		// horizontal - number of columns
		int gridSizeVertical = starfieldHeight / row;
		int gridSizeHorizontal = starfieldWidth / col;

		// Determine the size of stars based on both grid sizes above to fill starfield
		int starSize = Math.min(gridSizeVertical, gridSizeHorizontal);

		//Star pattern size * number of rows/columns
		int starPadHorizontal = starSize * col;
		int starPadVertical = starSize * row;

		// Horizontal and vertical gaps
		int horizontalGap = (starfieldWidth - starPadHorizontal) / 2;
		int verticalGap = (starfieldHeight - starPadVertical) / 2;
		
		// Draw stars in a grid pattern
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				drawStar(g, (x + (j * starSize) + horizontalGap), (y + (i * starSize) + verticalGap), starSize);
			}
		}
	} // drawFlag end bracket

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

		g.drawLine(x1, y1, x2, y2); // bottom left to top right line
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
				drawFlag(15, 13, g, 0, 0, width/2, height/2);
				drawFlag(20, 14, g, width/2, 0, width/2, height/2);
				drawFlag(24, 15, g, 0, height/2, width/2, height/2);
				drawFlag(48, 16, g, width/2, height/2, width/2, height/2);
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
