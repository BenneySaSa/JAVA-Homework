import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class LogIn extends JFrame{
	private LogIn frame;
	public LogIn(String s)
	{
		super(s);
		frame=this;
		//x,y������
		setBounds(500,500,500,320);
		//���ô���رն���Ϊ�˳�
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void design()
	{
		final GridLayout gridLayout=new GridLayout(3,2);
		gridLayout.setHgap(2);
		gridLayout.setVgap(2);
		Container panel=frame.getContentPane();
		panel.setLayout(gridLayout);
		
		final JLabel label=new JLabel("�û�����");
		panel.add(label);
		JTextField namefield=new JTextField();
		panel.add(namefield);
		
		final JLabel label2=new JLabel("���룺");
		panel.add(label2);
		JPasswordField secretfield=new JPasswordField();
		panel.add(secretfield);
		
		//��������OKbutton�ļ�����
		final JButton button1=new JButton("OK");
		button1.addActionListener
		(        //������
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						if(namefield.getText().equals("admin")&&secretfield.getText().equals("12345"))
						{
							JOptionPane.showMessageDialog( null , "welcome" ,"welcome" , JOptionPane.PLAIN_MESSAGE) ;
							String name2="welcome admin";
							LogIn frame2=new LogIn(name2);
							frame2.setVisible(true);
						}
						else
						{
							JOptionPane.showMessageDialog(null, "�û���Ϣ����ȷ�����������룡","��ʾ��Ϣ", JOptionPane.ERROR_MESSAGE);
						}
					
				  }
			  }
		);
		panel.add(button1);
		//�رմ���
		final JButton button2=new JButton("Close");
		button2.addActionListener
		(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						System.exit(0);
					}
				}
		);
		panel.add(button2);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name="��ӭ��½��";
		LogIn frame1=new LogIn(name);
		frame1.design();
		frame1.setVisible(true);
	}

}
