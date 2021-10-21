
public class Bordcomputer {
	private String deviceName;
	private int installedDevices = 1;
	private CdPlayer playingDevice;
	private static int volume = 0;

	private void readConfig() {
		// wtf
	}

	private void setDevices() {
		// wtf
	}

	public void shutdown() {
		System.out.println("Bordcomputer ist aus");

	}

	public void changeDevice() {
		// wtf

	}

	public void louder(int i) {
		volume += i;
	}

	public void quieter(int i) {
		volume -= i;

	}

	public void showVolume() {
		System.out.println("Volume: " + volume);
	}

	public void next() {
		System.out.println("Next title");
	}

	public void prev() {
		System.out.println("previous title");
	}

	public void play() {
		System.out.println("previous title");
	}
}
