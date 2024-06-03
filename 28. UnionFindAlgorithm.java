/* Union Find Algorithm to detect Cycle */

import java.util.*;
class Main {
    int N, E;
    class edges {
        int sv;
        int dv;
    }
    
    // Array of edges
    edges edge[];
    
    Main(int n, int e) {
        N = n;
        E = e;
        edge = new edges[E];
        for (int i = 0; i < E; i++) {
            edge[i] = new edges();
        }
    }
    
    void union(int parent[], int x, int y) { // 0---2
        parent[x] = y;
    }
    
    int find(int parent[], int index) { // 0---2 find(0) find(2)--2
        if (parent[index] == index)
            return index;
        return find(parent, parent[index]);
    }
    
    boolean checkCycle(Main m) {
        int parent[] = new int[m.N];
        for (int i = 0; i < m.N; i++) {
            parent[i] = i;
        }
      
        // iterate on all edges
        for (int i = 0; i < m.E; i++) { // edge[0]--> 0--1
            int s = m.find(parent, m.edge[i].sv);
            int d = m.find(parent, m.edge[i].dv);
            if (s == d)
                return true;
            m.union(parent, s, d);
        }
        return false;

    }
    
    // Driver code
    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        Main m = new Main(V, E);
        for (int i = 0; i < E; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            m.edge[i].sv = x;
            m.edge[i].dv = y;
        }
        
        if (m.checkCycle(m)) {
            System.out.print("Cycle detected");
        } else {
            System.out.print("Cycle not detected");
        }
        sc.close();
    }
}
