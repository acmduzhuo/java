/**
 * 
 */
package Two;

/**
 * @author lenovo
 *
 */
import java.util.Scanner;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Gongbeishu_gomngyueshu();
	}
	private static void Gongbeishu_gomngyueshu() {
		// TODO Auto-generated method stub
		int c,a,b,m,n;
		Scanner sc = new Scanner(System.in);
		System.out.printf("请输入两个数字：");
		a = sc.nextInt();
		b = sc.nextInt();
		m = a;
		n = b;
		c=1;
		while(c!=0) {
			c=a%b;
			a=b;
			b=c;
		}
		System.out.printf("最大公约数是：%d\n", a);
		System.out.printf("最小公倍数是：%d\n", m*n/a);
		sc.close();
	}

}
