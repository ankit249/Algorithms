package com.ds.bit;

/*
Using Bit Magic: The idea is based on the concept that 
if we AND a bit sequence with a shifted version of itself, 
we’re effectively removing the trailing 1 from every sequence of consecutive 1s.

      11101111   (x)
    & 11011110   (x << 1)
    ----------
      11001110   (x & (x << 1)) 
        ^    ^
        |    |
   trailing 1 removed
So the operation x = (x & (x << 1)) reduces length of every sequence of 1s by one in 
binary representation of x. If we keep doing this operation in a loop, we end up with x = 0. 
The number of iterations required to reach 0 is actually length of the longest consecutive 
sequence of 1s.
*/
public class LengthOfConsecutive1InBinary {

	public static int maxLengthOfConsecutiveOnes(int n) {
		int count = 0;
		while (n != 0) {
			n = n & (n << 1);
			count++;
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(maxLengthOfConsecutiveOnes(14)); // 3
		System.out.println(maxLengthOfConsecutiveOnes(13)); // 2
	}
}
