import javax.swing.*;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;

public class MyFrame2 extends JFrame{
	
	//Container contentPane;//���һ����Ա����
	private MyFrame2 frame;
	public MyFrame2()
	{
		super("���ı���");
		//contentPane=this.getContentPane();//����ǰ���帳���ó�Ա����
		frame=this;
		setLayout(new FlowLayout());
		JButton btn=new JButton("���ı���");
		//ע����ʵ�֣���ťע�����ʹ��������
		btn.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						Color c=new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
						//contentPane.setBackground(c);//�ó�Ա������getContentPane����ʵ�ֱ����ĸı�
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
