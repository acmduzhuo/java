/**
 * 
 */
package Two;

/**
 * @author dell
 *
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
 
public class client1{
	Socket socket=null;
	static int num=1;
	String name =null;
	public client1(String name) throws UnknownHostException, IOException {
		this.socket=new Socket("127.0.0.1",8089);
		this.name=name;
		System.out.println(name+" connection successfully!!");
	}
	
	public static void main(String[] args) {
		try {
 
			Scanner input=new Scanner(System.in);
			client1 client1=new client1("client"+num++);
			Thread re=new Thread(new ReadMes(client1.socket));
			re.start();
 
			PrintWriter out=new PrintWriter(client1.socket.getOutputStream(),true);
			while(true) {
				String mes=input.nextLine();
				out.println(client1.name+":"+mes);
				out.println();
				out.flush();
				System.out.println(123);
			}			
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
 
}
 
 
class ReadMes implements Runnable{
	static Socket socket=new Socket();
	public ReadMes(Socket socket) {
		this.socket=socket;
	}
	
	public void run() {
		// TODO 自动生成的方法存根
		try {
			Thread.sleep(1000);
			BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while(true) {
				String str=br.readLine();
				System.out.println(str);
				
			}
		} catch (InterruptedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
	
}