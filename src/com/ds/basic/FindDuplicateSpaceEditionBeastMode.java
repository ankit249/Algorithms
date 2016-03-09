package com.ds.basic;

public class FindDuplicateSpaceEditionBeastMode {
	public static int findDuplicate(int[] a) {

		final int n = a.length - 1;

		// STEP 1: GET INSIDE A CYCLE
		// start at position n+1 and walk n steps to
		// find a position guaranteed to be in a cycle
		int positionInCycle = n + 1;
		for (int i = 0; i < n; i++) {

			// we subtract 1 from the current position to step ahead:
			// the 2nd /position/ in an array is /index/ 1
			positionInCycle = a[positionInCycle - 1];
		}

		// STEP 2: FIND THE LENGTH OF THE CYCLE
		// find the length of the cycle by remembering a position in the cycle
		// and counting the steps it takes to get back to that position
		int rememberedPositionInCycle = positionInCycle;
		int currentPositionInCycle = a[positionInCycle - 1]; // 1 step ahead
		int cycleStepCount = 1;

		while (currentPositionInCycle != rememberedPositionInCycle) {
			currentPositionInCycle = a[currentPositionInCycle - 1];
			cycleStepCount += 1;
		}

		// STEP 3: FIND THE FIRST NODE OF THE CYCLE
		// start two pointers
		// (1) at position n+1
		// (2) ahead of position n+1 as many steps as the cycle's length
		int pointerStart = n + 1;
		int pointerAhead = n + 1;
		for (int i = 0; i < cycleStepCount; i++) {
			pointerAhead = a[pointerAhead - 1];
		}

		// advance until the pointers are in the same position
		// which is the first node in the cycle
		while (pointerStart != pointerAhead) {
			pointerStart = a[pointerStart - 1];
			pointerAhead = a[pointerAhead - 1];
		}

		// since there are multiple values pointing to the first node
		// in the cycle, its position is a duplicate in our array
		return pointerStart;
	}

	public static void main(String[] args) {
		System.out.println(findDuplicate(new int[] { 6, 5, 4, 3, 2, 1, 6 }));
	}
}
