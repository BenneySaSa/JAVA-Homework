import java.util.*;
public class YanghuiClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sn=new Scanner(System.in);
		System.out.print("�����������ӡ����������ε�������");
		int row=sn.nextInt();//����ȷ��
		
		System.out.println();

        int[][]triple=new int[row][];
		for(int i=0;i<row;i++)
		{
			triple[i]=new int[i+1];//���ȳ���ά���飬�ڴ˴�ȷ��ÿһ�е�����
			for(int j=0;j<=i;j++)
			{
				if(j==0||j==i)//ÿһ�е�һ���������һ����Ϊһ
				{
					triple[i][j]=1;
				}
				else if(i>0&&(j>0&&j<i))//����Ϊ��һ���ڽ�����������֮��
				{
					triple[i][j]=triple[i-1][j-1]+triple[i-1][j];
				}
			}
		}
		
		
		for(int i=0;i<row;++i)
		{
			for(int k=(row-1-i);k>0;k--)//��ո�
			{
				System.out.print(" ");
			}
			for(int j=0;j<=i;++j)//������
			{
				System.out.print(triple[i][j]+" ");
			}
			System.out.println();
		}
	}
}

