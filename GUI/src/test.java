import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//ʵ��Actonlistener�ӿ�
public class test extends Frame implements ActionListener{
	public test()
	{
		super("���ı���");
		setLayout(new FlowLayout());
		Button btn=new Button("���ı���");
		add(btn);
		//ע�������     �¼�Դ.add...listener����������
		btn.addActionListener(this);//��ť���¼�Դ��btn������test���𴴽��������ұ���ʵ�֡���listener�Ľӿ�
		
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
