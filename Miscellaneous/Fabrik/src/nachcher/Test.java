package nachcher;

import nachcher.A.*;
import nachcher.B.*;


public class Test {
    public static void main(String[] args) {

        BFactory bf = new BFactory();
        A1 a = new A1();
        a.opA(bf);

    }
}
