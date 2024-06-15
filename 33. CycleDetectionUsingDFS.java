// Cycle detection in directed graphs using DFS--> Recursion Stack(Back edges)

import java.util.*;

class Main { // Graph

    private int V;
    private List < List < Integer >> AL;
    
    Main(int v) {
        V = v;
        AL = new ArrayList(V);
        for (int i = 0; i < V; i++) {
            AL.add(new LinkedList < > ());
        }
    }

    void insertEdge(int s, int d) { // s---> d
        AL.get(s).add(d); // Directed graph
    }

    boolean cycleInDG() {
        boolean VA[] = new boolean[V];
        boolean recStack[] = new boolean[V];
        
        for (int i = 0; i < V; i++) {
            if (dfsHelper(i, VA, recStack)) {
                return true;
            }
        }
        return false;
    }
    
    boolean dfsHelper(int i, boolean VA[], boolean recStack[]) {
        
        if (recStack[i] == true) { // finding back edge
            return true;
        }
        
        if (VA[i] == true) {
            return false;
        }
        
        VA[i] = true;
        recStack[i] = true;
        List < Integer > al = AL.get(i);
        for (Integer c: al) {
            if (dfsHelper(c, VA, recStack) == true) {
                return true; // Back edge found
            }
        }
        recStack[i] = false;
        return false;
    }

    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        
        int v = sc.nextInt();
        Main graph = new Main(v);
        int e = sc.nextInt();
        
        for (int i = 0; i < e; i++) {
            int s = sc.nextInt();
            int d = sc.nextInt();
            graph.insertEdge(s, d);
        }

        if (graph.cycleInDG()) {
            System.out.print("Cycle detected");
        } else {
            System.out.print("Cycle not detected");
        }
        
        sc.close();
    }
}

// Hamiltonian Cycle detection in directed graphs using DFS--> Recursion Stack(Back edges)

import java.util.*;

class Main { // Graph
    int V;
    int path[];
    Main(int v) {
        V = v;
    }

    void hamiltonianCycle(int AM[][]) {
        path = new int[V];
        for (int i = 0; i < V; i++) {
            path[i] = -1;
        }
        
        path[0] = 0;
        if (Helper(AM, path, 1) == false) {
            System.out.print("No solution");
            return;
        }
        
        display(path);
        return;
    }

    void display(int path[]) {
        for (int i = 0; i < V; i++) {
            System.out.print(path[i] + "-->");
        }
        System.out.print(path[0]);

    }
    boolean Helper(int AM[][], int path[], int p) {
        
        // base condition if all vertices are included
        if (p == V) {
            // if there is an edge from the last included
            if (AM[path[p - 1]][path[0]] == 1) {
                return true;
            } else {
                return false;
            }
        }
        
        for (int i = 1; i < V; i++) {
            if (state(i, AM, path, p) == true) {
                path[p] = i;
                if (Helper(AM, path, p + 1) == true) {
                    return true;
                }
                path[p] = -1;

            }
        }
        return false;
    }


    boolean state(int i, int AM[][], int path[], int p) {
        if (AM[path[p - 1]][i] == 0) {
            return false;

        }
        for (int j = 0; j < V; j++) {
            if (path[j] == i) {
                return false;
            }
        }
        return true;
    }


    public static void main(String arg[]) {
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        Main graph = new Main(v);
        int AM[][] = new int[v][v];
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                AM[i][j] = sc.nextInt();
            }
        }
        
        graph.hamiltonianCycle(AM);
        sc.close();
    }
}
