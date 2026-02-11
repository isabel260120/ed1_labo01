package ed.lab;

import java.util.Random;



public class SortingAlgorithms {
    private static final Random RNG=new Random();

    public static <T extends Comparable<T>> void highPivotQuickSort(T[]array){
        if (array==null||array.length<2)return;
        quickSortHigh( array,0,array.length-1);
    }
    public static <T extends Comparable<T>> void lowPivotQuickSort(T[]array) {
        if (array == null || array.length < 2) return;
        quickSortLow(array, 0, array.length - 1);
    }
    public static <T extends Comparable<T>> void randomPivotQuickSort(T[]array) {
        if (array == null || array.length < 2) return;
        quickSortRandom(array, 0, array.length - 1);
    }

    private static <T extends Comparable<T>> void quickSortHigh(T[] array, int low, int high){
        if(low<high){
            int p= partitionHigh(array,low,high);
            quickSortHigh(array,low,p-1);
            quickSortHigh(array,p+1, high);
        }
    }
    private static <T extends Comparable<T>> int partitionHigh(T[] array, int low, int high){
        T pivot=array[high];
        int i=low-1;
        for (int j=low;j<high; j++){
            if(array[j]. compareTo(pivot)<=0){
                i++;
                swap( array,i,j);
            }
        }
        swap(array,i+1,high);
        return i+1;
    }
    private static <T extends Comparable<T>> void quickSortLow(T[] array, int low, int high){
        if(low<high){
            int p= partitionHigh(array,low,high);
            quickSortHigh(array,low,p-1);
            quickSortHigh(array,p+1, high);
        }
    }
    private static <T extends Comparable<T>> int partitionLow(T[] array, int low, int high){
        swap(array,low, high);
        return partitionHigh(array,low,high);
    }
    private static <T extends Comparable<T>> void quickSortRandom(T[] array, int low, int high){
        if(low<high){
            int p= partitionHigh(array,low,high);
            quickSortHigh(array,low,p-1);
            quickSortHigh(array,p+1, high);
        }
    }
    private static <T extends Comparable<T>> int partitionRandom(T[] array, int low, int high){
        int randomIndex=low+RNG.nextInt(high-low+1);
        swap(array, randomIndex,high);
        return partitionHigh(array,low,high);
    }
    private static <T>void swap(T[] array, int i, int j){
        if(i==j) return;
        T tmp= array[i];
        array[i]=array[j];
        array[j]=tmp;

    }
}

