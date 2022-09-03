import java.io.PrintWriter;
import java.util.Scanner;

/*

0 1 2 3 4 5 6 7 8 9  (indices)
7 4 8,2 5,1 9,3 6 10 (pins)

1 2 3 4 5 6 7 8 9 10
0 1 0 1 1 1 0 1 0 1

 */

public class B {
	
	public static void main(String[] args) {
		Scanner fs = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int T = 1;
//		T = fs.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			char[] s = fs.next().toCharArray();
			if (s[0] == '1') {
				out.println("No");
				continue;
			}
			int[] pins = new int[] {7, 4, 8, 2, 5, 1, 9, 3, 6, 10};
			int foo = 0;
			boolean split = false;
			outer: while (foo < 9) {
				boolean hasOne = false;
				if (singlePin(foo)) {
					hasOne = (s[pins[foo]-1] == '1');
				} else {
					hasOne = (s[pins[foo]-1] == '1' || s[pins[foo+1]-1] == '1');
//					System.out.println("here " + foo + " = " + pins[foo] + " " + (pins[foo+1]) + " " + hasOne);
				}
				boolean knockedDown = true;
				int bar = (singlePin(foo) ? foo + 1 : foo + 2);
				while (bar < 10 && hasOne) {
					if (singlePin(bar)) {
						if (s[pins[bar]-1] == '1' && knockedDown) {
							if (bar == 8) {
								if (bar - 2 != foo) {
									split = true;
									break outer;
								}
							} else {
								if (bar - 1 != foo) {
									split = true;
									break outer;
								}
							}
						}
						if (s[pins[bar]-1] != '0') {
							knockedDown = false;
						}
						bar++;
					} else {
						if ((s[pins[bar]-1] == '1' || s[pins[bar+1]-1] == '1') && knockedDown) {
							if (bar == 2) {
								if (bar - 1 != foo) {
									split = true;
									break outer;
								}
							} else {
								if (bar - 2 != foo) {
									split = true;
									break outer;
								}
							}
						}
						if (s[pins[bar]-1] != '0' || s[pins[bar+1]-1] != '0') {
							knockedDown = false;
						}
						bar += 2;
					}
				}
				if (singlePin(foo)) {
					foo++;
				} else {
					foo += 2;
				}
			}
			out.println(split ? "Yes" : "No");
		}
		fs.close();
		out.close();
	}
	
	static boolean singlePin(int index) {
		return index < 2 || index > 7;
	}
}
