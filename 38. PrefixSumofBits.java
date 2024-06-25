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
