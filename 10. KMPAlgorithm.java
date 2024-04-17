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

// Naive Approach
import java.util.*;
public class KMPAlgorithm
{
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

// KMP Approach

import java.util.*;
class Main {
void KMPSearch(String pat, String txt)// O(m+n)
{
	int M = pat.length();
	int N = txt.length();
	if(M > N) {
		System.out.print("Invalid");
		return;
	}

// create lps[] that will hold the longest
// prefix suffix values for pattern
int lps[] = new int[M];
// Preprocess the pattern (calculate lps[]
// array)
computeLPSArray(pat, M, lps); // m
int j = 0; // index for pat[]
int i = 0; // index for txt[]
	
while ((N - i) >= (M - j)) { // n
	if (pat.charAt(j) == txt.charAt(i)) {
		j++;
		i++;
}
if (j == M) {
	System.out.println("Found pattern " + "at index " + (i - j));
	j = lps[j - 1];
}

// mismatch after j matches
else if (i < N && pat.charAt(j) != txt.charAt(i)) {
	// Do not match lps[0..lps[j-1]] characters,
	// they will match anyway
	if (j != 0)
		j = lps[j - 1];
	else
		i = i + 1;
          }
     }
}

void computeLPSArray(String pat, int M, int lps[])
{
	// length of the previous longest prefix suffix
	int len = 0;int i = 1;
	lps[0] = 0; // lps[0] is always 0

	// the loop calculates lps[i] for i = 1 to M-1
	while (i < M) {
		if (pat.charAt(i) == pat.charAt(len)) {
			len++;
			lps[i] = len;
			i++;
		}
		else // (pat[i] != pat[len]) {
			// This is tricky. Consider the example.
			// AAACAAAA and i = 7. The idea is similar
			// to search step.
			if (len != 0) {
				len = lps[len - 1];
				// Also, note that we do not increment
				// i here
			}
			else // if (len == 0) {
				lps[i] = len;
		        i++;
	          }
             }
       }
}

      // Driver code
      public static void main(String args[])
      {
	Scanner s = new Scanner(System.in);
	String txt = s.nextLine();
	String pat = s.nextLine();
	Main obj = new Main();
	obj.KMPSearch(pat, txt);
      }
}
