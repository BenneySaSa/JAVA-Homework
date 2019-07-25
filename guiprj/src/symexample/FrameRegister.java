package symexample;
import javax.swing.*;
import java.awt.*;
import java.awt.List;
import java.awt.event.*;
import java.util.ArrayList; 
import java.util.*;
import java.lang.System;
import java.io.*;

public class FrameRegister extends JFrame{
	
	//˽�г�Ա����
	private FrameRegister frame;
	
	public FrameRegister()
	{
		super("FrameRegister");
    	frame=this;
    	//x,y,����
    	this.setSize(600,500);
    	this.setResizable(false);
    	//������������Ļ����
    	this.setLocationRelativeTo(null);
	}
	public void design()
	{
		final GridLayout gridLayout=new GridLayout(6,2);
		gridLayout.setHgap(2);
		gridLayout.setVgap(2);
		Container panel=frame.getContentPane();
		panel.setLayout(gridLayout);
		
		//����ѧ��
		final JLabel label=new JLabel("ѧ�ţ�",JLabel.CENTER);
		panel.add(label);
		//�ı�������ѧ��
		JTextField numfield=new JTextField();
		panel.add(numfield);
		
		//��������
		final JLabel label2=new JLabel("������",JLabel.CENTER);
		panel.add(label2);
		//�ı�����������
		JTextField namefield=new JTextField();
		panel.add(namefield);
		
		//�����Ա� ��ѡ��
		
		final JLabel label3=new JLabel("�Ա�",JLabel.CENTER);
		panel.add(label3);
        ButtonGroup buttongroup=new ButtonGroup();
        //�ټ�һ����壨Ĭ�������֣�
        final JPanel sexpanel=new JPanel();
        //�Ա���
        final JRadioButton manRadioButton=new JRadioButton();
        buttongroup.add(manRadioButton);
        manRadioButton.setSelected(true);
        manRadioButton.setText("��");
        manRadioButton.setBounds(32,6,46,23);
        //���뵽JPanel��
        sexpanel.add(manRadioButton);
        //�Ա�Ů��ͬ��
        final JRadioButton womanRadioButton=new JRadioButton();
        buttongroup.add(womanRadioButton);
        womanRadioButton.setText("Ů");
        womanRadioButton.setBounds(122,6,46,23);
        sexpanel.add(womanRadioButton);
        
        panel.add(sexpanel);
        
        
        //���ó��� �����б�
        final JLabel label4=new JLabel("���У�",JLabel.CENTER);
		panel.add(label4);
		//�����б�
		String[]cities= {"����","�Ͼ�","����","�Ϻ�","����"};
		JComboBox comboBox=new JComboBox(cities);
		comboBox.setEditable(true);//�ɺ����޸ı༭
		comboBox.setMaximumRowCount(4);//���õ���ʱ��ʾѡ����������
		comboBox.setBounds(62,7,104,21);
		panel.add(comboBox);
		
        final JLabel label5=new JLabel("���ã�",JLabel.CENTER);
		panel.add(label5);
		//����һ�㲼��
		final JPanel hobbiesPanel=new JPanel();
		//��ѡ��
		//��Ӿ
		final JCheckBox swiming=new JCheckBox("��Ӿ");
		swiming.setBounds(62, 6, 55, 23);
		hobbiesPanel.add(swiming);
		//д��
		final JCheckBox writing=new JCheckBox("д��");
		writing.setBounds(123, 6, 68, 23);
		hobbiesPanel.add(writing);
		//�Ķ�
		final JCheckBox reading=new JCheckBox("�Ķ�");
		reading.setBounds(197, 6, 75, 23);
		hobbiesPanel.add(reading);
		//����
		final JCheckBox dancing=new JCheckBox("����");
		dancing.setBounds(257, 6, 82, 23);
		hobbiesPanel.add(dancing);
		
		panel.add(hobbiesPanel);
		
		
		//����������ť
		final JButton plus=new JButton("����");
		//��������ΪStudent��list
		ArrayList<Student> allstudents=new ArrayList<Student>();
		//ע�������
		plus.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						// TODO Auto-generated method stub
						String num=numfield.getText();//ѧ��
						String name=namefield.getText();//����
						String sex;//�Ա�
						if(manRadioButton.isSelected())
						{
							sex="��";
						}
						else
							sex="Ů";
						//����
						String city=(String)comboBox.getSelectedItem();
						//����
						ArrayList<String> hobbies=new ArrayList<String>();
						if(swiming.isSelected())
							hobbies.add(swiming.getText());
						if(writing.isSelected())
							hobbies.add(writing.getText());
						if(reading.isSelected())
							hobbies.add(reading.getText());
						if(dancing.isSelected())
							hobbies.add(dancing.getText());
						
						Student temp=new Student(num,name,sex,city,hobbies);
						allstudents.add(temp);
						
					}
				}
		);
		panel.add(plus);
		
		//���ñ��水ť
	   final JButton save=new JButton("����");
	   //���ü�����
	   save.addActionListener(new ActionListener()
			 {

				@Override
				public void actionPerformed(ActionEvent arg0)
				{
					// TODO Auto-generated method stub
					FileWriter fw=null;
					try
					{
						File file=new File("D:\\Cindy Java\\guiprj","student.txt");
//					    FileOutputStream fos=new FileOutputStream(file,true);
//					    ObjectOutputStream os=new ObjectOutputStream(fos);
						//ÿ��д���ļ������ļ�β�� ��ʼtrue
						 fw=new FileWriter(file,true);
						
						//���û����Ϊstudent��txt�ļ�
						if(!file.exists())
						{
							 try {
				                    file.createNewFile();
				                } catch (IOException e) {
				                    // TODO Auto-generated catch block
				                    e.printStackTrace();
				                }
						}
						else
						{
							for(int i=0;i<allstudents.size();++i)
							{
								Student temp=allstudents.get(i);
								fw.write(temp.getNum()+" ");//д��ѧ��
								fw.write(temp.getName()+" ");//д������
								fw.write(temp.getSex()+" ");
								fw.write(temp.getCity()+" ");
								//�õ�hobby��arraylist
								ArrayList<String> hobby=
										(ArrayList<String>) temp.getHobby().clone();
								for(int j=0;j<hobby.size();++j)
								{
									fw.write(hobby.get(j)+" ");//д����Ȥ����
								}
								fw.write("\r\n");//����
//								os.write(allstudents.get(i));
							}
						}
						
					}
					catch (Exception e)
					{
						e.printStackTrace();

					}
					finally
					{
						try {
							fw.close();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
		   
			 });
	   allstudents.clear();//���allstudents���б�
	   panel.add(save);
	   
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
