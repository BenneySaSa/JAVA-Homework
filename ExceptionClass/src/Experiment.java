import javax.swing.*;

import java.text.SimpleDateFormat;
import  java.util.*;

public class Experiment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			 System.out.println("��������������յĸ�ʽ���£���yyyy/mm/dd����ʽ���ַ�����y��ʾ�꣬m��ʾ�£�d��ʾ�գ�");
			 String s=JOptionPane.showInputDialog("�밴�����Ϲ������������գ�");
			 String[] split1=s.split("/");
			 //����
			 if(split1[0].length()==4 &&split1[1].length()==2 &&split1[2].length()==2)
			 {
				 //�����Ƿ�����
				 int year=Integer.parseInt(split1[0]);
				 int month=Integer.parseInt(split1[1]);
				 int day=Integer.parseInt(split1[2]);
				 if(year>=1900 && month>=1&&month<=12&&day>=1&&day<=31)
				 {
                  Date date = new Date(year-1900,month-1,day);
                  System.out.println(date);
                  String dateStr = new SimpleDateFormat("yyyy-MM-dd").format(date);
                  System.out.println(dateStr); 
				 }
			 }
		}
		catch(NumberFormatException e)
		{
			System.out.println("�����쳣���������ݷǷ���");
		}
		finally
		{
			 System.out.println("finally part");
		}

	}

}
