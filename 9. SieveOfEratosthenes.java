/*
Sieve Of Eratosthenes

Printing Prime Numbers from 2 to N in logn time
Time complexity --> O(N*log(log(N)))

Input:
30

Output:
2 3 5 7 11 13 17 19 23 29 

*/

import java.util.*;
public class SieveOfEratosthenes
{
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    boolean isPrime[] = new boolean[n+1];
	    for(int i = 0; i <= n; i++)
	    isPrime[i] = true;
	    for(int prime = 2; prime*prime <= n; prime++) {
	        if(isPrime[prime] == true) {
	            for(int i = prime*prime; i <= n; i += prime)
	            isPrime[i] = false;
	        }
	    }
	    for(int i = 2; i <= n; i++) {
	        if(isPrime[i] == true) 
	        System.out.print(i + " ");
	    }
	}
}
