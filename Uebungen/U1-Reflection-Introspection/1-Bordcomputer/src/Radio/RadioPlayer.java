package Radio;

import hersteller.Device;

import java.lang.reflect.Method;

public class RadioPlayer implements Device {
    String[] tracks = {"A", "B", "C", "D"};
    int volume = 0;
    @Override
    public void louder() {
        volume++;
    }

    @Override
    public void quieter() {
        volume--;
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void next() {
        System.out.println("Next radio channel");

    }

    @Override
    public void prev() {
        System.out.println("Prev radio channel");
    }

    @Override
    public String getInfoText() {
        return "RadioFm";
    }

    @Override
    public String[] getOptions() {
        int c = this.getClass().getDeclaredMethods().length;
        String[] options = new String[c];
        for (int i = 0; i < c; i++) {
            options[i] = this.getClass().getDeclaredMethods()[i].getName();
        }
        return options;
    }

    @Override
    public void chooseOption(int opt) {
        System.out.println(this.getClass().getDeclaredMethods()[opt].getName());
    }

    @Override
    public String play() {
        return "RockNRoll";
    }
}
