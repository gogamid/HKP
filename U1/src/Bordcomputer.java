import java.io.*;
import java.net.URL;
import java.util.Objects;
import java.util.Properties;
import java.lang.reflect.*;

public class Bordcomputer {
	private String deviceName;
	private Device[] installedDevices = new Device[3];
	private Device playingDevice;
	private static int volume = 0;

	private void readConfig() {
		Properties prop = new Properties();
		String fileName = "/Users/imron/OneDrive - lt.hs-fulda.de/Desktop/Semester_7_HSF/HKP/U1/src/Geraete.config";
		try (FileInputStream fis = new FileInputStream(fileName)) {
			prop.load(fis);
		} catch (FileNotFoundException ex) {
			System.out.println("File not found");
		} catch (IOException ex) {
			System.out.println("IO err");
		}
		System.out.println("CD Klasse heisst: " + prop.getProperty("CD"));
	}

	/*
	 * installedDevices Referenzen auf aktuelle Device-Objekte hält (max. 3).
	 * Irgendwie müssen diese Referenzen gesetzt werden. Und dafür ist setDevices().
	 * Ebenfalls wird von den installedDevices eines ausgewählt und als
	 * playingDevice gesetzt. Aber dafür muss es erst einmal die installedDevices
	 * geben, oder?
	 */
	private void setDevices() {
		installedDevices[0] = new CdPlayer();
//		installedDevices[1] = new UsbPlayer();
//		installedDevices[2] = new RadioPlayer();

		playingDevice = installedDevices[0];
		
		System.out.println("Devices Are Set");

	}

	public void shutdown() {
		System.out.println("Bordcomputer ist aus");

	}

	public void changeDevice() {
		playingDevice = installedDevices[1];
		System.out.println("Changed Device to USB Player");
	}

	/*
	 * Wir konnten für unsere Methode "showOptions" im Boardcomputer über
	 * introspection sehr einfach alle Methoden auslesen
	 */
	public void showOptions() {
		try {
			System.out.println("Options are: ");
			Method m[] = Bordcomputer.class.getDeclaredMethods();
			for (int i = 0; i < m.length; i++) {
				System.out.println(i + ")\t" + m[i]);
			}
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
	}

	/*
	 * Wir haben die Methoden über Introspection ausgelesen und dann die Methode an
	 * der Stelle "choice" (MethodArray) ausgeführt. Dabei sind wir auf das
	 * Hindernis gestoßen, dass manche Methoden Parameter erwartet hatten. Hier
	 * einfach mit standartwerten für die Parameter arbeiten
	 */
	public void enterOption(int choice) {
		Bordcomputer obj = new Bordcomputer();
		Method m[] = Bordcomputer.class.getDeclaredMethods();
		if(m[choice].getName().equals("louder") || m[choice].getName().equals("quieter") || m[choice].getName().equals("enterOption"))
			try {
				m[choice].invoke(obj, 1);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		else
			try {
				m[choice].invoke(obj);
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}

	public void louder(int p) {
		volume += p;
		System.out.println("Louder");
	}

	public void quieter(int p) {
		volume -= p;
		System.out.println("Quieter");

	}

	public void showVolume() {
		System.out.println("Volume: " + volume);
	}

	public void next() {
		System.out.println("Next title");
	}

	public void prev() {
		System.out.println("previous title");
	}

	public void play() {
		System.out.println("previous title");
	}

}
