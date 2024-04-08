/*
On A Cube

A solid cube of 10 cm x 10cm x 10 cm rests on the ground. It has a beetle on it, and some sweet honey spots at various locations
on the surface of the cube. The beetle starts at a point on the surface of the cube, and goes to the honey spots in order along 
the surface of the cube.
Problem Description
A solid cube of 10 cm x 10cm x 10 cm rests on the ground. It has a beetle on it, and some sweet honey spots at various locations 
on the surface of the cube. The beetle starts at a point on the surface of the cube, and goes to the honey spots in order along 
the surface of the cube.

1. If it goes from a point to another point on the same face (say X to Y), it goes in an arc of a circle that subtends an angle 
of 60 degrees at the centre of the circle
2. If it goes from one point to another on a different face, it goes by the shortest path on the surface of the cube, except that
it never travels along the bottom of the cube.


Three characters { #, *, . } represents a constellation of stars and galaxies in space. Each galaxy is demarcated by # characters. 
There can be one or many stars in a given galaxy. Stars can only be in the shape of vowels { A, E, I, O, U }. A collection of * in
the shape of the vowels is a star. A star is contained in a 3×3 block. Stars cannot be overlapping. The dot(.) character denotes 
empty space.

Given 3xN matrix comprising of { #, *, . } character, find the galaxy and stars within them.
Note: Please pay attention to how vowel A is denoted in a 3×3 block in the examples section below.

Constraints:
• 3 <= N <= 10^5
Input:
• Input consists of a single integer N denoting the number of columns.
Output:
• The output contains vowels (stars) in order of their occurrence within the given galaxy. 
The galaxy itself is represented by the # character.

Example 1
Input
18
* . * # * * * # * * * # * * * . * .
* . * # * . * # . * . # * * * * * *
* * * # * * * # * * * # * * * * . *
Output
U#O#I#EA
Explanation
As it can be seen that the stars make the image of the alphabets U, O, I, E, and A respectively.

Example 2
Input
12
* . * # . * * * # . * .
* . * # . . * . # * * *
* * * # . * * * # * . *
Output
U#I#A
Explanation
As it can be seen that the stars make the image of the alphabet U, I, and A.
Possible solution:
Input:
12
* . * # . * * * # . * .
* . * # . . * . # * * *
* * * # . * * * # * . *

*/

import java.util.*;
public class OnACube {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        char[][] arr = new char[3][n];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < n; j++) {
               arr[i][j] = sc.next().charAt(0);
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr[0][i] == '#' && arr[1][i] == '#' && arr[2][i] == '#') {
                System.out.print('#');
            } 
            else if (arr[0][i] == '.' && arr[1][i] == '.' && arr[2][i] == '.') {
                // Do nothing for '.'
            } 
            else {
                char a, b, c, a1, b1, c1, a2, b2, c2;
                
                a = arr[0][i];
                b = arr[0][i + 1];
                c = arr[0][i + 2];

                a1 = arr[1][i];
                b1 = arr[1][i + 1];
                c1 = arr[1][i + 2];

                a2 = arr[2][i];
                b2 = arr[2][i + 1];
                c2 = arr[2][i + 2];
                
                if (a == '.' && b == '*' && c == '.' && a1 == '*' && b1 == '*' && c1 == '*' && a2 == '*' && b2 == '.' && c2 == '*') {
                    System.out.print("A");
                    i += 2;
                } 
                else if (a == '*' && b == '*' && c == '*' && a1 == '*' && b1 == '*' && c1 == '*' && a2 == '*' && b2 == '*' && c2 == '*') {
                    System.out.print("E");
                    i += 2;
                } 
                else if (a == '*' && b == '*' && c == '*' && a1 == '.' && b1 == '*' && c1 == '.' && a2 == '*' && b2 == '*' && c2 == '*') {
                    System.out.print("I");
                    i += 2;
                } 
                else if (a == '*' && b == '*' && c == '*' && a1 == '*' && b1 == '.' && c1 == '*' && a2 == '*' && b2 == '*' && c2 == '*') {
                    System.out.print("O");
                    i += 2;
                } 
                else { 
                System.out.print("U");
                i += 2;
                }
            }
        }
    }
}
