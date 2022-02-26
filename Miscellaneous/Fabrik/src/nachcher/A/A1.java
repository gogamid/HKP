package nachcher.A;


public class A1 {
    private IntB b;
    public void opA(IntBFactory bf) {
        b = bf.createB1();
        b.opB1();
    }
}
