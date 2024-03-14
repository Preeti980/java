//Bubble sort tc=O(n2)
public class BasicSorting {
    public static void bubbleSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String args[]) {
        int arr[] = { 5, 4, 1, 3, 2 };
        bubbleSort(arr);
        printArr(arr);
    }
}
//selection sort tc= O(n2)
    public static void selectionSort(int arr[]) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] < arr[j]) {
                    min = j;
                }
            }
            // swap
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }
    public static void printArr(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
 public static void main(String args[]) {
        int arr[] = { 5, 4, 1, 3, 2 };
        selectionSort(arr);
        printArr(arr);
    }
}
// insertion sort tc=O(n2)
public static void insertionSort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i];
            int prev = i - 1;
            // finding out the correct pos to insert
            while (prev >= 0 && arr[prev] > curr) {
                arr[prev + 1] = arr[prev];
                prev--;
            }
            // insertion
            arr[prev + 1] = curr;
        }
    }

//Inbuilt sort
//import java.util.Arrays
//Arrays.sort(arr)
// time complexity= O(nlog)
//Arrays.sort(arr,si,ei);
//Arrays.sort(arr,si,ei,Collections.reverseOrder());
import java.util.*;

public class BasicSorting {

    public static void printArr(Integer arr[]) {
        for (int i = 1; i <= arr.length; i++) {
            System.out.println(i + " ");
        }
    }
    public static void main(String args[]) {
        Integer arr[] = { 5, 4, 1, 3, 2 };
        Arrays.sort(arr);//asending order
      
        printArr(arr);
    }
}
