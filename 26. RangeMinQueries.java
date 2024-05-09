/* Finding range min queries using Segment Tree in T*logn */

import java.util.*;

class Main {
    int st[];
    int mini(int a, int b) { // finding minimum
        return (a < b) ? a : b;
    }

    int gMid(int si, int ei) { // finding the mid of ranges
        return si + (ei - si) / 2;
    }

    int rangeMin(int n, int qs, int qe) { // main solution function to find range min

        if (qs < 0 || qe > n - 1 || qs > qe) {

            System.out.println("incorrect query");
            return -1;
        }
        
        int result = rangeMinUtility(0, n - 1, qs, qe, 0);
        return result;
    }

    int rangeMinUtility(int sa, int ea, int qs, int qe, int index) {

        // if the segment is part of the given range
        if (qs <= sa && qe >= ea) {
            return st[index];
        }

        // if segment is outside the query
        if (ea < qs || sa > qe) {
            return Integer.MAX_VALUE;
        }

        int mid = gMid(sa, ea);

        return mini(rangeMinUtility(sa, mid, qs, qe, 2 * index + 1), rangeMinUtility(mid + 1, ea, qs, qe, 2 * index + 2));


    }
    void makingST(int arr[], int n) {
        int size = (int) Math.ceil(Math.log(n) / Math.log(2));
        int stSize = 2 * (int) Math.pow(2, size) - 1;
        st = new int[stSize];
        makingSTUtility(arr, 0, n - 1, 0);
    }
    
    int makingSTUtility(int arr[], int sa, int ea, int index) {

        if (sa == ea) {
            st[index] = arr[sa];
            return arr[sa];
        }
        
        int mid = gMid(sa, ea);
        st[index] = mini(makingSTUtility(arr, sa, mid, 2 * index + 1), makingSTUtility(arr, mid + 1, ea, 2 * index + 2));

        return st[index];
    }
    
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        Main sTree = new Main();

        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        
        sTree.makingST(a, n);
        int TC = sc.nextInt();
        for (int i = 1; i <= TC; i++) {
            int qs = sc.nextInt();
            int qe = sc.nextInt();
            System.out.println("Range min: " + sTree.rangeMin(n, qs, qe));
        }
    }
}
