package v1ch07.NotHelloWorld;

import javax.swing.*;
import java.awt.*;

public class NotHelloWorld {
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				NotHelloWorldFram frame = new NotHelloWorldFram();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

class NotHelloWorldFram extends JFrame {
	public static final int DEFAULT_WIDTH = 300;
	public static final int DEFAULT_HEIGHT = 200;

	public NotHelloWorldFram() {
		setTitle("NotHelloWorld");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		NotHelloWorldComponent comp = new NotHelloWorldComponent();
		add(comp);
	}
}

class NotHelloWorldComponent extends JComponent {
	public static final int MESSAGE_X = 75;
	public static final int MESSAGE_Y = 100;

	public void paintComponent(Graphics g) {
		g.drawString("Not a Hello, World program", MESSAGE_X, MESSAGE_Y);
	}
}