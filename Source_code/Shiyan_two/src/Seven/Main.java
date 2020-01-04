package Seven;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("请输入一个数字：");
		Suijishu();
	}
	private static void Suijishu()
	{
		int ram = 100;
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		int []sjs = new int[n];
		for(int k=0;k<n;k++) {
			int m = (int)(Math.random() * ram + 1);
			sjs[k] = m;
		}
		for(int i=0;i<(sjs.length-1);i++) {
			for(int j=i;j<sjs.length;j++) {
				if(sjs[i] > sjs[j]) {
					int temp = sjs[i];
					sjs[i] = sjs[j];
					sjs[j] = temp;
				}
			}
		}
//		for(int l=0;l<10;l++) {
//			System.out.println("从小到大："+sjs[l]);
//		}
		System.out.println("从小到大："+sjs[0]+","
				+sjs[1]+","+sjs[2]+","
				+sjs[3]+","+sjs[4]+","
				+sjs[5]+","+sjs[6]+","
				+sjs[7]+","+sjs[8]+","
				+sjs[9]);
	}
}
