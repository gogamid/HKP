package ZuliefererInterface;

public interface Device {
	public void louder();

	public void quieter();

	public int getVolume();

	public void next();

	public void prev();

	public String getInfoText();

	/*
	 * -das ist eine Methode die alle Optionen als String zurückgibt.
		Optionen sind diejenigen Funktionalitäten, die ein konkretes Device 
		über die im Interface geforderten hinaus zusätzlich anbietet. 
		Über die Auswahl einer solchen Option sollen sie vom 
		User-Interface des Bordcomputers aus ausführbar gemacht werden
	 */
	public String[] getOptions();

	/*
	 * die Methode erwartet einen String. Kann ja nur der Methodenname bzw. der Optionsname sein, der da ankommt. 
	 */
	public void chooseOption(String opt);

	public String play();
}
