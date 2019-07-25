package 实验一;

import javax.swing.*;


public class work4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str2=JOptionPane.showInputDialog("请输入转换的进制(2、8、16)：");
		String str=JOptionPane.showInputDialog("请输入需要转换的十进制数：");
		
		int num=(int)Double.parseDouble(str);
		int x=(int)Double.parseDouble(str2);
		
		System.out.println("输入需要转换的十进制数是"+num);	
		System.out.print("转换成"+x+"进制是："+intTOHex(x,num));	
	}
    private static String intTOHex(int x,int num)
    {
    	StringBuffer str = new StringBuffer();//初始化一个空的字符串
        String a;
        char []b = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        while(num != 0){
            str = str.append(b[num%x]);//利用char数组的下标组建字符串
            num = num/x;//取商           
        }
        a = str.reverse().toString();//reverse反转用法
        return a;
    }
}
