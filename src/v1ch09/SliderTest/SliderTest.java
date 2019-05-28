package v1ch09.SliderTest;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * @author Cay Horstmann
 * @version 1.13 2007-06-12
 */
public class SliderTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				SliderTestFrame frame = new SliderTestFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

/**
 * A frame with many sliders and a text field to show slider values.
 * 包含许多滑块的框架和用于显示滑块值的文本字段。
 */
class SliderTestFrame extends JFrame {
	public static final int DEFAULT_WIDTH = 350;
	public static final int DEFAULT_HEIGHT = 450;

	private JPanel sliderPanel;
	private JTextField textField;
	private ChangeListener listener;

	public SliderTestFrame() {
		setTitle("SliderTest");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

		sliderPanel = new JPanel();
		sliderPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		listener = new ChangeListener() {
			public void stateChanged(ChangeEvent event) {
				JSlider source = (JSlider) event.getSource();
				textField.setText("" + source.getValue());
			}
		};

		JSlider slider = new JSlider();
		addSlider(slider, "Plain");
		slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		addSlider(slider, "Ticks");
		slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setSnapToTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		addSlider(slider, "Snap to ticks");
		slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		slider.setPaintTrack(false);
		addSlider(slider, "No track");
		slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		slider.setInverted(true);
		addSlider(slider, "Inverted");
		slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		addSlider(slider, "Labels");
		slider = new JSlider();
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(5);
		Dictionary<Integer, Component> labelTable = new Hashtable<Integer, Component>();
		labelTable.put(0, new JLabel("A"));
		labelTable.put(20, new JLabel("B"));
		labelTable.put(40, new JLabel("C"));
		labelTable.put(60, new JLabel("D"));
		labelTable.put(80, new JLabel("E"));
		labelTable.put(100, new JLabel("F"));

		slider.setLabelTable(labelTable);
		addSlider(slider, "Custom labels");
		slider = new JSlider();
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setSnapToTicks(true);
		slider.setMajorTickSpacing(20);
		slider.setMinorTickSpacing(20);
		labelTable = new Hashtable<Integer, Component>();
		labelTable.put(0, new JLabel(new ImageIcon("nine.gif")));
		labelTable.put(20, new JLabel(new ImageIcon("ten.gif")));
		labelTable.put(40, new JLabel(new ImageIcon("jack.gif")));
		labelTable.put(60, new JLabel(new ImageIcon("queen.gif")));
		labelTable.put(80, new JLabel(new ImageIcon("king.gif")));
		labelTable.put(100, new JLabel(new ImageIcon("ace.gif")));

		slider.setLabelTable(labelTable);
		addSlider(slider, "Icon labels");
		textField = new JTextField();
		add(sliderPanel, BorderLayout.CENTER);
		add(textField, BorderLayout.SOUTH);
	}

	/**
	 * Adds a slider to the slider panel and hooks up the listener
	 * 向滑块面板添加滑块并挂接侦听器
	 *
	 * @param s           the slider
	 * @param description the slider description
	 */
	public void addSlider(JSlider s, String description) {
		s.addChangeListener(listener);
		JPanel panel = new JPanel();
		panel.add(s);
		panel.add(new JLabel(description));
		sliderPanel.add(panel);
	}
}
