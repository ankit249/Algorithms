package com.ds.basic;

import java.util.Random;

public class RandomNplet {

	public static int randInt(int min, int max) {
		Random rand = new Random();
		// nextInt is normally exclusive of the top value, so add 1 to make it inclusive
		int randomNum = rand.nextInt((max - min) + 1) + min;
		return randomNum;
	}

	// second argument of this function dertermines duplex, tripplets, quadrupplets etc.
	public static String getRandomNlets(int length, int nPlate) {
		String index = "";
		int current_num = -1;
		for (int i = nPlate; i > 0; i--) {
			current_num = randInt(current_num + 1, length - i);
			index = index + current_num;
		}

		return index;
	}

	public static void main(String[] args) {

		String input = "Helloworld";
		String index = getRandomNlets(input.length(), 3);
		System.out.println(index);
		String result = "";
		for (int i = 0; i < index.length(); i++) {
			String char_index = String.valueOf(index.charAt(i));
			result = result + input.charAt(Integer.valueOf(char_index));
		}

		System.out.println(result);
	}
}
