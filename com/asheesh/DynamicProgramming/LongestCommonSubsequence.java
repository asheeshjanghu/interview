package com.asheesh.DynamicProgramming;

import java.io.IOException;
import java.util.Scanner;

public class LongestCommonSubsequence {

    // LCS algorithm implementation
    private static int lcs(String s1, String s2) {
        int n1 = s1.length()+1;
        int n2 = s2.length()+1;

        // this array will store the longest subsequence length for each index
        int [][] lcsArr = new int[n1][n2];   // n1+1 because we will use first row and first column for filling with 0

        // init first row with 0
        for (int i = 0; i < n1; i++) {
            lcsArr[i][0] = 0;
        }

        // init first column with 0
        for (int i = 0; i < n2; i++) {
            lcsArr[0][i] = 0;
        }

        // fill the remaining arr using LCS algo
        for (int i = 1; i < n1; i++) {
            for (int j = 1; j < n2; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)) {
                    lcsArr[i][j] = lcsArr[i-1][j-1] + 1; // add 1 to the lcsArr until this character excluding it
                } else {
                    lcsArr[i][j] = Math.max(lcsArr[i][j-1], lcsArr[i-1][j]);  // max of prev row or column
                }
            }
        }
        return lcsArr[n1-1][n2-1]; // max length is at the end of the lcsArr
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();

        int result = lcs(s1, s2);
        System.out.println(result);

        scanner.close();
    }

}
