import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;

public class Main {
	public static void main(String[] args) {
		Bordcomputer b = new Bordcomputer();
		b.showOptions();

		CdPlayer cd = new CdPlayer();
		cd.chooseOption("prev");
	}
}
