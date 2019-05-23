package v1ch06.LocalInnerClassTest;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import javax.swing.*;

/**
 * This program demonstrates the use of local inner classes
 * 该程序演示了本地内部类的使用
 */
public class LocalInnerClassTest {
	public static void main(String[] args) {
		TalkingClock clock = new TalkingClock();
		clock.start(1000, true);
		//keep grogram running until user select "OK"
		JOptionPane.showMessageDialog(null, "Quit program?");
		System.exit(0);
	}
}

/**
 * A clock that prints the time in regular intervals
 * 一个以固定间隔打印时间的时钟
 */
class TalkingClock {
	/**
	 * Starts the clock.
	 *
	 * @param interval the interval between messages (in milliseconds) 消息之间的间隔（以毫秒为单位）
	 * @param beep     true if the clock should beep
	 */
	public void start(int interval, final boolean beep) {
		class TimePrinter implements ActionListener {
			@Override public void actionPerformed(ActionEvent e) {
				Date now = new Date();
				System.out.println("At the tone,tie time is " + now);
				if (beep)
					Toolkit.getDefaultToolkit().beep();
			}
		}
		ActionListener listener = new TimePrinter();
		Timer ts = new Timer(interval, listener);
		ts.start();
	}
}