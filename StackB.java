/**
 * The class `StackB` in Java implements a stack using an ArrayList and provides methods for push, pop,
 * peek, and checking if the stack is empty.
 */
import java.util.ArrayList;
public class StackB {
    static class Stack {
        static ArrayList<Integer> list = new ArrayList<>();

        public static boolean isEmpty() {
            return list.size() == 0;
        }
        // push
        public static void push(int data) {
            list.add(data);
        }
        // pop
        public static int pop() {
            if(isEmpty()){
                return -1;
            }
            int top = list.get(list.size() - 1);// O(1) constant time operration
            list.remove(list.size() - 1);
            return top;
        }
        // peek only top ko nikalna hai aur return karna hai
        public static int peek() {
            if(isEmpty()){
                return -1;
            }
            return list.get(list.size() - 1);
        }
    }

    public static void main(String args[]) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);

        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}
/**
 * The `StackB` class in Java implements a stack data structure using a linked list and includes
 * methods for push, pop, peek, and checking if the stack is empty.
 */

public class StackB {
    static class Node {
        int data;
        Node next;

        Node(int data) {// constuctor
            this.data = data;
            this.next = null;
        }
    }
    static class Stack {
        static Node head = null;

        public static boolean isEmpty() {
            return head == null;
        }
        // push
        public static void push(int data) {
            Node newNode = new Node(data);
            if (isEmpty()) {
                head = newNode;
                return;
            }
            newNode.next = head;
            head = newNode;
        }
        // pop
        public static int pop() {
            if (isEmpty()) {
                return -1;
            }
            int top = head.data;
            head = head.next;
            return top;
        }
        // peek
        public static int peek() {
            if (isEmpty()) {
                return -1;
            }
            return head.data;
        }
    }
    public static void main(String args[]) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}

/**
 * This Java class uses a Stack to push integers onto the stack and then print and pop them in a LIFO
 * (Last In First Out) order.
 * stack using java collection frame work
 */
import java.util.*;

public class StackB {
    public static void main(String args[]) {
        // Stack s = new Stack();
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
    }
}
/**
 * This Java class demonstrates a method to push an element to the bottom of a stack without using
 * extra memory.
 */
import java.util.*;
//push at the bottom of the stack 
//O(n) without using extra memory
public class StackB {
    public static void pushAtBottom(Stack<Integer> s, int data) {
        if (s.isEmpty()) {
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }
    public static void main(String args[]) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);

        pushAtBottom(s, 4);
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
}
/**
 * The class StackB contains a method to reverse a given string using a stack data structure in Java.
 */
import java.util.*;

public class StackB {
    public static String reverseString(String str) {
        Stack<Character> s = new Stack<>();
        int idx = 0;
        while (idx < str.lenght()) {
            s.push(str.charAt(idx));
            idx++;
        }
        StringBuilder result = new StringBuilder("");
        while (!s.isEmpty()) {
            char curr = s.pop();
            result.append(curr);
        }
        return result.toString();
    }
    public static void main(String args[]) {
        String str = "abc";
        String result = reverseString(str);
        System.out.println(result);
    }
}
/**
 * The StackB class in Java contains methods to reverse the order of elements in a stack and print the
 * stack in the reversed order.
 */
import java.util.*;
public class StackB {
    public static void pushAtBottom(Stack<Integer> s, int data) {
        if (s.isEmpty()) {
            s.push(data);
            return;
        }
        int top = s.pop();
        pushAtBottom(s, data);
        s.push(top);
    }
    public static void reverseStack(Stack<Integer> s) {
        if (s.isEmpty()) {
            return;
        }
        int top = s.pop();
        reverseStack(s);
        pushAtBottom(s, top);
    }
    public static void printStack(Stack<Integer> s) {
        while (!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
    public static void main(String args[]) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
//3,2,1
        reverseStack(s);
        printStack(s);//1,2,3
    }
}
