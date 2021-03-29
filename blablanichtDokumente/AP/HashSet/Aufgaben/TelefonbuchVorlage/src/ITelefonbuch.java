  import java.util.List;

public interface ITelefonbuch {
	
	/**
	 * F�gt einen neuen Mitarbeiter ins Telefonbuch ein.
	 * Gibt false zur�ck, falls das Einf�gen nicht geklappt hat.
	 * @param m
	 * @return
	 */
	public boolean addEintrag(Telefonbucheintrag m);
	
	/**
	 * Gibt die Telefonnumern zu einem Mitarbeiter mit
	 * �bergebenem Vor- und Nachnamen
	 * @param nachname
	 * @param vorname
	 * @return
	 */
	public List<String> getNummer(String nachname, String vorname);
	
	/**
	 * �ndert die Telefonnummer eines Mitarbeiters.
	 * Gibt false zur�ck, falls z.B. der Mitarbeiter nicht
	 * gefunden wurde. 
	 * @param m
	 * @param neueNummer
	 * @return
	 */
	public boolean update(Telefonbucheintrag m, String neueNummer);
	
	/**
	 * Gibt zeilenweise die Telefonbucheintr�ge aufsteigend 
	 * im folgenden Format aus:
	 * Nachname, Vorname: Telefonnumer
	 * @return
	 */
	public String toString();

}
