package com.company;

import java.util.ArrayList;

// modulo operation is a compressor
// using in-built hashcode function
// separate chaining technique aka open hashing used
// from geeksforgeeks.com
//Advantages:
//1) Simple to implement.
//2) Hash table never fills up, we can always add more elements to the chain.
//3) Less sensitive to the hash function or load factors.
//4) It is mostly used when it is unknown how many and how frequently keys may be inserted or deleted.
//
//Disadvantages:
//1) Cache performance of chaining is not good as keys are stored using a linked list. Open addressing provides better cache performance as everything is stored in the same table.
//2) Wastage of Space (Some Parts of hash table are never used)
//3) If the chain becomes long, then search time can become O(n) in the worst case.
//4) Uses extra space for links.

//Complexity O(1 + alpha), where alpha is n/m (load factor). Again the assumption is that the numbers are equally distributed
//across the table. However, creating a bigger table each time load factor becomes larger 0.7 takes 0.7m*O(1 + alphaNew)
//which is O(M) + O(alphaNew)*0.7M = O(M)

//hash functions are usually
// h(k) = k mod m, where m is a prime number not close to a power of 2 or 10
// h(k) = [a*k mod 2^w]>>(w-r)  r = log(size), >> - shift right, w - bit-length of machine words, a is an odd integer
//between 2^(w-1) and 2^w. It is advised to choose a not too close to 2^(w-1) and 2^w
//Amortized time under the assumption: O(1) (assumed the size is O(capacity))

public class HashTableSeparateChaining<K,V>
{
    private ArrayList<HashNode<K,V>> buckets;
    private int size;
    private int capacity;

    public HashTableSeparateChaining()
    {
        this.capacity = 5;
        buckets = createArrayListOfCapacity(capacity);
        this.size = 0;
    }

    public ArrayList<HashNode<K,V>> createArrayListOfCapacity(int capacity)
    {
        ArrayList<HashNode<K,V>> returnValue = new ArrayList<>();
        for(int i = 0; i < capacity; i++)
        {
            returnValue.add(null);
        }
        return returnValue;
    }

    public int size()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public V get(K key)
    {
        int bucketNumber = key.hashCode()%capacity;
        HashNode<K,V> currentBucket = buckets.get(bucketNumber);
        while(currentBucket!=null)
        {
            if(currentBucket.key.hashCode() == key.hashCode())
            {
                return currentBucket.value;
            }
            currentBucket = currentBucket.next;
        }
        return null;
    }

    public V remove(K key)
    {
        int bucketNumber = key.hashCode()%capacity;
        HashNode<K,V> currentBucket = buckets.get(bucketNumber);
        HashNode<K,V> prev = null;
        HashNode<K,V> deleted = null;
        if(currentBucket.key.hashCode() == key.hashCode())
        {
            deleted =currentBucket;
            buckets.set(bucketNumber,currentBucket.next);
            size--;
            return deleted.value;
        }
        while(currentBucket!=null)
        {
            if(currentBucket.key.hashCode() == key.hashCode())
            {
                deleted = currentBucket;
                prev.next = currentBucket.next;
                size--;
                return  deleted.value;

            }
            prev = currentBucket;
            currentBucket = currentBucket.next;
        }
        return null;
    }

    public void add(K key, V value)
    {
        int bucketNumber = key.hashCode()%capacity;
        HashNode<K,V> currentBucket = buckets.get(bucketNumber);
        while(currentBucket != null)
        {
            if(currentBucket.key.equals(key))
            {
                currentBucket.value = value;
                return;
            }
            currentBucket = currentBucket.next;
        }

        currentBucket = buckets.get(bucketNumber);
        HashNode<K,V> newNode = new HashNode<K,V>(key,value);
        newNode.next = currentBucket;
        buckets.set(bucketNumber, newNode);
        size++;

        if(1.0*size/capacity > 0.7)
        {
            ArrayList<HashNode<K,V>>newBuckets = createArrayListOfCapacity(2*capacity);
            for(int i = 0; i < capacity; i++)
            {
                currentBucket = buckets.get(i);
                while(currentBucket!=null)
                {
                    int newBucketNumber = currentBucket.key.hashCode()%(2*capacity);
                    HashNode<K,V> newCurrent = newBuckets.get(newBucketNumber);
                    while(newCurrent != null)
                    {
                        newCurrent = newCurrent.next;
                    }
                    newCurrent = new HashNode<>(currentBucket.key, currentBucket.value);
                    currentBucket = currentBucket.next;
                }
            }
            buckets = newBuckets;
            capacity *=2;
        }
    }





}
