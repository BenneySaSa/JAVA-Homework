package experiment_5;
import java.util.*;

interface Listener{
	void action();
}

public class test implements Listener{

	public void action() {
		System.out.println("stand up");
	}
	public void add(Listener a)
	{
		a.action();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	test x=new test();
	x.add(x);
	test2 y=new test2();
	x.add(y);
	}
}


class test2 implements Listener{
	public void action()
	{
		System.out.println("sit dowm");
	}
}