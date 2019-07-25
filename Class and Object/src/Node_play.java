
public class Node_play {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head=new Node(0);//哨兵
		
		//初始10个节点的单向链表
		for(int i=0;i<10;++i)
		{
			int num1=(int)(Math.random()*100);
			Node temp1=new Node(num1);
			AddNode(head,temp1);
		}
		System.out.println("10个节点的单向链表打印出数据是：");
		Node temp=head;
		for(int i=0;i<10;++i)
		{
			temp=temp.next;
			System.out.print(temp.date+"  ");
		}
		
		//在首添节点
		Node star=new Node(100);
		star.next=head.next;
		head.next=star;
		//在尾添节点
		Node res=new Node(100);
		AddNode(star,res);
		System.out.println();
		System.out.println("在首尾添加100后打印出数据是：");
		temp=head;
		for(int i=0;i<12;++i)
		{
			temp=temp.next;
			System.out.print(temp.date+"  ");
		}
		
	}

//链表的操作
	
//添加节点
   private static void AddNode(Node header,Node newNode)
	{
		Node temp=header;
		while(temp.next!=null)
		{
			temp=temp.next;
		}
		temp.next=newNode;
	}
}

//节点类
class Node
{
	int date;
	Node next;
	//初始化
	public Node(int data)
	{
		this.date=data;
		this.next=null;
	}
}


