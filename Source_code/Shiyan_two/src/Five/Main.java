/**
 * 
 */
package Five;

import java.math.RoundingMode;
import java.text.NumberFormat;

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
		Yuanzhoulv();
	}
	private static void Yuanzhoulv()
	{
	     Scanner in = new Scanner(System.in);
	        System.out.println("请输入测试数据：");
	        int n = in.nextInt();
	        System.out.println("请输入保留小数的位数：");
	        int k = in.nextInt();
	        double sum = 0.0;
	        double i;
	        for(i=1;i<=n;i++){
	            sum += (1/(4*i-3)) - (1/(4*i-1));
	 
	        }
	        NumberFormat nf = NumberFormat.getNumberInstance();
			nf.setMaximumFractionDigits(k);
	        nf.setRoundingMode(RoundingMode.UP);
			System.out.println(nf.format(Math.PI*sum/Math.PI*4));
	}
}
