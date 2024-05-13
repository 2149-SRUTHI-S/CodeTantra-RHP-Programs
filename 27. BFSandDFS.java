/* BFS and DFS Traversal in Graph */

import java.util.*;
class Main { // graph

    private int V;
    // Adjacency list
    private LinkedList < Integer > adj[]; //

    Main(int v) { // constructor
        V = v;
        adj = new LinkedList[v]; // Memory to to adj list
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList < Integer > ();
        }
    }

    // add edges UG DG
    void addEdge(int x, int y) {
        adj[x].add(y); // x-->y
        adj[y].add(x); // y--->x
    }

    void BFS(int s) {
        // Visited array
        boolean VA[] = new boolean[V];
        // QUEUE
        LinkedList < Integer > queue = new LinkedList < Integer > ();
        // start the bfs
        VA[s] = true;
        queue.add(s);
        
        while (queue.size() != 0) {
            // deque the front vertex
            s = queue.poll();
            System.out.print(s + " ");

            // Go for all adjacent vertices of s those are not visited
            Iterator < Integer > i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!VA[n]) {
                    VA[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    void DFS(int s) {
        boolean VA[] = new boolean[V];
        DFSUtility(s, VA);
    }

    void DFSUtility(int s, boolean VA[]) {
        VA[s] = true;
        System.out.print(s + " ");
        Iterator < Integer > i = adj[s].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!VA[n]) {
                DFSUtility(n, VA);
            }

        }
    }
    
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        Main obj = new Main(V);
        int E = sc.nextInt();
        
        for (int i = 0; i < E; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            obj.addEdge(x, y);
        }
        
        int s = sc.nextInt();
        obj.BFS(s);
        System.out.println();
        obj.DFS(s);
    }
}
