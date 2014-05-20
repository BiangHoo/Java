import java.awt.BorderLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class Client extends JFrame {
	JTextArea ta = new JTextArea("欢迎登录客户端群聊!" + "\n" );//显示信息框
	TextArea tf = new TextArea(3, 21);//信息发送框
	JButton btn = new JButton("send");
	JPanel jp = new JPanel();
	Socket s = null;
	public static void main(String args[]) throws Exception{
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		String server="127.0.0.1";//服务器端IP地址
		int port =8888;//服务器端端口号
		Client cc =new Client(server,port);//与服务器端建立TCP socket连接
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		while (str != null && str.length() != 0) {
			cc.send(str);
			str = br.readLine();
		}
		cc.disconnect();
	}
	public Client(String server,int port) throws Exception{
		this.setLayout(new BorderLayout(10, 10));
		this.add(ta, BorderLayout.CENTER);
		jp.add(tf);
		jp.add(btn);
		this.add(jp, BorderLayout.SOUTH);
		setBounds(300, 300, 400, 400);
		setVisible(true);
		tf.requestFocus();
		try{
			s = new Socket(server,port);
		}catch(Exception e){
			System.out.println("对不起，无法连接服务器");
		}
		btn.addActionListener(new ActionListener(){//监听按钮事件

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				try {
					String msg_send =tf.getText();
					if (msg_send.trim().length() == 0){
						return;
					}
					Client.this.send(msg_send);
					//发送信息到服务器端
					tf.setText("");//清空发送框
					ta.append("I say:" + "\n");
					ta.append(msg_send + "\n");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		btn.setMnemonic(KeyEvent.VK_ENTER);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		(new Thread(new ReceiveMsg())).start();
	}
	protected void send(String msg_send) throws IOException {
		System.out.println("client send");
		DataOutputStream dos = new DataOutputStream(s.getOutputStream());
		dos.writeUTF(msg_send);
		System.out.println("client send complete");
	}
	public void disconnect() throws Exception {
		s.close();
	}

	class ReceiveMsg implements Runnable {

		public void run() {
			if (s == null)
				return;
			try {
				DataInputStream dis = new DataInputStream(s.getInputStream());
				String str = dis.readUTF();
				while (str != null && str.length() != 0) {

					Client.this.ta.append(str + "\n");
					str = dis.readUTF();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}
	
}
