  import java.util.List;

public interface ITelefonbuch {
	
	/**
	 * Fügt einen neuen Mitarbeiter ins Telefonbuch ein.
	 * Gibt false zurück, falls das Einfügen nicht geklappt hat.
	 * @param m
	 * @return
	 */
	public boolean addEintrag(Telefonbucheintrag m);
	
	/**
	 * Gibt die Telefonnumern zu einem Mitarbeiter mit
	 * übergebenem Vor- und Nachnamen
	 * @param nachname
	 * @param vorname
	 * @return
	 */
	public List<String> getNummer(String nachname, String vorname);
	
	/**
	 * Ändert die Telefonnummer eines Mitarbeiters.
	 * Gibt false zurück, falls z.B. der Mitarbeiter nicht
	 * gefunden wurde. 
	 * @param m
	 * @param neueNummer
	 * @return
	 */
	public boolean update(Telefonbucheintrag m, String neueNummer);
	
	/**
	 * Gibt zeilenweise die Telefonbucheinträge aufsteigend 
	 * im folgenden Format aus:
	 * Nachname, Vorname: Telefonnumer
	 * @return
	 */
	public String toString();

}
