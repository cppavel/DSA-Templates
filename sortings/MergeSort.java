package com.company;

public class MergeSort{

    private static void merge(int arr[], int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;

        int[] L = new int[n1];
        int[] R = new int[n2];

        //getting the two sorted parts of the array
        for(int i = 0; i < n1; i++)
        {
            L[i] = arr[l+i];
        }
        for(int i = 0; i < n2; i++)
        {
            R[i] = arr[m + 1 + i];
        }

        int i = 0;
        int j = 0;

        //merging in one sorted part
        int k = l;

        while(i<n1 && j <n2)
        {
            if(L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        //if there are any elements left in one of the arrays, copy the rest. We could do this, because if these
        //elements were not taken, then they are greater than or equal to all the elements already added to the
        //array
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    //divide and conquer approach, work because it goes all the way down to arrays of 2 or 1 elements, which
    //are then sorted by merge procedure (base case) and go all the way up in the recursion, being merged each
    //time and hence remaining sorted.
    static void mergeSort(int arr [], int l, int r)
    {
        //if there are enough elements to divide
        if(l<r)
        {
            //divide into to parts
            int m = (l+r)/2;
            //repeat for the parts
            mergeSort(arr,l,m);
            mergeSort(arr,m+1,r);
            //once done these parts are sorted and we merge them in a larger part
            merge(arr,l,m,r);
        }
    }
}
