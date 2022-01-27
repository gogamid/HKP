import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.JavaFileObject;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Set;

@SupportedAnnotationTypes("FieldAnno")
public class FieldAnnoProcessor extends AbstractProcessor {


    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (TypeElement annotation : annotations) {
            for (Element element : roundEnv.getElementsAnnotatedWith(annotation)) {
                String currentClassName = element.getEnclosingElement().toString(); //Animal
                String subclassName = currentClassName + "Constructor"; //AnimalConstructor
                String annotationValue = element.getAnnotationMirrors().get(0).getElementValues().values().toArray()[0].toString(); //2
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

        return true;
    }
}
