package 继承和访问控制;

public class testCourse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("测试结果如下：");
		Course course1=new Course();
		course1.print();
		Course course2=new Course("001");
		course2.print();
		Course course3=new Course("002","语文");
		course3.print();
		Course course4=new Course("003","数学",4);
		course4.print();
		Course course5=new Course("004","英语",2,"Juliee");
		course5.print();	

	}

}
class Course{
	private String courseID;
	private String courseName;
	private int credit;
	private String teacher;
	
	Course() {
		this.courseID=null;
		this.courseName=null;
		this.credit=0;
		this.teacher=null;
	}
	Course(String courseID){
		this.courseID=courseID;
		this.courseName=null;
		this.credit=0;
		this.teacher=null;
	}
	Course(String courseID, String courseName, int credit, String teacher){
		this.courseID=courseID;
		this.courseName=courseName;
		this.credit=credit;
		this.teacher=teacher;
	}
	Course(String courseID, String courseName, int credit){
		this(courseID,courseName,credit,null);
	}
	Course(String courseID, String courseName){
		this(courseID,courseName,0);
	}
	public void  print() {
		System.out.println("课程代号："+courseID+" "
				+ "课程名称："+courseName+" 课程学分："+credit+" 任课老师："+teacher);
	}
}
