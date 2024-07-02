import java.util.*;

class Main {
    public static boolean checkSubset(int a[], int n, int target) { // O(2^n)
        // Base cases
        if (target == 0)
            return true;
        if (n == 0)
            return false;
        if (a[n - 1] > target) // if the element selected at n -1 and it is > then ignore
            checkSubset(a, n - 1, target);
        boolean result = checkSubset(a, n - 1, target) || checkSubset(a, n - 1, target - a[n - 1]);
        return result;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        
        int target = sc.nextInt();
        if (checkSubset(a, n, target))
            System.out.print("Yes");
        else
            System.out.print("No");
    }
}
