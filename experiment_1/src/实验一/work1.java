package ʵ��һ;

import javax.swing.*;
public class work1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str=JOptionPane.showInputDialog("����������n��ֵ:");
		int n=(int)Double.parseDouble(str);
		int sum=0;
		for(int i=0;i<=n;++i)
		{
			if(i<n)
				System.out.print("2^"+i+'+');
			else
				System.out.print("2^"+i+'=');
			int num=(int)Math.pow(2, i);
			sum+=num;
		}
		System.out.print(sum);
	}
}
