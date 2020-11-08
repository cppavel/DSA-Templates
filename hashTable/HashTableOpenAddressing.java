package com.company;
//Open Addressing aka closed hashing requires more computation.
//In open addressing, table may become full.
//Open addressing requires extra care for to avoid clustering and load factor.
//Open addressing is used when the frequency and number of keys is known.
//Open addressing provides better cache performance as everything is stored in the same table.
//In Open addressing, a slot can be used even if an input doesn’t map to it.
//No links in Open addressing

//Linear probing: cache efficient, problems with primary clustering, some problems with secondary clustering (affects
//only same hash elements)
//Quadratic probing: average cache efficiency, average problems with clustering. same hash still follow the same path
//Double hashing: cache inefficient, more computation, but less clustering

//Expected efficiency of operations under uniform probability assumption: O(1/1-alpha), where alpha is a load factor
//Every trial success with probability at least (capacity-size)/capacity
//O(1/1-alpha) = (capacity)/(capacity - size), which means that when capacity is around size the complexity would be
//linear. We can control this by resizing, but we would have to insert all the items into the new HashTable, which would
//take O(M), because for a hashtable of double size O(1/1-alpha) would remain O(1)
//Amortized time under the assumption: O(1) (assumed the size is O(capacity))


import java.util.ArrayList;

public class HashTableOpenAddressing<K,V>
{
    private int size  = 0;
    private int capacity;
    private ArrayList<HashEntry<K,V>> hashtable;
    private char mode = 'd';

    public HashTableOpenAddressing(int capacity, char mode)
    {
        hashtable = createArrayListOfCapacity(capacity);
        this.capacity = capacity;
        this.mode = mode;
    }

    public ArrayList<HashEntry<K,V>> createArrayListOfCapacity(int capacity)
    {
        ArrayList<HashEntry<K,V>> returnValue = new ArrayList<>();
        for(int i = 0; i < capacity; i++)
        {
            returnValue.add(null);
        }
        return returnValue;
    }

    public int hashFunctionOne(K key)
    {
        return key.hashCode()%capacity;
    }

    public int hashFunctionTwo(K key)
    {
        return 23 - key.hashCode()%23;
    }

    //Linear probing

    public int linearProbing(int index,int iteration)
    {
        return (index + iteration)%capacity ;
    }

    public int quadraticProbing(int index, int iteration)
    {
        return (index + iteration*iteration)%capacity;
    }

    public int doubleHashing(int index, int iteration, K key)
    {
        return (index + hashFunctionTwo(key)*iteration)%capacity;
    }

    public boolean isEmpty()
    {
        return size==0;
    }

    public int size()
    {
        return size;
    }


    public boolean insert(K key, V value)
    {
        int index = hashFunctionOne(key);
        int count = 0;
        while(hashtable.get(index)!=null&&!hashtable.get(index).isDeleted&&count<=capacity)
        {
            if(hashtable.get(index).key.equals(key))
            {
                hashtable.get(index).value = value;
                return true;
            }
            switch(mode)
            {
                case 'l':index = linearProbing(index, count);break;
                case 'q':index = quadraticProbing(index,count);break;
                case 'd':index = doubleHashing(index,count,key);break;
                default: break;
            }
            count++;
        }

        if(count != capacity + 1)
        {
            hashtable.set(index, new HashEntry<>(key, value));
            size++;
            return true;
        }
        else
        {
            return false;
        }
    }

    public V delete(K key)
    {
        int index = hashFunctionOne(key);
        int count = 0;
        while(hashtable.get(index)!=null&&count<=capacity)
        {
            if(!hashtable.get(index).isDeleted&&hashtable.get(index).key.equals(key))
            {
                hashtable.get(index).isDeleted = true;
                size--;
                return hashtable.get(index).value;
            }
            switch(mode)
            {
                case 'l':index = linearProbing(index, count);break;
                case 'q':index = quadraticProbing(index,count);break;
                case 'd':index = doubleHashing(index,count,key);break;
                default: break;
            }
            count++;
        }
        return null;
    }

    public V search(K key)
    {
        int index = hashFunctionOne(key);
        int count = 0;
        while(hashtable.get(index)!=null&&count<=capacity)
        {
            if(hashtable.get(index).key.equals(key))
            {
                if(hashtable.get(index).isDeleted)
                {
                    return null;
                }
                else
                {
                    return hashtable.get(index).value;
                }
            }
            switch(mode)
            {
                case 'l':index = linearProbing(index, count);break;
                case 'q':index = quadraticProbing(index,count);break;
                case 'd':index = doubleHashing(index,count,key);break;
                default: break;
            }
            count++;
        }
        return null;
    }
}
