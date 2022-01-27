### Uebung 6 Teil 1
### a) Schreiben Sie ein einfaches Testprogramm, in dem diese Annotation verwendet wird.
- @Log ist für Type, deswegen oben von class declaration @Log hinzufügen
### b) Bei der Arbeit mit eigenen Annotationen, die vom Compiler zu bearbeiten sind, muss man in zwei Stufen kompilieren:
1) Zuerst nur die Definition der Annotation und ihren Processor. Dabei ist zu beachten, dass der Compiler hier keine Annotationen verarbeiten sollte. Dies erreicht man durch die Option -proc:none.
2) Im zweiten Schritt dann kann man die Klassen kompilieren, die die Annotation verwenden.
   * Kompilieren Sie auf der Kommandozeilenebene gemäß dieses Vorgehens Annotation, Processor und ihr Testprogramm aus a).
   * Arbeiten Sie zur Vereinfachung ohne Pakete und achten Sie darauf, dass alle Dateien sich im selben Verzeichnis befinden (sowohl *.java als auch *.class)
   * Vergessen Sie nicht für den ServiceLoader die Bindung zwischen Service und seiner Implementierung durch den konkreten Annotation Processor herzustellen. 
   * Wenn beim Kompilieren "Note: found @Log at ..." ausgegeben wird, haben Sie die Aufgabe gelöst.
- ohne Pakete und ohne src
- create META-INF/services/javax.annotation.processing.Processor und content ist "LogProcessor"
- compile: `javac -proc:none Log*.java && javac Testprogramm.java`
### c)  Erklären Sie, was mit der Aussage "Der Compiler ist auf die Nutzung von Annotationsprozessoren, die vom Nutzer geschrieben werden vorbereitet." gemeint ist.

????



  

