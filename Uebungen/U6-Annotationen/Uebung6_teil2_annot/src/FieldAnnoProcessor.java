import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import javax.tools.JavaFileObject;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Set;

@SupportedAnnotationTypes("Log")
public class FieldAnnoProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for ( TypeElement annotation : annotations ) {
            for ( Element element : roundEnv.getElementsAnnotatedWith(annotation) ) {
                processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, "found @FieldAnno at " + element);
                Filer filer = processingEnv.getFiler();
                try {
                    JavaFileObject sourceFile = filer.createSourceFile("Test");
                    try (OutputStream out = sourceFile.openOutputStream()) {
                        out.write("package com.example.buck; class Test { }".getBytes());
                    }
                } catch (IOException e) {
                    throw new AssertionError(e);
                }
            }
        }
        return true;
    }
    // TODO: 21.01.22 übernimmmt code generierung

}
