************************************* Teil 1: Dependecy Injection für den Compiler ****************************************************
Auf Folie 15 sehen Sie ein Bsp. für die Definition einer einfachen Annotation, die vom Compiler verarbeitet wird. Die Java-Dateien hierzu finden Sie im Anschluss an diese Aufgabenstellung auf der Lernplattform.

a) Schreiben Sie ein einfaches Testprogramm, in dem diese Annotation verwendet wird.

b) Bei der Arbeit mit eigenen Annotationen, die vom Compiler zu bearbeiten sind, muss man in zwei Stufen kompilieren:
Zuerst nur die Definition der Annotation und ihren Processor. Dabei ist zu beachten, dass der Compiler hier keine Annotationen verarbeiten sollte. Dies erreicht man durch die Option -proc:none.
Im zweiten Schritt dann kann man die Klassen kompilieren, die die Annotation verwenden.
Kompilieren Sie auf der Kommandozeilenebene gemäß dieses Vorgehens Annotation, Processor und ihr Testprogramm aus a).  Arbeiten Sie zur Vereinfachung ohne Pakete und achten Sie darauf, dass alle Dateien sich im selben Verzeichnis befinden (sowohl *.java als auch *.class). Vergessen Sie nicht für den ServiceLoader die Bindung zwischen Service und seiner Implementierung durch den konkreten Annotation Processor herzustellen. Wenn beim Kompilieren "Note: found @Log at ..." ausgegeben wird, haben Sie die Aufgabe gelöst.
c) Erklären Sie, was mit der Aussage "Der Compiler ist auf die Nutzung von Annotationsprozessoren, die vom Nutzer geschrieben werden vorbereitet." gemeint ist.


### Aufgabe Uebung 6 Teil 2
```
javac -proc:none FieldAnno*.java && javac Animal.java
```