package symexample;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 

public class FrameMain extends JFrame{
	
	private FrameMain frame;//私有成员变量frame
	public FrameMain()
    {
    	super("菜单");
    	frame=this;
    	//x,y,宽，高
    	this.setSize(700,600);
    	this.setResizable(false);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	//窗口设置在屏幕中央
    	this.setLocationRelativeTo(null);
    }
	public void design()
	{
		JMenuBar menuBar = new JMenuBar();// 创建菜单栏对象
		frame.setJMenuBar(menuBar);// 将菜单栏对象添加到窗体的菜单栏中
		//新建菜单栏
		JMenu menu=new JMenu("菜单栏");
		menuBar.add(menu);
		//新建菜单栏的菜单
		JMenuItem logMenuItem=new JMenuItem("注册");
		menu.add(logMenuItem);
		
		JMenuItem queryMenuItem=new JMenuItem("查询");
		menu.add(queryMenuItem);
		
		JMenuItem exitMenuItem = new JMenuItem("退出");
		menu.add(exitMenuItem);
		
		//设置相应的监听器
		
		//注册菜单监听器
		logMenuItem.addActionListener(new ActionListener()
			{
			     public void actionPerformed(ActionEvent e)
			    {
			    	 FrameRegister logframe=new FrameRegister();
			    	 logframe.design();
			    	 logframe.setVisible(true);
			    }
			}
				);
		
		//查询菜单监听器
		queryMenuItem.addActionListener(new ActionListener()
		{
		     public void actionPerformed(ActionEvent e)
		    {
		    	 FrameBrowse queryframe=new FrameBrowse();
		    	 queryframe.setVisible(true);
		    }
		}
			);
		
		//退出菜单监听器
		exitMenuItem.addActionListener(new ActionListener()
		{
		     public void actionPerformed(ActionEvent e)
		    {
		    	 int r=JOptionPane.showConfirmDialog(FrameMain.this, "是否真要退出？","confirmDialog",JOptionPane.YES_NO_OPTION);
		    	 //点击确定，退出整个系统
		    	 if(r==JOptionPane.YES_OPTION)
		    	 {
		    		 System.exit(0);
		    	 }
		    	 //点击否
		    	 if(r==JOptionPane.NO_OPTION)
		    	 {
		    		 //不退出
		    	 }
		    }
		}
			);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		FrameMain frame1=new FrameMain();
		frame1.design();
		frame1.setVisible(true);

	}

}
