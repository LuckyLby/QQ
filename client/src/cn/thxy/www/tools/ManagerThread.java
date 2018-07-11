package cn.thxy.www.tools;
import java.util.*;
public class ManagerThread {

	private static HashMap hm=new HashMap<String, ConnectServerThread>();
	
	public static void addConnectServerThread(String chatId,ConnectServerThread connectThread)
	{
		hm.put(chatId,connectThread);
	}	
	public static ConnectServerThread getConnectServerThread(String chatId)
	{
		return (ConnectServerThread)hm.get(chatId);
	}
}
