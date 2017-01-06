package com.ds.math;

import java.awt.Point;
import java.util.HashMap;

// slope : (y2 - y1) / (x2 - x1)
public class MaxPointsOnLineSlope {
	public int maxPoints(Point[] points) {
		if (points == null || points.length == 0) return 0;

		HashMap<Double, Integer> result = new HashMap<Double, Integer>();
		int max = 0;

		for (int i = 0; i < points.length; i++) {
			int duplicate = 1;//
			int vertical = 0;
			for (int j = i + 1; j < points.length; j++) {
				// handle duplicates and vertical
				if (points[i].x == points[j].x) {
					if (points[i].y == points[j].y) {
						duplicate++;
					} else {
						vertical++;
					}
				} else {
					double slope = points[j].y == points[i].y ? 0.0
							: (1.0 * (points[j].y - points[i].y)) / (points[j].x - points[i].x);

					if (result.get(slope) != null) {
						result.put(slope, result.get(slope) + 1);
					} else {
						result.put(slope, 1);
					}
				}
			}

			for (Integer count : result.values()) {
				if (count + duplicate > max) {
					max = count + duplicate;
				}
			}

			max = Math.max(vertical + duplicate, max);
			result.clear();
		}

		return max;
	}
}
