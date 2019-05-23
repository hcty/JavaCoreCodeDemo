package v1ch07.ImageTest;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ImageTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				ImageFrame frame = new ImageFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

class ImageComponent extends JComponent {
	private Image image;

	public ImageComponent() {
		try {
			image = ImageIO.read(new File(this.getClass().getResource("/").getPath() + "//Aurora-4k.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override protected void paintComponent(Graphics g) {
		if (image == null)
			return;
		int imageWidth = image.getWidth(this);
		int imageHeight = image.getHeight(this);
		g.drawImage(image, 0, 0, null);
		for (int i = 0; i * imageWidth <= getWidth(); i++) {
			for (int j = 0; j * imageHeight <= getHeight(); j++) {
				if (i + j > 0)
					g.copyArea(0, 0, imageWidth, imageHeight, i * imageHeight, j * imageHeight);
			}
		}
	}
}

class ImageFrame extends JFrame {
	public static final int DEFAULT_WIDTH = 300;
	public static final int DEFAULT_HEIGHT = 200;

	public ImageFrame() {
		setTitle("ImageTest");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		ImageComponent component = new ImageComponent();
		add(component);
	}
}