package ʵ��һ;

import java.util.Scanner;
public class work5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("������������n��ֵ��");
		Scanner sn=new Scanner(System.in);
		int n=sn.nextInt();//��������n
		
		for(double x=0.2;x<=1.0;x+=0.2)
		{
			double sum=0;
			for(int i=1;i<=n;++i)
			{
				sum+=(double)Math.pow(x, (double)i)*1.0/multiply(i);
			}
			sum+=1;
			System.out.print("��x="+x+"ʱ��ex��ֵ��");
			System.out.println(String.format("%.6f", sum));
		}
	}
	private static int multiply(int num)//�׳�
	{
		int res=1;
		for(int i=1;i<=num;++i)
		{
			res*=i;
		}
		return res;
	}

}

