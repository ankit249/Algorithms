package com.ds.basic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PeekingIterator implements Iterator<Integer> {
	private Integer peek; // cache the next peek
	private Iterator<Integer> iter;

	public PeekingIterator(Iterator<Integer> iterator) {
		// initialize any member here.
		iter = iterator;
		if (iter.hasNext()) {
			peek = iter.next();
		}
	}

	// Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		return peek;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		Integer ret = peek;
		peek = iter.hasNext() ? iter.next() : null;
		return ret;
	}

	@Override
	public boolean hasNext() {
		return peek != null;
	}

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);

		Iterator<Integer> it = list.iterator();
		PeekingIterator peekIterator = new PeekingIterator(it);
		System.out.println(peekIterator.peek());
		while (peekIterator.hasNext()) {
			System.out.println(peekIterator.next());
		}
		System.out.println(peekIterator.peek());
	}
}