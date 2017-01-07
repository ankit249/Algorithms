package com.ds.graphnode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
/*
Given a list of airline tickets represented by pairs of departure and arrival airports [from, to],
reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. 
Thus, the itinerary must begin with JFK.

This is an application of Hierholzer’s algorithm to find a Eulerian path.
PriorityQueue should be used instead of TreeSet, because there are duplicate entries.
*/

public class ReconstructIternaryEulerianPath {
	Map<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
	List<String> result = new ArrayList<String>();

	public List<String> findItinerary(String[][] tickets) {
		for (String[] ticket : tickets) {
			if (!map.containsKey(ticket[0])) {
				map.put(ticket[0], new PriorityQueue<String>());
			}
			map.get(ticket[0]).offer(ticket[1]);
		}

		dfs("JFK");
		return result;
	}

	public void dfs(String s) {
		PriorityQueue<String> q = map.get(s);
		result.add(s);

		while (q != null && !q.isEmpty()) {
			String item = q.poll();
			dfs(item);
		}

	}
	
	public static void main(String[] args) {
		ReconstructIternaryEulerianPath Obj = new ReconstructIternaryEulerianPath();
		String[][] tickets = { { "JFK", "ADL" }, { "MUM", "AHM" }, { "SFO", "MUM" }, { "MUM", "SJC" }, { "SJC", "JFK" },
				{ "JFK", "SFO" } };
		System.out.println(Obj.findItinerary(tickets));

	}
}
