/**
 * 
 */
package Three;

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
		Sushu();
	}
	private static void Sushu()
	{
		Scanner in=new Scanner(System.in);
		int c,i,k=1;
		c=in.nextInt();
		for(i=2;i<c;i++)
		{
			if(c%i==0) k=0;
		}
		if(c==1) k=0;
		if(k==1) System.out.println("This is a prime.");
		else System.out.println("This is not a prime.");
	}
}
