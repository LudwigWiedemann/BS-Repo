import java.util.Collection;
import java.util.HashSet;

public class SpecialHashSet<T> extends HashSet<T> {

	int maximaleAnzahl; 
	
	
	public SpecialHashSet(int maxLaenge) {
		super(maxLaenge);
		this.maximaleAnzahl = maxLaenge;
	}
	
	@Override
	public boolean add(T elem) {
		if (maximaleAnzahl >= size()) {
			return super.add(elem);
			}
		else {
			return false;
		}
	}
	
	@Override
	public boolean addAll(Collection<? extends T> c) {
		boolean changed = false;
		for(T element: c) {
			if(size()>= maximaleAnzahl) {
				break;
			}
			changed = changed | add(element);
			
		}
		return changed;
	}
	
	public SpecialHashSet duchschnitt(SpecialHashSet<T> menge) {
		int min = size();
		int durchschnitt = 0;
		
		if(menge.size() > size()) {
			min = menge.size();
		}
		
		SpecialHashSet<T> temp = new SpecialHashSet<T>(min);
		
		for(T elem : this) {
			if(menge.contains(elem)) {
				temp.add(elem);
				durchschnitt ++;
			}
		}
		
		SpecialHashSet<T> durchschnittSet = new SpecialHashSet(durchschnitt);
		durchschnittSet.addAll(temp);
		
		return durchschnittSet;
	}
	
	public SpecialHashSet vereinigung(SpecialHashSet<T> menge) {
		
		SpecialHashSet<T> ergebnis = new SpecialHashSet<T>(size() + menge.size());
		ergebnis.addAll(this);
		ergebnis.addAll(menge);
		ergebnis.maximaleAnzahl = ergebnis.size();
		
		return ergebnis;
		
	}
}