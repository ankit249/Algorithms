package com.ds.basic;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MultiIterator<T> implements Iterator<T> {

	private T next;
	private boolean hasNext = true;

	private Iterator<Collection<T>> it;
	private Iterator<T> innerIt;


	public MultiIterator(Collection<Collection<T>> collections) {
		it = collections.iterator();
		prepareNext();
	}

	private void prepareNext() {
		do {
			if (innerIt == null || !innerIt.hasNext()) {
				if (!it.hasNext()) {
					hasNext = false;
					return;
				} else
					innerIt = it.next().iterator();
			}
		} while (!innerIt.hasNext());

		next = innerIt.next();
	}

	@Override
	public boolean hasNext() {
		return hasNext;
	}

	@Override
	public T next() {
		if (!hasNext)
			throw new NoSuchElementException();
		T res = next;
		prepareNext();
		return res;
	}


}