
//Day-7 :Check whether the inner class can be abstract.

package mypack7;
import mypack7.MyOuter7;
import mypack7.MyOuter7.MyInner;

class MyOuter7
{
	public int x =7;
	
	//yes,Abstract inner class can be inherited...
	public void displayOuter()
	{
		int outVar=101;
		System.out.println("Im a Outer method");
	}
	abstract class MyInner          
	{
		int y=17; //instance variable of inner class
		abstract public void InnerMethod();
		public void display()
		{
			int y1=18;      //local variable of inner class
			System.out.println("------------------------------------------------------------");
			System.out.println("Im a Inner method");
			System.out.println("Class Inner:Im a Outer class local variable:NOT Available.");
			System.out.println("Class Inner:Im a Outer class Instance variable: "+new MyOuter7().x+" .Available.");

		}
	}
	
	
	class MyInner2 extends MyInner
	{
		//selfNote:abstract class object can be created but not instance...!
		
		public void InnerMethod()
		{
			System.out.println("------------------------------------------------------------");
			System.out.println("From Inner method");
			System.out.println("x == " + x);
			System.out.println("y == " +y);
			super.display();
		}
//Doubt	
//		MyInner2 inn=new MyInner2();
		
	}
	public void OuterMethod()
	{
		System.out.println("------------------------------------------------------------");
		System.out.println("From outer method Outer instance X = " + x);
		System.out.println("From outer method Inner instance Y= " + new MyInner2().y);
		
	}
	public static void main(String[] args)
	{
	MyOuter7 mo = new MyOuter7();
	MyOuter7.MyInner mi = mo.new MyInner2(); //instantiating inner class
	
	//doubt
	//MyInner in=MyOuter7.new MyInner2();
	
	mi.InnerMethod();
	mo.OuterMethod();
//	mi.display();
	System.out.println("------------------------------------------------------------");
	System.out.println("\t\t*In Main Class*\n");
	System.out.println("Instance varibale of inner class: "+mi.y+" Availabe.");
	System.out.println("Local varibale of inner class:NOT Available."); //y1 (local variable) is not accessible
	System.out.println("\nInstance varibale of Outer class:NOT Available");
	System.out.println("Local varibale of Outer class:NOT Available.");
	}

}

// Check whether the inner class can be abstract? yes
// can it be inherited? yes
// scope of instance variable within the inner class ? Done in above code
// scope of local variable within the inner class ?Done in above code







