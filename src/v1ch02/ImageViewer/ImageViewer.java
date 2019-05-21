package v1ch02.ImageViewer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * Java 核心技术Demo2：A Program for viewing images
 */
public class ImageViewer {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override public void run() {
				JFrame frame = new ImageViewerFram();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

class ImageViewerFram extends JFrame {
	private static final int DEFAULT_WIDTH = 1000;
	private static final int DEFAULT_HEIGHT = 1000;
	private JLabel label;
	private JFileChooser chooser;

	public ImageViewerFram() {
		setTitle("InageViewer");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		label = new JLabel();
		add(label);
		chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File("."));
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu menu = new JMenu("File");
		menuBar.add(menu);
		JMenuItem openItem = new JMenuItem("Open");
		menu.add(openItem);
		openItem.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				int result = chooser.showOpenDialog(null);
				if (result == JFileChooser.APPROVE_OPTION) {
					String name = chooser.getSelectedFile().getPath();
					label.setIcon(new ImageIcon(name));
				}
			}
		});
		JMenuItem extItem = new JMenuItem("Exit");
		menu.add(extItem);
		extItem.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
}