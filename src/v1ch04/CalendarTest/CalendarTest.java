package v1ch04.CalendarTest;

import sun.util.resources.cldr.aa.CalendarData_aa_ER;

import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Java核心技术Demo练习,打印日历
 */
public class CalendarTest {
	public static void main(String[] args) {
		//construct d as current date
		GregorianCalendar d = new GregorianCalendar();
		int today = d.get(Calendar.DAY_OF_MONTH);
		int month = d.get(Calendar.MONTH);
		//set d to star date of month
		d.set(Calendar.DAY_OF_MONTH, 1);
		int weekday = d.get(Calendar.DAY_OF_WEEK);
		int firstDayOfWeek = d.getFirstDayOfWeek();
		//datemine the required indentation for the first line
		int indend = 0;
		while (weekday != firstDayOfWeek) {
			indend++;
			d.add(Calendar.DAY_OF_MONTH, -1);
			weekday = d.get(Calendar.DAY_OF_WEEK);
		}
		//print weekday names
		String[] weekdayNames = new DateFormatSymbols().getShortWeekdays();
		do {
			System.out.printf("%4s", weekdayNames[weekday]);
			d.add(Calendar.DAY_OF_MONTH, 1);
			weekday = d.get(Calendar.DAY_OF_WEEK);
		} while (weekday != firstDayOfWeek);
		while (weekday != firstDayOfWeek)
			System.out.println();
		for (int i = 1; i <= indend; i++)
			System.out.print("       ");
		d.set(Calendar.DAY_OF_MONTH, 1);
		//System.out.println();
		do {
			//print day
			int day = d.get(Calendar.DAY_OF_MONTH);
			System.out.printf("%4d", day);
			//mark current day with *
			if (day == today)
				System.out.print("*");
			else
				System.out.print(" ");
			//advance d to the next day
			d.add(Calendar.DAY_OF_MONTH, 1);
			weekday = d.get(Calendar.DAY_OF_WEEK);
			//start a new line at the start of the week
			if (weekday == firstDayOfWeek)
				System.out.println();
		} while (d.get(Calendar.MONTH) == month);
		//the loop exits when d is day 1 fo the next month
		//pritn final end of likne if necessary
		if (weekday != firstDayOfWeek)
			System.out.println();
	}
}
