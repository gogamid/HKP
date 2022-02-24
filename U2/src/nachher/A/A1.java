package nachher.A;

//import nachher.B.*;

public class A1 {

	public I_to_B1 myB;

	public void opA(I_toBFactory myBFactory) {
		int x = 1;

		myB = myBFactory.create(x);
		myB.opB2();
		myB.opB3();
	}
	public static void main(String[] args) {
		
	}
}
