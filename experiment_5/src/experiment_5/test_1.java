package experiment_5;

interface Fight
{
	void fight();
}

class FatFat implements Fight{
	public void fight()
	{
		System.out.println("FatFat ���˺�ʹ!");
	}
}

class ThinThin implements Fight{
	public void fight()
	{
		System.out.println("ThinThin ����һ�㶼��ʹ����������");
	}
}
public class test_1 {
    public static void f(Fight i)
    {
    	i.fight();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//����ת��
		Fight fight=new FatFat();
		if(fight instanceof FatFat)
			fight.fight();
		Fight fight1=new ThinThin();
		if(fight1 instanceof ThinThin)
			fight1.fight();
		//f(c)
		FatFat fat=new FatFat();
		ThinThin thin=new ThinThin();
		f(fat);
		f(thin);

	}

}
