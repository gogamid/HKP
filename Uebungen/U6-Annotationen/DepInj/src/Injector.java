import java.util.ServiceLoader;

public class Injector {
    public static void main(String[] args) {
        A1 a1 = new A1();

        final ServiceLoader<B_Service> b_services = ServiceLoader.load(B_Service.class);
        for (B_Service service : b_services){
            a1.setB_service(service);
            System.out.println(service.opB2());
        }

    }


}
