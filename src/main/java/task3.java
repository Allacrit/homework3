//(Дополнительно) Реализовать алгоритм сортировки слиянием


import java.util.Arrays;
import java.util.Random;

public class task3 {
    public static void main(String[] args) {
        int[] array = randomArray();
        int[] result = mergesort(array);
        System.out.println(Arrays.toString(result));
    }

    public static int[] randomArray() {
        Random random = new Random();
        int array[] = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(100);
            System.out.print(array[i] + " ");
        }
        System.out.println("");
        return array;
    }

    public static int[] mergesort(int[] newArray) {
        int[] bufferOne = Arrays.copyOf(newArray, newArray.length);
        int[] bufferTwo = new int[newArray.length];
        int[] result = mergesortInner(bufferOne, bufferTwo, 0, newArray.length);
        return result;
    }

    public static int[] mergesortInner(int[] bufferOne, int[] bufferTwo,
                                       int startIndex, int endIndex) {
        if (startIndex >= endIndex - 1) {
            return bufferOne;
        }

        int middle = startIndex + (endIndex - startIndex) / 2;
        int[] sortOne = mergesortInner(bufferOne, bufferTwo, startIndex, middle);
        int[] sortTwo = mergesortInner(bufferOne, bufferTwo, middle, endIndex);

        int indexFirst = startIndex;
        int indexSecond = middle;
        int indexBest = startIndex;
        int[] result = sortOne == bufferOne ? bufferTwo : bufferOne;
        while (indexFirst < middle && indexSecond < endIndex) {
            result[indexBest++] = sortOne[indexFirst] < sortTwo[indexSecond]
                    ? sortOne[indexFirst++]
                    : sortTwo[indexSecond++];
        }
        while (indexFirst < middle) {
            result[indexBest++] = sortOne[indexFirst++];
        }
        while (indexSecond < endIndex) {
            result[indexBest++] = sortTwo[indexSecond++];
        }
        return result;
    }
}
