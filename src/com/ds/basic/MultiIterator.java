package com.ds.basic;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class MultiIterator implements Iterator<Integer> {

	List<Iterator<Integer>> listIterator = new LinkedList<Iterator<Integer>>();
	Iterator<Integer> current = null;

	public MultiIterator(Iterator<Iterator<Integer>> iterator) {
		// copy the iterators into a list
		while (iterator.hasNext()) {
			listIterator.add(iterator.next());
		}
	}

	@Override
	public boolean hasNext() {
		boolean result = false;
		if (listIterator.isEmpty() && (current == null || !current.hasNext())) {
			return false;
		}

		if (current == null) {
			current = listIterator.remove(0);
		}

		while (!current.hasNext() && !listIterator.isEmpty()) {
			current = listIterator.remove(0);
		}

		if (current.hasNext()) {
			result = true;
		}
		return result;
	}

	@Override
	public Integer next() {
		if (current == null) {
			try {
				current = listIterator.remove(0);
			} catch (IndexOutOfBoundsException e) {
				throw new NoSuchElementException();
			}
		}
		Integer result = current.next(); // if this method was called without checking 'hasNext' this line might raise
											// NoSuchElementException which is fine
		listIterator.add(current);
		current = listIterator.remove(0);
		return result;
	}

	// test
	public static void main(String[] args) {
		List<Integer> a = new LinkedList<>();
		a.add(1);
		a.add(7);
		a.add(13);
		a.add(17);
		List<Integer> b = new LinkedList<>();
		b.add(2);
		b.add(8);
		b.add(14);
		b.add(18);
		List<Integer> c = new LinkedList<>();
		c.add(3);
		c.add(9);
		List<Integer> d = new LinkedList<>();
		d.add(4);
		d.add(10);
		d.add(15);
		List<Integer> e = new LinkedList<>();
		e.add(5);
		e.add(11);
		List<Integer> f = new LinkedList<>();
		f.add(6);
		f.add(12);
		f.add(16);
		f.add(19);
		List<Iterator<Integer>> list = new LinkedList<Iterator<Integer>>();
		list.add(a.iterator());
		list.add(b.iterator());
		list.add(c.iterator());
		list.add(d.iterator());
		list.add(e.iterator());
		list.add(f.iterator());
		MultiIterator multiIterator = new MultiIterator(list.iterator());
		while (multiIterator.hasNext()) {
			System.out.print(multiIterator.next() + ","); // prints: 1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,
		}
	}
}
