import java.util.Arrays;

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
        //task 4
        //task 5
        //task 6
    }
}