package hsfulda.bachelor.hkp.annotation;

public class ConcreteClassWithAnnotatedField extends AbstractClassWithAnnotatedField{

    @FieldAnno(10)
    private int myAnnotatedAttr;

    public static void main(String[] args) {
        ConcreteClassWithAnnotatedField test = new ConcreteClassWithAnnotatedField();
        System.out.println(test.myAnnotatedAttr);
    }
}
