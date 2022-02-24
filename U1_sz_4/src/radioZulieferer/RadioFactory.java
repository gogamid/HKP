package radioZulieferer;

import fahrzeugHersteller.Device;
import fahrzeugHersteller.DeviceFactory;

public class RadioFactory implements DeviceFactory {

    @Override
    public Device createDevice() {
        return new Radio();
    }
}
