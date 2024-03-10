/**
 * The `QueueB` class in Java implements a basic queue data structure with methods for adding,
 * removing, and peeking elements.
 * using array
 */
public class QueueB {
    static class Queue {
        static int arr[];
        static int size;
        static int rear;

        Queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
        }

        public static boolean isEmpty() {
            return rear == -1;
        }

        // add
        public static void add(int data) { // time complexity =O(1)
            if (rear == size - 1) {
                System.out.println("queue is full");
            }
            rear = rear + 1;
            arr[rear] = data;
        }

        // remove
       /**
        * The `remove` function removes and returns the front element of a queue implemented using an
        * array in Java.
        * 
        * @return The `remove()` method returns the element that is removed from the front of the
        * queue.
        */
        public static int remove() {// time complexity=O(n) 
            if (isEmpty()) {
                System.out.println("empty queue");
                return -1;
            }
            int front = arr[0];
            for (int i = 0; i < rear; i++) {
                arr[i] = arr[i + 1];
            }
            rear = rear - 1;
            return front;
        }

        // peek
      /**
      * The `peek` function in Java returns the element at the front of the queue or -1 if the queue is
      * empty.
      * 
      * @return The `peek` method is returning the element at the front of the queue. If the queue is
      * empty, it will print "empty queue" and return -1.
      */
        public static int peek() {
            if (isEmpty()) {
                System.out.println("empty queue");
                return -1;
            }
            return arr[0];
        }
    }

    public static void main(String args[]) {
        Queue q = new Queue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}

/**
 * The `QueueB` class in Java implements a circular queue data structure with methods to add, remove,
 * and peek elements while handling full and empty queue conditions.
 */

public class QueueB {
    static class Queue {
        static int arr[];
        static int size;
        static int rear;
        static int front;

        Queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }

        /**
         * The function checks if both the rear and front indices are -1 to determine if
         * the queue is
         * empty.
         * 
         * @return The method `isEmpty()` returns a boolean value, indicating whether
         *         the queue is empty
         *         or not. It returns `true` if both `rear` and `front` are equal to -1,
         *         and `false` otherwise.
         */
        public static boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        /**
         * The function `isFull` checks if the circular queue is full by comparing the
         * positions of the
         * front and rear elements.
         * 
         * @return The method `isFull()` is returning a boolean value that indicates
         *         whether the
         *         circular queue is full or not.
         */
        public static boolean isFull() {
            return (rear + 1) % size == front;
        }

        // add
        public static void add(int data) { // time complexity =O(1)
            if (isFull()) {
                System.out.println("queue is full");
                return;
            }
            // add first element in circular queue
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % size;
            arr[rear] = data;
        }

        // remove

    /**
     * The `remove` function in Java removes and returns the element at the front of a queue, updating
     * the front and rear pointers accordingly.
     * 
     * @return The `remove` method returns the element that is being removed from the queue.
     */
        public static int remove() {// time complexity=O(1)
            if (isEmpty()) {
                System.out.println("empty queue");
                return -1;
            }
            int result = arr[front];
            front = (front + 1) % size;
            // last element detele
            if (rear == front) {
                rear = front = -1;
            } else {
                front = (front + 1) % size;
            }
            return result;
        }

        // peek

        public static int peek() {// TM=O(1)
            if (isEmpty()) {
                System.out.println("empty queue");
                return -1;
            }
            return arr[front];
        }
    }

    public static void main(String args[]) {
        Queue q = new Queue(5);
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q.remove());
        q.add(4);
        System.out.println(q.remove());
        q.add(5);
        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}

// question 1 :
// Queue using linked List 
public class QueueB {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Queue {
        static Node head = null;
        static Node tail = null;

        public static boolean isEmpty() {
            return head == null & tail == null;
        }

        public static void add(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = tail = newNode;
                return;
            }
            tail.next = newNode;
            tail = newNode;
        }

        // remove
        public static int remove() {
            if (isEmpty()) {
                System.out.println("empty queue");
                return -1;
            }
            int front = head.data;
            // single element
            if (tail == head) {
                tail = head = null;
            } else {
                head = head.next;
            }
            return front;
        }

        // peek
        public static int peek() {
            if (isEmpty()) {
                System.out.println("empty queue");
                return -1;
            }
            return head.data;
        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);
        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}

// question 1 : TC=O(1)
// Queue using linked List  using packages
import java.util.*;
public class QueueB {
    public static void main(String[] args) {
        // Queue q = new Queue();
        // Queue<Integer> q = new LinkedList<>(); // Queue in java not a class it is a
        // frame work // Queue ko java me 2 class implement karti hai 1- linkedlist and
        // 2-ArrayDeque
        // or
        Queue<Integer> q = new ArrayDeque<>();
        q.add(1);
        q.add(2);
        q.add(3);
        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}

/**
 * The class `QueueB` implements a queue data structure using two stacks in Java.
 */

// question 2 :
// Queue using 2 stacks
import java.util.*;

public class QueueB {
    static class Queue {
        static Stack<Integer> s1 = new Stack<>();
        static Stack<Integer> s2 = new Stack<>();

        public static boolean isEmpty() {
            return s1.isEmpty();
        }

        // add-O(n)
        public void add(int data) {
            while (!s1.isEmpty()) {

                s2.push(s1.pop());
            }
            s1.push(data);
            while (!s2.isEmpty()) {
                s1.push(s2.pop());
            }
        }

        // rmeove-O(1)
        public static int remove() {
            if (isEmpty()) {
                System.out.println("queue is empty");
                return -1;
            }
            return s1.pop();
        }

        // peek-O(1)
        public static int peek() {
            if (isEmpty()) {
                System.out.println("queue is empty");
                return -1;
            }
            return s1.peek();

        }
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }

    }
}
