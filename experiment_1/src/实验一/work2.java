package ʵ��һ;


import java.util.Scanner;

public class work2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sn=new Scanner(System.in);
		int flag=0;//����ѭ��
		double sum=0;//�ܷ���
		int num_people=0;//ѧ��������
		int A_num=0;
		int B_num=0;
		int C_num=0;
		int D_num=0;
		int E_num=0;
		while(flag!=1)
		{
			System.out.println("������ѧ���ĳɼ���");
			double grade=sn.nextDouble();
			if(grade==(double)-1)
				flag=1;
			else
			{
				if(grade<(double)60)
				{
					E_num++;
					num_people++;
				    System.out.println("��ѧ���ĳɼ��ǲ�����");
				}
				else if(grade>=(double)60&&grade<(double)70)
				{
					D_num++;
					num_people++;
					System.out.println("��ѧ���ĳɼ��Ǽ���");
				}
				else if(grade>=(double)70&&grade<(double)80)
				{
					C_num++;
					num_people++;
					System.out.println("��ѧ���ĳɼ����е�");
				}
				else if(grade>=(double)80&&grade<(double)90)
				{
					B_num++;
					num_people++;
					System.out.println("��ѧ���ĳɼ�������");
				}
				else if(grade>=(double)90&&grade<=(double)1000)
				{
					A_num++;
					num_people++;
					System.out.println("��ѧ���ĳɼ�������");
				}
				else//�쳣����
				{
				 grade=(double)0;
				 System.out.println("�����쳣�����������룡");
				}
				sum+=grade;
			}
		}
		sn.close();
		System.out.print("ѧ���ĳɼ��������������");
		System.out.println(A_num);
		System.out.print("ѧ���ĳɼ������õ�������");
		System.out.println(B_num);
		System.out.print("ѧ���ĳɼ����еȵ�������");
		System.out.println(C_num);
		System.out.print("ѧ���ĳɼ��Ǽ����������");
		System.out.println(D_num);
		System.out.print("ѧ���ĳɼ��ǲ������������");
		System.out.println(E_num);
		System.out.print("ƽ���֣�");
		System.out.println(sum*1.0/num_people);
	}
}

