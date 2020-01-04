/**
 * 
 */
package Eight;

/**
 * @author dell
 *
 */
import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Biaoshifu();
	}
	private static void Biaoshifu()
	{
		System.out.printf("«Î ‰»Î≤‚ ‘◊÷∑˚¥Æ:");
		Scanner mi = new Scanner(System.in);
		while (mi.hasNext()) {
			String str = mi.nextLine();
			char ch = str.charAt(0);
			int f = 1;
			if (Character.isJavaIdentifierStart(ch)) {
				for (int i = 1; i < str.length(); i++) {
					if (!Character.isJavaIdentifierPart(str.charAt(i))) {
						f = 0;
						break;
					}
				}
			} else {
				f = 0;
			}
			if (f == 1) {
				System.out.println("true");
			} else {
				System.out.println("false");
			}
	}
}
}
