package v1ch09.ComboBoxTest;

import sun.awt.image.BufImgSurfaceData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComboBoxTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {

				ComboBoxFrame frame = new ComboBoxFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

class ComboBoxFrame extends JFrame {
	public static final int DEFAULT_WIDTH = 300;
	public static final int DEFAULT_HEIGHT = 200;
	private JComboBox faceCombo;
	private JLabel label;
	private static final int DEFAULT_SIZE = 12;

	public ComboBoxFrame() {
		setTitle("ComboBoxFrame");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		label = new JLabel("The quick brown fox jumps over the lay dog.");
		label.setFont(new Font("Serif", Font.PLAIN, DEFAULT_SIZE));
		faceCombo = new JComboBox();
		faceCombo.setEditable(true);
		faceCombo.addItem("Serif");
		faceCombo.addItem("SansSerif");
		faceCombo.addItem("Monspaced");
		faceCombo.addItem("Dialog");
		faceCombo.addItem("DialogInput");
		faceCombo.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				label.setFont(new Font((String) faceCombo.getSelectedItem(), Font.PLAIN, DEFAULT_SIZE));
			}
		});
		JPanel comboPanel = new JPanel();
		comboPanel.add(faceCombo);
		add(comboPanel, BorderLayout.SOUTH);
	}
}