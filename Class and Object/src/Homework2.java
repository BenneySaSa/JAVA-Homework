import java.util.*;

public class Homework2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Student[] person=new Student[8];//��studentΪ���͵�����
		
		for(int i=0;i<8;++i)
		{
			person[i]=new Student();
		}
		
		person[0]=new Student("С��",17,172740211);
		person[3]=new Student("С��",16,172740985);
		person[7]=new Student("Сǿ",10,172740222);
		
		System.out.println("ԭѧ�����е���ϢΪ��");
		for(int i=0;i<8;++i)
		{
			System.out.print(person[i].toString());
		}
		
		System.out.println();
		System.out.println("������ѧ�������һ�����ϢΪ��");
		for(int i=0;i<8;++i)
		{
			person[i].grow();
			System.out.print(person[i].toString());
		}
		
		System.out.println();
		System.out.println("�������20���ѧ������Ϊ��");
		for(int i=0;i<8;++i)
		{

			if(person[i].sage>20)
			{
			 System.out.print(person[i].toString());
			}
		}
		System.out.println();
		System.out.println("===Age����===");
		List<Student> res=Arrays.asList(person);
		Collections.sort(res);
		System.out.println(res.toString());
		
	}
}

class Student implements Comparable<Student>
{
	String sname;
	int scode;
	int sage;
	public void grow()
	{
		this.sage=sage+1;
	}
	public Student()
	{
		sname="����";
		sage=20;
		scode=1727405113;
	}
	public Student(String s1,int n,int m)
	{
		this.sname=s1;
		this.sage=n;
		this.scode=m;
	}
	//����
	public int compareTo(Student other)
	{
		return this.sage-other.sage;
	}
	public String toString()
	{
		return"ѧ�ţ�"+scode+"  "+"������"+sname+"  "+"���䣺"+sage+"\n";
	}
}
