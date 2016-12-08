package com.ds.bit;

public class SwapBitsOddEven {

	public static void main(String[] args) {
		// testcase 1
		int x = 8; // 1000 will become 0100 (after exchanging bits)
		System.out.println("result is: " + swapbits(x));

		// testcase 2
		x = 16;
		System.out.println("result is: " + swapbits(x));
	}

	private static int swapbits(int x) {
		// Get all even bits of x
		int even_bits = x & 0xAAAAAAAA;

		// Get all odd bits of x
		int odd_bits = x & 0x55555555;

		even_bits = even_bits >> 1; // Right shift even bits
		odd_bits = odd_bits << 1; // Left shift odd bits

		return (even_bits | odd_bits); // Combine even and odd bits

	}
}
