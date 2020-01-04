/**
 * 
 */
package One;

/**
 * @author lenovo
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Chengfabiao();
	}

	private static void Chengfabiao() {
		// TODO Auto-generated method stub
		for(int i=1;i<=9;i++)
		{
			for(int j=1;j<=i;j++)
			{
				System.out.printf("%d * %d = %d%c", i, j, i*j, (i==j) ? '\n':'\t');
			}
		}
	}

}
