package Integration;

import cdZulieferer.CdPlayerFactory;
import fahrzeugHersteller.Boardcomputer;
import fahrzeugHersteller.DeviceFactory;
import radioZulieferer.RadioFactory;

public class Configuration {

    public static void main(String[] args) {
        DeviceFactory[] df_arr = new DeviceFactory[2];
        df_arr[0] = new RadioFactory();
        df_arr[1] = new CdPlayerFactory();
        Boardcomputer b = new Boardcomputer(df_arr);
        b.play();
        b.changeDevice();
        b.play();
    }

}
