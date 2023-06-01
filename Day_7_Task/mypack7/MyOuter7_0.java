package mypack7;

class Out {
	 public void displayOut()
     {
     	System.out.println("Im a Outer class method");
     }
    abstract class Inn {
        abstract void displayIn();
        void displayIn2()
        {
        	System.out.println("Im a Inner class non-abstract method");
        }
    }
}

class OutsideCls extends Out.Inn {
	public OutsideCls()
	{
		new Out().super();  
	}
    public void displayIn() {
        System.out.println("OUTSIDE CLASS :Im a Inner class function and im implemented inside the class that inherits the Inner class. ");
    }
}

public class MyOuter7_0 {
    public static void main(String[] args) {
        Out out = new Out(); 
        OutsideCls oc = new OutsideCls();
        oc.displayIn(); //Inner class method
        oc.displayIn2();
        out.displayOut();
    }
}