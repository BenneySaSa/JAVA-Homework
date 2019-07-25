import javax.swing.*;

import java.text.SimpleDateFormat;
import  java.util.*;

public class Experiment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			 System.out.println("规则：输入的年月日的格式如下：“yyyy/mm/dd”形式的字符串（y表示年，m表示月，d表示日）");
			 String s=JOptionPane.showInputDialog("请按照以上规则输入年月日：");
			 String[] split1=s.split("/");
			 //长度
			 if(split1[0].length()==4 &&split1[1].length()==2 &&split1[2].length()==2)
			 {
				 //数据是否正常
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
			System.out.println("出现异常：日期数据非法！");
		}
		finally
		{
			 System.out.println("finally part");
		}

	}

}
