import java.util.*;

public class Homework2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Student[] person=new Student[8];//以student为类型的数组
		
		for(int i=0;i<8;++i)
		{
			person[i]=new Student();
		}
		
		person[0]=new Student("小亮",17,172740211);
		person[3]=new Student("小美",16,172740985);
		person[7]=new Student("小强",10,172740222);
		
		System.out.println("原学生所有的信息为：");
		for(int i=0;i<8;++i)
		{
			System.out.print(person[i].toString());
		}
		
		System.out.println();
		System.out.println("将所有学生年龄加一后的信息为：");
		for(int i=0;i<8;++i)
		{
			person[i].grow();
			System.out.print(person[i].toString());
		}
		
		System.out.println();
		System.out.println("年龄大于20岁的学生名单为：");
		for(int i=0;i<8;++i)
		{

			if(person[i].sage>20)
			{
			 System.out.print(person[i].toString());
			}
		}
		System.out.println();
		System.out.println("===Age排序===");
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
		sname="张三";
		sage=20;
		scode=1727405113;
	}
	public Student(String s1,int n,int m)
	{
		this.sname=s1;
		this.sage=n;
		this.scode=m;
	}
	//排序
	public int compareTo(Student other)
	{
		return this.sage-other.sage;
	}
	public String toString()
	{
		return"学号："+scode+"  "+"姓名："+sname+"  "+"年龄："+sage+"\n";
	}
}
