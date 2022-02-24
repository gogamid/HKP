import java.util.Set;

import javax.annotation.processing.*;
import javax.lang.model.element.*;
import javax.tools.*;

@SupportedAnnotationTypes("Log")
public class LogProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for ( TypeElement annotation : annotations ) {
            for ( Element element : roundEnv.getElementsAnnotatedWith(annotation) ) {
                processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, "found @Log at " + element);
            }
        }
        return true;
    }

}