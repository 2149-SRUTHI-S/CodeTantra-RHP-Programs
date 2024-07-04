// Bottum up DP

import java.util.*;

class Main {

    public static int Catalan(int n) {
        int table[] = new int[n + 1]; // to store the result of sub problem
        table[0] = 1;
        table[1] = 1;
        
        for (int i = 2; i <= n; i++) { // n
            for (int j = 0; j < i; j++) {
                table[i] = table[i] + (table[j] * table[i - j - 1]); // 2
            }
        }
        
        return table[n];
    }
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(Catalan(n));
    }
}


import java.util.*;
class Main { // Top down Recursion ( Top down DP (memoization))

    public static int Catalan(int n) {
        int table[] = new int[n + 2];
        for (int i = 0; i < n + 2; i++) {
            table[i] = -1;
        }

        int result = 0;
        if (n == 0 || n == 1) { // base condition
            return table[n] = 1;

        }
        if (table[n] != -1)
            return table[n];
        // backtracking logic
        for (int i = 0; i < n; i++) {
            result = result + (Catalan(i) * Catalan(n - i - 1));
            table[n] = result;
        }
        return table[n] = result;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(Catalan(n));
    }
}
