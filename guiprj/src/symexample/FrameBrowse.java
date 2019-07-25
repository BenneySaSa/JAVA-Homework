package symexample;

import javax.swing.*;
import java.awt.*;
import java.awt.List;
import java.awt.event.*;
import java.util.ArrayList; 
import java.util.*;
import java.lang.System;
import java.io.*;
import javax.swing.*;

public class FrameBrowse extends JFrame implements ActionListener{

	private FrameBrowse frame;
	private JLabel numLabel;
	private JLabel nameLabel;
	private JLabel sexLabel;
	private JLabel cityLabel;
	private JLabel hobbyLabel;
	
	HashMap<String, String[]>studentMap=new HashMap<String, String[]>();
	ListIterator<Map.Entry<String, String[]>> entryIterator;
	ArrayList<Map.Entry<String, String[]>>arrayList=new ArrayList<Map.Entry<String,String[]>>();
	
	public FrameBrowse()
	{
		super("FrameBrowse");//继承父类JFrame
		frame=this;
		this.setSize(600,500);
    	this.setResizable(false);
    	//窗口设置在屏幕中央
    	this.setLocationRelativeTo(null);
    	//初始化流布局管理器
    			final BorderLayout borderLayout=new BorderLayout();
    			borderLayout.setHgap(10);
    			borderLayout.setVgap(10);
    			//设置
    			Container panel=frame.getContentPane();
    			//主布局borderLayout
    			panel.setLayout(borderLayout);
    			
    			//加入面板
    			final JPanel panel2=new JPanel();//创建查询面板
    			GridLayout gridLayout=new GridLayout(0,2);
    			gridLayout.setVgap(3);
    			gridLayout.setHgap(3);
    			panel2.setLayout(gridLayout);//采用网格布局
    			panel.add(panel2,BorderLayout.CENTER);//放在窗体中央
    			
    			//学号标签+内容
    			JLabel labelsnum=new JLabel("学号：",JLabel.CENTER);
    			panel2.add(labelsnum);
    			numLabel=new JLabel();
    			panel2.add(numLabel);

    			//姓名标签+内容标签
    			JLabel labelname=new JLabel("姓名：",JLabel.CENTER);
    			panel2.add(labelname);
    			nameLabel=new JLabel();
    			panel2.add(nameLabel);
    			
    			//性别标签
    			JLabel labelsex=new JLabel("性别：",JLabel.CENTER);
    			panel2.add(labelsex);
    			sexLabel=new JLabel();
    			panel2.add(sexLabel);
    			
    			//所在城市标签+文本框
    			JLabel labelcity=new JLabel("所在城市：",JLabel.CENTER);
    			panel2.add(labelcity);
    			cityLabel=new JLabel();
    			panel2.add(cityLabel);
    			
    			//兴趣爱好+文本框
    			JLabel labelins=new JLabel("兴趣爱好：",JLabel.CENTER);
    			panel2.add(labelins);
    			hobbyLabel=new JLabel();
    			panel2.add(hobbyLabel);
    			
    			//读取文件
    			try {
    				readfile();
    			} catch (IOException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    				System.out.println("读取文件失败");
    			}
    			
    			Iterator<Map.Entry<String, String[]>> iterator = studentMap.entrySet().iterator();
    		
    			while(iterator.hasNext()) {
    				arrayList.add(iterator.next());
    			}
    			entryIterator=arrayList.listIterator();
    			
    			//初始化界面信息，默认第一个学生信息
    			fillBlank(entryIterator.next());
    					
    			//另一个面板存放next和previous按钮
    			final JPanel panel3=new JPanel();
    			FlowLayout flowLayout=new FlowLayout();//使用流布局
    			flowLayout.setHgap(30);
    			panel3.setLayout(flowLayout);
    			final JButton nextButton=new JButton("next");
    			nextButton.addActionListener(this);
    			
    			/*匿名类
    			nextButton.addActionListener(new ActionListener()
    					{
    						@Override
    						public void actionPerformed(ActionEvent arg0) 
    						{
    							// TODO Auto-generated method stub
    							if(entryIterator.hasNext()) 
    							{
    								//entryIterator=;
    								fillBlank(entryIterator.next());
    								if(!entryIterator.hasNext())
    								{
    									//entryIterator.previous();
    								}
    							}
    						}
    				
    					}
    				);
    				*/
    			panel3.add(nextButton);
    			
    			final JButton preButton=new JButton("previous");
    			preButton.addActionListener(this);
  
//    			preButton.addActionListener(new ActionListener()
//    					{
//    						@Override
//    						public void actionPerformed(ActionEvent arg0) 
//    						{
//    							// TODO Auto-generated method stub
//    							if(entryIterator.hasPrevious()) 
//    							{
//    								fillBlank(entryIterator.previous());
//    								if(!entryIterator.hasPrevious()) 
//    								{
//    									//entryIterator.next();
//    								}
//    							}			
//    						}
//    				
//    					}
//    				);
    			panel3.add(preButton);
    			//将面板3加入到主面板中
    			panel.add(panel3,BorderLayout.SOUTH);
	}
	
	
	public void readfile() throws IOException
	{
		try {
			FileReader fr=new FileReader("student.txt");
			BufferedReader bfr=new BufferedReader(fr);
			String str=null;
			//一行一行地读
			while((str=bfr.readLine())!=null)
			{
				String[] res=str.split(" ");
				String num=res[0];
				int newLength=res.length-1;//新的长度
				String[] newres=new String[newLength];//新数组            
				System.arraycopy(res, 1, newres, 0, newLength);//将剩余的放在一起
				studentMap.put(num, newres);
			}
			bfr.close();
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("找不到指定文件");
		}
	}
	
	//填入空白
	private void fillBlank(Map.Entry<String, String[]>entry) 
	{
		numLabel.setText(entry.getKey());
		nameLabel.setText(entry.getValue()[0]);
		sexLabel.setText(entry.getValue()[1]);
		cityLabel.setText(entry.getValue()[2]);
		//设置爱好
		String str="";
		for(int i=3;i<entry.getValue().length;i++) {
			str+=entry.getValue()[i]+" ";
		}
		hobbyLabel.setText(str);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String buttonName=e.getActionCommand();
		if(buttonName.equals("next"))
		{
			if(entryIterator.hasNext()) 
			{
				fillBlank(entryIterator.next());
				if(!entryIterator.hasNext())
				{
					//entryIterator.previous();
					JOptionPane.showMessageDialog(this, "已经是最后一个了");
				}
			}
		}
	
	  if(buttonName.equals("previous"))
	  {
		  if(entryIterator.hasPrevious()) 
				{
					fillBlank(entryIterator.previous());
					if(!entryIterator.hasPrevious()) 
					{
						//entryIterator.next();
						JOptionPane.showMessageDialog(this, "已经是第一个了");
					}
				}			
	  }
	}

}
