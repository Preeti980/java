// calculate largest number
public static int largestNo(int arr[]){
  int lg = Integer.MIN_VALUE;
  for(int i=0;i<arr.length;i++){
    if(lg<arr[i]){
      lg = arr[i];
    }
  }
  return lg;
}

// calculate second largest number 
public static int secondLargestNo(int arr[]){
  if(arr == null || arr.length >2){
    System.out.println("Array must have 2 elements");
  }
  int lg = Integer.MIN_VALUE;
        int slg = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (lg < arr[i]) {
                slg = lg;
                lg = arr[i];
            } else if (slg < arr[i] && arr[i] != lg) {
                lg = arr[i];
            }
        }
        return slg;
    }
// second Smellest element
 public static int secondSmallestNo(int arr[]) {
        if (arr == null || arr.length < 2) {
            System.out.println("arraya must have 2 elemts.");
        }
        int s = Integer.MAX_VALUE;// smallest
        int ss = Integer.MIN_VALUE;// second smallest
        for (int i = 0; i < arr.length; i++) {
            if (s > arr[i]) {
                ss = s;
                s = arr[i];
            } else if (ss > arr[i] && arr[i] != s) {
                ss = arr[i];
            }
        }
        return ss;
    }
 // to given array is sorted or not
    // approach 1 O(n2)
    public static boolean isSorted(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    return false;
                }
            }
        }
        return true;
    }
//approach 2 O(n)
    public static boolean issort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }
