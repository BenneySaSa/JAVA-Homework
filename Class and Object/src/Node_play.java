
public class Node_play {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head=new Node(0);//�ڱ�
		
		//��ʼ10���ڵ�ĵ�������
		for(int i=0;i<10;++i)
		{
			int num1=(int)(Math.random()*100);
			Node temp1=new Node(num1);
			AddNode(head,temp1);
		}
		System.out.println("10���ڵ�ĵ��������ӡ�������ǣ�");
		Node temp=head;
		for(int i=0;i<10;++i)
		{
			temp=temp.next;
			System.out.print(temp.date+"  ");
		}
		
		//������ڵ�
		Node star=new Node(100);
		star.next=head.next;
		head.next=star;
		//��β��ڵ�
		Node res=new Node(100);
		AddNode(star,res);
		System.out.println();
		System.out.println("����β���100���ӡ�������ǣ�");
		temp=head;
		for(int i=0;i<12;++i)
		{
			temp=temp.next;
			System.out.print(temp.date+"  ");
		}
		
	}

//����Ĳ���
	
//��ӽڵ�
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

//�ڵ���
class Node
{
	int date;
	Node next;
	//��ʼ��
	public Node(int data)
	{
		this.date=data;
		this.next=null;
	}
}


