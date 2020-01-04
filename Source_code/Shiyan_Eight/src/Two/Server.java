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
//������
public class Server  implements Runnable {
	static ServerSocket sever=null;
	static Socket socket=null;
	static List<Socket> socketList=new ArrayList<Socket>();
	/**
	 * constructor
	 * ����SeverSocket���������׽���
	 * */
	public Server(){
		try {
			sever=new ServerSocket(8089);
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
	}
	//ִ�з������˵Ĳ��������Ͻ����յĿͻ��˴�������socket�������̳߳��С�ͬʱ���ڿ�ʼ��ʱ�����һ����ͻ���д���̵߳������С�
	public static void main(String[] args) {
		//����һ���̳߳أ�
		ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 20, 200, TimeUnit.MILLISECONDS,
	            new ArrayBlockingQueue<Runnable>(5));
 
			Scanner input=new Scanner(System.in);
			Server t=new Server();
			System.out.println("-----------Sever--------------");
			
			int count=0;
 
			////���������Լ���ͻ���д��Ϣ��Ҫһ���̣߳��������Ϊû����ͼ�񻯽�������ʾ�������ֻ����һ��button��ť��������Ϣ��
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
						// TODO �Զ����ɵ� catch ��
						e.printStackTrace();
					} catch (IOException e) {
						// TODO �Զ����ɵ� catch ��
						e.printStackTrace();
					}
 
					
				}
				});
 
			//���շ�������
			while(true) {
				try {	
			socket=sever.accept();
			count++;
			System.out.println("the "+count+"th has been coonected");
			 socketList.add(socket);
			}
			catch (IOException e) {
			// TODO �Զ����ɵ� catch �飻
			e.printStackTrace();
			}
			//���տͻ��˵���Ϣ
			Thread read=new Thread(t);
			executor.execute(read);
 
		}
}
	//���մӿͻ��˴�������Ϣ����ת���������ͻ���
	public void run() {
 
		try {
			Thread.sleep(1000);
            BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
	
			while(true) {
				BufferedReader in = null;
				String getStr=in.readLine();
				System.out.println(getStr);
     //���������̷߳��������ܵ�����Ϣ
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
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
	}
 
}
