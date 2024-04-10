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
//sorted array to ablanced BST
public class BTS {
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

    public static void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }

    public static Node createBST(int arr[], int start, int end) {
        if (start > end) {
            return null;// invalid condition
        }
        int mid = (start + end) / 2;
        Node root = new Node(arr[mid]);// create new node
        root.left = createBST(arr, start, mid - 1);// create left node and store left root node
        root.right = createBST(arr, mid + 1, end);// ,, right
        return root;
    }

    public static void main(String args[]) {
        int arr[] = { 3, 5, 6, 8, 10, 11, 12 };
        Node root = createBST(arr, 0, arr.length - 1);
        preorder(root);

    }
}
// take user input for sorted array  to balanced BST
import java.util.Scanner;
public class BTS {
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
    public static void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
 public static Node createBST(int arr[], int start, int end) {
        if (start > end) {
            return null; // Invalid condition
        }
        int mid = (start + end) / 2;
        Node root = new Node(arr[mid]); // create new code
        root.left = createBST(arr, start, mid - 1);//create left node and store left root node
        root.right = createBST(arr, mid + 1, end);// ,, right
        return root;
    }
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter " + n + " elements in sorted order:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        Node root = createBST(arr, 0, arr.length - 1);
        System.out.println("Preorder traversal of the BST:");
        preorder(root);
        scanner.close();
    }
}
// covert BST to balance BST using arrayList
import java.util.ArrayList;

public class BTS {
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

    public static void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void getInorder(Node root, ArrayList<Integer> inorder) {
        if (root == null) {
            return;
        }
        getInorder(root.left, inorder);
        inorder.add(root.data);
        getInorder(root.right, inorder);
    }

    public static Node createBST(ArrayList<Integer> inorder, int start, int end) {
        if (start > end) {
            return null;// invalid condition
        }
        int mid = (start + end) / 2;
        Node root = new Node(inorder.get(mid));// create new node
        root.left = createBST(inorder, start, mid - 1);// create left node and store left root node
        root.right = createBST(inorder, mid + 1, end);// ,, right
        return root;
    }

    public static Node balaceBST(Node root) {
        // inorder seq
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(root, inorder);
        // sorted inorder -> balanced BST
        root = createBST(inorder, 0, inorder.size() - 1);
        return root;
    }

    public static void main(String args[]) {
        /*
         * 8
         * / \
         * 6 10
         * / \
         * 5 11
         * / \
         * 3 12
         */
        Node root = new Node(8);
        root.left = new Node(6);
        root.left.left = new Node(5);
        root.left.left.left = new Node(3);
        root.right = new Node(10);
        root.right.right = new Node(11);
        root.right.right.right = new Node(12);
        /*
         * 8
         * / \
         * 5 11
         * / \ / \
         * 3 6 10 12
         * expected bST
         */
        root = balaceBST(root);
        preorder(root);
    }
}
