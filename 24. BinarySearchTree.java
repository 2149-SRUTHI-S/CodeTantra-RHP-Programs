/* Binary Search Tree */       
           
import java.util.*;
public class Main {

    static class TreeNode { // Representing the node in the BST
        int val;
        TreeNode left, right;
        TreeNode(int x) {
            val = x;
            left = right = null;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        TreeNode root = null;
        while (true) {
            System.out.println("Enter the data in the BST, type exit to terminate");
            String input = sc.nextLine();
            if (input.equals("exit")) {
                break;
            }
            int data = Integer.parseInt(input); // "22" ---> 22
            root = insertIntoBST(root, data);
        }

        List < Integer > inorder = inorderTraversal(root); // DFS using STACK --> recursion
        System.out.println("Inorder traversal: " + inorder);

        boolean isValid = isValidBST(root);
        System.out.println("is valid BST: " + isValid);
        List < Integer > levelorder = levelorderTraversal(root);
        System.out.println("levelorder traversal: " + levelorder); // using queue --> iterative
        
        //List<Integer> rightView = rightViewTraversal(root);
        //System.out.println("right view traversal: " + rightView );
        // left view
        // reverse level order
        // ZIG ZAG level order traversal
        // Boundry as well as top view of the tree also


    } // Driver code closed

    public static TreeNode insertIntoBST(TreeNode root, int value) {
        if (root == null) {
            return new TreeNode(value);
        }
        if (value < root.val) {
            root.left = insertIntoBST(root.left, value);
        } else {
            root.right = insertIntoBST(root.right, value);
        }
        return root;
    }


    public static List < Integer > inorderTraversal(TreeNode root) {
        List < Integer > ls = new ArrayList < > ();
        inorderUtility(root, ls);
        return ls;

    }

    public static void inorderUtility(TreeNode root, List < Integer > ls) {
        if (root != null) {
            inorderUtility(root.left, ls);
            ls.add(root.val);
            inorderUtility(root.right, ls);

        }
    }
  
    public static boolean isValidBST(TreeNode root) {
        return isValidBSTUtility(root, null, null);
    }

    public static boolean isValidBSTUtility(TreeNode root, Integer min, Integer max) {

        if (root == null) {
            return true;
        }
        if ((min != null && root.val <= min) || (max != null && root.val >= max)) {
            return false;
        }
        return isValidBSTUtility(root.left, min, root.val) && isValidBSTUtility(root.right, root.val, max);
    }


    public static List < Integer > levelorderTraversal(TreeNode root) { // iterative

        List < Integer > ans = new ArrayList < > ();
        if (root == null)
            return ans;

        Queue < TreeNode > q = new LinkedList < > ();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            ans.add(node.val);
            if (node.left != null) {
                q.add(node.left);
            }
            if (node.right != null) {
                q.add(node.right);
            }
        }
        return ans;

    }
}
