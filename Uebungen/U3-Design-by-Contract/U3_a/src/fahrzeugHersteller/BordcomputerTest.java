package fahrzeugHersteller;
public class BordcomputerTest {

	public static void main(String[] args) throws ClassNotFoundException {
		Bordcomputer b = new Bordcomputer();

		/*
		a) CD: Weil open ist immer falsch. Deswegen kann man nicht abspielen. Bordcomputer kann nicht open true machen.
		Radio:  ist nicht abspielbar, weil volume ist 0. Ich kann auch lauder nicht machen, weil es ist mute.
		Ich kann nicht unmute machen, weil es gibt kein so was funktion in Bordcomputer
		* */
		
//		// play forwards and backwards on actual device
//		b.changeDevice();
		b.play();
		b.louder(11);
		b.play();
		b.next();
		b.play();
		b.next();
		b.play();
		b.prev();
		b.play();

		// moving to next device
//		b.changeDevice();
		b.play();
//		b.changeDevice();
		b.play();

		// testing volume
		b.showVolume();
		b.louder(3);
		b.showVolume();
		b.quieter(2);
		b.showVolume();

		// testing options
		b.showOptions();
		b.enterOption(4);
		
	}

}