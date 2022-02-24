import java.lang.reflect.Field;

public class Dog extends Animal {

    public Dog() {

        //felder->richtige annotation->wert read und setInt
        Field[] fields = this.getClass().getSuperclass().getDeclaredFields();
        for(Field field : fields){ field.setAccessible(true);
            if(field.isAnnotationPresent(FieldAnno.class)){
                try {
                    field.setInt(this, field.getAnnotation(FieldAnno.class).value()); //ersetzten
                } catch (Exception e) {
                    System.out.println("illegal assignment");
                }

            }
        }
    }

}
