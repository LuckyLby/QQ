package cn.thxy.www.tools;
import java.util.*;

import cn.thxy.www.boundary.*;
public class ManagerChat {

	private static HashMap hm=new HashMap<String, Chat>();
	
	public static void addChat(String friend,Chat chat)
	{
		hm.put(friend, chat);
	}
	public static Chat getChat(String friend )
	{
		return (Chat)hm.get(friend);
	}	
}
