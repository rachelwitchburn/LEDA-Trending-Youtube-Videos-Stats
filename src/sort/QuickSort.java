package sort;

public class QuickSort<T extends Comparable<T>> {
    public void sort(T[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        quickSort(array, 0, array.length - 1, false);
    }

    // Ordena de forma decrescente
    public void sortDesc(T[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        quickSort(array, 0, array.length - 1, true);
    }

    private void quickSort(T[] array, int low, int high, boolean desc) {
        if (low < high) {
            int pivotIndex = partition(array, low, high, desc);
            quickSort(array, low, pivotIndex - 1, desc);
            quickSort(array, pivotIndex + 1, high, desc);
        }
    }

    private int partition(T[] array, int low, int high, boolean desc) {
        T pivot = array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            // a, b
            // exemple com 5 e 10 : 5 - 10 = -5 ent
            // compare -> 0 : equals, < 0 : less than, > 0 : greater than
            if (desc) {
                if (array[j].compareTo(pivot) > 0) {
                    i++;
                    swap(array, i, j);
                }
            } else {
                if (array[j].compareTo(pivot) < 0) {
                    i++;
                    swap(array, i, j);
                }
            }
        }

        swap(array, i + 1, high);
        return i + 1;
    }

    private void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
