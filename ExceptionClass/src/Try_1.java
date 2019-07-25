import javax.swing.*;

public class Try_1 {
   
	public static void main(String[] args) {
		try {
		// TODO Auto-generated method stub
		String word[]= {"good","bad","ok","bye"};
		String s=JOptionPane.showInputDialog("请输入一个数：");
		int n=Integer.parseInt(s);
		System.out.println(word[n]);
	   }
	  catch(Exception e) {
		  System.out.println("请重新输入整数：");
	  }
	  finally {
		  System.out.println("finally part");
	  }
	}

}
