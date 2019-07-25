
public class Work1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point a=new Point();
		a.x=5;
		System.out.println(a);
		Point b;
		b= new Point(8,3);
		System.out.println(b);
		b=null;
		System.out.println(b);
		Point c[]=new Point[8];
		c[0]=a;
		c[1]=b;
		for(int k=0;k<c.length;k++)
		{
			System.out.println(c[k]);
		}
		c[6]=new Point(4,6);
		for(int k=0;k<c.length;k++)
		{
			System.out.println(c[k]);
		}
		System.out.println();
		c[7]=new Point();
		for(int k=0;k<c.length;k++)
		{
			System.out.println(c[k]);
		}
		System.out.println();
	}

}
class Point{
	int x,y;
	public String toString()
	{
		return x+","+y;
	}
	public Point()
	{
		this(10,10);//用this调用另一构造方法，等价于x=10；y=10
	}
	public Point(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
}
