import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
public @interface AutoInject {
     Class toInjectFor(); //kann auch interface sein
}
