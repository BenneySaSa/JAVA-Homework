package ʵ��һ;

import javax.swing.*;


public class work4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str2=JOptionPane.showInputDialog("������ת���Ľ���(2��8��16)��");
		String str=JOptionPane.showInputDialog("��������Ҫת����ʮ��������");
		
		int num=(int)Double.parseDouble(str);
		int x=(int)Double.parseDouble(str2);
		
		System.out.println("������Ҫת����ʮ��������"+num);	
		System.out.print("ת����"+x+"�����ǣ�"+intTOHex(x,num));	
	}
    private static String intTOHex(int x,int num)
    {
    	StringBuffer str = new StringBuffer();//��ʼ��һ���յ��ַ���
        String a;
        char []b = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        while(num != 0){
            str = str.append(b[num%x]);//����char������±��齨�ַ���
            num = num/x;//ȡ��           
        }
        a = str.reverse().toString();//reverse��ת�÷�
        return a;
    }
}
