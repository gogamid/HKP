import java.util.ArrayList;
import java.util.List;

public class Main {
    void foo(List inputList){
        @SuppressWarnings("uncheck")
        List<String> list = (List<String>) inputList; //unsafe cast
    }
    void uncheckedGenerics(){
        List words = new ArrayList();
        words.add("hello");
    }

    static void print(String...strings){
        for(String s : strings){
            System.out.println(s);
        }
    }
    public static void main(String[] args) {
        print(new String[] {"a", "b"});

    }
}
