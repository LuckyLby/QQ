package cn.thxy.www.model;
import java.util.*;

import cn.thxy.www.share.*;
import cn.thxy.www.tools.*;

import java.net.*;
import java.io.*;

public class Connect 
{
	public Socket s;
	public Connect()
	{
		
	}
	public boolean send(Object o)
	{
		boolean b=false;
		try {
			s=new Socket("127.0.0.1",9999);		
			ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
			oos.writeObject(o);
            ObjectInputStream ois=new ObjectInputStream(s.getInputStream());			
			Message ms=(Message)ois.readObject();
			if(ms.getMesType().equals("1"))
			{	
				ConnectServerThread connectServerThread=new ConnectServerThread(s);
				connectServerThread.start();
				ManagerThread.addConnectServerThread(((User)o).getUserId(),connectServerThread);
				b=true;
			}			
		} catch (Exception e) {}
		return b;
	}
}