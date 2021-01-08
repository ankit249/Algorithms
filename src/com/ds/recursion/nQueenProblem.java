package com.ds.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class nQueenProblem {

    /*
     * Complete the function below.
     */
    static String[][] find_all_arrangements(int n) {
        List<String[]> result = new ArrayList<>();
        find_all_arrangements(n, 0, result, new int[n]);
        return result.toArray(new String[0][n]);
    }

    static void find_all_arrangements(int size, int i, List<String[]> result, int[] positions) {
        if(i == size) {
            result.add(getArrangement(positions));
            return;
        }

        for(int j = 0; j < size; j++) {
            if(!hasConflict(i, j, positions)) {
                positions[i] = j;
                find_all_arrangements(size, i+1, result, positions);
            }
        }
    }

    static boolean hasConflict(int row, int col, int[] positions) {
        for(int i = row-1, j=1; i>=0; i--, j++) {
            if(positions[i] == col || positions[i] == col-j || positions[i] == col+j){
                return true;
            }
        }
        return  false;
    }

    static String[] getArrangement(int[] positions) {
        String[] arrangement = new String[positions.length];
        char[] row = new char[positions.length];
        Arrays.fill(row, '-');
        for(int i = 0; i < positions.length; i++) {
            row[positions[i]] = 'q';
            arrangement[i] = new String(row);
            row[positions[i]] = '-';
        }
        return arrangement;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(find_all_arrangements(4)));
    }


}
