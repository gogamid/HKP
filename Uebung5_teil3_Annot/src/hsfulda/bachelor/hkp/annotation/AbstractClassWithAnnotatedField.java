package hsfulda.bachelor.hkp.annotation;
import java.lang.reflect.*;

public abstract class AbstractClassWithAnnotatedField {

    public AbstractClassWithAnnotatedField() {
       //felder->richtige annotation->wert read und setInt
        Field[] fields = getClass().getDeclaredFields();
        for(Field field : fields){
            field.setAccessible(true);
            if(field.isAnnotationPresent(FieldAnno.class)){
                try {
                    field.setInt(this, field.getAnnotation(FieldAnno.class).value());
                } catch (Exception e) {
                    System.out.println("illegal assignment");
                }

            }
        }
    }
}
