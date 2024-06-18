/*
Cheapest Flights with K Stops
Leetcode Link: https://leetcode.com/problems/cheapest-flights-within-k-stops/description/

Logic:
n = 4
Flight data[] []: (0 , 1, 100), (1, 2,100), (2,0,100), (1,3,600), (2,3,200)
Src: 0
Dst: 3
K( Max stops) = 1

BFS:
Queue[] : pair (destination , cost)
DP[]: size is n, for every location I will store Integer.Max_VALUE
Creation of adjacency list List<List<Pair>> adj = new ArrayList<>()
Fill the adj list from Flight data.
Start doing BFS:
DP[src] = DP[0] = 0
Push source in the queue.
While(!Queue.isEmpty() && k-- >=0) -- This the while for BFS

Performing BFS:
Level 0 ( 0 stops):
Int size: Queue.size = 1
Dequeue city 0 with cost 0 ( Pair x = Queue.poll() )
Explore all the neighbours of city 0:
City 1 is the neighbour: 0 + 100 = 100 < DP[1] = 100 < Integer.MAX_VALUE.
Its yes so update D[1] with new cheap value i.e. 100.
Queue.add(Pair(1,100)

Level 1:
( 1 stop)
Int size: Queue.size = 1
Dequeue city 1 with cost 100 ( Pair x = Queue.poll() )
Explore all the neighbours of city 1:
Neighbour city 2 with cost 100:
City1- city 2: 100 + 100 = 200 < DP[2] yes so update
Neighbour city 3 with cost 600:
100 + 600 = 700 < DP[3]
Queue.add(Pair(2,100)
Queue.add(Pair(3,600)
*/

class Solution {
    
    class pair {
        int d;
        int c;
        pair(int d, int c) {
            this.d = d;
            this.c = c;
        }
    }
    
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Queue < pair > q = new LinkedList < > ();
        int dp[] = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        List < List < pair >> adj = new ArrayList < > ();
        
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList < > ());

        }
        
        // fill the data from flights[]]to adj
        for (int a[]: flights) {
            adj.get(a[0]).add(new pair(a[1], a[2]));
        }
        
        q.add(new pair(src, 0));
        dp[src] = 0;
        while (!q.isEmpty() && k-- >= 0) {
            int size = q.size();
            while (size-- > 0) {
                pair x = q.poll();
                for (pair i: adj.get(x.d)) {
                    if (x.c + i.c < dp[i.d]) { // city 1 (d, c)
                        dp[i.d] = x.c + i.c;
                        q.add(new pair(i.d, dp[i.d]));
                    }
                }
            }
        }

        if (dp[dst] == Integer.MAX_VALUE) {
            return -1;
        }
        return dp[dst];
    }
}
