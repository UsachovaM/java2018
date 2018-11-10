import java.util.Scanner;
import java.util.ArrayList;

public class Reverse {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ArrayList<String> arr = new ArrayList<String>();
		while (scan.hasNextLine()) {
			arr.add(scan.nextLine());
		}
		for (int i = arr.size(); i > 0; i--) {
			String[] arg = arr.get(i - 1).split(" ");
			for (int j = arg.length; j > 0; j--) {
				if (j - 1 != 0) {
					System.out.print(arg[j - 1]);
					System.out.print(" ");
				}
				else {
					System.out.println(arg[j - 1]);
				}
			}
		}
	}
}
