import java.util.Scanner;

public class BookTestStaticVarial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sn=new Scanner(System.in);
		//书一
		book salebook1=new book("<<数据库的使用>>");
		System.out.print("请输入卖出书籍<<数据库的使用>>的次数：");
		int num1=sn.nextInt();
		for(int i=0;i<num1;i++)
		{
			salebook1.sale();
		}
		System.out.println(salebook1.toString());
		
		//书二
		book salebook2=new book("<<Java程序设计>>");
		System.out.print("请输入卖出书籍<<Java程序设计>>的次数：");
		int num2=sn.nextInt();
		for(int i=0;i<num2;i++)
		{
			salebook2.sale();
		}
		System.out.println(salebook2.toString());
		
		
		//书三
		book salebook3=new book("<<论演员的自我修养>>");
		System.out.print("请输入卖出书籍<<论演员的自我修养>>的次数：");
		int num3=sn.nextInt();
		for(int i=0;i<num3;i++)
		{
			salebook3.sale();
		}
		System.out.println(salebook3.toString());
		
		
	}
}

class book
{
	String title;//书名      不写是default，包内可访问
	int salesnumber;//一本书的出售量
	static int gensalenumber=0;//所有书的出售量
	public book(String s)
	{
		this.title=s;
		this.salesnumber=0;
	}
	public void sale()
	{
		this.salesnumber++;
		this.gensalenumber++;
	}
	public String toString()
	{
		return "书"+title+"的销量为："+salesnumber+"\n"+
				"目前书的总销量为："+gensalenumber;
	}
}