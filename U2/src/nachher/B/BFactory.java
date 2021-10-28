package nachher.B;

import nachher.A.I_toBFactory;

public class BFactory implements I_toBFactory {
	@Override
	public B1 create(int x) {
		return new B1(x);
	}

}
