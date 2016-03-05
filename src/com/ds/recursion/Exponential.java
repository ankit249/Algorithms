package com.ds.recursion;

public class Exponential {

	public static int exp(int n, int t) {
		if(n <= 0 || t <= 0 ) return 1;
		if(t == 1) return n;
		return(n * exp(n, t-1));
	}
	
	public static void main(String[] args) {
		for (int i = 0; i < 32; i++) {
			System.out.print(exp(2, i) + " ");
		}
	}
}
