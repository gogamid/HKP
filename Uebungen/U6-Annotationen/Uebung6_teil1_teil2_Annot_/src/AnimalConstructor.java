import java.lang.reflect.Field; 
 public class AnimalConstructor extends Animal { 
 public AnimalConstructor(){ 
 Field[] fields = this.getClass().getSuperclass().getDeclaredFields();
        for(Field field : fields){ field.setAccessible(true);
            if(field.isAnnotationPresent(FieldAnno.class)){
                try {
                    field.setInt(this, 10);
                } catch (Exception e) {
                    System.out.println("illegal assignment");
                }

            }
        }  } 
 }