package cdZulieferer;

import fahrzeugHersteller.Device;
import fahrzeugHersteller.DeviceFactory;

public class CdPlayerFactory implements DeviceFactory {

	@Override
	public Device createDevice() {
		return new CdPlayer();
	}

}
