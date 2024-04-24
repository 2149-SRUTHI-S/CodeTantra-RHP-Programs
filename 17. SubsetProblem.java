/* 
Naive Approach for Subset Problem
O(n x m) Time complexity

6
5
1 2 3 4 5 6
1 3 5 2 6
True

6
4
1 2 1 2 1 2
2 2 2 2
True

*/

import java.util.*;
public class Main {

    public static boolean subsetSolution(int a1[], int a2[], int n, int m) {
        int i = 0;
        int j = 0;

        for (i = 0; i < m; i++) { // m
            for (j = 0; j < n; j++) { // n

                if (a2[i] == a1[j])
                    break;

            }
            if (j == m)
                return false;


        }
        return true;

    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();
        int a1[] = new int[n];
        int a2[] = new int[m];
        for (int i = 0; i < n; i++) {
            a1[i] = s.nextInt();
        }
        for (int i = 0; i < m; i++) {
            a2[i] = s.nextInt();
        }
        if (subsetSolution(a1, a2, n, m)) {
            System.out.print("True");
        } else {
            System.out.print("False");

        }
    }
}

// Optimized Naive Approach for Subset Problem
// O(n + m) Time complexity

import java.util.*;
public class Main {

    public static boolean subsetSolution(int a1[], int a2[], int n, int m) {
        HashSet < Integer > hSet = new HashSet < Integer > ();
        for (int i = 0; i < n; i++) { // putting a1l elements in the hash set (n)
            if (!hSet.contains(a1[i])) {
                hSet.add(a1[i]);
            }
        }

        for (int i = 0; i < m; i++) { // m
            if (!hSet.contains(a2[i])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int m = s.nextInt();

        int a1[] = new int[n];
        int a2[] = new int[m];
        for (int i = 0; i < n; i++) {
            a1[i] = s.nextInt();
        }
        for (int i = 0; i < m; i++) {
            a2[i] = s.nextInt();
        }
        if (m > n) {
            System.out.print("False");

        } else {
            if (subsetSolution(a1, a2, n, m)) {
                System.out.print("True");
            } else {
                System.out.print("False");

            }
        }
    }
}

// Two HashMap Approach
// O(n + m) Time complexity

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int a1[] = new int[n];
        HashMap < Integer, Integer > map1 = new HashMap < > ();
        HashMap < Integer, Integer > map2 = new HashMap < > ();
        
        for (int i = 0; i < n; i++) { //n
            a1[i] = sc.nextInt();
            if (!map1.containsKey(a1[i])) {
                map1.put(a1[i], 1);
            } else {
                map1.put(a1[i], map1.get(a1[i]) + 1);
            }
        }

        int a2[] = new int[m];
        for (int i = 0; i < m; i++) { //m
            a2[i] = sc.nextInt();
            if (!map2.containsKey(a2[i])) {
                map2.put(a2[i], 1);
            } else {
                map2.put(a2[i], map2.get(a2[i]) + 1);
            }
        }
        
        int f = 1;
        for (int i = 0; i < m; i++) //m
        {
            if (map1.get(a2[i]) != map2.get(a2[i])) {
                f = 0;
                break;
            }
        }
        
        if (f == 1) {
            System.out.print("True");
        } else {
            System.out.print("False");
        }
    }
}

// One HashMap Approach
// O(n + m) Time complexity

import java.util.*;

public class Main {

    public static boolean subsetSol(int a1[], int a2[], int n, int m) {
        HashMap < Integer, Integer > map = new HashMap < > ();
        for (int i = 0; i < n; i++) { // map conatins frequency count of a1
            map.put(a1[i], map.getOrDefault(a1[i], 0) + 1);
        }
        
        for (int j = 0; j < m; j++) {
            if (!map.containsKey(a2[j]) || map.get(a2[j]) == 0) {
                return false;
            }
            map.put(a2[j], map.getOrDefault(a2[j], 0) - 1); // reducing the frequency count in map
        }
        
        for (int j = 0; j < m; j++) {
            if (map.get(a2[j]) != 0) {
                return false;
            }
        }

        return true;

    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int a1[] = new int[n];
        int a2[] = new int[m];
        for (int i = 0; i < n; i++)
            a1[i] = sc.nextInt();
        for (int i = 0; i < m; i++)
            a2[i] = sc.nextInt();

        System.out.println(subsetSol(a1, a2, n, m));
    }
}
