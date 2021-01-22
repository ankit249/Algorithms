package com.ds.graphnode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/*

https://leetcode.com/problems/course-schedule-ii/

1. Clarity
---------
courses --> node
pairs -> edges so this implies graph problems

2. Algo
-------

Graph - No Construction
Traverse - Not undirected, its directed because its one way
so for directed - bfs, dfs, toposort
THis one is TOPO SOrt becuase dependencies, here you also have to find sequence and thats why toposort
-- if the question is how many pre-requisites - that can be solved with BFS/DFS



 0
 1 - 0
 2 - 0
 3 - 1, 2

3.

TC - // TC  O(N+E)


 */

// TC  O(N+E)
public class CourseScheduleDAG {

	// representation of the graph in adjacency lists
	private static Map<Integer, List<Integer>> neighbors = new HashMap<Integer, List<Integer>>();

	public static void addVertex(Integer vertex) {
		neighbors.put(vertex, new ArrayList<Integer>());
	}

	public static void addEdge(Integer from, Integer to) {
		neighbors.get(from).add(to);
	}

	// you need to find the inDegree and store it in the map for all the nodes, needed for topological sort
	public static Map<Integer, Integer> inDegree() {
		Map<Integer, Integer> result = new HashMap<Integer, Integer>();
		for (Integer v : neighbors.keySet()) {
			result.put(v, 0);
		}

		for (Integer from : neighbors.keySet()) {
			for (Integer to : neighbors.get(from)) {
				result.put(to, result.get(to) + 1);
			}
		}

		return result;
	}

	// topological sort
	public static List<Integer> topSort() {
		Map<Integer, Integer> in_deg = inDegree();
		List<Integer> result = new ArrayList<Integer>();
		Stack<Integer> stack = new Stack<Integer>();
		for (Integer v : neighbors.keySet()) {
			if (in_deg.get(v) == 0) {
				stack.push(v);
			}
		}

		while (!stack.isEmpty()) {
			Integer element = stack.pop();
			result.add(element);
			for (Integer v : neighbors.get(element)) {
				in_deg.put(v, in_deg.get(v) - 1);
				if (in_deg.get(v) == 0) {
					stack.push(v);
				}
			}
		}

		// this condition means no cycle
		if (result.size() != neighbors.size()) {
			return null;
		}

		return result;
	}

	// if cycle is detected
	public static boolean isCycleDetected() {
		return topSort() == null;
	}


	public static String printGraph() {
		StringBuffer s = new StringBuffer();
		for (Integer v : neighbors.keySet())
			s.append("\n    " + v + " -> " + neighbors.get(v));
		return s.toString();
	}

	public static void main(String[] args) {
		// CourseScheduleDAG g = new CourseScheduleDAG();
		// Testcase 1
		//int courses = 4;
		//int[][] prerequisites = new int[][] { { 1, 0 }, { 2, 0 } };

		// Testcase 2
		// int courses = 2;
		// int[][] prerequisites = new int[][] { { 1, 0 }, { 0, 1 } };

		// Testcase 3
		int courses = 4;
		int[][] prerequisites = new int[][] { { 1,0 }, { 2,0 }, {3, 1}, {3, 2} };



		for (int i = 0; i < courses; i++) {
			addVertex(i);
		}
		for (int i = 0; i < prerequisites.length; i++) {
			addEdge(prerequisites[i][1], prerequisites[i][0]);
		}

		System.out.println("Graph represntation of the courses: " + printGraph());
		System.out.println("InDegree for this graph for all nodes: " + inDegree());
		System.out.println("Topological sort, course needs to be completed in this order: " + topSort());
		System.out.println("Can you complete the course? " + !isCycleDetected());

	}
}
