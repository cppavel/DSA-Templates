package com.company;

public class HashEntry<K,V>
{
    public K key;
    public V value;
    public boolean isDeleted = false;

    public HashEntry(K key, V value)
    {
        this.key = key;
        this.value = value;
    }
}
