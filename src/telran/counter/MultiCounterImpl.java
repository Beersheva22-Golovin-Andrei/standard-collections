package telran.counter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;
import java.util.TreeMap;

public class MultiCounterImpl implements MultiCounter {

	private Map<Object, Integer> counter;
	
	private NavigableMap <Integer, Set<Object>> mapOfcounts;
	
	public MultiCounterImpl () {
		counter = new HashMap<>();
		mapOfcounts = new TreeMap<>();
	}
		
	@Override
	public Integer addItem(Object item) {
		Integer res = counter.get(item);
		if (res == null) {
			counter.put(item, 1);
			res = 1;
		} else {
			counter.put(item, ++res);
		}
		Set<Object> objectSet = null;
		if (!mapOfcounts.isEmpty()) objectSet = mapOfcounts.get(res);
		if (objectSet==null) {
			objectSet = new HashSet<Object>();
			objectSet.add(item);
			mapOfcounts.put(res, objectSet);
		} else {
			objectSet.add(item);
		}
		return res;
	}

	@Override
	public Integer getValue(Object item) {
		return counter.get(item);
	}

	@Override
	public boolean remove(Object item) {
		boolean res = false; 
		Integer removingCounter = counter.remove(item);
		if (removingCounter!=null) {
			Set<Object> set = mapOfcounts.get(removingCounter);
			set.remove(item);
			res =true;
			if (set.isEmpty()) mapOfcounts.remove(removingCounter);
		}
		
		return res;
	}

	@Override
	public Set<Object> getMaxItems() {
		return mapOfcounts.lastEntry().getValue();
	}

}
