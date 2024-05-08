/* Balanced Binary Search Tree(BST) using AVL Tree */
       
import java.util.*;

class Node {
    int data, height;
    Node left, right;

    Node(int d) {
        data = d;
        height = 1;
    }
}


public class Main {

    Node root;
    // function that will return the height of the tree

    int height(Node root) {
        if (root == null)
            return 0;
        return root.height;
    }

    int maxi(int a, int b) { // utility to find max
        return (a > b) ? a : b;
    }

    // right rotation
    Node rightRotation(Node y) {
        Node x = y.left;
        Node T2 = x.right;
        x.right = y;
        y.left = T2;
        y.height = maxi(height(y.left), height(y.right)) + 1;
        x.height = maxi(height(x.left), height(x.right)) + 1;

        // return the new root
        return x;

    }

    // left rotation
    Node leftRotation(Node x) {
        Node y = x.right;
        Node T2 = y.left;
        y.left = x;
        x.right = T2;
        x.height = maxi(height(x.left), height(x.right)) + 1;
        y.height = maxi(height(y.left), height(y.right)) + 1;

        // return the new root
        return y;

    }

    // compute balancing factor of each node

    int gBalance(Node root) {
        if (root == null)
            return 0;
        return height(root.left) - height(root.right);
    }

    // insertions in a balanced BST
    
    Node insertBST(Node root, int d) { // recursion

        if (root == null) {
            return (new Node(d));
        }

        if (d < root.data) {
            root.left = insertBST(root.left, d);
        } else if (d > root.data) {
            root.right = insertBST(root.right, d);
        } else {
            return root;
        }


        // updation of height of ancestor node
        root.height = 1 + maxi(height(root.left), height(root.right));
        // Balancing factor of ancestor node
        int balance = gBalance(root);

        // cater all the 4 cases RR, LL, RL, LR

        // LL case
        if (balance > 1 && d < root.left.data) {
            return rightRotation(root);
        }

        // RR rotation
        if (balance < -1 && d > root.right.data) {
            return leftRotation(root);
        }

        // LR rotation

        if (balance > 1 && d > root.left.data) {
            root.left = leftRotation(root.left);
            return rightRotation(root);
        }
        // RL rotation

        if (balance < -1 && d < root.right.data) {
            root.right = rightRotation(root.right);
            return leftRotation(root);
        }

        return root; // return the unchanged root

    }

    void preorder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    public static void main(String args[]) {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Main tree = new Main();
        for (int i = 1; i <= n; i++) {
            int data = sc.nextInt();
            tree.root = tree.insertBST(tree.root, data);
        }

        System.out.println(" Preorder of balanced BST is: ");
        tree.preorder(tree.root);
    }
}
