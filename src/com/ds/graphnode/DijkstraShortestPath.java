package com.ds.graphnode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * E 9 / \ 6 / \ / 2 11 \ F-----C------D 14 | /9 10\ | 15 A------------B 7
 * 
 * graph on the wikipedia :https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm
 */

class Vertex implements Comparable<Vertex> {
	public String name;
	public Edge[] neighbors;
	public Vertex previous;
	public double minDistance = Double.POSITIVE_INFINITY;

	public Vertex(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}

	public int compareTo(Vertex o) {
		return Double.compare(minDistance, o.minDistance);
	}

}

class Edge {
	public Vertex target;
	public double weight;

	public Edge(Vertex target, double weight) {
		this.target = target;
		this.weight = weight;
	}
}

public class DijkstraShortestPath {

	public static void computePaths(Vertex source) {
		source.minDistance = 0.;
		java.util.Queue<Vertex> q = new LinkedList<Vertex>();
		q.offer(source);

		while (!q.isEmpty()) {
			Vertex v = q.poll();

			// Visit each edge exiting v
			for (Edge edge : v.neighbors) {
				Vertex w = edge.target;
				double weight = edge.weight;
				double distancetoedge = v.minDistance + weight;
				if (distancetoedge < w.minDistance) {
					q.remove(w);
					w.minDistance = distancetoedge;
					w.previous = v;
					q.offer(w);
				}
			}
		}
	}

	public static List<Vertex> getShortestPathTo(Vertex target) {
		List<Vertex> result = new ArrayList<Vertex>();
		Vertex current = target;
		while (current != null) {
			result.add(current);
			current = current.previous;
		}

		Collections.reverse(result);
		return result;
	}

	public static void main(String[] args) {
		// mark all the vertices
		Vertex A = new Vertex("A");
		Vertex B = new Vertex("B");
		Vertex C = new Vertex("C");
		Vertex D = new Vertex("D");
		Vertex E = new Vertex("E");
		Vertex F = new Vertex("F");

		// set the edges and weight
		A.neighbors = new Edge[] { new Edge(B, 7), new Edge(C, 9), new Edge(F, 14) };
		B.neighbors = new Edge[] { new Edge(A, 7), new Edge(C, 10), new Edge(D, 15) };
		C.neighbors = new Edge[] { new Edge(A, 9), new Edge(B, 10), new Edge(D, 11), new Edge(F, 2) };
		D.neighbors = new Edge[] { new Edge(B, 15), new Edge(C, 11), new Edge(E, 6) };
		E.neighbors = new Edge[] { new Edge(D, 6), new Edge(F, 9) };
		F.neighbors = new Edge[] { new Edge(A, 14), new Edge(C, 2), new Edge(E, 9) };

		computePaths(A); // run Dijkstra
		System.out.println("Distance from A to D: " + D.minDistance);
		List<Vertex> path = getShortestPathTo(D);

		// computePaths(B); // run Dijkstra
		// System.out.println("Distance from B to E: " + E.minDistance);
		// List<Vertex> path = getShortestPathTo(E);

		System.out.println("Path: " + path);
	}
}
