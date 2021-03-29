package geschenk;

public enum GeschenkType {
	
	ESSBARES("Essbares"),
	KLEIDUNG("Kleidung"),
	SPIELZEUG("Spielzeug"),
	GESCHENK("Geschenk");
	
	private final String type;
	
	private GeschenkType(String type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return type;
	}

}
