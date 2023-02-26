package telran.counter.test;



import static org.junit.Assert.assertArrayEquals;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.counter.MultiCounter;
import telran.counter.MultiCounterImpl;

public class CounterTest {

	MultiCounter mapItems = new MultiCounterImpl();
	
	@BeforeEach
	void setUp() throws Exception {
		
		for (int i = 0; i < 10; i++) {
			mapItems.addItem("object_1");
		}
		for (int i = 0; i < 3; i++) {
			mapItems.addItem("object_2");
		}	
			mapItems.addItem("object_3");	

	}

	@Test
	public void addItemTest() {
		assertEquals(11, mapItems.addItem("object_1"));
		assertEquals(1, mapItems.addItem("object_4"));
	}
	
	@Test
	public void getValueTest() {
		assertEquals(10, mapItems.getValue("object_1"));
		mapItems.addItem("object_1");
		assertEquals(11, mapItems.getValue("object_1"));
		assertEquals(null, mapItems.getValue("object_4"));
	}
	
	@Test
	public void removeItemTest() {
		assertTrue(mapItems.remove("object_1"));
		assertEquals(null, mapItems.getValue("object_1"));
		assertFalse(mapItems.remove("object_4"));
		mapItems.addItem("object_4");
		assertTrue(mapItems.remove("object_4"));
	}
	
	@Test
	public void getMaxItemTest() {
		Set<String> expected = new HashSet<>();
		expected.add("object_1");
		expected.add("object_4");
		for (int i = 0; i < 10; i++) {
			mapItems.addItem("object_4");
		}
		assertArrayEquals(expected.toArray(), mapItems.getMaxItems().toArray());
		
	}
}
