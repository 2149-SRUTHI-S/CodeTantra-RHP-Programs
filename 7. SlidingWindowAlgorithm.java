/*
Sliding Window Algorithm

Finding MaxSum of subarray with size K | Time Complexity --> O(n-k) 
where as Brute Force Approach has O(n*k)

Input:
7 
1 2 3 -2 3 4 5
2
Output:
9
 
*/

import java.util.*;
public class SlidingWindowAlgorithm
{
    public static int maxSumSlidindWindow(int arr[], int n, int k)
    {
        int i,j, maxSum = Integer.MIN_VALUE;
        for(i=0;i<k;i++)
        maxSum += arr[i];
        int windowSum = maxSum;
        for(i=k;i<n;i++) {
            windowSum += arr[i] - arr[i-k];
            maxSum = Math.max(maxSum, windowSum);
        }
        return maxSum;
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++)
		arr[i] = sc.nextInt();
		int k = sc.nextInt();
		System.out.print(maxSumSlidindWindow(arr, n, k));
	}
}
