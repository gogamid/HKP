import java.lang.annotation.*;

@Target({ElementType.TYPE})
public @interface AutoInject {
     Class toInjectFor();
}
