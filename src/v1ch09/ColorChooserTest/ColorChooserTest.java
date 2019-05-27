package v1ch09.ColorChooserTest;

import com.sun.xml.internal.messaging.saaj.soap.JpegDataContentHandler;
import sun.awt.ModalExclude;
import sun.awt.ModalityListener;
import sun.security.jca.JCAUtil;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.management.MonitorInfo;

public class ColorChooserTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				ColorChooserFrame frame = new ColorChooserFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

class ColorChooserFrame extends JFrame {
	public static final int DEFAULT_WIDTH = 300;
	public static final int DEFAULT_HEIGHT = 200;

	public ColorChooserFrame() {
		setTitle("ColorChooserFrame");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		ColorChooserPanel panel = new ColorChooserPanel();
		add(panel);
	}
}

class ColorChooserPanel extends JPanel {
	public ColorChooserPanel() {
		JButton modalButton = new JButton("Modal");
		modalButton.addActionListener(new ModalListener());
		add(modalButton);
		JButton modelessButton = new JButton("Modeless");
		modelessButton.addActionListener(new ModelessListener());
		add(modelessButton);

		JButton immediateButton = new JButton("Immediate");
		immediateButton.addActionListener(new ImmediateListener());
		add(immediateButton);
	}

	private class ModalListener implements ActionListener {
		@Override public void actionPerformed(ActionEvent e) {
			Color defaultColor = getBackground();
			Color selected = JColorChooser.showDialog(ColorChooserPanel.this, "Set background", defaultColor);
			if (selected != null)
				setBackground(selected);
		}

		;
	}

	private class ModelessListener implements ActionListener {
		private JDialog dialog;
		private JColorChooser chooser;

		public ModelessListener() {
			chooser = new JColorChooser();
			dialog = JColorChooser
					.createDialog(ColorChooserPanel.this, "Background Color", false, chooser, new ActionListener() {
						@Override public void actionPerformed(ActionEvent e) {
							setBackground(chooser.getColor());
						}
					}, null);
		}

		@Override public void actionPerformed(ActionEvent e) {
			chooser.setColor(getBackground());
			dialog.setVisible(true);
		}
	}

	private class ImmediateListener implements ActionListener {
		private JDialog dialog;
		private JColorChooser chooser;

		public ImmediateListener() {
			chooser = new JColorChooser();
			chooser.getSelectionModel().addChangeListener(new ChangeListener() {
				@Override public void stateChanged(ChangeEvent e) {
					setBackground(chooser.getColor());
				}
			});
			dialog = new JDialog((Frame) null, false);
			dialog.add(chooser);
			dialog.pack();
		}

		@Override public void actionPerformed(ActionEvent e) {
			chooser.setColor(getBackground());
			dialog.setVisible(true);
		}
	}
}
