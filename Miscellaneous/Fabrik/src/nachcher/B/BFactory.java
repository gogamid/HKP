package nachcher.B;

import nachcher.A.IntB;
import nachcher.A.IntBFactory;

public class BFactory implements IntBFactory {
    @Override
    public IntB createB1() {
        return new B1(10);
    }
}
