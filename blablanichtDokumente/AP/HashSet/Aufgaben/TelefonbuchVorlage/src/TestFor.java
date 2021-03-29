import java.util.LinkedList;

class Mensch{
	String name = "mensch";
}

class Mann extends Mensch{
	String name = "mann";
}

class Frau extends Mensch{
	String name = "frau";
}

class TestFor {
	
	
	
	
	
	public static void main(String[] args) {
		LinkedList<Mann> lauefer = new LinkedList<Mann>();
		LinkedList<Frau> laeuferinnen = new LinkedList<Frau>();
		LinkedList<Mensch> alle = new LinkedList<Mensch>();
		Mann frau = new Mann();
		alle.add(frau);
		TestFor t = new TestFor();
		
		t.listeAusgeben(alle);
		
		
	}
	
	void listeAusgeben(LinkedList<Mensch> liste){
		for(Mensch i : liste){
		System.out.println(i);
		}
	}
}