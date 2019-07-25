import javax.swing.*;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;

public class MyFrame2 extends JFrame{
	
	//Container contentPane;//设计一个成员变量
	private MyFrame2 frame;
	public MyFrame2()
	{
		super("更改背景");
		//contentPane=this.getContentPane();//将当前窗体赋给该成员变量
		frame=this;
		setLayout(new FlowLayout());
		JButton btn=new JButton("更改背景");
		//注册且实现，按钮注册监听使用匿名类
		btn.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						Color c=new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
						//contentPane.setBackground(c);//用成员变量的getContentPane方法实现背景的改变
						frame.getContentPane().setBackground(c);
					}
				}
				);
		
		add(btn);
		setSize(300,300);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyFrame2();

	}

}
