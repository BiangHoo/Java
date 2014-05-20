import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JTextArea;


public class Server extends JFrame {
	JTextArea ta = new JTextArea();
	ServerSocket server = null;
	ArrayList<Conn> ConnList = new ArrayList<Conn>();
	public Server(int port) throws Exception{
		server = new ServerSocket(port);
		this.add(ta,BorderLayout.CENTER);
		setBounds(200, 200, 300, 450);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		setVisible(true);
	}
	public void startServer(){
		try {
			while(true){
				Socket socket = server.accept();//服务器端接收Socket请求
				ConnList.add(new Conn(socket));//将该连接加入ArrayList，起一个新线程建立连接
				ta.append(socket.getInetAddress().getHostName() + "进入" + "    " + "端口号"
						+ socket.getPort()+"\n");
				ta.append("当前在前总人数： " + ConnList.size() + "\n\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	class Conn implements Runnable{//处理新的连接的内部类
		
		private Socket socket =null;
		public Conn(Socket socket){
			this.socket=socket;	
			System.out.println("init");
			(new Thread(this)).start();
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				DataInputStream dis = new DataInputStream(socket.getInputStream());
				String str = dis.readUTF();//得到用户发来的信息
				String clientInfo = socket.getInetAddress().getHostName();//得到用户的主机名
				while (str != null && str.length() != 0) {
					ta.append(str + "\n");
					System.out.println(str);
					for (Iterator it = ConnList.iterator(); it.hasNext();) {
						Conn cc = (Conn) it.next();
						if (this != cc) {
							cc.send(str, clientInfo);
						}
					}
					str = dis.readUTF();
				}
				this.dispose();
			}catch(Exception e){
				e.printStackTrace();
				this.dispose();
			}
		}
		
		public void send(String str,String client) throws IOException{
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			dos.writeUTF(client+"says:\n"+str);
		}
		public void dispose(){
			try {
				// this.setVisible(false);
				ta.append(socket.getInetAddress().getHostName() + "退出" + "\n");
				if (socket != null)
					socket.close();
				ConnList.remove(this);
				ta.append("当前在线人数: " + ConnList.size() + "\n\n");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String args[])throws Exception{
		 
		try {
			int port = 8888;//定义一个ServerSocket监听端口8888
			JFrame.setDefaultLookAndFeelDecorated(true);
			Server cs = new Server(port);
			cs.startServer();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
