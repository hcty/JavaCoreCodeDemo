import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DialogTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				DialogFrame frame = new DialogFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

class DialogFrame extends JFrame {
	public static final int DEFAULT_WIDTH = 300;
	public static final int DEFAULT_HEIGHT = 200;

	private AboutDialog dialog;

	public DialogFrame() {
		setTitle("DialogTest");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

		// construct a File menu

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu fileMenu = new JMenu("File");
		menuBar.add(fileMenu);

		// add About and Exit menu items

		// The About item shows the About dialog

		JMenuItem aboutItem = new JMenuItem("About");
		aboutItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				if (dialog == null) // first time
					dialog = new AboutDialog(DialogFrame.this);
				dialog.setVisible(true); // pop up dialog
			}
		});
		fileMenu.add(aboutItem);

		// The Exit item exits the program

		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});
		fileMenu.add(exitItem);
	}

}

class AboutDialog extends JDialog {
	public AboutDialog(JFrame owner) {
		super(owner, "About DialogTest", true);

		// add HTML label to center

		add(new JLabel("<html><h1><i>Core Java</i></h1><hr>By Cay Horstmann and Gary Cornell</html>"),
				BorderLayout.CENTER);

		// Ok button closes the dialog

		JButton ok = new JButton("Ok");
		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				setVisible(false);
			}
		});

		// add Ok button to southern border

		JPanel panel = new JPanel();
		panel.add(ok);
		add(panel, BorderLayout.SOUTH);

		setSize(250, 150);
	}
}
