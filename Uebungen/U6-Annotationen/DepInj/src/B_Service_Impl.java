
@AutoInject(toInjectFor = B_Service.class)
public class B_Service_Impl implements B_Service {
    @Override
    public String opB2() {
        return "this is opB2";
    }
}
