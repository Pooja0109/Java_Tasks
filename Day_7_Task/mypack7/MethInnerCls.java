package mypack7;

public class MethInnerCls{
	public void MyMethInner()
	{
		int a=10;    //local variable of outer class
		abstract class Inner1                                            //

		{
			int b=20; //instance variable of inner class
			abstract public void method1();
		}
		
		class Inner2 extends Inner1
		{
			public void method1()
			{
				System.out.println("local variable of outer class method A="+a);
				System.out.println("instance variable of inner class B="+b);
			}
		}
		
		Inner2 in=new Inner2();
		in.method1();
	}
	
	void dispConclusion()
	{
		System.out.println("--------Therefore method local inner class can be abstract in nature---------");
	}
	public static void main(String args[])
	{
		MethInnerCls obj1=new MethInnerCls();
		obj1.MyMethInner();
		obj1.dispConclusion();
	}
}

