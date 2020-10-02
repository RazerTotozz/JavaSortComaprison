/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortcomparison;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author Administrator
 */
public class SortComparison {
    
    static final int FIRSTINPUTSIZE = 1000;
    static final int SECONDINPUTSIZE = 100000;
    static final int THRIDINPUTSIZE = 1000000;
    
    private static Integer[] initialFirstArray(){
        Random randomer = new Random();
        Integer[] result = new Integer[FIRSTINPUTSIZE];
        for (int i = 0; i < result.length; i++) {
            result[i] = randomer.nextInt();
        }
        return result;
    }
    
    private static Integer[] initialSecondArray(){
        Random randomer = new Random();
        Integer[] result = new Integer[SECONDINPUTSIZE];
        for (int i = 0; i < result.length; i++) {
            result[i] = randomer.nextInt();
        }
        return result;
    }
    
    private static Integer[] initialThirdArray(){
        Random randomer = new Random();
        Integer[] result = new Integer[THRIDINPUTSIZE];
        for (int i = 0; i < result.length; i++) {
            result[i] = randomer.nextInt();
        }
        return result;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Integer[] arr1,arr2;
        arr1 = initialFirstArray();
        arr2 = Arrays.copyOf(arr1, arr1.length);
        
        System.out.printf("Input\tQuick Sort\tArray Sort\n");
        
        long beginTimeQuick = System.currentTimeMillis();
        quickSort(arr1, 0, arr1.length-1);
        long finishTimeQuick = System.currentTimeMillis();
        
        long beginTimeTim = System.currentTimeMillis();
        Arrays.sort(arr2);
        long finishTimeTim = System.currentTimeMillis();
        
        System.out.printf(FIRSTINPUTSIZE+"\t"+(finishTimeQuick-beginTimeQuick)+"\t\t"+(finishTimeTim-beginTimeTim)+"\n");
        
        arr1 = initialSecondArray();
        arr2 = Arrays.copyOf(arr1, arr1.length);
        
        beginTimeQuick = System.currentTimeMillis();
        quickSort(arr1, 0, arr1.length-1);
        finishTimeQuick = System.currentTimeMillis();
        
        beginTimeTim = System.currentTimeMillis();
        Arrays.sort(arr2);
        finishTimeTim = System.currentTimeMillis();
        
        System.out.printf(SECONDINPUTSIZE+"\t"+(finishTimeQuick-beginTimeQuick)+"\t\t"+(finishTimeTim-beginTimeTim)+"\n");
        
        arr1 = initialThirdArray();
        arr2 = Arrays.copyOf(arr1, arr1.length);
        
        beginTimeQuick = System.currentTimeMillis();
        quickSort(arr1, 0, arr1.length-1);
        finishTimeQuick = System.currentTimeMillis();
        
        beginTimeTim = System.currentTimeMillis();
        Arrays.sort(arr2);
        finishTimeTim = System.currentTimeMillis();
        
        System.out.printf(THRIDINPUTSIZE+"\t"+(finishTimeQuick-beginTimeQuick)+"\t\t"+(finishTimeTim-beginTimeTim)+"\n");
        
        
    }
    
    static int partition(Integer arr[], int low, int high) 
    { 
        int pivot = arr[high];  
        int i = (low-1); // index of smaller element 
        for (int j=low; j<high; j++) 
        { 
            // If current element is smaller than the pivot 
            if (arr[j] < pivot) 
            { 
                i++; 
  
                // swap arr[i] and arr[j] 
                int temp = arr[i]; 
                arr[i] = arr[j]; 
                arr[j] = temp; 
            } 
        } 
  
        // swap arr[i+1] and arr[high] (or pivot) 
        int temp = arr[i+1]; 
        arr[i+1] = arr[high]; 
        arr[high] = temp; 
  
        return i+1; 
    } 
  
  
    /* The main function that implements QuickSort() 
      arr[] --> Array to be sorted, 
      low  --> Starting index, 
      high  --> Ending index */
    static void quickSort(Integer arr[], int low, int high) 
    { 
        if (low < high) 
        { 
            /* pi is partitioning index, arr[pi] is  
              now at right place */
            int pi = partition(arr, low, high); 
  
            // Recursively sort elements before 
            // partition and after partition 
            quickSort(arr, low, pi-1); 
            quickSort(arr, pi+1, high); 
        } 
    } 
    
}
