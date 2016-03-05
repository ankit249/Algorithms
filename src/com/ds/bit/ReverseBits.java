package com.ds.bit;

public class ReverseBits {

	public static int reverseBits(int n) {
		int answer = 0;
		for (int i = 0; i < 32; i++) {
			answer = answer << 1;
			answer = answer | ((n >> i) & 1);
		}
		return answer;
	}

	public static void main(String[] args) {
		System.out.println(reverseBits(964176192));
	}
}
