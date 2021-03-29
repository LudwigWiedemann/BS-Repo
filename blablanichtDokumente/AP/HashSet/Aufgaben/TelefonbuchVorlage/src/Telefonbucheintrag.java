
import java.util.ArrayList;

public class Telefonbucheintrag implements Comparable<Telefonbucheintrag>{
	
	private String vorname, nachname, telefonnummer;
	private Telefonbucheintrag links, rechts = null;

	public Telefonbucheintrag(String vorname, String nachname, String telefonnummer) {
		this.vorname = vorname;
		this.nachname = nachname;
		this.telefonnummer = telefonnummer;
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getTelefonnummer() {
		return telefonnummer;
	}

	public void setTelefonnummer(String telefonnummer) {
		this.telefonnummer = telefonnummer;
	}
	
	public Telefonbucheintrag getRechts() {
		return rechts;
	}
	
	public void setRechts(Telefonbucheintrag t) {
		rechts = t;
	}
	
	public Telefonbucheintrag getLinks() {
		return links;
	}
	
	public void setLinks(Telefonbucheintrag t) {
		links = t;
	}
	
	
	
	public boolean nachfolgerEinfuegen(Telefonbucheintrag t) {
		if(this.compareTo(t) < 0) {
			return nachRechtsEinfuegen(t);
		}
		if(this.compareTo(t) > 0) {
			return nachLinksEinfuegen(t);
		}
		return false;
	}

		private boolean nachRechtsEinfuegen(Telefonbucheintrag t) {
			if(getRechts() == null) {
				setRechts(t);
				return true;
			}
			return getRechts().nachfolgerEinfuegen(t);
		}
		
		private boolean nachLinksEinfuegen(Telefonbucheintrag t) {
			if(getLinks() == null) {
				setLinks(t);
				return true;
			}
			return getLinks().nachfolgerEinfuegen(t);
		}
		
	
	public ArrayList<String> sucheAlleNummernMitName(String nachname, String vorname) {
			
		ArrayList<String> temp = new ArrayList<String>();
			
		if(hatDiesenNamen(nachname, vorname)) {
			temp.add(telefonnummer);
		}
			
		if(rechts != null)
			temp.addAll(rechts.sucheAlleNummernMitName(nachname, vorname));
			
		if(links != null)
			temp.addAll(links.sucheAlleNummernMitName(nachname, vorname));
			
			return temp;
		}
	
	public boolean setTelefonnummer(Telefonbucheintrag m, String neueNummer) {
		if(this.compareTo(m) == 0) {
			this.setTelefonnummer(neueNummer);
			return true;
		}
		if(this.compareTo(m) < 0) {
			if(rechts != null) {
				return getRechts().setTelefonnummer(m, neueNummer);
			}
			return false;
		}
		if(this.compareTo(m) > 0) {
			if(links != null) {
				return getLinks().setTelefonnummer(m, neueNummer);
			}
			return false;
		}
		return false;
	}
		
		
		
	
	@Override
	public int compareTo(Telefonbucheintrag o) {
		int comp;
		comp = this.getNachname().compareTo(o.getNachname());
		
		if(comp == 0) 
			comp = this.getVorname().compareTo(o.getVorname());
			
		if(comp == 0) 
				comp = this.getTelefonnummer().compareTo(o.getTelefonnummer());
		
		
		if(comp == 0) return 0;
		if(comp > 0) return 1;
		if(comp < 0) return -1;
		
		return -4;
		}
	
	public Telefonbucheintrag compareToAndReturnRechtsLinks(Telefonbucheintrag o) {
		int comp;
		comp = this.getNachname().compareTo(o.getNachname());
		
		if(comp == 0) 
			comp = this.getVorname().compareTo(o.getVorname());
			
		if(comp == 0) 
				comp = this.getTelefonnummer().compareTo(o.getTelefonnummer());
		
		
		if(comp == 0) return null;
		if(comp > 0) return getRechts();
		if(comp < 0) return getLinks();
		
		return null;
		}
			
	
	@Override
	public String toString() {
		return "Nachname: " + nachname + " Vorname: " + vorname + " Telefonnummer: " + telefonnummer;
	}

	
	private boolean hatDiesenNamen(String nachname, String vorname) {
	return (getNachname() == nachname && getVorname() ==  vorname);
	}

	public String printTree() {
		StringBuilder tempStr = new StringBuilder();
		tempStr.append(this.toString() + "\n");
		if( links!= null)
			tempStr.append(links.printTree());
		if( rechts!= null)
			tempStr.append(rechts.printTree());
		return tempStr.toString();
	}

	
	
	
	
	
}