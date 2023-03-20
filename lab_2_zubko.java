import java.util.Arrays;
import java.util.Random;

public class lab_2_zubko {
    public static void selectSort(int[] A) {
        int n = A.length;
        for (int i = 0; i < n - 1; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (A[j] < A[min]) {
                    min = j;
                }
            }
            swap(A, min, i);
        }
    }
    private static void swap(int[] A, int a, int b) {
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }
    public static void bubbleSort(int[] A) {
        int n = A.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = n - 1; j > i; j--) {
                if (A[j] < A[j - 1]) {
                    swap(A, j, j - 1);
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] testData = {5, 3, 8, 1, 7, 2, 4, 6};
        System.out.println("Original:");
        printArray(testData);
        int[] selectSortData = testData.clone();
        selectSort(selectSortData);
        System.out.println("After selection sort:");
        printArray(selectSortData);
        int[] bubbleSortData = testData.clone();
        bubbleSort(bubbleSortData);
        System.out.println("After bubble sort:");
        printArray(bubbleSortData);

        //analiz
        int[] sizes = {500, 1000, 2000, 4000, 8000, 16000};
        Random random = new Random();
        System.out.println("Size\tSelection Sort Time\tBubble Sort Time");
        for (int size : sizes) {
            int[] randomArray = new int[size];
            for (int i = 0; i < size; i++) {
                randomArray[i] = random.nextInt(10000);
            }
            int[] selectSortData1 = randomArray.clone();
            long startTimeSelect = System.currentTimeMillis();
            selectSort(selectSortData1);
            long endTimeSelect = System.currentTimeMillis();
            long elapsedTimeSelect = endTimeSelect - startTimeSelect;
            int[] bubbleSortData1 = randomArray.clone();
            long startTimeBubble = System.currentTimeMillis();
            bubbleSort(bubbleSortData1);
            long endTimeBubble = System.currentTimeMillis();
            long elapsedTimeBubble = endTimeBubble - startTimeBubble;
            System.out.println(size + "\t" + elapsedTimeSelect + "\t" + elapsedTimeBubble);
        }
    }
    private static void printArray(int[] A) {
        for (int i : A) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
