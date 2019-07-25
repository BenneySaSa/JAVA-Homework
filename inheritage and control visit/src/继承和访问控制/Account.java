package 继承和访问控制;

import java.util.*;


public class Account {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SavingAccount saver=new SavingAccount(6000);
		SavingAccount.year_bonus=0.03;
		
		double money=saver.saving();
		System.out.println("saver的存款额："+money);
		double yearmoney=saver.yearInterest();
		System.out.println("saver的年利息："+yearmoney);
		double monthmoney=saver.monthInterest();
		System.out.println("saver的月利息："+monthmoney);
	}

}

class SavingAccount
{
	public static double year_bonus;
	private double money;
	SavingAccount(double money)
	{
		this.money=money;
	}
	public double saving()
	{
		return money;
	}
	public double yearInterest()
	{
		return money*year_bonus;
	}
	public double monthInterest()
	{
		return yearInterest()*1.0/12;
	}
}
