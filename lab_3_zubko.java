import java.util.Random;

public class lab_3_zubko{
    /*
    * Task 1:
    * Zewnętrzna pętla wykonuje się log2(N) razy, 
    * ponieważ na każdej iteracji wartość n jest dzielona przez 2. 
    * Wewnętrzna pętla wykonuje się n razy. W związku z tym ogólna złożoność 
    * algorytmu wynosi O(N).
    * 
    * Zewnętrzna pętla wykonuje się log2(N) razy, ponieważ na każdej 
    * iteracji wartość i jest mnożona przez 2. Wewnętrzna pętla wykonuje 
    * się i razy. W związku z tym ogólna złożoność algorytmu wynosi O(N).
    * 
    * Zewnętrzna pętla wykonuje się log2(N) razy, ponieważ na każdej 
    * iteracji wartość i jest mnożona przez 2. Wewnętrzna pętla wykonuje 
    * się N razy. W związku z tym ogólna złożoność algorytmu wynosi O(N*log2(N)).
    */
    public static int example1(int N) {
        int sum = 0;
        for (int n = N; n > 0; n /= 2) {
            for (int i = 0; i < n; i++) {
                sum++;
            }
        }
        return sum;
    }
    public static int example2(int N) {
        int sum = 0;
        for (int i = 1; i < N; i *= 2) {
            for (int j = 0; j < i; j++) {
                sum++;
            }
        }
        return sum;
    }
    public static int example3(int N) {
        int sum = 0;
        for (int i = 1; i < N; i *= 2) {
            for (int j = 0; j < N; j++) {
                sum++;
            }
        }
        return sum;
    }
    public static int countFourSums(int[] array) {
        int count = 0;
        int N = array.length;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    for (int l = k + 1; l < N; l++) {
                        if (array[i] + array[j] + array[k] + array[l] == 0) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
    public static int findLocalMinimum(int[] A) {
        int L = 0;
        int R = A.length - 1;
        while (L < R) {
            int M = (L + R) / 2;
            if (A[M] < A[M - 1] && A[M] < A[M + 1]) {
                return A[M];
            } else if (A[M - 1] < A[M]) {
                R = M - 1;
            } else {
                L = M + 1;
            }
        }
        return A[L];
    }
    public static int[] bitonic(int N) {
        Random ran = new Random();
        int mid = ran.nextInt(N);
        int[] a = new int[N];
        for (int i = 1; i < mid; i++) {
            a[i] = a[i - 1] + 1 + ran.nextInt(9);
        }
        if (mid > 0) a[mid] = a[mid - 1] + ran.nextInt(10) - 5;
        for (int i = mid + 1; i < N; i++) {
            a[i] = a[i - 1] - 1 - ran.nextInt(9);
        }
        for (int i = 0; i < N; i++) {
            System.out.println(a[i]);
        }
        return a;
    }
    public static int findMax(int[] array) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (array[mid] > array[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
            return array[left];
    }
    public static int findMax(int[] arr, int left, int right) {
        if (left == right) {
            return arr[left];
        }
        int mid = left + (right - left) / 2;
        if (arr[mid] > arr[mid + 1]) {
            return findMax(arr, left, mid);
        } else {
            return findMax(arr, mid + 1, right);
        }
    }
    public static int binarySearch(int[] arr, int left, int right, int key, boolean isAscending) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == key) {
                return mid;
            }
            if (isAscending) {
                if (key < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (key > arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }
    public static boolean bitonicSearch(int[] arr, int key) {
        int maxIndex = findMax(arr, 0, arr.length - 1);
        int leftSearch = binarySearch(arr, 0, maxIndex, key, true);
        int rightSearch = binarySearch(arr, maxIndex + 1, arr.length - 1, key, false);
        return leftSearch != -1 || rightSearch != -1;
    }
    public static void main(String[] args){
        //task 1
        int N = 8;
        int sum1 = example1(N);
        int sum2 = example2(N);
        int sum3 = example3(N);
        System.out.println("Example 1: " + sum1);
        System.out.println("Example 2: " + sum2);
        System.out.println("Example 3: " + sum3);
        //task 2 
        int[] array = {1, 0, -1, 2, -2, 3, -3};
        int count = countFourSums(array);
        System.out.println(" : " + count);
        //task 3
        int[] A1 = {8, 5, 7, 2, 3, 4, 1, 9};
        int[] A2 = {8, 5, 2, 7, 3, 4, 1, 9};
        System.out.println("Local min A1: " + findLocalMinimum(A1));
        System.out.println("Local max A2: " + findLocalMinimum(A2));
        //task 4
        int N1 = 10;
        int[] array1 = bitonic(N1);
        int max = findMax(array1);
        System.out.println("Max: " + max);
        //task 5
        int[] bitonicArray = {1, 3, 5, 9, 7, 6, 4, 2};
        int key = 5;
        boolean isPresent = bitonicSearch(bitonicArray, key);
        System.out.println("Kay " + key + (isPresent ? " +" : " -") + " in array");
    }
}