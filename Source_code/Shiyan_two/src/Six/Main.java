/**
 * 
 */
package Six;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("ÇëÊäÈë²âÊÔÊı¾İ£º£¨ÀıÈç1*2£©");
		Jisuanqi(); 
	}

	private static void Jisuanqi() {
		Scanner input = new Scanner(System.in);
		String sc = input.next();//×Ö·û´®
		int [] a = new int [4];
		char c;
		a[0] = sc.charAt(0) - 48;
		c = sc.charAt(1);
		a[1] = sc.charAt(2) - 48;
		if(c == '+')
		    System.out.printf("%d + %d = %d", a[0], a[1], a[0]+a[1]);
		else if(c == '-')
			System.out.printf("%d - %d = %d", a[0], a[1], a[0]-a[1]);
		else if(c == '*')
			System.out.printf("%d * %d = %d", a[0], a[1], a[0]*a[1]);
		else if(c == '+')
			if(a[1] != 0)
			    System.out.printf("%d / %d = %d", a[0], a[1], a[0]/a[1]);
			else
				System.out.printf("Error!");
				
	}
}