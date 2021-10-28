import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Test {
	
	// ein privates Attribut deklarieren
	private int myInt = 1;
	
	public static void main(String[] args) {
		
		Test t = new Test();
		
//		// die Klasse eines existierenden Objektes erfragen
		Class c = t.getClass();
		
//		// eine Klasse ueber ihren Namen erzeugen (inkl. Exception Handling)
		try {
			Class c2 = Class.forName("Test");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		// die Klasse von einer Klasse statisch abfragen
		Class c3 = Test.class;
		
		// die Superklasse der Klasse abfragen
		Class c4 = c.getSuperclass();
		
		// die public Methoden einer Klasse abfragen (inkl. der geerbten)
		Method[] m = c.getMethods();
		
		System.out.println();
		
		// die in der Klasse selbst deklarierten Methoden einer Klasse abfragen (unabh�ngig von Sichtbarkeit)
		m = c.getDeclaredMethods();
		
		// die Konstruktoren einer Klasse abfragen
		
		Field[] as = c.getDeclaredFields();
		
		// alle Attribute (egal welcher Sichtbarkeit) einer Klasse abfragen
		try {
			Field a = c.getDeclaredField("myInt");
			
			try {
				a.get(t);
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// die Modifier einer Methode laden 
		int i = m[0].getModifiers();
		
		// Abfragen mit Hilfe der Klasse Modifier, ob das Feld privat
		boolean b = Modifier.isPublic(i);
		
		

		
	}

}