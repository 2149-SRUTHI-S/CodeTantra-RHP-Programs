/*
Longest Palindromic Substring - Dynamic Pogramming:

    1. Overlaping: s1 - s2
2. Optimal substructure: 0 1 1 2 3 5 8 13-- -- --s0 + s1 - s2
Shortest path:
    a-- --2-- - b--4-- - c - 3— d
longest doesn’ t follow optimal sustructure:
    a-- - 12-- --b-- -- --10-- - c
Problem: if any string is given to me I have to find the longest palindromic substring
Example: str = aaaabbaa-- - 8

Table[length][length]

1. Str[start] === Str[end]
2. Non boundry substring must be a palindrome.

Table[i][i] = Str[Start] == Str[end] && table[i + 1][j - 1]
*/

import java.util.*; // o(n^2)-- O(n) ( only by using 1-D array)

public class Main {
    public static void print(String str, int start, int length) {
        int end = start + length;
        System.out.print(str.substring(start, end));
        System.out.println();
    }

    public static int Solution(String str) {
        int n = str.length();
        boolean table[][] = new boolean[n][n];
        // All one length substrings are already palindrome
        int maxLength = 1;
        for (int i = 0; i < n; i++) {
            table[i][i] = true;
        }

        // check substring of length 2 aabababab
        int start = 0;
        for (int i = 0; i < n - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                table[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }

        }

        // length 3,4,5 or more
        for (int k = 3; k <= n; k++) {
            // Fix the starting index
            for (int i = 0; i < n - k + 1; i++) {
                int j = i + k - 1;
                // check for substring
                if ((table[i + 1][j - 1] == true) && str.charAt(i) == str.charAt(j)) {
                    table[i][j] = true;
                    if (k > maxLength) {
                        start = i;
                        maxLength = k;
                    }
                }
            }
        }

        print(str, start, maxLength);
        return maxLength;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.print(Solution(str));
    }
}
