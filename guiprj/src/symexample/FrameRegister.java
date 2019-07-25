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
	
	//私有成员变量
	private FrameRegister frame;
	
	public FrameRegister()
	{
		super("FrameRegister");
    	frame=this;
    	//x,y,宽，高
    	this.setSize(600,500);
    	this.setResizable(false);
    	//窗口设置在屏幕中央
    	this.setLocationRelativeTo(null);
	}
	public void design()
	{
		final GridLayout gridLayout=new GridLayout(6,2);
		gridLayout.setHgap(2);
		gridLayout.setVgap(2);
		Container panel=frame.getContentPane();
		panel.setLayout(gridLayout);
		
		//设置学号
		final JLabel label=new JLabel("学号：",JLabel.CENTER);
		panel.add(label);
		//文本框输入学号
		JTextField numfield=new JTextField();
		panel.add(numfield);
		
		//设置姓名
		final JLabel label2=new JLabel("姓名：",JLabel.CENTER);
		panel.add(label2);
		//文本框输入姓名
		JTextField namefield=new JTextField();
		panel.add(namefield);
		
		//设置性别 单选框
		
		final JLabel label3=new JLabel("性别：",JLabel.CENTER);
		panel.add(label3);
        ButtonGroup buttongroup=new ButtonGroup();
        //再加一层面板（默认流布局）
        final JPanel sexpanel=new JPanel();
        //性别男
        final JRadioButton manRadioButton=new JRadioButton();
        buttongroup.add(manRadioButton);
        manRadioButton.setSelected(true);
        manRadioButton.setText("男");
        manRadioButton.setBounds(32,6,46,23);
        //加入到JPanel中
        sexpanel.add(manRadioButton);
        //性别女（同理）
        final JRadioButton womanRadioButton=new JRadioButton();
        buttongroup.add(womanRadioButton);
        womanRadioButton.setText("女");
        womanRadioButton.setBounds(122,6,46,23);
        sexpanel.add(womanRadioButton);
        
        panel.add(sexpanel);
        
        
        //设置城市 下拉列表
        final JLabel label4=new JLabel("城市：",JLabel.CENTER);
		panel.add(label4);
		//下拉列表
		String[]cities= {"扬州","南京","苏州","上海","北京"};
		JComboBox comboBox=new JComboBox(cities);
		comboBox.setEditable(true);//可后续修改编辑
		comboBox.setMaximumRowCount(4);//设置弹出时显示选项的最多行数
		comboBox.setBounds(62,7,104,21);
		panel.add(comboBox);
		
        final JLabel label5=new JLabel("爱好：",JLabel.CENTER);
		panel.add(label5);
		//加上一层布局
		final JPanel hobbiesPanel=new JPanel();
		//复选框
		//游泳
		final JCheckBox swiming=new JCheckBox("游泳");
		swiming.setBounds(62, 6, 55, 23);
		hobbiesPanel.add(swiming);
		//写作
		final JCheckBox writing=new JCheckBox("写作");
		writing.setBounds(123, 6, 68, 23);
		hobbiesPanel.add(writing);
		//阅读
		final JCheckBox reading=new JCheckBox("阅读");
		reading.setBounds(197, 6, 75, 23);
		hobbiesPanel.add(reading);
		//跳舞
		final JCheckBox dancing=new JCheckBox("跳舞");
		dancing.setBounds(257, 6, 82, 23);
		hobbiesPanel.add(dancing);
		
		panel.add(hobbiesPanel);
		
		
		//设置新增按钮
		final JButton plus=new JButton("新增");
		//放置类型为Student的list
		ArrayList<Student> allstudents=new ArrayList<Student>();
		//注册监听器
		plus.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						// TODO Auto-generated method stub
						String num=numfield.getText();//学号
						String name=namefield.getText();//姓名
						String sex;//性别
						if(manRadioButton.isSelected())
						{
							sex="男";
						}
						else
							sex="女";
						//城市
						String city=(String)comboBox.getSelectedItem();
						//爱好
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
		
		//设置保存按钮
	   final JButton save=new JButton("保存");
	   //设置监听器
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
						//每次写入文件都从文件尾部 开始true
						 fw=new FileWriter(file,true);
						
						//如果没有名为student的txt文件
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
								fw.write(temp.getNum()+" ");//写入学号
								fw.write(temp.getName()+" ");//写入姓名
								fw.write(temp.getSex()+" ");
								fw.write(temp.getCity()+" ");
								//得到hobby的arraylist
								ArrayList<String> hobby=
										(ArrayList<String>) temp.getHobby().clone();
								for(int j=0;j<hobby.size();++j)
								{
									fw.write(hobby.get(j)+" ");//写入兴趣爱好
								}
								fw.write("\r\n");//换行
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
	   allstudents.clear();//清出allstudents的列表
	   panel.add(save);
	   
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
