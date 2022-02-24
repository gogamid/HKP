### Step by step 
- erstelle Anima, FieldAnno und FieldAnnoProcessor
- erstelle META-INF.services/javax.annotation.processing.Processor und drin "FieldAnnoProcessor"
- zur Compilezeit wird AnimalConstructor erstellt dank AnnotationProcessor
- compile mit in src : `javac -proc:none  FieldAnno*.java && javac Animal.java`