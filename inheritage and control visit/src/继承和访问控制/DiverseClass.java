package 继承和访问控制;
import java.util.*;

public class DiverseClass {
	
	public double getSalary(Object object) {
		if(object instanceof Employee)
			return ((Employee)object).comSalary();
		if(object instanceof Manager)
			return ((Manager)object).comSalary();
		if(object instanceof Contractor)
			return ((Contractor)object).comSalary();
		return -1;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		 Calendar star=Calendar.getInstance();
		 int year=2015;
		 int month=10;
		 int day=21;
		 star.set(year,month,day);
		 
		 Calendar fin=Calendar.getInstance();
		 int year1=2017;
		 int month1=10;
		 int day1=21;
		 fin.set(year1,month1,day1);
		 
        Employee worker1=new Employee("苏韵锦",29,"市场分析",star,5000);
		System.out.println("工人的工资:"+worker1.comSalary());
		Manager worker2=new Manager("苏韵锦",29,"市场分析",star,5000,2000);
		System.out.println("经理的工资:"+worker2.comSalary());
		Contractor worker3=new Contractor("苏韵锦",29,"市场分析",star,5000,fin);
		System.out.println("承包商的工资:"+worker3.comSalary());
	}

}
class Employee{
	 String name;
	 int age;
	 String department;
	 Calendar star;
	 double basicSalary;
	public Employee(String n,int a,String dep,Calendar s,double basic)
	{
		this.name=n;
		this.age=a;
		this.department=dep;
		this.star=s;
		this.basicSalary=basic;
	}
	public double comSalary()
	{
		double Salary;
		Calendar cal=Calendar.getInstance();//获取目前年份
		int year=cal.get(Calendar.YEAR);
		int syear=star.get(Calendar.YEAR);//获取开始年份
		int dyear=year-syear;//获取工作时间间隔年数
		Salary=basicSalary+dyear*20;
		return Salary;
	}
}

class Manager extends Employee{//继承employee
	private double bonus;
	public Manager (String n,int a,String dep,Calendar s,double basic,double bon)
	{
		super(n,a,dep,s,basic);
		this.bonus=bon;
	}
	public double comSalary()
	{
		
		double Salary=super.comSalary()+bonus;
		return Salary;
	}
}

class Contractor extends Employee{//继承employee
	private Calendar fin;
	public Contractor (String n,int a,String dep,Calendar s,double basic,Calendar fin)
	{
		super(n,a,dep,s,basic);
		this.fin=fin;
	}
	public double comSalary()
	{
		double Salary;
		long beginTime = star.getTime().getTime(); 
		long endTime = fin.getTime().getTime(); 
		long betweenDays = (long)((endTime - beginTime) / (1000 * 60 * 60 *24)); 
		Salary=basicSalary+betweenDays*15;
		return Salary;
	}
}