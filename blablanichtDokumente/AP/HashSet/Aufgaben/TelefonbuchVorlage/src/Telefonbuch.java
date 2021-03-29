
import java.util.ArrayList;

public class Telefonbuch implements ITelefonbuch{
	
	private Telefonbucheintrag erster = null;

	@Override
	public boolean addEintrag(Telefonbucheintrag t) {
		
		if(erster == null) {
			erster = t;
			return true;
		}
		
		return erster.nachfolgerEinfuegen(t);
		
		
		
	}

	@Override
	public ArrayList<String> getNummer(String nachname, String vorname) {
		ArrayList<String> nummern = new ArrayList<String>();
		nummern.addAll(erster.sucheAlleNummernMitName(nachname,vorname));
		return nummern;
	}

	@Override
	public boolean update(Telefonbucheintrag m, String neueNummer) {
		return erster.setTelefonnummer(m, neueNummer);
		
	}
	
	@Override
	public String toString() {
		StringBuilder bld = new StringBuilder();
		bld.append(erster.printTree());
		return bld.toString();
	}
	
	public Telefonbucheintrag getErster() {
		return erster;
	}

}
