import java.util.Scanner;

public class BinarySearchTrees {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Implementation of binary tree insertion
    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (root.data > val) {
            // Insert into the left subtree
            root.left = insert(root.left, val);
        } else {
            // Insert into the right subtree
            root.right = insert(root.right, val);
        }
        return root;
    }

    // Inorder traversal
    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Node root = null;

        System.out.println("Enter integers to insert into the BST (enter a non-integer to stop):");

        // Read integers from user input until a non-integer input is entered
        while (scanner.hasNextInt()) {
            int val = scanner.nextInt();
            root = insert(root, val);
        }

        // Print inorder traversal of the BST
        System.out.println("Inorder traversal of the BST:");
        inorder(root);

        scanner.close();
    }
}
