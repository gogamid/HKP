import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Name;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.MirroredTypeException;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.util.ElementFilter;
import javax.tools.Diagnostic;
import javax.tools.FileObject;
import javax.tools.JavaFileObject;
import javax.tools.StandardLocation;
import java.io.IOException;
import java.io.OutputStream;
import java.text.MessageFormat;
import java.util.Set;

@SupportedAnnotationTypes("*")
public class FieldAnnoProcessor extends AbstractProcessor {


    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (TypeElement annotation : annotations) {
            if (annotation.toString().equals("AutoInject")) {
                for (Element element : roundEnv.getElementsAnnotatedWith(annotation)) {

                    TypeMirror value = null;
                    AutoInject ai = element.getAnnotation(AutoInject.class);
                    try {
                        ai.toInjectFor();
                    } catch (MirroredTypeException mte) {
                        value = mte.getTypeMirror();
                    }

                    Filer filer = processingEnv.getFiler();
                    try {
                        FileObject sourceFile = filer.createResource(StandardLocation.SOURCE_OUTPUT, "", "javax.annotation.processing.Processor");
                        try (OutputStream out = sourceFile.openOutputStream()) {
                            out.write(String.format(value.toString()).getBytes());
                        }
                    } catch (IOException e) {
                        throw new AssertionError(e);
                    }
                }


            } else if (annotation.toString().equals("FieldAnno")) {
                for (Element element : roundEnv.getElementsAnnotatedWith(annotation)) {
                    String currentClassName = element.getEnclosingElement().toString();
                    String subclassName = currentClassName + "Constructor";
                    String annotationValue = element.getAnnotationMirrors().get(0).getElementValues().values().toArray()[0].toString();
                    Filer filer = processingEnv.getFiler();
                    try {
                        JavaFileObject sourceFile = filer.createSourceFile(subclassName);
                        try (OutputStream out = sourceFile.openOutputStream()) {
                            out.write(String.format("import java.lang.reflect.Field; \n public class %s extends %s { \n public %s(){ \n Field[] fields = this.getClass().getSuperclass().getDeclaredFields();\n" +
                                    "        for(Field field : fields){ field.setAccessible(true);\n" +
                                    "            if(field.isAnnotationPresent(FieldAnno.class)){\n" +
                                    "                try {\n" +
                                    "                    field.setInt(this, %s);\n" +
                                    "                } catch (Exception e) {\n" +
                                    "                    System.out.println(\"illegal assignment\");\n" +
                                    "                }\n" +
                                    "\n" +
                                    "            }\n" +
                                    "        }  } \n }", subclassName, currentClassName, subclassName, annotationValue).getBytes());
                        }
                    } catch (IOException e) {
                        throw new AssertionError(e);
                    }
                }
            }
        }

        return true;
    }
}
