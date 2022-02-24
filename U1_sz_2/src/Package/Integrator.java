package Package;

import fahrzeugHersteller.Boardcomputer;
import ZuliefererInterface.Device;
import cdZulieferer.CdPlayer;
import radioZulieferer.Radio;

public class Integrator {

	public static void main(String[] args) {
		Device[] d = new Device[2];
		d[0] = new Radio();
		d[1] = new CdPlayer();


		Boardcomputer b = new Boardcomputer(d);

		// play forwards and backwards on actual device
		b.play();
		b.next();
		b.play();
		b.next();
		b.play();
		b.prev();
		b.play();

		// moving to next device
		b.changeDevice();
		b.play();
		b.changeDevice();
		b.play();

		// testing volume
		b.showVolume();
		b.louder(3);
		b.showVolume();
		b.quieter(2);
		b.showVolume();

		// testing options
		b.showOptions();
		b.enterOption(2);
	}

}
