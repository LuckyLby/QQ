package cn.thxy.www.tools;
import java.util.*;

import cn.thxy.www.boundary.*;
import cn.thxy.www.boundary.List;

import java.io.*;

public class ManagerList 
{
    private static HashMap hm=new HashMap<String,List>();
	public static void addList(String chat,List list)
	{
		hm.put(chat,list);
	}
	
	public static List getFriendList(String chat)
	{
		return (List)hm.get(chat);
	}
}
