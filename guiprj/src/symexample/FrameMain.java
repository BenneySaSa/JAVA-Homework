package symexample;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*; 

public class FrameMain extends JFrame{
	
	private FrameMain frame;//˽�г�Ա����frame
	public FrameMain()
    {
    	super("�˵�");
    	frame=this;
    	//x,y,����
    	this.setSize(700,600);
    	this.setResizable(false);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	//������������Ļ����
    	this.setLocationRelativeTo(null);
    }
	public void design()
	{
		JMenuBar menuBar = new JMenuBar();// �����˵�������
		frame.setJMenuBar(menuBar);// ���˵���������ӵ�����Ĳ˵�����
		//�½��˵���
		JMenu menu=new JMenu("�˵���");
		menuBar.add(menu);
		//�½��˵����Ĳ˵�
		JMenuItem logMenuItem=new JMenuItem("ע��");
		menu.add(logMenuItem);
		
		JMenuItem queryMenuItem=new JMenuItem("��ѯ");
		menu.add(queryMenuItem);
		
		JMenuItem exitMenuItem = new JMenuItem("�˳�");
		menu.add(exitMenuItem);
		
		//������Ӧ�ļ�����
		
		//ע��˵�������
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
		
		//��ѯ�˵�������
		queryMenuItem.addActionListener(new ActionListener()
		{
		     public void actionPerformed(ActionEvent e)
		    {
		    	 FrameBrowse queryframe=new FrameBrowse();
		    	 queryframe.setVisible(true);
		    }
		}
			);
		
		//�˳��˵�������
		exitMenuItem.addActionListener(new ActionListener()
		{
		     public void actionPerformed(ActionEvent e)
		    {
		    	 int r=JOptionPane.showConfirmDialog(FrameMain.this, "�Ƿ���Ҫ�˳���","confirmDialog",JOptionPane.YES_NO_OPTION);
		    	 //���ȷ�����˳�����ϵͳ
		    	 if(r==JOptionPane.YES_OPTION)
		    	 {
		    		 System.exit(0);
		    	 }
		    	 //�����
		    	 if(r==JOptionPane.NO_OPTION)
		    	 {
		    		 //���˳�
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
