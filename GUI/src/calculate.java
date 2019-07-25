import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class calculate extends JFrame{
    private calculate frame;//私有成员变量
    public calculate()
    {
    	super("简易计算器");
    	frame=this;
    	//x,y,宽，高
    	this.setSize(400,300);
    	this.setResizable(false);
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	//窗口设置在屏幕中央
    	this.setLocationRelativeTo(null);
    }
    public void design()
    {
    	final FlowLayout flowlayout=new FlowLayout();
    	flowlayout.setHgap(5);
    	flowlayout.setVgap(5);
    	Container panel=frame.getContentPane();//得到容器
    	panel.setLayout(flowlayout);
    	
    	int length=8;//文本框长度
    	final JTextField num1=new JTextField(length);
    	panel.add(num1);
    	
    	final JTextField num2=new JTextField(length);
    	panel.add(num2);
    	
    	final JButton plus=new JButton("+");
    	final JLabel label=new JLabel();
    	plus.addActionListener
		(        //匿名类
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						//出错处理
						if(num1.getText().equals("")||num2.getText().equals(""))
						{
							JOptionPane.showMessageDialog(null, "文本框不可为空！","提示消息", JOptionPane.ERROR_MESSAGE);
						}
						else if(!isNumeric(num1.getText())||!isNumeric(num2.getText()))
						{
							JOptionPane.showMessageDialog(null, "请输入整数!","提示消息", JOptionPane.ERROR_MESSAGE);
						}
						int res=Integer.parseInt(num1.getText())+Integer.parseInt(num2.getText());
				    	label.setText(String.valueOf(res));
					}
				}
	   );
    	panel.add(plus);
    	
    	final JButton multiply=new JButton("*");
    	multiply.addActionListener
		(        //匿名类
				new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						if(num1.getText().equals("")||num2.getText().equals(""))
						{
							JOptionPane.showMessageDialog(null, "文本框不可为空！","提示消息", JOptionPane.ERROR_MESSAGE);
						}
						else if(!isNumeric(num1.getText())||!isNumeric(num2.getText()))
						{
							JOptionPane.showMessageDialog(null, "请输入整数!","提示消息", JOptionPane.ERROR_MESSAGE);
						}
						int res=Integer.parseInt(num1.getText())*Integer.parseInt(num2.getText());
						label.setText(String.valueOf(res));
					}
				}
	   );
    	panel.add(multiply);
    	final JLabel res=new JLabel("=");
    	panel.add(res);
    	panel.add(label);

    }
    
    //是否为整数
    public boolean isNumeric(String str) {
		for(int i=str.length();--i>=0;) {
			if(!Character.isDigit(str.charAt(i))){
				return false;
			}
		}
		return true;
	}
    //main
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		calculate frame1=new calculate();
		frame1.design();
		frame1.setVisible(true);

	}

}
