package 继承和访问控制;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//第一个实验
		//parent farther=new parent();
		//farther.m();
		

	}

}
//测验一
class parent{
	int x=100;
	void m() {
		System.out.println(x);
	}
}

class child extends parent{
	int x=200;
	void m()
	{
		System.out.println("x="+x);
		System.out.println("super.x="+super.x);
		super.m();
	}
	public static void main(String args[])
	{
		parent a=new child();
		a.m();
		System.out.println(a.x);
	}
}








