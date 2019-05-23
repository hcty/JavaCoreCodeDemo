package v1ch07.FontTest;

import javax.swing.*;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class FontTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				FontFrame frame = new FontFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}

}

class FontFrame extends JFrame {
	public static final int DEFAULT_WIDTH = 300;
	public static final int DEFAULT_HEIGHT = 200;

	public FontFrame() {
		setTitle("FontTest");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		FontCoomponent coomponent = new FontCoomponent();
		add(coomponent);
	}
}

class FontCoomponent extends JComponent {
	@Override protected void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		String message = "Hello,Workd!";
		Font f = new Font("Serif", Font.BOLD, 36);
		g2.setFont(f);
		FontRenderContext context = g2.getFontRenderContext();
		Rectangle2D bounds = f.getStringBounds(message, context);
		double x = (getWidth() - bounds.getWidth()) / 2;
		double y = (getHeight() - bounds.getHeight()) / 2;
		double ascent = -bounds.getY();
		double baseY = y + ascent;
		g2.drawString(message, (int) x, (int) baseY);
		;
		g2.setPaint(Color.LIGHT_GRAY);
		g2.draw(new Line2D.Double(x, baseY, x + bounds.getWidth(), baseY));
		Rectangle2D rect = new Rectangle2D.Double(x, y, bounds.getWidth(), bounds.getHeight());
		g2.draw(rect);
	}
}