
public class CdPlayer implements Device {
	private static int volume=0;

	@Override
	public void louder() {
		// TODO Auto-generated method stub
		System.out.println("volume: "+ ++volume);
		
	}

	@Override
	public void quieter() {
		// TODO Auto-generated method stub
		System.out.println("quieter: " + --volume);
	}

	@Override
	public int getVolume() {
		// TODO Auto-generated method stub
		return volume;
	}

	@Override
	public void next() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void prev() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getInfoText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] getOptions() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void chooseOption(String opt) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String play() {
		// TODO Auto-generated method stub
		return null;
	}

}
