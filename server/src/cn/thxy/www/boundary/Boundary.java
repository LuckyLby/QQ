package cn.thxy.www.boundary;
import javax.swing.*;

import cn.thxy.www.model.*;

import java.awt.*;
import java.awt.event.*;

public class Boundary extends JFrame implements ActionListener
{

	JPanel jp1;
	JButton jb1,jb2;
	
	public static void main(String[] args)
	{
		Boundary boundary= new Boundary();
	}
	public Boundary()
	{
		jp1=new JPanel();
		jb1=new JButton("启动服务器");
		jb1.addActionListener(this);
		jb2=new JButton("关闭服务器");
		jb2.addActionListener(this);
		jp1.add(jb1);
		jp1.add(jb2);
		
		
		this.add(jp1);
		this.setSize(186,168);
		this.setLocation(318,186);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==jb1)
		{
			new Service();
		}	
		else if(e.getSource()==jb2)
		{
			System.exit(0);
		}
	}
}
