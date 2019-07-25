package experiment_5;
import java.util.*;

//接口
interface Sortable
{
	int Compare(Sortable s);
}


class Student implements Sortable{
	private int score;
	Student(int num)
	{
		score=num;
	}
	public int Compare(Sortable s)
	{  
		Student temp=null;
		if(s instanceof Student)
		{
			 temp =(Student)s;
		}
		else
		{
			System.out.println("出现错误，请重新赋值！");
		}
		if(this.score>temp.score)return 1;
		else
		{
			if(this.score==temp.score)return 0;
			else
				return -1;
		}
	}
	public String toString()
	{
		return "成绩:"+score;
	}
}
class Rectangle implements Sortable{
	private int length;
	private int width;
	//构造函数
	Rectangle(int num1,int num2)
	{
		length=num1;
		width=num2;
	}
	//求面积
	public int area()
	{
		return length*width;
	}
	public int Compare(Sortable s)
	{
		Rectangle temp=null;
		if(s instanceof Rectangle)
			temp=(Rectangle)s;
		else
		{
			System.out.println("出现错误，请重新赋值！");
		}
		if(this.area()>temp.area())return 1;
		else
		{
			if(this.area()==temp.area())return 0;
			else
				return -1;
		}
	}
	public String toString()
	{
		return "面积:"+area();
	}
}

class Sort
{
	public static void SelectSort(Sortable [] a)
	{
		Sortable temp=null;
		for(int i=0;i<a.length;i++)
		{
			for(int j=i+1;j<a.length;j++)
				if(a[i].Compare(a[j])>0) 
				{
                  temp=a[i];
                  a[i]=a[j];
                  a[j]=temp;
				}
		}
	}
}
public class TestSort {
	
	TestSort(){
		Student[] s=new Student[5];
		for(int i=0;i<s.length;i++){
			s[i]=new Student((int)(Math.random()*100));
		}
		Sort.SelectSort(s);
		System.out.println("下面是按升序输出学生成绩");
		for(int i=0;i<s.length;i++){
			System.out.println(s[i]);
		}
		
		Rectangle[] ss=new Rectangle[5];
		for(int i=0;i<ss.length;i++){
			ss[i]=new Rectangle((int)(Math.random()*100),(int)(Math.random()*100));
		}
		Sort.SelectSort(ss);
		System.out.println("下面是按升序输出矩形面积");
		for(int i=0;i<ss.length;i++){
			System.out.println(ss[i]);
		}
	 }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TestSort();
	}

}
