import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//实现Actonlistener接口
public class test extends Frame implements ActionListener{
	public test()
	{
		super("更改背景");
		setLayout(new FlowLayout());
		Button btn=new Button("更改背景");
		add(btn);
		//注册监听器     事件源.add...listener（监视器）
		btn.addActionListener(this);//按钮是事件源（btn），类test负责创建监视器且必须实现。。listener的接口
		
		setSize(300,300);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		Color c=new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
		setBackground(c);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new test();
	}

}
