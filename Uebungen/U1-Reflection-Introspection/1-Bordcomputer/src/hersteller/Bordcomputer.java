package hersteller;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

public class Bordcomputer {
    private String deviceName;
    private Device[] mediaPlayer = new Device[3];
    private Device playingDevice;
    HashMap<String, String> classNames = new HashMap<>();

    private void readConfig() {
        //read from file Geraete.config and get name of device
        String nameFromFile = "RadioPlayer"; //got from File
        classNames.put("Radio", nameFromFile);
    }

    //reflection mit new Instance
    private void setDevices() throws ClassNotFoundException {
        if (classNames.containsKey("Radio")) {
            String cName = classNames.get("Radio");
            try {
                mediaPlayer[0] = (Device) Class.forName(cName).getDeclaredConstructors()[0].newInstance();
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }

            playingDevice = mediaPlayer[0];
        }
    }

    public void shutdown() {
        System.out.println("Shutting down Boardcomputer");
    }

    public void changeDevice() {
        System.out.println("Changind to the next device");
    }

    //introspection
    public void showOptions() {
        int c = 1;
        if (playingDevice != null) {
            for (String option : playingDevice.getOptions()) {
                System.out.println(c++ + "Option: " + option);
            }

            for (Method extra_option : playingDevice.getClass().getDeclaredMethods()) {
                System.out.println(c++ + "Option: " + extra_option.getName());
            }
        }
    }

    public void play() {
        if (playingDevice != null) System.out.println(playingDevice.play());
    }

    public void next() {
        if (playingDevice != null) playingDevice.next();
    }

    public void prev() {
        if (playingDevice != null) playingDevice.next();
    }

    public void showVolume() {
        if (playingDevice != null) System.out.println(playingDevice.getVolume());
    }

    public void louder(int i) {
        if (playingDevice != null)
            for (int j = 0; j < i; j++) {
                playingDevice.louder();
            }
    }

    public void quieter(int i) {
        if (playingDevice != null)
            for (int j = 0; j < i; j++) {
                playingDevice.quieter();
            }
    }

    public void enterOption() {
    }
}
