import java.lang.*;

class Temp
{
	private int x;
	Temp()
	{
		System.out.println("1");
	}

	Temp(int i)
	{
		System.out.println("2");
	}
}

class Sample
{
	public static void main(String arg[])
	{
		Temp x= new Temp(2);
	}
}
