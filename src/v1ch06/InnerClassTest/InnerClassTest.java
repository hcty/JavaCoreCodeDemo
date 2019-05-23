package v1ch06.InnerClassTest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * This program demonstrates the use of inner classes
 * 该程序演示了内部类的使用
 */
public class InnerClassTest {
	public static void main(String[] args) {
		TalkingClock clock = new TalkingClock(1000, true);
		clock.start();
		//keep program running until use select "OK"
		JOptionPane.showMessageDialog(null, "Quit program?");
		System.exit(0);
	}
}

/**
 * A clock that prints the time in regular intervals.
 * 一个以固定间隔打印时间的时钟。
 */
class TalkingClock {
	private int interval;
	private boolean beep;

	/**
	 * Constructs a talking clock
	 *
	 * @param interval the interval between messages (in milliseconds)
	 * @param beep     true if the clock should beep
	 */
	public TalkingClock(int interval, boolean beep) {
		this.interval = interval;
		this.beep = beep;
	}

	/**
	 * Starts the clock.
	 */
	public void start() {
		ActionListener listener = new TimePrinter();
		Timer t = new Timer(interval, listener);
		t.start();
	}

	public class TimePrinter implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			Date now = new Date();
			System.out.println("At the tone, the time is " + now);
			if (beep)
				Toolkit.getDefaultToolkit().beep();
		}
	}
}
