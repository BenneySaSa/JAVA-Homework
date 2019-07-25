import java.util.*;
public class YanghuiClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sn=new Scanner(System.in);
		System.out.print("请输入你想打印的杨辉三角形的行数：");
		int row=sn.nextInt();//行数确定
		
		System.out.println();

        int[][]triple=new int[row][];
		for(int i=0;i<row;i++)
		{
			triple[i]=new int[i+1];//不等长二维数组，在此处确定每一行的列数
			for(int j=0;j<=i;j++)
			{
				if(j==0||j==i)//每一行第一个数和最后一个数为一
				{
					triple[i][j]=1;
				}
				else if(i>0&&(j>0&&j<i))//其余为上一行邻近的两个数字之和
				{
					triple[i][j]=triple[i-1][j-1]+triple[i-1][j];
				}
			}
		}
		
		
		for(int i=0;i<row;++i)
		{
			for(int k=(row-1-i);k>0;k--)//输空格
			{
				System.out.print(" ");
			}
			for(int j=0;j<=i;++j)//输数字
			{
				System.out.print(triple[i][j]+" ");
			}
			System.out.println();
		}
	}
}

