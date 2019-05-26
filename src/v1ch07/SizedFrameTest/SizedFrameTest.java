package v1ch07.SizedFrameTest;

import javax.swing.*;
import java.awt.*;

public class SizedFrameTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override public void run() {
				SizeFram frame = new SizeFram();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

class SizeFram extends JFrame {
	public SizeFram() {
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screeHight = screenSize.height;
		int screenWidth = screenSize.width;
		setSize(screenWidth / 2, screeHight / 2);
		setLocationByPlatform(true);
		Image img = kit.getImage("icon.gif");
		setIconImage(img);
		setTitle("SizedFrame");
	}
}