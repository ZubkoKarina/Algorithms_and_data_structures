import java.util.Random;

public class lab_4_zubko{
    public static void F(int n) {
        if (n <= 0) return;
        System.out.println(n);
        F(n - 2);
        F(n - 3);
        System.out.println(n);
    }
    public static void F1(int n) {
        if (n <= 0) {
            return;
        }
        F1(n - 3);
        System.out.println(n);
        F1(n - 2);
        System.out.println(n);
    }
    public static void F2(int n) {
        if (n <= 0) {
            return;
        }
        F2(n - 3);
        F2(n - 2);
        System.out.println(n);
        System.out.println(n);
    }
    public static int F3(int a, int b) {
        if (b == 0) {
            return 0;
        }
        if (b % 2 == 0) {
            return F3(a + a, b / 2);
        }
        return F3(a + a, b / 2) + a;
    }
    public static int F4(int a, int b) {
        if (b == 0) return 0;
        if (b % 2 == 0) return F4(a+a, b/2);
        return F4(a+a, b/2) + a;
    }
    public static int F5(int a, int b) {
        if (b == 0) return 0;
        else return a + F5(a, b-1);
    }
    public static int F6(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 1;
        return 2*F6(n-2) + F6(n-3);
    }
    public static void IntToBinary(int number) {
        if (number > 1) {
            IntToBinary(number / 2);
        }
        System.out.print(number % 2);
    }
    public static void piramida(int level) {
        if (level == 0) { 
            return; 
        }
        for (int i = 0; i < level; i++) { 
            System.out.print("*"); 
        }
        System.out.println(); 
        piramida(level - 1); 
    }
    public static void piramida1(int level) {
        if (level == 1) { 
            System.out.println("*");
        } else { 
            piramida(level - 1); 
            for (int i = 0; i < level; i++) { 
                System.out.print("*");
            }
            System.out.println(); 
        }
    }
        public static double H1(int n) {
        if (n == 1) {
            return 1;
        }
        return 1.0 / (n * n) + H1(n - 1);
    }
    public static int H2(int n) {
        if (n == 1) {
            return 1;
        }
        return n + H2(n - 1);
    }
    public static int H3(int n) {
        if (n == 0) {
            return 0;
        }
        return 2 * n + H3(n - 1);
    }
    public static int H4(int n) {
        if (n == 1) {
            return 1;
        }
        return n * (n + 1) * (2 * n + 1) / 6 + H4(n - 1);
    }
    public static double GoldenR(int n) {
        if (n == 0) {
            return 1;
        } else {
            return 1 + 1 / GoldenR(n - 1);
        }
    }
    public static int f(int n) {
        if (n == 1) {
            return -1;
        }
        return -f(n - 1) * (n - 3);
    }
    public static int binomialCoefficient(int n, int k) {
        if (k == 0 || k == n) {
            return 1;
        }
        return binomialCoefficient(n - 1, k - 1) + binomialCoefficient(n - 1, k);
    }
    public static void printPascalTriangle(int height) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(binomialCoefficient(i, j) + " ");
            }
            System.out.println();
        }
    }
    public static int binaryNWD(int p, int q) {
        if (q == 0) {
            return p;
        }
        if (p == 0) {
            return q;
        }
        if ((p & 1) == 0 && (q & 1) == 0) {
            return 2 * binaryNWD(p / 2, q / 2);
        }
        if ((p & 1) == 0) {
            return binaryNWD(p / 2, q);
        }
        if ((q & 1) == 0) {
            return binaryNWD(p, q / 2);
        }
        if (p >= q) {
            return binaryNWD((p - q) / 2, q);
        }
        return binaryNWD(p, (q - p) / 2);
    }
    public static void reverse(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        reverse(arr, start + 1, end - 1);
    }
    public static int binarySearchRecursive(int[] arr, int left, int right, int key) {
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) / 2;
        if (arr[mid] == key) {
            return mid;
        } else if (arr[mid] < key) {
            return binarySearchRecursive(arr, mid + 1, right, key);
        } else {
            return binarySearchRecursive(arr, left, mid - 1, key);
        }
    }
    public static int binarySearchIterative(int[] arr, int key) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == key) {
                return mid;
            } else if (arr[mid] < key) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        //task 1
        for (int i = 1; i <= 6; i++) {
            System.out.println("F(" + i + "):");
            F(i);
            System.out.println();
        }
        //task 2 
        for (int i = 1; i <= 6; i++) {
            System.out.println("Вызов F1(" + i + "):");
            F1(i);
            System.out.println("--------------");
        }
        //task 3
        for (int i = 1; i <= 6; i++) {
            System.out.println("Вызов F2(" + i + "):");
            F2(i);
            System.out.println("--------------");
        }
        //task 4
        int a = 4;
        int b = 7;
        int result = F3(a, b);
        System.out.println(a + " * " + b + " = " + result);
        //task 5
        int a1 = 5;
        int b1 = 3;
        int result1 = F4(a1, b1);
        System.out.println("Res: " + result1);
        //task 6
        int result2 = F5(1, 6);
        System.out.println(result2); 
        //task 7
        int result3 = F6(6);
        System.out.println("F6(6) = " + result3);
        //task 8
        int number = 366;
        IntToBinary(number);
        //task 9
        piramida(75);
        //task 10
        piramida1(75);
        //task 11
        int n = 5;
        System.out.println("H1(" + n + ") = " + H1(n));
        System.out.println("H2(" + n + ") = " + H2(n));
        System.out.println("H3(" + n + ") = " + H3(n));
        System.out.println("H4(" + n + ") = " + H4(n));
        //task 12
        int n1 = 10;
        double goldenRatio = GoldenR(n1);
        System.out.println("Golden ratio for n = " + n + ": " + goldenRatio);
        //task 13
        for (int i = 1; i <= 10; i++) {
            System.out.println("f(" + i + ") = " + f(i));
        }
        //task 14
        int height = 5;
        printPascalTriangle(height);
        //task 15
        int p = 48;
        int q = 18;
        int result4 = binaryNWD(p, q);
        System.out.printf("Greatest Common Divisor of Numbers %d and %d =  %d\n", p, q, result4);
        //task 16
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("My array:");
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
        reverse(arr, 0, arr.length - 1);
        System.out.println("Reverse array:");
        for (int value : arr) {
            System.out.print(value + " ");
        }
        //task 17
        int[] sortedArray = {1, 3, 5, 7, 9, 11, 13, 15};
        int key = 11;
        int recursiveResult = binarySearchRecursive(sortedArray, 0, sortedArray.length - 1, key);
        int iterativeResult = binarySearchIterative(sortedArray, key);
        System.out.println("Recurs search: index " + key + " = " + recursiveResult);
        System.out.println("Iterative search: index " + key + " = " + iterativeResult);
    }
}