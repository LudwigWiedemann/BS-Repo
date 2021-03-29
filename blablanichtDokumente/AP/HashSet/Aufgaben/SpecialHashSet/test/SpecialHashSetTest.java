import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SpecialHashSetTest {
	
	@Test
	public void durchschnittTest() {
		SpecialHashSet<Integer> eins = new SpecialHashSet<Integer>(4);
		SpecialHashSet<Integer> zwei = new SpecialHashSet<Integer>(4);
		eins.add(5);
		eins.add(6);
		eins.add(3);
		eins.add(4);
		
		zwei.add(3);
		zwei.add(4);
		zwei.add(5);
		zwei.add(6);
		SpecialHashSet<?> drei = eins.duchschnitt(zwei); 
		assertEquals(eins, drei);
		}
	@Test
	public void vereinigungTest() {
		SpecialHashSet<Integer> eins = new SpecialHashSet<Integer>(4);
		SpecialHashSet<Integer> zwei = new SpecialHashSet<Integer>(4);
		eins.add(1);
		eins.add(2);
		eins.add(3);
		eins.add(4);
		
		zwei.add(7);
		zwei.add(8);
		zwei.add(5);
		zwei.add(6);
		SpecialHashSet<?> drei = eins.vereinigung(zwei); 
		assertEquals(8, drei.size());
		}

}
