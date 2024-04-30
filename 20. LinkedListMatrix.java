/*
Linked List Matrix

Given a matrix. Convert it into a linked list matrix such that each node is connected to its next right and down node.
Input : 2D matrix
1 2 3
4 5 6
7 8 9
Output :
1 -> 2 -> 3 -> NULL
| | |
v v v
4 -> 5 -> 6 -> NULL
| | |
v v v
7 -> 8 -> 9 -> NULL
| | |
v v v
NULL NULL NULL
 
*/

import java.util.Scanner;

class Node {
    int data;
    Node right, down;

    Node(int data) {
        this.data = data;
        right = null;
        down = null;
    }
}

public class MatrixToLinkedList {
    static Node constructLinkedListMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return null;

        int rows = matrix.length;
        int cols = matrix[0].length;

        Node[][] nodeMatrix = new Node[rows][cols];

        // Create nodes for each element in the matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                nodeMatrix[i][j] = new Node(matrix[i][j]);
            }
        }

        // Connect each node to its right and down nodes
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (i < rows - 1) {
                    nodeMatrix[i][j].down = nodeMatrix[i + 1][j];
                }
                if (j < cols - 1) {
                    nodeMatrix[i][j].right = nodeMatrix[i][j + 1];
                }
            }
        }

        return nodeMatrix[0][0];
    }

    static void printLinkedListMatrix(Node head) {
        Node row = head;
        while (row != null) {
            Node current = row;
            while (current != null) {
                System.out.print(current.data + " -> ");
                current = current.right;
            }
            System.out.println("NULL");
            row = row.down;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int cols = scanner.nextInt();

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }

        Node head = constructLinkedListMatrix(matrix);

        System.out.println("Linked List Matrix:");
        printLinkedListMatrix(head);
    }
}
