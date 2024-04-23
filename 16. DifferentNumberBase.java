/*
Here is about to introduce a new kind of number system. Where instead of 10 digits there is 20, from a to t, 
all in small. Now a means 1, b means 2 and t means 20, thenn aa means 21. Now for a new number you have to print 
the decimal form it.

Note that the letters in the input string will be lower case and from a to t.

Input Format:
Single line containing the string of new number system’s number

Output Format:
Single line denoting the integer with the same decimal value as the input string

Sample input 1: e
Sample Output: 5

Sample Input 2: ac
Sample Output: 23 

*/

import java.util.*;
public class Main
{
    public static int differentNumberBase(String str, int i, int n) // str = "ac" i = 2 n = -1
    {
        // Base condition
        if(n < 0) {
            return 0;
        }
        
        // Recursive logic with backtracking computation
        return ((str.charAt(n) - 'a' + 1) * (int)Math.pow(20, i) + differentNumberBase(str, i + 1, n - 1));
        // 3*1 + 20
        // 23
    }
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		int result = differentNumberBase(str, 0, str.length()-1);
		System.out.print(result);
	}
}
