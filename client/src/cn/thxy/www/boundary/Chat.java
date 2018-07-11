package cn.thxy.www.boundary;
import javax.swing.*;

import cn.thxy.www.model.Connect;
import cn.thxy.www.share.*;
import cn.thxy.www.tools.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class Chat extends JFrame implements ActionListener
{
	//定义文本框
	JTextArea jta;
	//定义输入框
	JTextField jtf;
	//定义发送按钮
	JButton jb;
	//定义面板
	JPanel jp;
	//当前用户ID
	String ownerId;
	//聊天好友ID
	String friendId;
	//发送的信息
	String xinxi;
	
	public Chat(String owner ,String friend)
	{
		this.ownerId=owner;
		this.friendId=friend;
		jta=new JTextArea();
		jtf=new JTextField(15);
		jb=new JButton("发送");
		jb.addActionListener(this);
		jp=new JPanel();
		jp.add(jtf);
		jp.add(jb);
		
		this.add(jta,"Center");
		this.add(jp,"South");
		//设置文本框标题
		this.setTitle(ownerId+"正在和"+friend+"聊天");
		this.setIconImage((new ImageIcon("image/qq.gif").getImage()));
		this.setSize(300, 200);
		this.setLocation(318,186);
		this.setResizable(false);
		this.setVisible(true);
	}
	//显示好友发送过来的信息
	public void showMessage(Message m)
	{
		String datetime=Calendar.getInstance().getTime().toLocaleString();
		xinxi=m.getSender()+"对我说:    "+m.getCon()+"      "+datetime+"\r\n";
		jta.append(xinxi);
	}
	//监听发送按钮
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==jb)
		{
			//封装信息对象
			Message m=new Message();
			m.setMesType(MessageType.message_comm_mes);
			m.setSender(this.ownerId);
			m.setGetter(this.friendId);
			m.setCon(jtf.getText());
			m.setSendTime(new Date().toString());
			try {
				ObjectOutputStream oos=new ObjectOutputStream
				(ManagerThread.getConnectServerThread(ownerId).getS().getOutputStream());
				oos.writeObject(m);
				String wodeneirong="我对"+m.getGetter()+"说：   "+jtf.getText()+"      "+Calendar.getInstance().getTime().toLocaleString()+"\r\n";
				jta.append(wodeneirong);
				jtf.setText("");
			} catch (Exception e2) {}			
		}	
	}	
}//this.timeNow.setText("当前系统时间："+Calendar.getInstance().getTime().toLocaleString()+" ");	