import java.io.PrintWriter;
import java.util.Scanner;

public class A {
	
	public static void main(String[] args) {
		Scanner fs = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int T = 1;
//		T = fs.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			String s = fs.next();
			String[] days = new String[] {"", "Monday", "Tuesday",
					"Wednesday", "Thursday", "Friday", "Saturday"};
			int day = 0;
			for (int i = 0; i < 7; i++) {
				if (s.equals(days[i])) {
					day = i + 1;
					break;
				}
			}
			out.println(7 - day);
		}
		fs.close();
		out.close();
	}
}
