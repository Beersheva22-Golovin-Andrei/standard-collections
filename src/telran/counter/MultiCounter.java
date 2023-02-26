package telran.counter;

import java.util.Set;

public interface MultiCounter {
/**
	* @param item
	* @return How many times the item has been added
	* if item is the new one then 1 will be returned
	*/
	Integer addItem(Object item);
	//O[LogN]
	/**
	* @param item
	* @return how many tim
	es a given item has been added
	* if no one then null will be returned
	*/
	Integer getValue(Object item);
	//O[1]
	/**
	* removes item with all counters
	* @param item
	* @return true if item has been removed otherwise false (if a given item doesn't exists)
	*/
	boolean remove(Object item) ;
	//O[LOgN]
	
	Set<Object> getMaxItems();
}
