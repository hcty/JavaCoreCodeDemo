package v1ch07.FillTest;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class FillTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override public void run() {
				FileFram fram = new FileFram();
				fram.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				fram.setVisible(true);
			}
		});
	}
}

class FileFram extends JFrame {
	public static final int DEFAULT_WIDTH = 400;
	public static final int DEFAULT_HEIGHT = 400;

	public FileFram() {
		setTitle("FileTest");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		FillComponent component = new FillComponent();
		add(component);
	}
}

class FillComponent extends JComponent {
	@Override protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		double leftX = 100;
		double topY = 100;
		double width = 200;
		double hieght = 150;
		Rectangle2D rect = new Rectangle2D.Double(leftX, topY, width, hieght);
		g2.setPaint(Color.RED);
		g2.fill(rect);
		Ellipse2D ellipse = new Ellipse2D.Double();
		ellipse.setFrame(rect);
		g2.setPaint(new Color(0, 128, 128));
		g2.fill(ellipse);
	}
}