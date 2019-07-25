import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class calculate extends JFrame{
    private calculate frame;//˽�г�Ա����
    public calculate()
    {
    	super("���׼�����");
    	frame=this;
    	//x,y,����
    	this.setSize(400,300);
    	this.setResizable(false);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	//������������Ļ����
    	this.setLocationRelativeTo(null);
    }
    public void design()
    {
    	final FlowLayout flowlayout=new FlowLayout();
    	flowlayout.setHgap(5);
    	flowlayout.setVgap(5);
    	Container panel=frame.getContentPane();//�õ�����
    	panel.setLayout(flowlayout);
    	
    	int length=8;//�ı��򳤶�
    	final JTextField num1=new JTextField(length);
    	panel.add(num1);
    	
    	final JTextField num2=new JTextField(length);
    	panel.add(num2);
    	
    	final JButton plus=new JButton("+");
    	final JLabel label=new JLabel();
    	plus.addActionListener
		(        //������
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						//������
						if(num1.getText().equals("")||num2.getText().equals(""))
						{
							JOptionPane.showMessageDialog(null, "�ı��򲻿�Ϊ�գ�","��ʾ��Ϣ", JOptionPane.ERROR_MESSAGE);
						}
						else if(!isNumeric(num1.getText())||!isNumeric(num2.getText()))
						{
							JOptionPane.showMessageDialog(null, "����������!","��ʾ��Ϣ", JOptionPane.ERROR_MESSAGE);
						}
						int res=Integer.parseInt(num1.getText())+Integer.parseInt(num2.getText());
				    	label.setText(String.valueOf(res));
					}
				}
	   );
    	panel.add(plus);
    	
    	final JButton multiply=new JButton("*");
    	multiply.addActionListener
		(        //������
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						if(num1.getText().equals("")||num2.getText().equals(""))
						{
							JOptionPane.showMessageDialog(null, "�ı��򲻿�Ϊ�գ�","��ʾ��Ϣ", JOptionPane.ERROR_MESSAGE);
						}
						else if(!isNumeric(num1.getText())||!isNumeric(num2.getText()))
						{
							JOptionPane.showMessageDialog(null, "����������!","��ʾ��Ϣ", JOptionPane.ERROR_MESSAGE);
						}
						int res=Integer.parseInt(num1.getText())*Integer.parseInt(num2.getText());
						label.setText(String.valueOf(res));
					}
				}
	   );
    	panel.add(multiply);
    	final JLabel res=new JLabel("=");
    	panel.add(res);
    	panel.add(label);

    }
    
    //�Ƿ�Ϊ����
    public boolean isNumeric(String str) {
		for(int i=str.length();--i>=0;) {
			if(!Character.isDigit(str.charAt(i))){
				return false;
			}
		}
		return true;
	}
    //main
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		calculate frame1=new calculate();
		frame1.design();
		frame1.setVisible(true);

	}

}
