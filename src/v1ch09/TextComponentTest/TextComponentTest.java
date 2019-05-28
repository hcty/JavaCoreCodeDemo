package v1ch09.TextComponentTest;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TextComponentTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				TextComponentFrame frame = new TextComponentFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

class TextComponentFrame extends JFrame {

	public static final int DEFAULT_WIDTH = 300;
	public static final int DEFAULT_HEIGHT = 300;

	public TextComponentFrame() {
		setTitle("TextComponentTest");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		final JTextField textField = new JTextField();
		final JPasswordField passwordField = new JPasswordField();
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new GridLayout(2, 2));
		northPanel.add(new JLabel("User name: ", SwingConstants.RIGHT));
		northPanel.add(textField);
		northPanel.add(new JLabel("Password: ", SwingConstants.RIGHT));
		northPanel.add(passwordField);
		add(northPanel, BorderLayout.NORTH);
		final JTextArea textArea = new JTextArea(8, 40);
		JScrollPane scrollPane = new JScrollPane(textArea);
		add(scrollPane, BorderLayout.CENTER);
		JPanel southPanel = new JPanel();
		JButton insertButton = new JButton("Insert");
		southPanel.add(insertButton);
		insertButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				textArea.append(
						"User name: " + textField.getText() + " Password: " + new String(passwordField.getPassword())
								+ "\n");
			}
		});
		add(southPanel, BorderLayout.SOUTH);
	}
}
