/**
 * 
 */
package Four;

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
		// TODO Auto-generated method stub
		System.out.println("请输入一个数字：");
		Jiecheng();
	}
	private static void Jiecheng() 
	{
		Scanner in=new Scanner(System.in);
		int c,i,a=1;
		c=in.nextInt();
		for(i=1;i<=c;i++)
		{
			a*=i;
		}
		System.out.println(a);
		if(a<0)
		{
			System.out.printf("%d溢出\n", c);
		}
	}

}
