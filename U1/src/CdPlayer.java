import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CdPlayer implements Device {
	private static int volume=0;

	@Override
	public void louder() {
		System.out.println("volume: "+ ++volume);
		
	}

	@Override
	public void quieter() {
		System.out.println("quieter: " + --volume);
	}

	@Override
	public int getVolume() {
		return volume;
	}

	@Override
	public void next() {
		System.out.println("Next title");
	}

	@Override
	public void prev() {
		System.out.println("Prev title");
		
	}

	@Override
	public String getInfoText() {
		return null;
	}

	@Override
	public String[] getOptions() {
		String[] arr = new String[20];
		try {
			Method m[] = Bordcomputer.class.getDeclaredMethods();
			for (int i = 0; i < m.length; i++) {
				arr[i] = m[i].getName();
			}
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
		return arr;
	}

	@Override
	public void chooseOption(String opt) {
		CdPlayer obj = new CdPlayer();
		Method method = null;
		try {
			method = obj.getClass().getDeclaredMethod(opt);
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			method.invoke(obj);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String play() {
		System.out.println("Play");
		return "Play";
	}

}
