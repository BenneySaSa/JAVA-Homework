package �̳кͷ��ʿ���;

public class trapezoid {
    double upper;//�ϵ�
    double bottom;//�µ�
    double height;//��
    public trapezoid(double upper,double bottom,double height)
    {
    	this.upper=upper;
    	this.bottom=bottom;
    	this.height=height;
    }
    public double area()
    {
    	return (upper+bottom)*height/2;
    }
    public static double area(trapezoid me)
    {
    	return (me.upper+me.bottom)*me.height/2;
    }
    public static double area(double upper,double bottom,double height)
    {
    	return (upper+bottom)*height/2;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		trapezoid x=new trapezoid(2,6,3);
		System.out.println("���1="+x.area());
		System.out.println("���2="+area(new trapezoid(2,8,4)));
        System.out.println("���2="+area(3,8,5));
	}

}
