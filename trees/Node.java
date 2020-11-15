package com.company;

public class Node<T>
{
    T value;
    public Node<T> left;
    public Node<T> right;

    public Node(T value)
    {
        this.value = value;
    }

}
