package fahrzeugHersteller;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public class Boardcomputer {
    private final String[] deviceName = new String[3];
    private final Device[] installedDevices = new Device[3];
    private Device playingDevice;

    /*
    ist ein eigener Konstruktor erlaubt? (steht nicht im Klassendiagramm)
    und readConfig und setDevices müssen ja private sein, können also nicht von einer Testing Klasse aufgerufen werden
     */
    public Boardcomputer(DeviceFactory[] df) {
    	installedDevices[0] =  df[0].createDevice();
        installedDevices[1] =  df[1].createDevice();
        playingDevice = installedDevices[0];
    }

//    private void readConfig() {
//        String dir = "/home/timo/NextCloud/Studium/Angewandte Informatik/3. Semester/Höhere Konzepte der Programmierung/HKP_JavaProgrammingStuff/src/";
//        File configFile = new File(dir + "Geraete.config");
//
//        try {
//            FileReader fr = new FileReader(configFile);
//            BufferedReader br = new BufferedReader(fr);
//            String line;
//            ArrayList<String> stringlist = new ArrayList<>();
//            while ((line = br.readLine()) != null) {
//                stringlist.add(line);
//            }
//            fr.close();
//
//            int devicesFound = 0;
//            for (String myLine : stringlist) {
//                if (devicesFound >= 3) {
//                    break;
//                }
//                if (myLine.contains("=")) {
//                    deviceName[devicesFound] = myLine;
//                    devicesFound++;
//                }
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

//    private void setDevices() throws ClassNotFoundException {
//        int i = 0;
//        for (String device : deviceName) {
//            if (device != null) {
//                String classname = device.substring(device.indexOf("=") + 1).trim();
//                try {
//                    installedDevices[i] = (Device) Class.forName(classname).getDeclaredConstructors()[0].newInstance();
//                    i++;
//                } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }

    public void shutdown() {
        System.exit(0);
    }

    public void changeDevice() {
        boolean currentDeviceFound = (playingDevice == null);
        for (Device d : installedDevices) {
            if (currentDeviceFound && d != null) {  // use next available device if current device was found
                playingDevice = d;
                System.out.println("Chosen device: " + d.getClass().getSimpleName());
                return;
            } else if (d != null && d.getClass().getName().equals(playingDevice.getClass().getName())) {
                currentDeviceFound = true;
            }
        }
        for (Device d : installedDevices) {
            if (currentDeviceFound && d != null) {   // use same device or one on a previous position in the array
                playingDevice = d;
                System.out.println("Chosen device: " + d.getClass().getSimpleName());
                return;
            }
        }
        System.out.println("No device available");
    }

    public void showOptions() {
        int internalOptionCounter = 0;
        System.out.println("\nBoardcomputer options:");
        ArrayList<String> bcOptions = new ArrayList<>();
        for (Method m : this.getClass().getDeclaredMethods()) { // returns all declared methods including private or protected
            try {
                if (Modifier.isPublic(this.getClass().getDeclaredMethod(m.getName()).getModifiers())) {  // filter out methods that are not public (using Modifier) or have arguments (using getDeclaredMethod)
                    bcOptions.add(m.getName());
                    System.out.println(internalOptionCounter + " - " + m.getName());
                    internalOptionCounter++;
                }
            } catch (NoSuchMethodException ignore) {
                // System.out.println("No method with name " + m.getName() + " found");
            }
        }

        /*if (playingDevice != null) {
            System.out.println("\nAll playing device options:");
            for (String option : playingDevice.getOptions()) {
                System.out.println(internalOptionCounter + " - " + option);
                internalOptionCounter++;
            }
        }*/

        if (playingDevice != null) {
            System.out.println("\nExtra device options:");
            for (String option : playingDevice.getOptions()) {
                try {
                    if (option != null && !bcOptions.contains(option) &&  // filter out methods that are already called from Boardcomputer
                            Modifier.isPublic(playingDevice.getClass().getDeclaredMethod(option).getModifiers())    // filter out methods that are not public or have arguments
                    ) {
                        System.out.println(internalOptionCounter + " - " + option);
                        internalOptionCounter++;
                    }
                } catch (NoSuchMethodException ignored) {
                    // System.out.println("No method with name " + option + " found");
                }
            }
        }
    }

    public void enterOption(int choice) {
        int internalOptionCounter = 0;
        ArrayList<String> bcOptions = new ArrayList<>();

        for (Method m : this.getClass().getDeclaredMethods()) {
            try {
                if (Modifier.isPublic(this.getClass().getDeclaredMethod(m.getName()).getModifiers())) { // filter out methods that are not public or have arguments
                    bcOptions.add(m.getName());
                    if (internalOptionCounter == choice) {
                        System.out.println("\nselected option: " + m.getName());
                        try {
                            m.invoke(this);
                        } catch (IllegalAccessException | InvocationTargetException e) {
                            e.printStackTrace();
                        }
                        return;
                    }
                    internalOptionCounter += 1;
                }
            } catch (NoSuchMethodException ignore) {
                // System.out.println("No executable method with name " + m.getName() + " found");
            }
        }
        for (String option : playingDevice.getOptions()) {
            try {
                if (!bcOptions.contains(option) &&  // filter out methods that are already called from Boardcomputer
                        Modifier.isPublic(playingDevice.getClass().getDeclaredMethod(option).getModifiers())    // filter out methods that are not public or have arguments
                ) {
                    if (internalOptionCounter == choice) {
                        System.out.println("\nselected device option: " + option);
                        playingDevice.chooseOption(option);
                        return;
                    }
                    internalOptionCounter += 1;
                }
            } catch (NoSuchMethodException ignored) {
                // System.out.println("No executable method with name " + option + " found");
            }
        }
    }

    public void louder(int p) {
        for (int i = 0; i < p; i++) {
            playingDevice.louder();
        }
    }

    /*
    why is p of type String?
     */
    public void quieter(String p) {
        playingDevice.quieter();
    }

    public void showVolume() {
        System.out.println(playingDevice.getVolume());
    }

    public void next() {
        playingDevice.next();
    }

    public void prev() {
        playingDevice.prev();
    }

    public void play() {
        System.out.println(playingDevice.play());
    }

    public void testing(int foo) {

    }
}
