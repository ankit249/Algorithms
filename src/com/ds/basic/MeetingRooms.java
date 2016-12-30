package com.ds.basic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MeetingRooms {

	private static int findMeetingRooms(List<MInterval> list) {
		Collections.sort(list, new Comparator<MInterval>() {
			public int compare(MInterval o1, MInterval o2) {
				return o1.start == o2.start ? o1.end - o2.end : o1.start - o2.start;
			}
		});
		System.out.println(list);

		int room = 1;
		int max = room;
		MInterval prev = list.get(0);
		for (int i = 1; i < list.size(); i++) {
			MInterval current = list.get(i);
			if (prev.end > current.start) {
				room++;
			} else {
				room--;
			}
			max = Math.max(max, room);
		}

		return max;
	}

	public static void main(String[] args) {
		List<MInterval> list = new ArrayList<MInterval>();
		list.add(new MInterval(1, 3));
		list.add(new MInterval(5, 7));
		list.add(new MInterval(6, 8));
		list.add(new MInterval(2, 4));
		list.add(new MInterval(1, 8));
		list.add(new MInterval(2, 9));

		System.out.println(findMeetingRooms(list));
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