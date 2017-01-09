package com.ds.heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MeetingRooms {

	private static int findMeetingRooms(List<MInterval> list) {
		Collections.sort(list, new Comparator<MInterval>() {
			public int compare(MInterval o1, MInterval o2) {
				return o1.start == o2.start ? o1.end - o2.end : o1.start - o2.start;
			}
		});
		System.out.println("Sorted meeting list: " + list);

		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		int count = 1;
		queue.offer(list.get(0).end);

		// remove it since in the queue, if it was array start the i loop from 1.
		list.remove(0);

		for (MInterval interval : list) {
			if (interval.start < queue.peek()) {
				count++;
			} else {
				queue.poll();
			}
			queue.offer(interval.end);
		}

		return count;
	}

	public static boolean canOneAttendAllMeetings(List<MInterval> list) {

		Collections.sort(list, new Comparator<MInterval>() {
			public int compare(MInterval o1, MInterval o2) {
				return o1.start == o2.start ? o1.end - o2.end : o1.start - o2.start;
			}
		});
		System.out.println("Sorted meeting list: " + list);

		MInterval prev = list.get(0);
		for (int i = 1; i < list.size(); i++) {
			MInterval current = list.get(i);
			if (prev.end > current.start) {
				return false;
			}
			prev = current;
		}
		return true;
	}

	public static void main(String[] args) {
		List<MInterval> list = new ArrayList<MInterval>();
		list.add(new MInterval(1, 3));
		list.add(new MInterval(5, 7));
		list.add(new MInterval(6, 8));
		list.add(new MInterval(4, 7));
		list.add(new MInterval(2, 4));
		list.add(new MInterval(1, 8));
		list.add(new MInterval(2, 9));

		System.out.println("No. of Meeting Roooms needed: " + findMeetingRooms(list));
		System.out.println("Can one person attend all the meetings ? " + canOneAttendAllMeetings(list));

		list = new ArrayList<MInterval>();
		list.add(new MInterval(1, 3));
		list.add(new MInterval(5, 7));
		list.add(new MInterval(6, 8));

		System.out.println("No. of Meeting Roooms needed: " + findMeetingRooms(list));
		System.out.println("Can one person attend all the meetings ? " + canOneAttendAllMeetings(list));
	}
}

class MInterval {
	int start;
	int end;

	MInterval(int start, int end) {
		this.start = start;
		this.end = end;
	}

	public String toString() {
		return "[" + start + "," + end + "]";
	}

}