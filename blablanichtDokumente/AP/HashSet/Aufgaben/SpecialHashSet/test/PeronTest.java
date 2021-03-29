import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PeronTest {
	
	private final Person p1 = new Person("A", "a");
	
	@Test
	public void noDuplicatePeronsInSet() {
		SpecialHashSet<Person> set = new SpecialHashSet<Person>(2);
		Person p2 = new Person("A", "a");
		set.add(p1);
		set.add(p2);
		assertEquals(1, set.size());
	}
	
	@Test
	public void noMoreElementsThanMaximum() {
		SpecialHashSet<Person> set = new SpecialHashSet<Person>(1);
		Person p2 = new Person("B", "b");
		set.add(p1);
		set.add(p2);
		assertEquals(1, set.size());
		assertTrue(set.contains(p1));
		assertFalse(set.contains(p2));
	}

}
