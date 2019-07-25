package 实验一;

import java.util.Scanner;
public class work5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("请输入正整数n的值：");
		Scanner sn=new Scanner(System.in);
		int n=sn.nextInt();//读入数据n
		
		for(double x=0.2;x<=1.0;x+=0.2)
		{
			double sum=0;
			for(int i=1;i<=n;++i)
			{
				sum+=(double)Math.pow(x, (double)i)*1.0/multiply(i);
			}
			sum+=1;
			System.out.print("当x="+x+"时，ex的值：");
			System.out.println(String.format("%.6f", sum));
		}
	}
	private static int multiply(int num)//阶乘
	{
		int res=1;
		for(int i=1;i<=num;++i)
		{
			res*=i;
		}
		return res;
	}

}

