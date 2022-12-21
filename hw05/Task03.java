// Реализовать алгоритм пирамидальной сортировки (HeapSort).

package hw05;

public class Task03 {
    public static void main(String[] args) {
        int arr[] = {63, 47, 24, 77, 68, 10, 48, 34, 32, 70, 65, 7, 57, 8, 78, 16, 50, 54, 85, 5};
        System.out.printf("Original array is \t%s\n", arrToString(arr));
        HeapSort(arr);
        System.out.printf("Sorted array is \t%s\n", arrToString(arr));
    }

    /**
    * Sorts array with Heap Sort algorithm
    * @param  numbers       the unsorted array int[]
    */
    public static void HeapSort(int[] numbers) {
        int arrLen = numbers.length;

        // Init first heap
        for (int i = arrLen / 2 - 1; i >= 0; i--) {
            heapify(numbers, arrLen, i);
        }

        for (int i = arrLen - 1; i >= 0; i--)
        {
            // Move current root of tree to the end of array
            swap(numbers, i, 0);

            // Call heapify function on decreased heap
            heapify(numbers, i, 0);
        }
    }

    /**
    * Moves the largest element to the root of tree (recursive)
    * @param  arr       the unsorted array int[]
    * @param  heapLen   the heap length
    * @param  root      the root of tree
    */
    public static void heapify(int arr[], int heapLen, int root) {
        int largest = root;            // assign a root of tree as largest element
        int left = getLeft(root);      // get left child element
        int right = getRight(root);    // get right child element

        // Find largest element and swap it to root element
        if (left < heapLen && arr[left] > arr[largest]) largest = left;
        if (right < heapLen && arr[right] > arr[largest]) largest = right;
        if (largest != root) {
            swap(arr, root, largest);
            heapify(arr, heapLen, largest);
        } 
    }

    /**
    * Swaps two elements in array
    * @param  arr     the unsorted array int[]
    * @param  i       the index of one element
    * @param  j       the index of another element
    */
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    /**
    * Returns left child from binary tree
    * @param  i       the index of root element
    *
    * @return         the left child index
    */
    private static int getLeft(int i) {
        return 2 * i + 1;
    }

    /**
    * Returns right child from binary tree
    * @param  i       the index of root element
    *
    * @return         the right child index
    */
    private static int getRight(int i) {
        return 2 * i + 2;
    }

    /**
    * Builds string from array
    * @param  arr     the array int[]
    *
    * @return         the String representation of array
    */
    private static String arrToString(int[] arr) {
        StringBuilder res = new StringBuilder();
        res.append("[ ");
        for (int i : arr) {
            res.append(String.format("%s ", i));
        }
        res.append("]");
        return res.toString();
    }
}
