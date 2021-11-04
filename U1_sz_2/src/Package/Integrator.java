package Package;

import fahrzeugHersteller.Boardcomputer;
import ZuliefererInterface.Device;
import cdZulieferer.CdPlayer;

public class Integrator {
	
	Device d = new CdPlayer();
	Boardcomputer b = new Boardcomputer(d);

}
