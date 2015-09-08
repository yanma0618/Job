package Sort;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		int[] arr = build();
		
		//Insertion Sort
		print(arr);
		InsertionSort.sort(arr);
		print(arr);
		
		//Shell Sort
		arr = build();
		print(arr);
		ShellSort.sort(arr);
		print(arr);
		
		//Heap Sort
		arr = build();
		print(arr);
		HeapSort.sort(arr);
		print(arr);	
		

		//Merge Sort
		arr = build();
		print(arr);
		MergeSort.sort(arr);
		print(arr);		
		
		//Quick Sort
		arr = build();
		print(arr);
		QuickSort.sort(arr);
		print(arr);	
		
		
	}
	static int[] build(){
		int[] arr = { 4, 6, 3, 5, 7, 8 };
		return arr;
	}
	
	static void print(int[] a) {
		for (int n : a) {
			System.out.print(n + " ");
		}
		System.out.println();
	}
}
