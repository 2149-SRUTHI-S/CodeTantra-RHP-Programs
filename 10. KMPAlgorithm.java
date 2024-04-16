/*
KMP Algorithm for Pattern Searching
  
Given a string Text[0...N-1] and a Pattern[0...M-1], print all the occurrences of Pattern in Text
Time Complexity --> O(N+M)

Input: 
AABAACAADAABAABA  // Text
AABA             // Pattern

Output:
0 9 12

*/

import java.util.*;
public class KMPAlgorithm
{
    // Naive Approach
    public static void PatternMatching(String text, String pattern) 
    {
        int tlen = text.length(), plen = pattern.length();
	    for(int i = 0; i <= tlen - plen; i++) {
	        if(text.substring(i, i + plen).equals(pattern)) {
	            System.out.print(i + " ");
	        }
	    }
    }
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    String text = sc.next();
	    String pattern = sc.next();
	    PatternMatching(text, pattern);
	}
}
