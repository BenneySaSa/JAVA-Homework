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
		super("FrameBrowse");//�̳и���JFrame
		frame=this;
		this.setSize(600,500);
    	this.setResizable(false);
    	//������������Ļ����
    	this.setLocationRelativeTo(null);
    	//��ʼ�������ֹ�����
    			final BorderLayout borderLayout=new BorderLayout();
    			borderLayout.setHgap(10);
    			borderLayout.setVgap(10);
    			//����
    			Container panel=frame.getContentPane();
    			//������borderLayout
    			panel.setLayout(borderLayout);
    			
    			//�������
    			final JPanel panel2=new JPanel();//������ѯ���
    			GridLayout gridLayout=new GridLayout(0,2);
    			gridLayout.setVgap(3);
    			gridLayout.setHgap(3);
    			panel2.setLayout(gridLayout);//�������񲼾�
    			panel.add(panel2,BorderLayout.CENTER);//���ڴ�������
    			
    			//ѧ�ű�ǩ+����
    			JLabel labelsnum=new JLabel("ѧ�ţ�",JLabel.CENTER);
    			panel2.add(labelsnum);
    			numLabel=new JLabel();
    			panel2.add(numLabel);

    			//������ǩ+���ݱ�ǩ
    			JLabel labelname=new JLabel("������",JLabel.CENTER);
    			panel2.add(labelname);
    			nameLabel=new JLabel();
    			panel2.add(nameLabel);
    			
    			//�Ա��ǩ
    			JLabel labelsex=new JLabel("�Ա�",JLabel.CENTER);
    			panel2.add(labelsex);
    			sexLabel=new JLabel();
    			panel2.add(sexLabel);
    			
    			//���ڳ��б�ǩ+�ı���
    			JLabel labelcity=new JLabel("���ڳ��У�",JLabel.CENTER);
    			panel2.add(labelcity);
    			cityLabel=new JLabel();
    			panel2.add(cityLabel);
    			
    			//��Ȥ����+�ı���
    			JLabel labelins=new JLabel("��Ȥ���ã�",JLabel.CENTER);
    			panel2.add(labelins);
    			hobbyLabel=new JLabel();
    			panel2.add(hobbyLabel);
    			
    			//��ȡ�ļ�
    			try {
    				readfile();
    			} catch (IOException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    				System.out.println("��ȡ�ļ�ʧ��");
    			}
    			
    			Iterator<Map.Entry<String, String[]>> iterator = studentMap.entrySet().iterator();
    		
    			while(iterator.hasNext()) {
    				arrayList.add(iterator.next());
    			}
    			entryIterator=arrayList.listIterator();
    			
    			//��ʼ��������Ϣ��Ĭ�ϵ�һ��ѧ����Ϣ
    			fillBlank(entryIterator.next());
    					
    			//��һ�������next��previous��ť
    			final JPanel panel3=new JPanel();
    			FlowLayout flowLayout=new FlowLayout();//ʹ��������
    			flowLayout.setHgap(30);
    			panel3.setLayout(flowLayout);
    			final JButton nextButton=new JButton("next");
    			nextButton.addActionListener(this);
    			
    			/*������
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
    			//�����3���뵽�������
    			panel.add(panel3,BorderLayout.SOUTH);
	}
	
	
	public void readfile() throws IOException
	{
		try {
			FileReader fr=new FileReader("student.txt");
			BufferedReader bfr=new BufferedReader(fr);
			String str=null;
			//һ��һ�еض�
			while((str=bfr.readLine())!=null)
			{
				String[] res=str.split(" ");
				String num=res[0];
				int newLength=res.length-1;//�µĳ���
				String[] newres=new String[newLength];//������            
				System.arraycopy(res, 1, newres, 0, newLength);//��ʣ��ķ���һ��
				studentMap.put(num, newres);
			}
			bfr.close();
			fr.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("�Ҳ���ָ���ļ�");
		}
	}
	
	//����հ�
	private void fillBlank(Map.Entry<String, String[]>entry) 
	{
		numLabel.setText(entry.getKey());
		nameLabel.setText(entry.getValue()[0]);
		sexLabel.setText(entry.getValue()[1]);
		cityLabel.setText(entry.getValue()[2]);
		//���ð���
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
					JOptionPane.showMessageDialog(this, "�Ѿ������һ����");
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
						JOptionPane.showMessageDialog(this, "�Ѿ��ǵ�һ����");
					}
				}			
	  }
	}

}
