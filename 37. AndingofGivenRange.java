/*
Int a[] = {13,11,2,3,6}
L, R: 2, 4
We have to do the bitwise anding: {2,3,6}
Binary of 2: 00000000000000000000000000000010
Binary of 3: 00000000000000000000000000000011
Binary of 6: 00000000000000000000000000000110
Bitwise &: 00000000000000000000000000000010 2

0101
0101
0101
Naïve way to do the anding of given range is:
*/

import java.util.*;

class Main {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        int left = sc.nextInt();
        int right = sc.nextInt();

        int result = 0;
        for (int i = left; i < right; i++) {
            a[i] = a[i] & a[i + 1];
            result = a[i];

            // Anding of element in the given range
        }
        if (left == right)
            System.out.print(a[left]);
        else if (left > right || left > n - 1 || right > n - 1)
            System.out.print("Invalid range");
        else
            System.out.print(result);;

        sc.close();
    }
}
