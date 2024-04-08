/*
Beetle Spots

The beetle is a student of Cartesian geometry, and knows the coordinates (x, y, z) of all the points 
it needs to go to. The origin of coordinates it uses is one corner of the cube on the ground, and the 
z axis points up. Hence, the bottom surface (on which it does not crawl) is z=0, and the top surface 
is z=10. The beetle keeps track of all the distances travelled, and rounds the distance travelled to 
two decimal places once it reaches the next spot, so that the final distance is a sum of the rounded
distances from spot to spot.

Input:
The first line gives an integer N, the total number of points (including the starting point) the beetle visits
The second line is a set of 3N comma separated non-negative numbers, with up to two decimal places each. These 
are to be interpreted in groups of three as the x, y, z coordinates of the points the beetle needs to visit in 
the given order.
Output:
One line with a number giving the total distance travelled by the beetle accurate to two decimal places. Even if 
the distance travelled is an integer, the output should have two decimal places.

Constraints:
None of the points the beetle visits is on the bottom face (z=0) or on any of the edges of the cube (the lines 
where two faces meet)
2<=N<=10
Time Limit (secs)
1

Example 1
Input
3
1,1,10,2,1,10,0,1,9
Output
4.05
Explanation:
There are three points visited by the beetle (N=3). The beetle starts on the top face of the cube (z=10) at point 
(1,1,10) and goes to another point on the same face (2,1,10). Though the straight line distance is 1, it travels on
the arc of a circle subtending an angle of 60 degrees at the centre of the circle, and hence travels (2*pi)/6 or 1.05
(note that it rounds the distance at each leg of the journey). It then travels from (2,1,10) on the face z=10 to (0,1,9)
on the face x=0 along the surface of the cube. This is a distance of 3. The total distance travelled is 1.05+3=4.05. 
The output is 4.05

Example 2
Input
3
1,1,10,2,1,10,0,5,9
Output
6.05
Explanation:
There are three points visited by the beetle (N=3). The beetle starts on the top face of the cube (z=10) at point 
(1,1,10) and goes to another point on the same face (2,1,10). As before. This distance is 1.05. It then travels from
(2,1,10) on the face z=10 to (0,5,9) on the face x=0 along the surface of the cube. The shortest distance on the surface
of the cube between these points is 5. The total distance travelled is 1.05+5=6.05. The output is 6.05.

*/

import java.util.*;
public class BeetleSpots
{
    final static float PI = 3.14f;
    static int startX, startY, startZ;
    
    public static float distance(int x, int y, int z)
    {
        float dist;
        // If the honey spots are on the same face
        if(startZ == z && (startY == y || startX == x) && startZ != 0) {
            if(startX != x)
            dist = (2 * PI * Math.abs(startX - x)) / 6.0f;
            else
            dist = (2 * PI * Math.abs(startY - y)) / 6.0f;
        }
        else {   // If the honey spots are on different faces
            dist = (int) Math.sqrt(Math.pow(x - startX, 2)+ Math.pow(y - startY, 2))+ Math.abs(z - startZ);
        }
        startX = x; startY = y; startZ = z;
        return dist;
    }
    
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int i, N, X, Y, Z;
	    int cube[] = new int[50];
	    float sum = 0.0f;
	    N = sc.nextInt();
	    N *= 3;
	    for(i = 0; i < N; i++) {
	        cube[i] = sc.nextInt();
	    }
	    startX = cube[0];
	    startY = cube[1];
	    startZ = cube[2];
	    for(i = 3; i < N; i += 3) {
	        sum += distance(cube[i], cube[i+1], cube[i+2]);
	    }
		System.out.printf("%.2f", sum);
	}
}
