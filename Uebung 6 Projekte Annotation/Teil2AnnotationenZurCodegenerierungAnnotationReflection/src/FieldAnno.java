import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) //zur Compilerzeit
@Target(ElementType.FIELD)
public @interface FieldAnno {
    int value();
}
