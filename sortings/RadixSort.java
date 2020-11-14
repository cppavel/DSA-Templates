package com.company;

public class RadixSort
{
    private static void countSort(int[] arr,int n, int exp)
    {
        int[] output = new int[n];
        int[] count = new int[10];

        for(int i =0;i<arr.length;i++)
        {
            int digit = (arr[i]/exp)%10;
            count[digit]++;
        }

        for(int i = 1;i<count.length; i++)
        {
            count[i] += count[i-1];
        }

        int k = 0;
        for(int i = n - 1; i >=0; i--)
        {
            output[count[(arr[i]/exp)%10]-1] = arr[i];
            count[(arr[i]/exp)%10]--;
        }

        for(int i = 0; i <n ;i++)
        {
            arr[i] = output[i];
        }
    }

    public static void radixSort(int[] arr)
    {
        int n = arr.length;

        int max = arr[0];

        for(int i = 1; i<n; i++)
        {
            if(arr[i]>max)
            {
                max = arr[i];
            }
        }

        int digits = String.valueOf(max).length();

        int exp = 1;
        for(int i = 1; i <= digits + 1;i++)
        {
            countSort(arr,n,exp);
            exp = exp * 10;
        }
    }


}
