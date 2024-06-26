//what is BSt 
//a. left subtree Nodes <root
// b. right subtree nodes> root
// c. left & right subtrees are  also BST with no duplicates
//Build a binary tree
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
    // implementation of binary tree
    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (root.data > val) {
            // left subtree
          root.left = insert(root.left, val);// insert ek pointer return karega jisko hum root.left ke ander store kar denge
        } else {
            // right subtree
            root.right = insert(root.right, val);
        }
        return root;
    }
    // inorder traversal
    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data);
        inorder(root.right);
    }
    public static void main(String args[]) {
        int values[] = { 5, 1, 3, 4, 2, 7 };
        Node root = null; // in first step need to create null node
        for (int i = 0; i < values.length; i++) {// insert values
            root = insert(root, values[i]);
        }
        inorder(root);// print inorder
        System.out.println();
    }
}
// Search a BST
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
    // implementation of binary tree
    public static Node insert(Node root, int val) {
        if (root == null) {// agar root null hai to
            root = new Node(val);// new Node create karo aur usme uski value asign kar or fill kar do
            return root;
        }
        if (root.data > val) {
            // left subtree
            root.left = insert(root.left, val);// insert ek pointer return karega jisko hum root.left ke ander store kar
                                               // denge
        } else {
            // right subtree
            root.right = insert(root.right, val);// ,,
        }
        return root;
    }
// search element in existing binary tree
    public static boolean search(Node root, int key) {
        if (root == null) { // when root is equal to null then return false means key does not exist in binary tree
            return false;
        }
        if (root.data == key) { // when key match with root data
            return true;
        }
        if (root.data > key) {
            return search(root.left, key);// tree ke left data ko search karenge aur us data ko return kar denge boolean form me
        } else {
            return search(root.right, key);// ,,
        }
    }

    public static void main(String args[]) {
        int values[] = { 10, 7, 8, 9, 1, 6, 4, 5, 2, 3 };
        Node root = null; // in first step need to create null node
        for (int i = 0; i < values.length; i++) {// insert values in BST
            root = insert(root, values[i]);
        }
        if (search(root, 11)) {
            System.out.println("found");
        } else {
            System.out.println("not found");
        }
    }
}

// delete a Node
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
    // implementation of binary tree
    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (root.data > val) {
            // left subtree
            root.left = insert(root.left, val);// insert ek pointer return karega jisko hum root.left ke ander store kar
                                               // denge
        } else {
            // right subtree
            root.right = insert(root.right, val);
        }
        return root;
    }

    // inorder traversal
    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
 public static boolean search(Node root, int key) {
        if (root == null) {
            return false;
        }
        if (root.data == key) {
            return true;
        }
        if (root.data > key) {
            return search(root.left, key);// search karne ke baad hum data reurn kar denge
        } else {
            return search(root.right, key);
        }
    }
    public static Node delete(Node root, int val) {
        if (root.data < val) {// search value for deleting
            root.right = delete(root.right, val);
        } else if (root.data > val) {
            root.left = delete(root.left, val);
        } else {// jaha hume value delete karni hai
                // case 1 -leaf node
            if (root.left == null && root.right == null) {
                return null;// null store karane ka mtlb hai ki leaf node delete ho gyi hai
            }
            // case 2 - single child
            /*
             * if i want to delete node 10 and delete 10 and replace with child node (8)
             * 8 8
             * \ \
             * 10 ----> 11
             * \ \
             * 11 14
             * \
             * 14
             */
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // case 3 : both children means left and right both node exist
            // first of all find inorder successor so create a function for for finding
            // inorder successor
            Node IS = findInorderSuccessor(root.right);// kyu ki inorder successor data root ke right me hata hai
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }
        return root;
    }
    public static Node findInorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
      return root;
    }
    public static void main(String args[]) {
        int values[] = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        Node root = null; // in first step need to create null node
        for (int i = 0; i < values.length; i++) {// insert values
            root = insert(root, values[i]);
        }
        inorder(root);
        System.out.println();
        root = delete(root, 1);
        System.out.println();
        inorder(root);
        ;

    }
}

