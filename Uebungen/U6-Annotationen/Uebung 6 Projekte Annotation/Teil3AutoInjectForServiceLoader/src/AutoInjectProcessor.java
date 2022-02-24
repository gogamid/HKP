import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.MirroredTypeException;
import javax.lang.model.type.TypeMirror;
import javax.tools.FileObject;
import javax.tools.StandardLocation;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Set;

@SupportedAnnotationTypes("AutoInject")
public class AutoInjectProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (TypeElement annotation : annotations) {
            for (Element element : roundEnv.getElementsAnnotatedWith(annotation)) {

                TypeMirror value = null;
                AutoInject ai = element.getAnnotation(AutoInject.class);
                try {
                    ai.toInjectFor();
                } catch (MirroredTypeException mte) {
                    value = mte.getTypeMirror();
                }
                String relName = "META-INF/services/"+value;

                Filer filer = processingEnv.getFiler();
                try {
                    FileObject sourceFile = filer.createResource(StandardLocation.SOURCE_OUTPUT, "", relName);
                    try (OutputStream out = sourceFile.openOutputStream()) {

                        out.write(String.format(element.getSimpleName().toString()).getBytes());
                    }
                } catch (IOException e) {
                    throw new AssertionError(e);
                }
            }
        }
        return false;
    }
}

