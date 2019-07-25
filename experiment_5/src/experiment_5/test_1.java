package experiment_5;

interface Fight
{
	void fight();
}

class FatFat implements Fight{
	public void fight()
	{
		System.out.println("FatFat 打人很痛!");
	}
}

class ThinThin implements Fight{
	public void fight()
	{
		System.out.println("ThinThin 打人一点都不痛！！哈哈。");
	}
}
public class test_1 {
    public static void f(Fight i)
    {
    	i.fight();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//向上转型
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
