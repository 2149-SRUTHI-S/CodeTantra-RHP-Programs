/*
How we can solve this problem using prefix sum of bits:
Int a[] = { 13, 11, 2, 3, 6}
L, R: 2, 4
We have to do the bitwise anding:
{2, 3, 6}
Binary of 2: 00000000000000000000000000000010
Binary of 3: 00000000000000000000000000000011
Binary of 6: 00000000000000000000000000000110
Bitwise & : 00000000000000000000000000000010  2
Int Temp array [n+1][32] where columns are 32
Row 0: 00000000000000000000000000000000
Row 1(13 (1101): 10110000000000000000000000000000
Row 2(11 (1011): 11010000000000000000000000000000
Row 3( 2(0010: 01000000000000000000000000000000
Row 4: (3(0011): 11000000000000000000000000000000
Row 5: (6(0110): 01100000000000000000000000000000

PrefixSum[n+1][32] of bits:
Row 0: 00000000000000000000000000000000
Row 1 : 10110000000000000000000000000000
Row 2 : 21120000000000000000000000000000
Row 3 : 22120000000000000000000000000000
Row 4: : 33120000000000000000000000000000
Row 5: : 34220000000000000000000000000000

L= 2 r = 4
{2, 3, 6}
Output: 2 : 00000000000000000000000000000010
Bit position 0:
Count = preSum[5][0] – preSum[1][0] = 3 – 1 = 2 (not all bits are set)-0
Bit position 1: preSum[5][1] – preSum[1][1] = 4 – 0 = 4 (all bits are set)  1
Bit position 2: preSum[5][2] – preSum[1][2] = 2– 1 = 1 (no all all bits are set)
Bit position 3: preSum[5][3] – preSum[1][3] = 2– 1 = 1 (no all all bits are set)

For Bitwise oring:
Count = preSum[5][0] – preSum[1][0] = 3 – 1 = 2 > 0 (more than 0 bits are set)-1
Bit position 1: preSum[5][1] – preSum[1][1] = 4 – 0 = 4 (more than 0 bits are set)-1
Bit position 2: preSum[5][2] – preSum[1][2] = 2– 1 = 1 (more than 0 bits are set)-1

L= 2 r = 4
{2, 3, 6}
Output: 2 : 00000000000000000000000000000111
*/

import java.util.*;

public class Main {

    public static List < List < Integer >> prefixsumBit(List < Integer > nums) {
        int n = nums.size();

        // Step 1: Store bit information in 'temp'
        List < List < Integer >> temp = new ArrayList < > ();
        for (int i = 0; i <= n; ++i) {
            temp.add(new ArrayList < > (Collections.nCopies(32, 0)));
        }
        for (int i = 1; i <= n; ++i) {
            int num = nums.get(i - 1);
            for (int j = 0; j < 32; ++j) {
                // Check if the j-th bit of nums[i] is set
                if (((1 << j) & num) != 0) {
                    temp.get(i).set(j, 1);
                }
            }
        }

        // Step 2: Compute prefix sums
        List < List < Integer >> psum = new ArrayList < > ();
        for (int i = 0; i <= n; ++i) {
            psum.add(new ArrayList < > (Collections.nCopies(32, 0)));
        }
        for (int j = 0; j < 32; ++j) {
            for (int i = 1; i <= n; ++i) {
                // Calculate prefix sum for each bit
                psum.get(i).set(j, psum.get(i - 1).get(j) + temp.get(i).get(j));
            }
        }
        return psum;
    }

    public static int rangeBitwiseAND(List < List < Integer >> psum, int l, int r) {
        int result = 0;
        for (int j = 0; j < 32; ++j) {
            // Calculate the count of elements with j-th bit set in the range [l, r]
            int count = psum.get(r + 1).get(j) - psum.get(l).get(j);
            if (count == r - l + 1) {
                // If all elements in the range have j-th bit set, add it to the result
                result = result + (1 << j);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Input Array
        List < Integer > nums = new ArrayList < > (Arrays.asList(13, 11, 2, 3, 6));

        // Range
        int l = 2, r = 4;

        // 2D prefix sum
        List < List < Integer >> psum = prefixsumBit(nums);

        System.out.println("Bitwise AND of range [2,4] is : " + rangeBitwiseAND(psum, l, r));
    }
}
