package task_3;


public class Main {

    private static int n = 0;

    public static void main(String[] args) {

        int[] array = {6, 7, 11, 34, 12, 1, 4, 32, 13, 5, 23, 12, 10, 1, 7, 8};

        int[] array_1 = array.clone();
        int[] array_2 = array.clone();
        int[] array_3 = array.clone();
        int[] array_4 = array.clone();
        int[] array_5 = array.clone();
        int[] array_6 = array.clone();
        int[] array_7 = array.clone();

        System.out.println("+Сортировка вставками");
        insertion(array_4);
        printArray(array_4);
        System.out.println("n=" + n);

        System.out.println("+Сортировка бинрными вставками");
        insertionBinar(array_5);
        printArray(array_5);
        System.out.println("n=" + n);

        System.out.println("+Сортировка пузырьком");
        bubbleSort(array_6);
        printArray(array_6);
        System.out.println("n=" + n);

        System.out.println("+Сортировка Шелла");
        shellSort(array_1);
        printArray(array_1);
        System.out.println("n=" + n);

    }


    /*
    Сложность - O(n2)
     */
    public static void insertion(int[] array) {
        n = 0;
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                n++;
                if (temp < array[j]) {
                    array[j + 1] = array[j];
                } else {
                    break;
                }
            }
            array[j + 1] = temp;
        }
    }

    /*
    Сложность - O(N*logN)
     */
    public static void insertionBinar(int[] array) {
        n = 0;
        int lenght = array.length;
        int x, left, right, sred;
        for (int i = 1; i < lenght; i++) {
            n++;
            if (array[i - 1] > array[i]) {
                x = array[i];
                left = 0;
                right = i - 1;
                do {
                    sred = (left + right) / 2;
                    n++;
                    if (array[sred] < x) {

                        left = sred + 1;
                    } else {

                        right = sred - 1;
                    }
                } while (left <= right);

                for (int j = i - 1; j >= left; j--)
                    array[j + 1] = array[j];
                array[left] = x;
            }
        }
    }

    /*
   Сложность -  O(n^2)
     */
    public static void bubbleSort(int[] array) {
        n = 0;
        for (int out = array.length - 1; out >= 1; out--) {
            for (int i = 0; i < out; i++) {
                n++;
                if (array[i] > array[i + 1])
                    swap(array, i, i + 1);
            }
        }
    }

    /*
      Метод Кнута - O(n) = n^(3/2)
       */

    public static void shellSort(int[] a) {
        n = 0;
        int temp;
        int h = 1;

        while (h <= a.length / 3)
            h = 3 * h + 1;// метод Кнута

        for (int k = h; k > 0; k = (k - 1) / 3) {
            for (int i = k; i < a.length; i++) {
                temp = a[i];
                int j;
                for (j = i; j >= k; j -= k) {
                    n++;
                    if (temp < a[j - k])
                        a[j] = a[j - k];
                    else
                        break;
                }
                a[j] = temp;
            }
        }
    }
    private static void swap(int[] array, int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }


    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
