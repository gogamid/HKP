package radioZulieferer;


import ZuliefererInterface.Device;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

public class Radio implements Device {
    private int volume = 0;
    private final double minFrequency = 80.00;
    private final double maxFrequency = 120.00;
    private double currentFrequency;
    private String type = "UKW";

    @Override
    public void louder() {
        if (volume < 100) {
            volume++;
        }
    }

    @Override
    public void quieter() {
        if (volume > 0) {
            volume--;
        }
    }

    @Override
    public int getVolume() {
        return volume;
    }

    @Override
    public void next() {
        if (currentFrequency < maxFrequency) {
            currentFrequency++;
        } else {
            currentFrequency = minFrequency;
        }
    }

    @Override
    public void prev() {
        if (currentFrequency > minFrequency) {
            currentFrequency--;
        } else {
            currentFrequency = maxFrequency;
        }
    }

    private String extractCurrentPlayingSongTitle() {
        return "Highway To Hell";
    }

    @Override
    public String getInfoText() {
        return extractCurrentPlayingSongTitle();
    }

    @Override
    public String[] getOptions() {
        Method[] m = this.getClass().getDeclaredMethods();
        ArrayList<String> options = new ArrayList<>();
        for (int i = 0, j = 0; i < m.length; i++, j++) {
            if (Modifier.isPublic(m[i].getModifiers())) {
                options.add(m[i].getName());
            } else {
                j--;
            }
        }
        return options.toArray(new String[0]);
    }

    @Override
    public void chooseOption(String opt) {
        try {
            Object calledMethodResponseObj = this.getClass().getMethod(opt).invoke(this);
            if (calledMethodResponseObj instanceof Number || calledMethodResponseObj instanceof String) {
                String response = calledMethodResponseObj.toString();
                if (response != null) {
                    System.out.println(response);
                }
            }
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String play() {
        return "Start playing";
    }

    public String stop() {
        return "Stop playing";
    }

    public void setUKW() {
        type = "UKW";
    }

    public void setLW() {
        type = "LW";
    }

    public double getCurrentFrequency() {
        return currentFrequency;
    }
}
