import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TelefonbuchTest {
	
	private Telefonbuch buch;
	private Telefonbucheintrag t1;
	private Telefonbucheintrag t2;
	
	@BeforeEach
	public void setUp() {
		buch = new Telefonbuch();
	}
	
	@Test
	public void sameNameDifferentNumbersTest() {
		t1 = new Telefonbucheintrag("a", "A", "1");
		t2 = new Telefonbucheintrag("a", "A", "2");
		buch.addEintrag(t1);
		buch.addEintrag(t2);
		List<String> nummern = buch.getNummer(t1.getNachname(), t1.getVorname());
		assertEquals(2,nummern.size());
		assertTrue(nummern.contains(t1.getTelefonnummer()));
		assertTrue(nummern.contains(t2.getTelefonnummer()));
	}
	
	@Test
	public void correctUpdate() {
		t1 = new Telefonbucheintrag("a", "A", "1");
		t2 = new Telefonbucheintrag("a", "A", "2");
		buch.addEintrag(t1);
		buch.addEintrag(t2);
		buch.update(t1, "3");
		List<String> nummern = buch.getNummer(t1.getNachname(), t1.getVorname());
		assertEquals(2, nummern.size());
		assertTrue(nummern.contains("2"));
		assertTrue(nummern.contains("3"));
	}
	
	@Test
	public void correctToString() {
		t1 = new Telefonbucheintrag("a", "A", "1");
		t2 = new Telefonbucheintrag("b", "B", "1");
		buch.addEintrag(t2);
		buch.addEintrag(t1);
		String s = buch.toString();
		String[] lines = s.split("\n");
		assertEquals(2, lines.length);
		assertEquals(t1.getNachname()+", " + t1.getVorname() + ": " +t1.getTelefonnummer(), lines[0]);
		assertEquals(t2.getNachname()+", " + t2.getVorname() + ": " +t2.getTelefonnummer(), lines[1]);
	}
	
	@Test
	public void correctStringEmptyBook() {
		String s = buch.toString();
		assertTrue(s.isEmpty());
	}
	
	@Test
	public void correctOrder() {
		t1 = new Telefonbucheintrag("A", "a", "1");
		t2 = new Telefonbucheintrag("B", "b", "2");
		Telefonbucheintrag t3 = new Telefonbucheintrag("A", "a", "3");
		Telefonbucheintrag t4 = new Telefonbucheintrag("C", "c", "1");
		buch.addEintrag(t4);
		buch.addEintrag(t3);
		buch.addEintrag(t2);
		buch.addEintrag(t1);
		String s = buch.toString();
		String[] lines = s.split("\n");
		assertEquals(t1.getNachname()+", " + t1.getVorname() + ": " +t1.getTelefonnummer(), lines[0]);
		assertEquals(t3.getNachname()+", " + t3.getVorname() + ": " +t3.getTelefonnummer(), lines[1]);
		assertEquals(t2.getNachname()+", " + t2.getVorname() + ": " +t2.getTelefonnummer(), lines[2]);
		assertEquals(t4.getNachname()+", " + t4.getVorname() + ": " +t4.getTelefonnummer(), lines[3]);
	}

}
