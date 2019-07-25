package symexample;
import java.util.*;

public class Student {
	private String num;
	private String name;
	private String sex;
	private String city;
	private ArrayList<String> hobby;
	
	public Student(String num,String name,String sex,String city,ArrayList<String> hobby)
	{
		this.num=num;
		this.name=name;
		this.sex=sex;
		this.city=city;
		this.hobby=(ArrayList<String>) hobby.clone();
	}
	public String getNum()
	{
		return this.num;
	}
	public String getName()
	{
		return this.name;
	}
	public String getSex()
	{
		return this.sex;
	}
	public String getCity()
	{
		return this.city;
	}
	public ArrayList<String> getHobby()
	{
		return this.hobby;
	}
}
