@AutoInject(toInjectFor = B_Service.class)
public class B_Service_Impl implements B_Service{
    @Override
    public void opB() {
        System.out.println("i am b");
    }
}
