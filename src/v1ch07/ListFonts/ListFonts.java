package v1ch07.ListFonts;

import java.awt.*;

/**
 * This program demonstrates print system font
 * 该程序演示了打印系统字体
 */
public class ListFonts {
	public static void main(String[] args) {
		String[] fontNames = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		for (String fontName : fontNames) {
			System.out.println(fontName);
		}
	}
}
