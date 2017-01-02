package com.ds.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/*
Date 01/07/2016

Given skyline of a city merge the buildings Time complexity is O(nlogn) Space complexity is O(n)
https://www.youtube.com/watch?v=GSBLe8cKu0s

References https://leetcode.com/problems/the-skyline-problem/
https://leetcode.com/discuss/67091/once-for-all-explanation-with-clean-java-code-nlog-time-space
*/
public class SkyLineProblem {

	/**
	 * Represents either start or end of building
	 */
	class BuildingPoint implements Comparable<BuildingPoint> {
		int x;
		boolean isStart;
		int height;

		public int compareTo(BuildingPoint o) {
			// first compare by x.
			// If they are same then use this logic
			// if two starts are compared then higher height building should be picked first
			// if two ends are compared then lower height building should be picked first
			// if one start and end is compared then start should appear before end
			if (this.x != o.x) {
				return this.x - o.x;
			} else {
				return (this.isStart ? -this.height : this.height) - (o.isStart ? -o.height : o.height);
			}
		}

		public String toString() {
			return " [x=" + x + ", height=" + height + ", isStart=" + isStart + "]\n";
		}

	}

	public List<int[]> getSkyline(int[][] buildings) {

		// for all start and end of building put them into List of BuildingPoint
		BuildingPoint[] bp = new BuildingPoint[buildings.length * 2];
		int index = 0;
		for (int building[] : buildings) {
			bp[index] = new BuildingPoint();
			bp[index].x = building[0];
			bp[index].isStart = true;
			bp[index].height = building[2];

			bp[index + 1] = new BuildingPoint();
			bp[index + 1].x = building[1];
			bp[index + 1].isStart = false;
			bp[index + 1].height = building[2];
			index += 2;
		}
		Arrays.sort(bp);

		System.out.println(Arrays.toString(bp));

		// using TreeMap because it gives log time performance.
		// PriorityQueue in java does not support remove(object) operation in log time.
		// TreeMap<Integer, Integer> queue = new TreeMap<>();
		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
		queue.offer(0);

		int prevMaxHeight = 0;
		List<int[]> result = new ArrayList<>();
		for (BuildingPoint buildingPoint : bp) {
			// if it is start of building then add the height to map. If height already exists then increment
			// the value
			if (buildingPoint.isStart) {
				queue.offer(buildingPoint.height);
			} else {
				// if it is end of building then remove the height from heap.
				queue.remove(buildingPoint.height);
			}
			// peek the current height after addition or removal of building x.
			int currentMaxHeight = queue.peek();
			// if height changes from previous height then this building x becomes critcal x.
			// So add it to the result.
			if (prevMaxHeight != currentMaxHeight) {
				result.add(new int[] { buildingPoint.x, currentMaxHeight });
				prevMaxHeight = currentMaxHeight;
			}
		}
		return result;
	}

	public static void main(String args[]) {
		int[][] buildings = { { 1, 3, 4 }, { 3, 4, 4 }, { 2, 6, 2 }, { 8, 11, 4 }, { 7, 9, 3 }, { 10, 11, 2 } };
		SkyLineProblem sd = new SkyLineProblem();
		List<int[]> criticalPoints = sd.getSkyline(buildings);
		criticalPoints.forEach(cp -> System.out.println(cp[0] + " " + cp[1]));

	}
}
