/*
Numbers representation:
Positive: unsigned int
Negative numbers: int, signed int
4 bytes: 32 bits

Unsigned int a = 10 - 32 bits are going to be used to represent any number.
0-- -- -- -- -- -- -- -- -- -- -- -- --(2 ^ 32) - 1
00000000000000000000000000001010(binary) - > 1 x 2 ^ 3 + 0 x 2 ^ 2 + 1 x 2 ^ 1 + 0 x 2 ^ 0 = 10(decimal)

Signed int a = -10
32 bits but it will use one bit as a sign bit
    -
    2 ^ 31-- -- -- -- -- -- -- -- -- -- -- --0-- -- -- -- -- -- -- -- -- -- -- -- --(2 ^ 31) - 1
1. bit pattern of 10 = 00000000000000000000000000001010
2. take 1 s compliment of 10 + 1(2’ s compliment) = -10

= 10 + (-10) = 0

I we add sum number binary to its 2’ s compliment the result will be zero.
To represent negative numbers in binary, we typically use a method called Two 's Complement. Here'
s how you can represent - 10 in an 8 - bit binary format:
    1. Find the binary representation of the positive number(10): 00001010200001010 _2000010102.
2. Invert the digits(change 0 s to 1 s and 1 s to 0 s): 11110101211110101 _2111101012.
3. Add 1 to the inverted binary number:
    4. 2 + 12 = 11110110211110101 _2 + 1 _2 = 11110110 _2111101012 + 12 = 111101102
So, the 8 - bit binary representation of -10 is 11110110211110110 _2111101102

Bit Manipulation:
    1. Bit wise &
    2. Bit or |
    3. Bitwise compliment = ~
    4. Bit wise xor = ^
    5. Bitwise shift operation

*/

// Problem to check given number is power of 2 or not
import java.util.*;
// n = 8 ( given number is a power of 2 or not
class Main {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int one = 1;
        int count = 0;
        while (n != 0) {
            int value = n & 1;
            if (value == 1) {
                count++;
            }
            n = n >> 1;
        }
        if (count == 1)
            System.out.print("Yes");
        else
            System.out.print("No");
        sc.close();
    }
}

// Optimized one is:
    import java.util.*;
// n = 8 ( given number is a power of 2 or not
class Main {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = n & (n - 1);
        if (result == 0)
            System.out.print("Yes");
        else
            System.out.print("No");
        sc.close();
    }
}

// To check the status of any position in the binary pattern
import java.util.*;
// n = 8 ( given number is a power of 2 or not
class Main {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 7 --> 00000000000000000000000111
        int pos = sc.nextInt(); // 1 --> 0000000000000000000000001
        int result = n & (1 << (pos - 1));
        if (result != 0)
            System.out.print("Set bit");
        else
            System.out.print("not Set bit");
        sc.close();
    }
}

// How to set / reset any position in the binary pattern:
    import java.util.*;
// n = 8 ( given number is a power of 2 or not
class Main {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 7 --> 00000000000000000000000111
        int pos = sc.nextInt(); // 1<<3 000000000000001000
        System.out.println("Before" + n);
        n = n | (1 << (pos - 1));
        System.out.println("After" + n);
        sc.close();
    }
}

// To unset a given bit in the binary pattern of the number:
    import java.util.*;
// n = 8 ( given number is a power of 2 or not
class Main {
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 7 --> 00000000000000000000000111
        int pos = sc.nextInt(); // 1<<3 111111111111111011
        System.out.println("Before" + n);
        n = n & ~(1 << (pos - 1));
        System.out.println("After" + n); // 00000000000000000000000011-->3
        sc.close();
    }
}
