import java.util.Scanner;
import java.util.ArrayList;

public class ReverseMax {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<String> input = new ArrayList<String>();
		while (scan.hasNextLine()) {
			input.add(scan.nextLine());
		}
		ArrayList<int []> lines = new ArrayList<int []>();
		for (int i = 0; i < input.size(); i++) {
			if (!input.get(i).equals("")) {
				String[] str = input.get(i).split(" ");
				int [] strInt = new int[str.length];
				for (int j = 0; j < str.length; j++) {
					strInt[j] = Integer.parseInt(str[j]);
				}
				lines.add(strInt);
			} else {
				lines.add(new int[0]);
			}
		}
		ArrayList<Integer> maxLine = new ArrayList<Integer>();
		ArrayList<Integer> maxColumn = new ArrayList<Integer>();
		for (int i = 0; i < input.size(); i++) {		
			maxLine.add(Integer.MIN_VALUE);		
			for (int j = 0; j < lines.get(i).length; j++) {
				if (lines.get(i)[j] > maxLine.get(i)) {
					maxLine.set(i, lines.get(i)[j]);
				}
				if (maxColumn.size() <= j) {
					maxColumn.add(lines.get(i)[j]);
				} else if (lines.get(i)[j] > maxColumn.get(j)) {
					maxColumn.set(j, lines.get(i)[j]);
				}
			}
		}
		for (int i = 0; i < input.size(); i++) {
			for (int j = 0; j < lines.get(i).length; j++) {
				if (maxLine.get(i) < maxColumn.get(j)) {
					System.out.print(maxColumn.get(j));
				} else {
					System.out.print(maxLine.get(i));
				}
				if (j != lines.get(i).length - 1) System.out.print(" ");
			}
			System.out.println();
		}
	}
}
