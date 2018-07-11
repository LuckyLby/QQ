package cn.thxy.www.model;
import cn.thxy.www.share.*;

public class Proving 
{
	public boolean checkUser(User u)
	{
		return new Connect().send(u);
	}
}
