//Zubko
public class lab_1_zubko {
    // 1
    public static boolean find(long[] tab, long key) {
        for (long element : tab) {
            if (element == key) {
                return true;
            }
        }
        return false;
    }

    // 2
    public static boolean findbin(long[] tab, long key) {
        int left = 0;
        int right = tab.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (tab[middle] == key) {
                return true;
            } else if (tab[middle] < key) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return false;
    }

    // 3
    public static void reverse(long[] tab) {
        int left = 0;
        int right = tab.length - 1;
        while (left < right) {
            long temp = tab[left];
            tab[left] = tab[right];
            tab[right] = temp;
            left++;
            right--;
        }
    }

    // 4
    public static long max(long[] tab) {
        long max = tab[0];
        for (long element : tab) {
            if (element > max) {
                max = element;
            }
        }
        return max;
    }

    // 5
    public static long min(long[] tab) {
        long min = tab[0];
        for (long element : tab) {
            if (element < min) {
                min = element;
            }
        }
        return min;
    }

    // 6
    public static void remove(long[] tab, long value) {
        int count = 0;
        for (int i = 0; i < tab.length; i++) {
            if (tab[i] != value) {
                tab[count++] = tab[i];
            }
        }
        for (int i = count; i < tab.length; i++) {
            tab[i] = 0;
        }
    }

    // 7
    public static long average(long[] tab) {
        long sum = 0;
        int count = 0;
        for (long element : tab) {
            if (element >= 0) {
                sum += element;
                count++;
            }
        }
        return sum / count;
    }

    // 8
    public static int even(long[] tab) {
        int count = 0;
        for (long element : tab) {
            if (element % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    // 9
    public static int odd(long[] tab) {
        int count = 0;
        for (long element : tab) {
            if (element % 2 != 0) {
                count++;
            }
        }
        return count;
    }

    // 10
    public static int numberInstances(long[] tab, long key) {
        int count = 0;
        for (long element : tab) {
            if (element == key) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        long[] array = {1, 3, 7, 2, 5, 9, 4, 6, 8};
        long[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("Linear search for 5: " + lab_1_zubko.find(array, 5));
        System.out.println("Linear search for 10: " + lab_1_zubko.find(array, 10));
        System.out.println("Binary search for 5: " + lab_1_zubko.findbin(sortedArray, 5));
        System.out.println("Binary search for 10: " + lab_1_zubko.findbin(sortedArray, 10));
        lab_1_zubko.reverse(array);
        System.out.println("Reversed array: " + java.util.Arrays.toString(array));
        System.out.println("Maximum element: " + lab_1_zubko.max(array));
        System.out.println("Minimum element: " + lab_1_zubko.min(array));
        lab_1_zubko.remove(array, 5);
        System.out.println("Array after removing 5: " + java.util.Arrays.toString(array));
        System.out.println("Average of non-negative elements: " + lab_1_zubko.average(array));
        System.out.println("Number of even elements: " + lab_1_zubko.even(array));
        System.out.println("Number of odd elements: " + lab_1_zubko.odd(array));
        long[] arrayWithDuplicates = {1, 2, 3, 2, 4, 2, 5};
        System.out.println("Number of instances of 2: " + lab_1_zubko.numberInstances(arrayWithDuplicates, 2));
    }
}

