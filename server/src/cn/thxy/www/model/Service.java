package cn.thxy.www.model;
import java.net.*;
import java.io.*;
import java.util.*;

import cn.thxy.www.share.*;

public class Service 
{
	public Service()
	{
        try {
			ServerSocket ss=new ServerSocket(9999);
			while(true)
			{
				Socket s=ss.accept();
				ObjectInputStream ois=new ObjectInputStream(s.getInputStream());
				User u=(User)ois.readObject();
				Message m=new Message();
				ObjectOutputStream oos=new ObjectOutputStream(s.getOutputStream());
				if(u.getPasswd().equals("admin"))
				{
					m.setMesType("1");
					oos.writeObject(m);
					MesThread xc=new MesThread(s);
					MesThreadManager.addMesThread(u.getUserId(), xc);
					xc.start();
					xc.tongzhi(u.getUserId());
				}	
				else
				{
					m.setMesType("2");
					oos.writeObject(m);
					s.close();
				}				
			}				
		} catch (Exception e) {}
	}
}
