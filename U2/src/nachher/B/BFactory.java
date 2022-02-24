//should be changed, rückgabe usw

package nachher.B;

import nachher.A.I_toBFactory;
import nachher.A.I_to_B1;

public class BFactory implements I_toBFactory {
	
	@Override
	public I_to_B1 create(int x) {
		return new B1(x);
	}

}
