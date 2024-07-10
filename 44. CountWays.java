/*
Count ways to select N pair of distinct balls of distinct colors
Test case :
Sample Input:
N = 3
0 0 0
0 1 1
0 1 1
Sample Output:
2
*/

// Recursive logic(N!)
import java.util.*;
class Main {

    public static int noOfWays(int a[][], int n, int i, HashSet < Integer > set) {
        // Base
        if (i == n)
            return 1;
        int counter = 0;
        for (int j = 0; j < n; j++) {

            if (a[i][j] == 1 && !set.contains(j)) {
                set.add(j);
                counter = counter + noOfWays(a, n, i + 1, set);
                // bactracking
                set.remove(j);
            }
        }
        return counter;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // no nodes / vertices
        int a[][] = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }
        
        HashSet < Integer > set = new HashSet < > ();
        System.out.print(noOfWays(a, n, 0, set));
        sc.close();
    }
}
