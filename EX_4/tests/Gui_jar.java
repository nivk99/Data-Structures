package ex4.tests;

import java.util.Scanner;
import ex4.geometry.*;
import ex4.*;

import java.awt.Color;
import java.io.File;
import java.io.FileWriter;

/**
 * This class creates the jar
 * 
 * @author niv kotek
 *
 */
public class Gui_jar {
	public static void main(String[] a) {
		Scanner sc = new Scanner(System.in);
		Ex4 win = new Ex4();
		GUI_Shape_Collection test_get = win.getShape_Collection();
		int flag = 0;
		String file = new String();
		String fs = new String();
		if (a.length > 1) {
			file = a[0];
			fs = a[1];
			if (((char) a[1].charAt(0) > '5' || (char) a[1].charAt(0) < '0')) {
				file = a[1];
				fs = a[0];
			}
		} else {
			System.out.print("Please type the file name: ");
			file = sc.next();
			System.out.print("Enter a sorting method (a number in [0-5]): ");
			fs = sc.next();
		}

		if (((char) fs.charAt(0) > '5' || (char) fs.charAt(0) < '0')) {
			throw new IllegalArgumentException("\n" + "!!! You did not a number between 0-5 !!!");
		}

		test_get.load(file);
		flag = Integer.parseInt(fs);
		Shape_Comp comp = new Shape_Comp(flag);
		test_get.sort(comp);
		System.out.println("**** Sorting accurding to flag=" + flag + " ****");
		System.out.println();
		System.out.println(win.getInfo());
		win.show();

	}

}