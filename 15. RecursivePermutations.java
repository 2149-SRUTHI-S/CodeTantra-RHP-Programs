/*
Recusrsive logic to generate all permutation of the string 

Problem Statement :

Ashish was copying from Rahit in the exam. So, Rahit told him to change the answers a little bit so that the 
examiner cannot find the fraud. But silly Ashish in the way started to change all the answers that were needed. 
He shuffled the letters in each word in a way where the maximum number of letters were misplaced.

For a given word, find the maximum difference that Ashish can generate between his answer and Rahit’s answer.
Suppose Rahit wrote “car” for an answer, Ashish can write “acr” with difference 2, or “arc” with differnece 3.
Note That: The letters are all in lowercase.

Input Format:
First line containing an integer n, number of words.
Then, n numbers of lines as the query words.

Output Format:
N number of lines with an integer each denoting possible maximum difference.

Sample Input:
4
abababa
bbj
kj
kk

Sample Output:
6
2
2
0

*/

import java.util.*;
public class Main
{
    public static String swap(String str, int i, int j)
    {
        char s[] = str.toCharArray();
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
        return String.valueOf(s);
    }
    
    public static void permutations(String str, int left, int right, HashSet<String> h)
    {
        if(left == right - 1) {
            h.add(str + " ");
        }
        else {
            for(int i = left; i < right; i++) {
                str = swap(str, left, i);
                permutations(str, left + 1, right, h);
                str = swap(str, left, i);
            }
        }
    }
    
    public static int maximumDiff(String str, String st) // Example: str = "abc"   st = "acb"
    {
        int count = 0;
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) != st.charAt(i))
            count++;
        }
        return count;
    }
    
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    String a[] = new String[t];
	    for(int i = 0; i < t; i++) {
	        a[i] = sc.next();
	    }
	    for(int i = 0; i < t; i++) {
	        HashSet<String> h = new HashSet<>();
	        String str = a[i];
	        permutations(str, 0 , str.length(), h);
	        int max = 0;
	        int result = 0;
	        for(String st : h)
	        {
	            result = maximumDiff(str, st);
	            max = Math.max(max, result);
	        }
	        System.out.println("Maximum Difference : " + max);
	    }
	}
}
