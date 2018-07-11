package cn.thxy.www.model;
import java.util.*;

public class MesThreadManager 
{
	public static HashMap hm=new HashMap<String, MesThread>();
	public static void addMesThread(String uid,MesThread xt)
	{
		hm.put(uid, xt);
	}
	public static MesThread getMesThread(String uid)
	{
		return (MesThread)hm.get(uid);
	}
	public static String getOnlineUser()
	{
		Iterator it=hm.keySet().iterator();
		String res="";
		while(it.hasNext())
		{
			res+=it.next().toString()+" ";
		}
		return res;
	}
}