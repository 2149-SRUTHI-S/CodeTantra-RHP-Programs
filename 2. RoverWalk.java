/*
Problem Statement:
A Rover sent to moon wants to move in a research area land in form grid of size M x N. (M- Rows N- Columns). 
Rover starts from (0,0) coordinates and it has to reach to destination (M-1,N-1) coordinates. 
Note: Rover can only move right or down. 
You have to compute the total number of ways rover can reach the destination.
Complete the function RoverWalk with parameters:
integer M,N : It specifies the the Number of rows and columns in the area grid.

Function returns:
integer: the count of number of possible ways for rover to reach (0,0) to (M-1,N-1) destination coordinates.
Note: Both M and N may be equal or not (i.e grid can be square as well as rectangular in shape

Constraints to be followed:
1 <= M,N <=500
Sample testcase 1:
Input:
2 2
Output:
2
Sample testcase 2:
Input:
5 5
Output:
70
*/

// Recursion - Backtracking

import java.util.*;
public class RoverWalk
{
    public static int countWays(int m, int n) // O(2 ^ n) - Function Calling time + Extra space used by Recursive Stack
    {
        if(m == 1 || n == 1)
        return 1;
        return countWays(m - 1, n) + countWays(m, n - 1);
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        System.out.print(countWays(m, n));
    }
}


// Dynamic Programming

import java.util.*;
public class RoverWalk
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int i,j;
        int dp[][] = new int[m][n];
        for(i = 0; i < m; i++)
        dp[i][0] = 1;
        for(i = 0; i < n; i++)
        dp[0][j] = 1;
        for(i = 1; i < m; i++){
            for(j = 1; j < n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        System.out.print(dp[m-1][n-1]);
    }
}
