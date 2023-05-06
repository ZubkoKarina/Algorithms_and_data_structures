import java.util.Arrays;
import java.util.Comparator;

public class lab_5_zubko{
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
    
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
    
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
 
    public static void cocktailSort(int[] arr) {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
            swapped = false;
            for (int i = arr.length - 2; i >= 0; i--) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
    }
    public static void bubbleSort2(int[] arr) {
        boolean swapped;
        int lastIndex = arr.length - 1;
        do {
            swapped = false;
            for (int i = 0; i < lastIndex; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapped = true;
                }
            }
            lastIndex--;
        } while (swapped);
    }
    public static <T> void selectionSort(T[] arr, Comparator<T> comparator) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (comparator.compare(arr[j], arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            T temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
    public static <T> void insertionSort(T[] arr, Comparator<T> comparator) {
        for (int i = 1; i < arr.length; i++) {
            T key = arr[i];
            int j = i - 1;
            while (j >= 0 && comparator.compare(arr[j], key) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
    public static <T> void bubbleSort(T[] arr, Comparator<T> comparator) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (comparator.compare(arr[j], arr[j + 1]) > 0) {
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    public static <T> void cocktailSort(T[] arr, Comparator<T> comparator) {
        boolean swapped;
        int start = 0;
        int end = arr.length;
        while (start < end) {
            swapped = false;
            for (int i = start; i < end - 1; ++i) {
                if (comparator.compare(arr[i], arr[i + 1]) > 0) {
                    T temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
            swapped = false;
            end--;

            for (int i = end - 1; i >= start; i--) {
                if (comparator.compare(arr[i], arr[i + 1]) > 0) {
                    T temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    swapped = true;
                }
            }
            start++;
        }
    }
    public static int[] naiveMinMax(int[] arr) {
        int min = arr[0];
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return new int[]{min, max};
    }
    public static int[] divideAndConquerMinMax(int[] arr, int start, int end) {
        if (start == end) {
            return new int[]{arr[start], arr[start]};
        } else if (end - start == 1) {
            return arr[start] < arr[end] ? new int[]{arr[start], arr[end]} : new int[]{arr[end], arr[start]};
        }
        int mid = (start + end) / 2;
        int[] leftMinMax = divideAndConquerMinMax(arr, start, mid);
        int[] rightMinMax = divideAndConquerMinMax(arr, mid + 1, end);
        int min = Math.min(leftMinMax[0], rightMinMax[0]);
        int max = Math.max(leftMinMax[1], rightMinMax[1]);
        return new int[]{min, max};
    }
    public static long naivePower(long base, int exponent) {
        long result = 1;
        for (int i = 0; i < exponent; i++) {
            result *= base;
        }
        return result;
    }
    public static long divideAndConquerPower(long base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent % 2 == 0) {
            long temp = divideAndConquerPower(base, exponent / 2);
            return temp * temp;
        } else {
            return base * divideAndConquerPower(base, exponent - 1);
        }
    }
    public static void main(String[] args){
        //task 1
        int[] identicalKeys = {7, 7, 7, 7, 7, 7, 7};
        long startTime, endTime;
        int[] selectionArray = identicalKeys.clone();
        startTime = System.nanoTime();
        selectionSort(selectionArray);
        endTime = System.nanoTime();
        System.out.println("Selection sort: " + (endTime - startTime) + " ns");
        int[] insertionArray = identicalKeys.clone();
        startTime = System.nanoTime();
        insertionSort(insertionArray);
        endTime = System.nanoTime();
        System.out.println("Insertion sort: " + (endTime - startTime) + " ns");
        int[] bubbleArray = identicalKeys.clone();
        startTime = System.nanoTime();
        bubbleSort(bubbleArray);
        endTime = System.nanoTime();
        System.out.println("Bubble sort: " + (endTime - startTime) + " ns");
        //task 2
        int[] reversedArray = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        int[] arrayForSelectionSort = Arrays.copyOf(reversedArray, reversedArray.length);
        int[] arrayForInsertionSort = Arrays.copyOf(reversedArray, reversedArray.length);
        int[] arrayForBubbleSort = Arrays.copyOf(reversedArray, reversedArray.length);
        long startTime1, endTime1;
        startTime1 = System.nanoTime();
        selectionSort(arrayForSelectionSort);
        endTime1 = System.nanoTime();
        System.out.println("Select sort: " + (endTime1- startTime1) + " nanosec");
        startTime1 = System.nanoTime();
        insertionSort(arrayForInsertionSort);
        endTime1 = System.nanoTime();
        System.out.println("Insertion sort: " + (endTime1 - startTime1) + " nanosec");
        startTime1 = System.nanoTime();
        bubbleSort(arrayForBubbleSort);
        endTime1 = System.nanoTime();
        System.out.println("Bubble sort: " + (endTime1 - startTime1) + " nanosec");
        //task 3
        int[] arr1 = {5, 2, 9, 1, 5, 6};
        int[] arr2 = arr1.clone();
        int[] arr3 = arr1.clone();
        cocktailSort(arr1);
        bubbleSort(arr2);
        bubbleSort2(arr3);
        System.out.println("Cocktail sort: " + Arrays.toString(arr1));
        System.out.println("Bubble sort: " + Arrays.toString(arr2));
        System.out.println("Bubble sort 2: " + Arrays.toString(arr3));
        //task 4
        Integer[] arr = {5, 3, 8, 1, 6, 2, 7, 4};
        Comparator<Integer> comparator = Integer::compareTo;
        System.out.println("Array:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        selectionSort(arr, comparator);
        System.out.println("Array:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        arr = new Integer[]{5, 3, 8, 1, 6, 2, 7, 4};
        insertionSort(arr, comparator);
        System.out.println("Array:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        arr = new Integer[]{5, 3, 8, 1, 6, 2, 7, 4};
        bubbleSort(arr, comparator);
        System.out.println("Array:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        arr = new Integer[]{5, 3, 8, 1, 6, 2, 7, 4};
        cocktailSort(arr, comparator);
        System.out.println("Array:");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        //task 5
        int[] arr4 = {3, 5, 2, 9, 6, 1, 8, 7, 4};
        int[] naiveResult = naiveMinMax(arr4);
        System.out.println("Naive: min = " + naiveResult[0] + ", max = " + naiveResult[1]);
        int[] divideAndConquerResult = divideAndConquerMinMax(arr4, 0, arr4.length - 1);
        System.out.println("Divide and conquer: min = " + divideAndConquerResult[0] + ", max = " + divideAndConquerResult[1]);
        //task 6
        long base = 3;
        int exponent = 10;
        long startTime3 = System.nanoTime();
        long naiveResult3 = naivePower(base, exponent);
        long naiveDuration3 = System.nanoTime() - startTime3;
        startTime = System.nanoTime();
        long divideAndConquerResult3 = divideAndConquerPower(base, exponent);
        long divideAndConquerDuration3 = System.nanoTime() - startTime;
        System.out.println("Naive: res = " + naiveResult3 + ", time = " + naiveDuration3 + " nanosec");
        System.out.println("Divide and conquer: res = " + divideAndConquerResult3 + ", time = " + divideAndConquerDuration3 + " nanosec");
        if (naiveDuration3 > divideAndConquerDuration3) {
            System.out.println("Algorytm dziel i zwyciężaj jest szybszy niż algorytm naiwny.");
        } else if (naiveDuration3 < divideAndConquerDuration3) {
            System.out.println("Algorytm naiwny jest szybszy niż algorytm „dziel i zwyciężaj”.");
        } else {
            System.out.println("Oba algorytmy zakończyły się w tym samym czasie.");
        }
    }
}
