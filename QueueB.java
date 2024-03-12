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


// question 3:
// Stack using 2 queue
import java.util.*;

public class QueueB {
    static class Stack {
        static Queue<Integer> q1 = new LinkedList<>();
        static Queue<Integer> q2 = new LinkedList<>();

        public static boolean isEmpty() {
            return q1.isEmpty() && q2.isEmpty();
        }

        public static void push(int data) {
            if (!q1.isEmpty()) {
                q1.add(data);
            } else {
                q2.add(data);
            }
        }

        public static int pop() {
            if (isEmpty()) {
                System.out.println("empty stack");
                return -1;

            }
            int top = -1;
            // case 1
            if (!q1.isEmpty()) {
                while (!q1.isEmpty()) {
                    top = q1.remove();
                    if (q1.isEmpty()) {
                        break;
                    }
                    q2.add(top);
                }

            } else {
                // case 2
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    if (q2.isEmpty()) {
                        break;
                    }
                    q1.add(top);
                }

            }
            return top;
        }

        public static int peek() {
            if (isEmpty()) {
                System.out.println("empty stack");
                return -1;
            }
            int top = -1;
            // case 1
            if (!q1.isEmpty()) {
                top = q1.remove();
                q2.add(top);
            } else {
                // case 2
                while (!q2.isEmpty()) {
                    top = q2.remove();
                    q1.add(top);
                }
            }
            return top;
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


//Question - 4
// First non- repeating letter in  a stream of charcter
import java.util.*;

public class QueueB {
    public static void printNonRepeating(String str) {
        int freq[] = new int[26];// 'a'-'z'
        Queue<Character> q = new LinkedList<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            q.add(ch);
            freq[ch - 'a']++;

            while (!q.isEmpty() && freq[q.peek() - 'a'] > 1) {
                q.remove();
            }
            if (q.isEmpty()) {
                System.out.print(-1 + " ");
            } else {
                System.out.print(q.peek() + " ");
            }
        }
        System.out.println();
    }

    public static void main(String args[]) {
        String str = "aabccxb";
        printNonRepeating(str);
    }
}


//Question- 5
// interLeav 2 halves of a queue(even length)
import java.util.*;

public class QueueB {
    public static void InterLeave(Queue<Integer> q) {
        Queue<Integer> firstHalf = new LinkedList<>();
        int size = q.size();

        for (int i = 0; i < size / 2; i++) {
            firstHalf.add(q.remove());
        }
        while (!firstHalf.isEmpty()) {
            q.add(firstHalf.remove());
            q.add(q.remove());
        }
    }

    public static void main(String args[]) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);

        InterLeave(q);
        while (!q.isEmpty()) {
            System.out.print(q.remove() + " ");
        }
        System.out.println();
    }
}


//Question- 5
// Queue reversal 1 2 3 4 5
// final= 5 4 3 2 1 
import java.util.*;

public class QueueB {
    public static void queueReverse(Queue<Integer> q) {
        Stack<Integer> s = new Stack<>();
        while (!q.isEmpty()) {
            s.push(q.remove());
        }
        while (!s.isEmpty()) {
            q.add(s.pop());
        }
    }

    public static void main(String args[]) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);

        queueReverse(q);
        while (!q.isEmpty()) {
            System.out.print(q.remove() + " ");
        }
        System.out.println();
    }
}
//deque - double ended queue
import java.util.*;

public class QueueB {

    public static void main(String args[]) {
        Deque<Integer> deque = new LinkedList<>();
        deque.addFirst(1);// 1
        deque.addFirst(2);// 2 1
        deque.addLast(3);// 2 1 3
        deque.addLast(4);// 2 1 3 4
        System.out.println(deque);
        // deque.removeFirst();
        // System.out.println(deque);
        System.out.println("first el" + deque.getFirst());
        System.out.println("last el"+ deque.getLast());
    }
}


//deque - double ended queue
// stack using deque
import java.util.*;

public class QueueB {
    static class Stack {
        Deque<Integer> deque = new LinkedList<>();

        public void push(int data) {
            deque.addLast(data);

        }

        public int pop() {
            return deque.removeLast();
        }

        public int peek() {
            return deque.getLast();
        }
    }

    public static void main(String args[]) {
        Stack s = new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println("peek =" + s.peek());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.pop());
    }
}


//deque - double ended queue
// Queue using deque
import java.util.*;

public class QueueB {
    static class Queue {
        Deque<Integer> deque = new LinkedList<>();

        public void add(int data) {
            deque.addLast(data);

        }

        public int remove() {
            return deque.removeFirst();
        }

        public int peek() {
            return deque.getFirst();
        }
    }

    public static void main(String args[]) {
        Queue s = new Queue();
        s.add(1);
        s.add(2);
        s.add(3);
        System.out.println("peek =" + s.peek());
        System.out.println(s.remove());
        System.out.println(s.remove());
        System.out.println(s.remove());
    }
}
