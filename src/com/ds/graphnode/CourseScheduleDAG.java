package com.ds.graphnode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class CourseScheduleDAG {

	// representation of the graph in adjacency lists
	private Map<Integer, List<Integer>> neighbors = new HashMap<Integer, List<Integer>>();

	public void addVertex(Integer vertex) {
		neighbors.put(vertex, new ArrayList<Integer>());
	}

	public void addEdge(Integer from, Integer to) {
		neighbors.get(from).add(to);
	}

	// you need to find the inDegree and store it in the map for all the nodes, needed for topological sort
	public Map<Integer, Integer> inDegree() {
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
	public List<Integer> topSort() {
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
	public boolean isCycleDetected() {
		return topSort() == null;
	}

	public String toString() {
		StringBuffer s = new StringBuffer();
		for (Integer v : neighbors.keySet())
			s.append("\n    " + v + " -> " + neighbors.get(v));
		return s.toString();
	}

	public static void main(String[] args) {
		CourseScheduleDAG g = new CourseScheduleDAG();
		// Testcase 1
		int courses = 4;
		int[][] prerequisites = new int[][] { { 1, 0 }, { 2, 0 } };

		// Testcase 2
		// int courses = 2;
		// int[][] prerequisites = new int[][] { { 1, 0 }, { 0, 1 } };

		for (int i = 0; i < courses; i++) {
			g.addVertex(i);
		}
		for (int i = 0; i < prerequisites.length; i++) {
			g.addEdge(prerequisites[i][1], prerequisites[i][0]);
		}

		System.out.println("Graph represntation of the courses: " + g.toString());
		System.out.println("InDegree for this graph for all nodes: " + g.inDegree());
		System.out.println("Topological sort, course needs to be completed in this order: " + g.topSort());
		System.out.println("Can you complete the course? " + !g.isCycleDetected());

	}
}
