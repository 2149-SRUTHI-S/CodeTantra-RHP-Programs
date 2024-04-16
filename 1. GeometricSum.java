/*
Problem Statement:
Your are given a positive integer k.
Your task is to find the geometric sum i.e. 1 + 1/2 + 1/4 + 1/8 + _______ + 1/(2^k)
Note: Use recursion to implement your solution.
Your task is to complete function geometricSum with following parameters passed:
integer k: k is a positive integer defines the limit up to which you have to find the geometric sum.
Function returns:
float : Return the geometric sum i.e. as real number.
   
Constraints to be followed:
0 <= k <= 100
Sample test case 1:
Input:
3 // value of k
Output:
1.875000 // geometric sum up to 5 decimal places
Sample test case 2:
Input:
4
Output:
1.937500
Brief editorial: in test case 1 geometric sum will be calculated as: 1+ 1/(2^1) + 1/(2^2) + 1/(2^3) = 1.875
*/

import java.util.*;
public class GeometricSum
{
    public static double geometricSum(double k) // O(k) - Function Calling time + Extra space used by Recursive Stack
    {
        // Base Condition
        if(k == 0)
        return 1;
        else
        return (double) 1 / (Math.pow(2 , k)) + geometricSum(k - 1);
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        double k = sc.nextDouble();
        System.out.printf("%.5f", geometricSum(k));
    }
}
