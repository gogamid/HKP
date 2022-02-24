import javax.annotation.processing.*;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.MirroredTypeException;
import javax.lang.model.type.TypeMirror;
import java.util.Set;
@SupportedAnnotationTypes("AutoInject")
public class AutoInjectAnnoProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        System.out.println("Hello World tesrt");
        for (TypeElement annotation : annotations) {
            for (Element element : roundEnv.getElementsAnnotatedWith(annotation)) {
                TypeMirror value = null;
                AutoInject ai = element.getAnnotation(AutoInject.class);
                try {
                    ai.toInjectFor();
                } catch (MirroredTypeException mte) {
                    value = mte.getTypeMirror();
                }
                System.out.println(value);

//                Filer filer = processingEnv.getFiler();
//                try {
//                    FileObject sourceFile = filer.createResource(StandardLocation.SOURCE_OUTPUT, "", "javax.annotation.processing.Processor");
//                    try (OutputStream out = sourceFile.openOutputStream()) {
//                        out.write(String.format(value.toString()).getBytes());
//                    }
//                } catch (IOException e) {
//                    throw new AssertionError(e);
//                }
            }
        }
        return false;
    }
}
