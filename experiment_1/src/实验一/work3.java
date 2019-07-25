package 实验一;

public class work3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int num=0;//计数
		for(int i=10;i<=100;++i)
		{
			if(i%3==0||i%5==0)
			{
				++num;
				System.out.print(i);
				System.out.print(' ');
				if(num%5==0)//每行输出5个数
		        	System.out.println();
			}
        }
	}
}

