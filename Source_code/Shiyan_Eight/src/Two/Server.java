/**
 * 
 */
package Two;
import java.io.BufferedReader;
/**
 * @author dell
 *
 */
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
//服务器
public class Server  implements Runnable {
	static ServerSocket sever=null;
	static Socket socket=null;
	static List<Socket> socketList=new ArrayList<Socket>();
	/**
	 * constructor
	 * 创建SeverSocket服务器端套接字
	 * */
	public Server(){
		try {
			sever=new ServerSocket(8089);
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
	}
	//执行服务器端的操作，不断将接收的客户端传过来的socket加入至线程池中。同时，在开始的时候加入一个想客户端写的线程单独运行。
	public static void main(String[] args) {
		//设置一个线程池，
		ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 20, 200, TimeUnit.MILLISECONDS,
	            new ArrayBlockingQueue<Runnable>(5));
 
			Scanner input=new Scanner(System.in);
			Server t=new Server();
			System.out.println("-----------Sever--------------");
			
			int count=0;
 
			////服务器端自己向客户端写消息需要一个线程，这儿是因为没有用图像化界面来显示，否则就只需用一个button按钮来发送消息。
			Thread out=new Thread(new Runnable() {
				Scanner input=new Scanner(System.in);
				public void run() {
					try {
						Thread.sleep(1000);
						while(true) {
							String mes=input.nextLine();
							for(int i=0;i<socketList.size();i++){
								Socket socket=socketList.get(i);
								PrintWriter out =new PrintWriter(socket.getOutputStream());
								out.println("sever:"+mes);
								out.flush();
							}
						}
					} catch (InterruptedException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					} catch (IOException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}
 
					
				}
				});
 
			//接收服务器端
			while(true) {
				try {	
			socket=sever.accept();
			count++;
			System.out.println("the "+count+"th has been coonected");
			 socketList.add(socket);
			}
			catch (IOException e) {
			// TODO 自动生成的 catch 块；
			e.printStackTrace();
			}
			//接收客户端的消息
			Thread read=new Thread(t);
			executor.execute(read);
 
		}
}
	//接收从客户端传来的消息，并转发到其他客户端
	public void run() {
 
		try {
			Thread.sleep(1000);
            BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
	
			while(true) {
				BufferedReader in = null;
				String getStr=in.readLine();
				System.out.println(getStr);
     //向其他的线程发送所接受到的消息
				for(int i=0;i<socketList.size();i++)
				{
					Socket socket=socketList.get(i);
					PrintWriter pw=new PrintWriter(socket.getOutputStream(),true);
					if(this.socket!=socket) {
						pw.println(getStr);
 
					}
					else 
					{
						pw.println("(you:)"+getStr);
						pw.flush();
					}
				}
				
				
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
