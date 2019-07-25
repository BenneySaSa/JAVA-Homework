package 实验一;


import java.util.Scanner;

public class work2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sn=new Scanner(System.in);
		int flag=0;//控制循环
		double sum=0;//总分数
		int num_people=0;//学生的人数
		int A_num=0;
		int B_num=0;
		int C_num=0;
		int D_num=0;
		int E_num=0;
		while(flag!=1)
		{
			System.out.println("请输入学生的成绩：");
			double grade=sn.nextDouble();
			if(grade==(double)-1)
				flag=1;
			else
			{
				if(grade<(double)60)
				{
					E_num++;
					num_people++;
				    System.out.println("该学生的成绩是不及格");
				}
				else if(grade>=(double)60&&grade<(double)70)
				{
					D_num++;
					num_people++;
					System.out.println("该学生的成绩是及格");
				}
				else if(grade>=(double)70&&grade<(double)80)
				{
					C_num++;
					num_people++;
					System.out.println("该学生的成绩是中等");
				}
				else if(grade>=(double)80&&grade<(double)90)
				{
					B_num++;
					num_people++;
					System.out.println("该学生的成绩是良好");
				}
				else if(grade>=(double)90&&grade<=(double)1000)
				{
					A_num++;
					num_people++;
					System.out.println("该学生的成绩是优秀");
				}
				else//异常处理
				{
				 grade=(double)0;
				 System.out.println("输入异常！请重新输入！");
				}
				sum+=grade;
			}
		}
		sn.close();
		System.out.print("学生的成绩是优秀的人数：");
		System.out.println(A_num);
		System.out.print("学生的成绩是良好的人数：");
		System.out.println(B_num);
		System.out.print("学生的成绩是中等的人数：");
		System.out.println(C_num);
		System.out.print("学生的成绩是及格的人数：");
		System.out.println(D_num);
		System.out.print("学生的成绩是不及格的人数：");
		System.out.println(E_num);
		System.out.print("平均分：");
		System.out.println(sum*1.0/num_people);
	}
}

