package Solved;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * Starting from point (0,0) on a plane, we have written all non-negative
 * integers 0,1,2,... as shown in the figure. For example, 1, 2, and 3 has been
 * written at points (1,1), (2,0), and (3,1) respectively and this pattern has
 * continued. You are to write a program that reads the coordinates of a point
 * (x, y), and writes the number (if any) that has been written at that point.
 * (x, y) coordinates in the input are in the range 0...5000.
 * 
 * input: The first line of the input is N, the number of test cases for this
 * problem. In each of the N following lines, there is x, and y representing the
 * coordinates (x, y) of a point.
 *
 * output: For each point in the input, write the number written at that point
 * or write "No Number" if there is none.
 */
public class _7326 {
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);

		int numCo = Integer.parseInt(scnr.nextLine());

		ArrayList<String> result = new ArrayList<String>();

		int[][] co = new int[numCo][2];

		for (int i = 0; i < numCo; i++) {
			String tmp = scnr.nextLine();
			co[i][0] = Integer.parseInt(tmp.split(" ")[0].trim());
			co[i][1] = Integer.parseInt(tmp.split(" ")[1].trim());
		}

		for (int i = 0; i < co.length; i++) {
			boolean noNum = false;
			int x = co[i][0];
			int y = co[i][1];
			if (x == 0 && y == 0) {// 0,0
				result.add("" + 0);
			} else if (x - y == 1) {// wrong coords
				result.add("No Number");
			} else if (x % 2 == 0) {// Even
				if (y == x) {
					result.add("" + x * 2);
				} else if (x - 2 == y) {
					result.add("" + (x * 2 - 2));
				} else {
					noNum = true;
				}
			} else if (x % 2 == 1) {// Odd
				if (y == x) {
					result.add("" + (x * 2 - 1));
				} else if (x - 2 == y && x - 2 > 0) {
					result.add("" + (x * 2 - 3));
				} else {
					noNum = true;
				}
			}
			if (noNum) {
				result.add("No Number");
			}
		}
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
	}
}
