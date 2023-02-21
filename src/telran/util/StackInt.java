package telran.util;

import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class StackInt {

	private LinkedList<Integer> llist;
	private Deque <Integer> maxValues;
	private int currentMax;
	
	
	public StackInt() {
		llist = new LinkedList<>();
		maxValues = new LinkedList<>();
	}

		public void push(int num) {
			if (!llist.isEmpty()) {
				if (num>currentMax) {
					currentMax = num;
					maxValues.offerLast(num);
				}			
			} else {
				maxValues.offerLast(num);
				currentMax = num;
			}			
			llist.add(num);
		}
		public int pop() {
			validate();
			int res = llist.pollLast();
			if (res == currentMax) {
				maxValues.removeLast();
				currentMax = maxValues.peekLast();
			}
			return res;
		}
		
		public boolean isEmpty () {
			return llist.isEmpty();
		}
		public int getMax() {
			validate();
			return currentMax;
		}
		
		private void validate() {
			if (llist.isEmpty()) throw new NoSuchElementException();
			}
}
