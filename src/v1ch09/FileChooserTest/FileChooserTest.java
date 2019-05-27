import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import java.io.*;
import javax.swing.*;
import javax.swing.filechooser.*;
import javax.swing.filechooser.FileFilter;

public class FileChooserTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				ImageViewerFrame frame = new ImageViewerFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

class ImageViewerFrame extends JFrame {
	public static final int DEFAULT_WIDTH = 300;
	public static final int DEFAULT_HEIGHT = 400;

	private JLabel label;
	private JFileChooser chooser;

	public ImageViewerFrame() {
		setTitle("FileChooserTest");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

		// set up menu bar
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu menu = new JMenu("File");
		menuBar.add(menu);

		JMenuItem openItem = new JMenuItem("Open");
		menu.add(openItem);
		openItem.addActionListener(new FileOpenListener());

		JMenuItem exitItem = new JMenuItem("Exit");
		menu.add(exitItem);
		exitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});

		label = new JLabel();
		add(label);

		chooser = new JFileChooser();

		FileNameExtensionFilter filter = new FileNameExtensionFilter("Image files", "jpg", "jpeg", "gif");
		chooser.setFileFilter(filter);

		chooser.setAccessory(new ImagePreviewer(chooser));

		chooser.setFileView(new FileIconView(filter, new ImageIcon("palette.gif")));
	}

	private class FileOpenListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			chooser.setCurrentDirectory(new File("."));

			int result = chooser.showOpenDialog(ImageViewerFrame.this);

			if (result == JFileChooser.APPROVE_OPTION) {
				String name = chooser.getSelectedFile().getPath();
				label.setIcon(new ImageIcon(name));
			}
		}
	}

}

class FileIconView extends FileView {

	public FileIconView(FileFilter aFilter, Icon anIcon) {
		filter = aFilter;
		icon = anIcon;
	}

	public Icon getIcon(File f) {
		if (!f.isDirectory() && filter.accept(f))
			return icon;
		else
			return null;
	}

	private FileFilter filter;
	private Icon icon;
}

class ImagePreviewer extends JLabel {

	public ImagePreviewer(JFileChooser chooser) {
		setPreferredSize(new Dimension(100, 100));
		setBorder(BorderFactory.createEtchedBorder());

		chooser.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent event) {
				if (event.getPropertyName() == JFileChooser.SELECTED_FILE_CHANGED_PROPERTY) {
					// the user has selected a new file
					File f = (File) event.getNewValue();
					if (f == null) {
						setIcon(null);
						return;
					}

					// read the image into an icon
					ImageIcon icon = new ImageIcon(f.getPath());

					// if the icon is too large to fit, scale it
					if (icon.getIconWidth() > getWidth())
						icon = new ImageIcon(icon.getImage().getScaledInstance(getWidth(), -1, Image.SCALE_DEFAULT));

					setIcon(icon);
				}
			}
		});
	}
}
