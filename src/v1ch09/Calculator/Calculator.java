package v1ch09.Calculator;

import com.sun.xml.internal.fastinfoset.algorithm.IEEE754FloatingPointEncodingAlgorithm;

import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				CalculatorFrame frame = new CalculatorFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

class CalculatorFrame extends JFrame {
	public CalculatorFrame() {
		setTitle("CalculatorFrame");
		CalculatorPanel panel = new CalculatorPanel();
		add(panel);
		pack();
	}
}

class CalculatorPanel extends JPanel {
	private JButton display;
	private JPanel panel;
	private double result;
	private String lastCommand;
	private boolean start;

	public void calculate(double x) {
		if (lastCommand.equals("+"))
			result += x;
		else if (lastCommand.equals("-"))
			result -= x;
		else if (lastCommand.equals("*"))
			result *= x;
		else if (lastCommand.equals("/"))
			result /= x;
		else if (lastCommand.equals("="))
			result = x;
		display.setText("" + result);
	}

	private class CommandAction implements ActionListener {
		@Override public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			if (start) {
				if (command.equals("-")) {
					display.setText(command);
					start = false;
				} else
					lastCommand = command;
			} else {
				calculate(Double.parseDouble(display.getText()));
				lastCommand = command;
				start = true;
			}
		}
	}

	private class InsertAction implements ActionListener {
		@Override public void actionPerformed(ActionEvent e) {
			String input = e.getActionCommand();
			if (start) {
				display.setText("");
				start = false;
			}
			display.setText(display.getText() + input);
		}
	}

	private void addButton(String label, ActionListener listener) {
		JButton button = new JButton(label);
		button.addActionListener(listener);
		panel.add(button);
	}

	public CalculatorPanel() {
		setLayout(new BorderLayout());
		result = 0;
		lastCommand = "=";
		start = true;
		display = new JButton("0");
		display.setEnabled(false);
		add(display, BorderLayout.NORTH);
		ActionListener insert = new InsertAction();
		ActionListener command = new CommandAction();
		panel = new JPanel();
		panel.setLayout(new GridLayout(4, 4));
		addButton("7", insert);
		addButton("8", insert);
		addButton("9", insert);
		addButton("/", command);
		addButton("4", insert);
		addButton("5", insert);
		addButton("6", insert);
		addButton("*", command);
		addButton("1", insert);
		addButton("2", insert);
		addButton("3", insert);
		addButton("-", command);
		addButton("0", insert);
		addButton(".", insert);
		addButton("=", command);
		addButton("+", command);
		add(panel, BorderLayout.CENTER);
	}
}