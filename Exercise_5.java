// Time Complexity :O(n2) - worst case and O(nlogn) avg case
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : N/A
// Any problem you faced while coding this : Yes, difficult to understand the concept.
class IterativeQuickSort {
    void swap(int arr[], int i, int j) 
    { 
	//Try swapping without extra variable
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    } 
  
    /* This function is same in both iterative and 
       recursive*/
    int partition(int arr[], int l, int h) 
    { 
        int pivot = arr[h];

        int i = (l - 1);
        for (int j = l; j <= h - 1; j++) {
            if (arr[j] <= pivot) {
                i++;

                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        swap(arr,i+1,h);

        return i + 1;
    } 
  
    void QuickSort(int arr[], int l, int h)
    { 
        int[] stack = new int[h - l + 1];

        int top = -1;

        stack[++top] = l;
        stack[++top] = h;

        while (top >= 0) {
            h = stack[top--];
            l = stack[top--];


            int p = partition(arr, l, h);

            if (p - 1 > l) {
                stack[++top] = l;
                stack[++top] = p - 1;
            }
            if (p + 1 < h) {
                stack[++top] = p + 1;
                stack[++top] = h;
            }
        }
    } 
  
    // A utility function to print contents of arr 
    void printArr(int arr[], int n) 
    { 
        int i; 
        for (i = 0; i < n; ++i) 
            System.out.print(arr[i] + " "); 
    } 
  
    // Driver code to test above 
//    public static void main(String args[])
//    {
//        IterativeQuickSort IterativeQuickSort = new IterativeQuickSort();
//        int arr5[] = { 4, 3, 5, 2, 1, 3, 2, 3 };
//        IterativeQuickSort.QuickSort(arr5, 0, arr5.length - 1);
//        IterativeQuickSort.printArr(arr5, arr5.length);
//    }
} 