package leetcode.sort;

import java.util.Arrays;

public class QuickSort {

    public static void quickSort(int[] arr, int low, int high) {
        System.out.println("quickSort ("+low+", "+high+")");
        if (low < high) {
            // Получаем индекс разделения
            int pivotIndex = partition(arr, low, high);
            System.out.println("pivotIndex = "+pivotIndex);

            // Рекурсивно сортируем левую и правую части
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    // Метод разделения: все меньше pivot налево, больше — направо
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // опорный элемент
        System.out.println("pivot = "+pivot);

        int i = low - 1; // указатель на последний элемент меньший pivot

//        for (int z = low; z < high; z++) {
//            if (arr[z] <= pivot) {
//                i++;
//                swap(arr, i, z);
//                System.out.println("partition "+ Arrays.toString(arr));
//            }
//        }

        int lastKnown = low - 1;
        int index = low;
        while (index < high) {

            if (arr[index] <= pivot) {
                lastKnown++;
                swap(arr, index, lastKnown);
            }
            index++;
        }

        swap(arr, lastKnown + 1, high); // перемещаем pivot на своё место
        return lastKnown + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] data = { 8, 4, 7, 3, 10, 2, 6, 5 };
        System.out.println("partition "+ Arrays.toString(data));
        quickSort(data, 0, data.length - 1);

        System.out.println("Отсортированный массив:");
        for (int num : data) {
            System.out.print(num + " ");
        }
    }

}
