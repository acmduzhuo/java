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
		System.out.printf("�������������֣�");
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
		System.out.printf("���Լ���ǣ�%d\n", a);
		System.out.printf("��С�������ǣ�%d\n", m*n/a);
		sc.close();
	}

}
