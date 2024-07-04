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
