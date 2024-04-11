/*

Given an integer array, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
Note that you must do this in-place without making a copy of the array.
 
Example 1:
Input: nums = [0,1,0,3,12] Output: [1,3,12,0,0]

Example 2:
Input: nums = [0] Output: [0]

Constraints:
• 1 <= nums.length <= 104
• -231 <= nums[i] <= 231 – 1 // signed integer

*/

import java.util.*;
public class MoveZeros
{
    // Greedy Approach - Sorting
    public static void moveZero(int arr[], int n)
    {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n - i - 1; j++) {
                if(arr[j] == 0)
                {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            } 
        }
    }
    
    // 2 Pointer Approach
    public static void moveZero(int arr[], int n)
    {
        int left = 0, right = 0;
        while(right < n) {
            if(arr[right] != 0 && arr[left] == 0) {  // n times ---> O(n)
            
                // Using XOR Operation
                arr[left] = arr[right] ^ arr[left];
                arr[right] = arr[right] ^ arr[left];
                arr[left] = arr[right] ^ arr[left];
                
                // Or
                
                // Using Swapping
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
            }
            right++;
        }
    }
    
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int n = sc.nextInt();
	    int arr[] = new int[n];
	    
	    for(int i = 0; i < n; i++)
	    arr[i] = sc.nextInt();
	    
	    moveZero(arr, n);
	    
	    for(int i = 0; i < n; i++)
		System.out.print(arr[i] + " ");
	}
}
