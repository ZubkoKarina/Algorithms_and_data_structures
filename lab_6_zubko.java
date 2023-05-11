import java.util.Arrays;

public class lab_6_zubko {
    public static void quickSort(char[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }
    public static int partition(char[] array, int low, int high) {
        char pivot = array[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                char temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        char temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }
    public static void quickSort0(char[] array, int low, int high) {
        if (low < high) {
            int pivotIndex = partition0(array, low, high);
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    public static int partition0(char[] array, int low, int high) {
        char pivot = array[low];
        int i = low - 1, j = high + 1;
        while (true) {
            do {
                i++;
            } while (array[i] < pivot);
            do {
                j--;
            } while (array[j] > pivot);
            if (i >= j) {
                return j;
            }
            char temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
    private static int CUTOFF = 10;
    public static void sort(char[] a) {
        quicksort(a, 0, a.length - 1);
    }

    private static void quicksort(char[] a, int low, int high) {
        if (high <= low + CUTOFF - 1) {
            insertionSort(a, low, high);
            return;
        }
        int j = partition1(a, low, high);
        quicksort(a, low, j - 1);
        quicksort(a, j + 1, high);
    }

    private static int partition1(char[] a, int low, int high) {
        int i = low, j = high + 1;
        char v = a[low];
        while (true) {
            while (less(a[++i], v)) if (i == high) break;
            while (less(v, a[--j])) if (j == low) break;
            if (i >= j) break;
            exch(a, i, j);
        }
        exch(a, low, j);
        return j;
    }

    private static void insertionSort(char[] a, int low, int high) {
        for (int i = low; i <= high; i++)
            for (int j = i; j > low && less(a[j], a[j - 1]); j--)
                exch(a, j, j - 1);
    }

    private static boolean less(char v, char w) {
        return v < w;
    }

    private static void exch(char[] a, int i, int j) {
        char t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    public static void sort6(char[] a) {
        quicksort6(a, 0, a.length - 1);
    }

    private static void quicksort6(char[] a, int low, int high) {
        if (high <= low) return;
        int median = medianOf36(a, low, low + (high - low) / 2, high);
        swap6(a, low, median);
        int j = partition6(a, low, high);
        quicksort6(a, low, j - 1);
        quicksort6(a, j + 1, high);
    }
    private static int partition6(char[] a, int low, int high) {
        int i = low, j = high + 1;
        char v = a[low];
        while (true) {
            while (less6(a[++i], v)) if (i == high) break;
            while (less6(v, a[--j])) if (j == low) break;
            if (i >= j) break;
            swap6(a, i, j);
        }
        swap6(a, low, j);
        return j;
    }
    
    private static int medianOf36(char[] a, int i, int j, int k) {
        return (less6(a[i], a[j]) ?
                (less6(a[j], a[k]) ? j : less6(a[i], a[k]) ? k : i) :
                (less6(a[k], a[j]) ? j : less6(a[k], a[i]) ? k : i));
    }
    
    private static boolean less6(char v, char w) {
        return v < w;
    }
    
    private static void swap6(char[] a, int i, int j) {
        char t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    static void quickSort9(char[] array, int low, int high) {
        if (low < high) {
            int pi = partition9(array, low, high);
            quickSort9(array, low, pi - 1);
            quickSort9(array, pi + 1, high);
        }
    }

    static int partition9(char[] array, int low, int high) {
        char pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                char temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        char temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;
        return i + 1;
    }
    static void mergeSort10(char[] array, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort10(array, left, mid);
            mergeSort10(array, mid + 1, right);
            merge10(array, left, mid, right);
        }
    }

    static void merge10(char[] array, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        char[] LeftArray = new char[n1];
        char[] RightArray = new char[n2];
        for (int i = 0; i < n1; i++) {
            LeftArray[i] = array[left + i];
        }
        for (int j = 0; j < n2; j++) {
            RightArray[j] = array[mid + 1 + j];
        }
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (LeftArray[i] <= RightArray[j]) {
                array[k] = LeftArray[i];
                i++;
            } else {
                array[k] = RightArray[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            array[k] = LeftArray[i];
            i++;
            k++;
        }
        while (j < n2) {
            array[k] = RightArray[j];
            j++;
            k++;
        }
    }
    static void modifiedMergeSort12(char[] array, int left, int right) {
        if (right - left <= 10) { // Blokujemy rekurencje dla małych podzbiorów (rozmiar 10)
            insertionSort12(array, left, right);
        } else {
            int mid = (left + right) / 2;
            modifiedMergeSort12(array, left, mid);
            modifiedMergeSort12(array, mid + 1, right);
            merge10(array, left, mid, right);
        }
    }

    static void insertionSort12(char[] array, int left, int right) {
        for (int i = left + 1; i <= right; i++) {
            char key = array[i];
            int j = i - 1;

            while (j >= left && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    }
    public static void mergeSort13(char[] arr, int l, int r) {
        if (l < r) {
            int m = l + (r - l) / 2;
            mergeSort13(arr, l, m);
            mergeSort13(arr, m + 1, r);
            if (arr[m] <= arr[m + 1]) {
                return;
            }
            merge13(arr, l, m, r);
        }
    }

    public static void merge13(char[] arr, int l, int m, int r) {
        int n1 = m - l + 1;
        int n2 = r - m;
        char[] left = new char[n1];
        char[] right = new char[n2];
        System.arraycopy(arr, l, left, 0, n1);
        System.arraycopy(arr, m + 1, right, 0, n2);
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = left[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }
    public static void mergeSort14(char[] arr, int left, int right) {
        if (right <= left) return;
        int mid = (left+right)>>1;
        mergeSort14(arr, left, mid);
        mergeSort14(arr, mid + 1, right);
        merge14(arr, left, mid, right);
    }

    public static void merge14(char[] arr, int left, int mid, int right) {
        int i = left, j = mid + 1, k = left;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                i++;
            } else {
                char temp = arr[j];
                System.arraycopy(arr, i, arr, i + 1, j - i);
                arr[i] = temp;
                i++;
                mid++;
                j++;
            }
        }
    }
    public static void mergeSort15(char[] arr, int left, int right) {
        if (right <= left) return;
        int mid = (left+right)>>1;
        mergeSort15(arr, left, mid);
        mergeSort15(arr, mid + 1, right);
        merge15(arr, left, mid, right);
    }

    public static void merge15(char[] arr, int left, int mid, int right) {
        int i = left, j = mid + 1, k = left;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                i++;
            } else {
                char temp = arr[j];
                System.arraycopy(arr, i, arr, i + 1, j - i);
                arr[i] = temp;
                i++;
                mid++;
                j++;
            }
        }
    }
    public static int[] countingSort17(int[] array) {
        int max = Arrays.stream(array).max().getAsInt();
        int min = Arrays.stream(array).min().getAsInt();
        int range = max - min + 1;
        int[] count = new int[range];
        int[] output = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            count[array[i] - min]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        for (int i = array.length - 1; i >= 0; i--) {
            output[count[array[i] - min] - 1] = array[i];
            count[array[i] - min]--;
        }

        return output;
    }
    static void radixsort18(int arr[]) {
        int m = Arrays.stream(arr).max().getAsInt();
        for (int exp = 1; m / exp > 0; exp *= 10)
            countSort18(arr, arr.length, exp);
    }

    static void countSort18(int arr[], int n, int exp) {
        int output[] = new int[n];
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0);
        for (i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];
        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }
    public static void main(String[] args) {
        //zad 1
        char[] chars = {'E', 'A', 'S', 'Y', 'Q', 'U', 'E', 'S', 'T', 'I', 'O', 'N'};
        quickSort(chars, 0, chars.length - 1);
        System.out.println(Arrays.toString(chars));
        //zad 2
        char[] chars0 = {'O', 'T', 'H', 'E', 'R', 'Q', 'U', 'E', 'S', 'T', 'I', 'O', 'N'};
        quickSort0(chars0, 0, chars0.length - 1);
        System.out.println(Arrays.toString(chars0));
        //zad 3
        /*E A S Y Q U E S T I O N
        E A I E N Q U S T S Y O
        E A E I N O Q S T S Y U
        A E E I N O Q S S T U Y*/
        //zad 4
        /*O T H E R Q U E S T I O N
        N I H E O Q U S T R E T O
        E H I N O E O Q R S T U
        E E H I N O O Q R S T U*/
        //zad 5
        char[] arr = {'k', 'b', 'a', 'z', 'f', 'q', 'c', 'l', 'p', 'o'};
        sort(arr);
        System.out.println(Arrays.toString(arr));
        //zad 6
        char[] arr0 = {'k', 'b', 'a', 'z', 'f', 'q', 'c', 'l', 'p', 'o'};
        sort(arr0);
        System.out.println(Arrays.toString(arr0));
        //zad 7-8-9
        char[] array9 = {'S', 'O', 'R', 'T', 'O', 'W', 'A', 'N', 'I', 'E', 'D', 'A', 'N', 'Y', 'C', 'H'};
        quickSort9(array9, 0, array9.length - 1);
        System.out.println(Arrays.toString(array9));
        //zad 10
        char[] array10 = {'S', 'O', 'R', 'T', 'O', 'W', 'A', 'N', 'I', 'E', 'D', 'A', 'N', 'Y', 'C', 'H'};
        mergeSort10(array10, 0, array10.length - 1);
        System.out.println(Arrays.toString(array10));
        //zad 11
        /*Pierwszy podział:
        S O R T O W A N I E D A N Y C H
        Podział na pojedyncze elementy:
        S - O - R - T - O - W - A - N - I - E - D - A - N - Y - C - H
        Scalanie w uporządkowany sposób:
        O S - O R - O T - A N - E I - A D - N Y - C H
        Kontynuacja scalania:
        O R S - O T - A N O - A D E I - C H N Y
        Scalanie do końca:
        O R S O T - A D E I N O - C H N Y
        Finalne scalanie i wynik:
        A D E I N O O R S T - C H N Y
        Finalny wynik:
        A D E I N O O R S T C H N Y*/
        //zad 12
        char[] array12 = {'S', 'O', 'R', 'T', 'O', 'W', 'A', 'N', 'I', 'E', 'D', 'A', 'N', 'Y', 'C', 'H'};
        modifiedMergeSort12(array12, 0, array12.length - 1);
        System.out.println(Arrays.toString(array12));
        //zad 13
        char[] arr13 = {'s', 'o', 'r', 't', 'i', 'n', 'g'};
        mergeSort13(arr13, 0, arr13.length - 1);
        System.out.println(Arrays.toString(arr13));
        //zad 14
        char[] arr14 = {'s', 'o', 'r', 't', 'i', 'n', 'g'};
        mergeSort14(arr14, 0, arr14.length - 1);
        System.out.println(Arrays.toString(arr14));
        //zad 15
        char[] arr15 = {'S', 'O', 'R', 'T', 'O', 'W', 'A', 'N', 'I', 'E', 'D', 'A', 'N', 'Y', 'C', 'H'};
        mergeSort15(arr15, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr15));
        //zad 16-17
        int[] array17 = {4, 3, 2, 5, 4, 2, 3, 1, 2, 4, 5, 3, 2};
        System.out.println("Before Sorting : ");
        System.out.println(Arrays.toString(array17));
        array17 = countingSort17(array17);
        System.out.println("After Sorting : ");
        System.out.println(Arrays.toString(array17));
        //zad 18
        int[] data18 = {387, 468, 134, 123, 68, 221, 769, 37, 7};
        System.out.println("Before Sorting : ");
        System.out.println(Arrays.toString(data18));
        radixsort18(data18);
        System.out.println("After Sorting : ");
        System.out.println(Arrays.toString(data18));
    }
}

