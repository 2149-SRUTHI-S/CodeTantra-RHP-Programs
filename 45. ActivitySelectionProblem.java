/*
Greedy Algorithms: go for the optimal solution
Graphs: Minimum Cost Spanning tree: Prims, Kruskals
Shortest Paths: Djkastra’ s algorithm
Problem: to find the kth max or kth min element
12 67 23 34 65 67 98 11
2
1 st arrange the data
11 12 23 34 65 67 67 98    – nlogn–
Size = 8
Kth min = k– 1
Kth max = size - k = 8 - 2 = 6
Fractional Knapsack:
    Items[]: 2 5 6 4 1-- -- -- --vegetable
Profit[]: 10 20 11 5 30
Unitwise profit: 5 4 1.8 1.2 30
Sort: 30 5 4 1.8 1.2
Capacity: 9 - 1 = 8 - 2 = 6 - 5 = 1 - 1 = 0
Profit: 30 + 10 + 20 + 1.8 = 61.8
Problem:
    Items[]: 2 5 6 4 1-- -- -- --vegetable
Profit[]: 10 20 11 5 30
Unitwise profit: 5 4 1.8 1.2 30
Sort: 30 5 4 1.8 1.2
Item[]: 1 2 5 6 4
Profit[]: 30 10 20 11 5
0 / 1 knapsack
C = 9 - 1 = 8 - 2 = 6 - 5 = 1
Profit: 30 + 10 + 20 = 60
Failure of greedy on 0 / 1 knapsack
Capacity 4 kg
Item Weight Value value / Weight
A 3 1.65 0.55
B 2 1 0.5
C 2 1 0.5
C = 4 - 3 = 1
Profit: 1.65
Actual: 4– 2– 2 = 0
Profit: 1 + 1 = 2
0 / 1 knapsack using Dynamic programming

Problem:
    Activity selection problem:
    Test case :
Start[]:
    10, 12, 20
    End[]: 20, 25, 30
    Output: 0, 2 2
    Test
case :
S[]:
    1, 3, 0, 5, 8, 5
    End[]: 2, 4, 6, 7, 9, 9
    Output: 0, 1, 3, 4 - 4

    S[]: 5, 3, 0, 1, 8, 5
    End[]: 7, 4, 6, 2, 9, 9
    Output: 0, 4
    
*/
    //Solution:
    import java.util.*;
    class Main {
        
        /*
        S[]: 1, 3, 0, 5, 8, 5
        End[]: 2, 4, 6, 7, 9, 9
        below not ordered data
        S[]: 5, 3, 0, 1, 8, 5
        End[]: 7, 4, 6, 2, 9, 9
        */

        public static int solution(int start[], int end[], int n) {

            int i, j;
            int counter = 0;
            i = 0;
            System.out.print(i + " ");
            counter++;
            for (j = 1; j < n; j++) { //n
                if (start[j] >= end[i]) {
                    System.out.print(j + " ");
                    counter++;
                    i = j;
                }
            }
            System.out.println();
            return counter;
        }

        public static void main(String args[]) { // n + nlogn ---> O(nlogn)
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt(); // no of jobs
            int start[] = new int[n];
            int end[] = new int[n];
            for (int i = 0; i < n; i++) {
                start[i] = sc.nextInt();
                end[i] = sc.nextInt();
            }
            // do the sorting ascending order according to the end time n logn
            //HashSet<Integer> set = new HashSet<>();

            System.out.print(solution(start, end, n)); //n
            sc.close();

        }
    }
