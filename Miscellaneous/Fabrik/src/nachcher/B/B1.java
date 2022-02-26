package nachcher.B;

import nachcher.A.IntB;

public class B1 implements IntB {
    public B1(int x) {
        System.out.println("fabric created B1");
    }

    @Override
    public void opB1() {
        System.out.println("ope b1 is called");
    }
}
