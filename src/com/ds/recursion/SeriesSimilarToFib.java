package com.ds.recursion;

public class SeriesSimilarToFib {

    private static int series(int n) {
        int a = 0;
        int b = 2;
        return seriesHeler(n, b, a + b);
    }

    private static int seriesHeler(int n, int a, int b) {
        if(n == 0) return 0;
        if(n == 1) return b;
        return seriesHeler(n - 1 , b, a + b);
    }

    public static void main(String[] args) {
        // series 2, 4, 6, 10, 16.....
        // index  0, 1, 2, 3,  4
        for(int i = 0; i < 10; i++) {
            System.out.println(series(i));
        }
    }
}
