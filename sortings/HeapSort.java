package com.company;

public class HeapSort
{
    public static void sort(int [] arr)
    {
        for(int i = arr.length/2 -1;i>=0;i--)
        {
            heapify(arr,arr.length,i);
        }

        for(int i = 0; i<arr.length;i++)
        {
            int temp = arr[0];
            arr[0] = arr[arr.length-1-i];
            arr[arr.length-1-i] = temp;
            heapify(arr,arr.length-i-1,0);
        }

    }
    private static void heapify(int [] heap, int n, int i)
    {
        int left = 2*i + 1;
        int right = 2*i + 2;
        int max = i;
        if(left<n&&heap[left]>heap[max])
        {
            max = left;
        }
        if(right<n&&heap[right]>heap[max])
        {
            max = right;
        }

        if(max != i)
        {
            int temp = heap[max];
            heap[max] = heap[i];
            heap[i] = temp;
            heapify(heap,n,max);
        }
    }

}
