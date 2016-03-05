package com.ds.bit;

/**
 * Given a (decimal - e.g. 3.72) number that is passed in as a string, print the binary rep- resentation. If the number
 * can not be represented accurately in binary, print �ERROR�
 */
// http://cs.furman.edu/digitaldomain/more/ch6/dec_frac_to_bin.htm
public class BinaryFraction {

	public static String convert(String fraction) {
		int intpart = Integer.parseInt(fraction.substring(0, fraction.indexOf(".")));
		double decimalpart = Double.parseDouble(fraction.substring(fraction.indexOf("."), fraction.length()));

		String result = toBinary(intpart) + "." + toBinary(decimalpart);
		return result;
	}

	public static void main(String[] args) {
		System.out.println(convert("18.75"));
	}

	public static String toBinary(double decimal) {

		StringBuffer sb = new StringBuffer();

		while (decimal > 0) {
			if (sb.length() > 32) {
				return "ERROR";
			}
			if (decimal == 1) {
				sb.append((int) decimal);
				break;
			}

			double r = decimal * 2;
			if (r > 1) {
				sb.append(1);
				decimal = r - 1;
			} else {
				sb.append(0);
				decimal = r;
			}
		}

		return sb.toString();
	}

	public static String toBinary(int number) {
		String s = "";

		while (number != 0) {
			int r = number % 2;
			s = r + s;
			number = number / 2;
		}

		return s;
	}


	public static String toBinary_1(int number) {
		String s = "";
		while (number != 0) {
			int r = number % 2;
			s = r + s;
			number = number >> 1;

		}

		return s;
	}
}
