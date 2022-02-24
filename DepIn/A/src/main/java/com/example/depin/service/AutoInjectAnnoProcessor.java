package main.java.com.example.depin.service;


import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.MirroredTypeException;
import javax.lang.model.type.TypeMirror;
import java.util.Set;

@SupportedAnnotationTypes("*")
public class AutoInjectAnnoProcessor extends AbstractProcessor {
    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        System.out.println("VALUE OF ANNOTATION IS=================");
        for (TypeElement annotation : annotations) {
            for (Element element : roundEnv.getElementsAnnotatedWith(annotation)) {
                TypeMirror value = null;
                AutoInject ai = element.getAnnotation(AutoInject.class);
                try {
                    ai.toInjectFor();
                } catch (MirroredTypeException mte) {
                    value = mte.getTypeMirror();
                }
                System.out.println("VALUE OF ANNOTATION IS=================" + value);

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