// print in range k1=5 to k2=12
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
    // implementation of binary tree
    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (root.data > val) {
            // left subtree
            root.left = insert(root.left, val);// insert ek pointer return karega jisko hum root.left ke ander store // denge
        } else {
            // right subtree
            root.right = insert(root.right, val);
        }
        return root;
    }
    // inorder traversal
    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }
    public static void printInRange(Node root, int k1, int k2) {
        if (root == null) {
            return;
        }
        if (root.data >= k1 && root.data <= k2) {
            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRange(root.right, k1, k2);
        } else if (root.data < k1) {
            printInRange(root.left, k1, k2);
        } else {
            printInRange(root.right, k1, k2);
        }
    }
    public static void main(String args[]) {
        int values[] = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        Node root = null; // in first step need to create null node
        for (int i = 0; i < values.length; i++) {// insert values
            root = insert(root, values[i]);
        }
        inorder(root);
        System.out.println();
        printInRange(root, 5, 12);
    }
}
// Root to leaf path
import java.util.*;
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

    // implementation of binary tree
    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (root.data > val) {
            // left subtree
            root.left = insert(root.left, val);// insert ek pointer return karega jisko hum root.left ke ander store kar
                                               // denge
        } else {
            // right subtree
            root.right = insert(root.right, val);
        }
        return root;
    }
    public static void printPath(ArrayList<Integer> path) {
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + "-> ");
        }
        System.out.println("null");
    }

    public static void printRoot2Leaf(Node root, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.data); // arrayList me data add kar dena
        if (root.left == null && root.right == null) {
            printPath(path);
        }
        printRoot2Leaf(root.left, path);// assume that ki left se jitni cheeje add ho rhi hogi utni remove v ho rhi hogi
        printRoot2Leaf(root.right, path);// ,,
        path.remove(path.size() - 1);// root node ka data last index pe exist karta hai
    }

    public static void main(String args[]) {
        int values[] = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        Node root = null; // in first step need to create null node
        for (int i = 0; i < values.length; i++) {// insert values
            root = insert(root, values[i]);
        }  
        printRoot2Leaf(root, new ArrayList<>());
    }
}
//Validate BST

import java.util.*;

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

    // implementation of binary tree
    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (root.data > val) {
            // left subtree
            root.left = insert(root.left, val);// insert ek pointer return karega jisko hum root.left ke ander store kar
                                               // denge
        } else {
            // right subtree
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static void printPath(ArrayList<Integer> path) {
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + "-> ");
        }
        System.out.println("null");
    }

    public static void printRoot2Leaf(Node root, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.data); // arrayList me data add kar dena
        if (root.left == null && root.right == null) {
            printPath(path);
        }
        printRoot2Leaf(root.left, path);// assume that ki left se jitni cheeje add ho rhi hogi utni remove v ho rhi hogi
        printRoot2Leaf(root.right, path);// ,,
        path.remove(path.size() - 1);// root node ka data last index pe exist karta hai
    }

    public static boolean isValidBST(Node root, Node min, Node max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.data <= min.data) {
            return false;
        } else if (max != null && root.data >= max.data) {
            return false;
            return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
        }
    }

    public static void main(String args[]) {
        int values[] = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        Node root = null; // in first step need to create null node
        for (int i = 0; i < values.length; i++) {// insert values
            root = insert(root, values[i]);
        }
        if (isValidBST(root, null, null)) {
            System.out.println("valid");
        } else {
            System.out.println("not valid");
        }
    }
}
//Mirror image of BST
/*
 *  8      |       8
 * /  \    |      /  \
 * 5   10  |     10   5
 * /\   \  |     /   / \
 * 3 6  11 |    11   6  3
 */
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
    public static Node createMirror(Node root) {
        if (root == null) {
            return null;
        }
        Node leftMirror = createMirror(root.left);
        Node rightMirror = createMirror(root.right);
        root.left = rightMirror;
        root.right = leftMirror;
        return root;
    }
    public static void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
    }
    public static void main(String args[]) {
        Node root = new Node(8);
        root.left = new Node(5);
        root.right = new Node(10);
        root.left.left = new Node(3);
        root.left.right = new Node(6);
        root.right.right = new Node(11);
        root = createMirror(root);
        preorder(root);

    }
}
