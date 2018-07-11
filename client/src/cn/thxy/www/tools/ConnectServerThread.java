package cn.thxy.www.tools;
import java.io.*;
import java.net.*;

import cn.thxy.www.boundary.*;
import cn.thxy.www.share.*;


public class ConnectServerThread extends Thread
{
    private Socket s;
	
	public ConnectServerThread(Socket s)
	{
		this.s=s;
	}
	public Socket getS() {
		return s;
	}

	public void setS(Socket s) {
		this.s = s;
	}
	public void run()
	{
		while(true)
		{
			try {
				
				ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
				Message m=(Message)ois.readObject();
				if(m.getMesType().equals(MessageType.message_comm_mes))
				{				
					Chat chat= ManagerChat.getChat(m.getGetter()+" "+m.getSender());
					chat.showMessage(m);
				}else if(m.getMesType().equals(MessageType.message_ret_onLineFriend))
				{
					String con=m.getCon();
					String friends[]=con.split(" ");
					String getter=m.getGetter();
					System.out.println("getter="+getter);
					List list=ManagerList.getFriendList(getter);
					if(list !=null)
					{
						list.upateFriend(m);
					}				
				}
			} catch (Exception e) {}
		}
	}
}
