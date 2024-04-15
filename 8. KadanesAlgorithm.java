/*
Kadane's Algorithm   

Given an array arr[] of size N. The task is to find the sum of the contiguous subarray 
within a arr[] with the largest sum. 

Time Complexity --> O(n)
Space Complexity --> O(1)

Input:
8
-2 -3 4 -1 -2 1 5 -3

Output:
7   [4, -1, -2, 1, 5, -3]

*/

import java.util.*;
public class Main
{
    public static void KadanesAlgorithm(int arr[], int n)
    {
        int max_so_far = Integer.MIN_VALUE,
            max_ending_here = 0, start = 0, end = 0, s = 0;
 
        for (int i = 0; i < n; i++) {
            max_ending_here += arr[i];
 
            if (max_so_far < max_ending_here) {
                max_so_far = max_ending_here;
                start = s;
                end = i;
            }
 
            if (max_ending_here < 0) {
                max_ending_here = 0;
                s = i + 1;
            }
        }
        System.out.println("Maximum Contiguous Sum: " + max_so_far);
        System.out.println("Contiguous subarray with Maximum Sum: ");              
        for(int i = start; i <= end; i++)
        System.out.print(arr[i] + " ");
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++)
		arr[i] = sc.nextInt();
		KadanesAlgorithm(arr, n);
	}

}
