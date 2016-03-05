package com.ds.bit;

public class BitCount {

	// count number of 1's in a bit
    public static int countBits(byte num) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            if ((num & 1) == 1) // check if right most bit is 1
            {
                count++;
            }
            num = (byte)(num >>> 1); // shit right 1 bit, including the sign bit
        }
        return count;
    }

	// if you want to count number of 1's in a byte
	public static int countTotalBits(byte[] arr) {
		int count = 0;
		for (byte b : arr) {
			count = count + countBits(b);
		}
		return count;
	}

	public static void main(String args[]) {

		byte[] arr = new byte[] { 7, 6, 5 };

		byte b = -7;
		System.out.println(countBits(b));

		System.out.println(countTotalBits(arr));
    }
}