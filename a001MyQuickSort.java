package com.cc150.lbd;
import java.util.Arrays;

public class myQuickSort {

	/**
	 * Created by Administrator on 2015/9/10.
	 */
    public static void swap(int[] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static void bubbleSort(int[] array){
        if (array == null) return;
        int len = array.length;;
        for(int i = 0; i < len-1; i++){
            for (int j = len-1; j > i; j--){
                if (array[j] < array[j-1] ){
                    swap(array,j,j-1);
                }
            }
        }
    }
    public static void quickSort(int[] array, int low, int high){
        if (array == null || low < 0 || high < 0 || low >= array.length) return;
        int pivotloc = partition(array, low, high);
        if(low < high){
            quickSort(array, low, pivotloc-1);
            quickSort(array,pivotloc+1,high);
        }
    }
    public static int partition(int[] array, int low, int high){
        int pivokey = array[low];
        while(low < high){
            while(low < high && array[high] >= pivokey)
            {
                high--;
            }
            array[low] = array[high];
            while(low < high && array[low] <= pivokey)
            {
                low++;
            }
            array[high] = array[low];
        }
        array[low] = pivokey;
        return low;
    }
    public static void Test(int a[],int b[]) {
        System.out.println("The Source Secquence:");
        if (a == null) return;
        System.out.println(Arrays.toString(a));

        bubbleSort(a);
        System.out.println("BubbleSort Result: ");
        System.out.println(Arrays.toString(a));

        quickSort(b, 0, b.length-1);
        System.out.println("QuickSort Result:");
        System.out.println(Arrays.toString(b));
        System.out.println();
    }
    public static void main(String[] args){
        int a1[] = null;
        int a2[] = {1};
        int a3[] = {3, 6, 1, 8, 2, 9, 4};
        int a4[] = {1, 3, 5, 7, 9};
        int a5[] = {6, 9, 4, 8, -1};
        int a6[] = {9, 5, 4, 2, 1};
        int b1[] = null;
        int b2[] = {1};
        int b3[] = {3, 6, 1, 8, 2, 9, 4};
        int b4[] = {1, 3, 5, 7, 9};
        int b5[] = {6, 9, 4, 8, -1};
        int b6[] = {9, 5, 4, 2, 1};
        Test(a1,b1);
        Test(a2,b2);
        Test(a3,b3);
        Test(a4,b4);
        Test(a5,b5);
        Test(a6,b6);
    }
}
