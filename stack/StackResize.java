package com.company;

//An array implementation of stack with resizing
@SuppressWarnings("unchecked")
public class StackResize<T>
{
    T[] array;
    int numOfElements =0;

    public StackResize(int initialSize)
    {
        array = (T[]) new Object[initialSize];
    }

    public void push(T item)
    {
        array[numOfElements] = item;
        numOfElements++;
        if(numOfElements == array.length)
        {
            T[] temp = (T[]) new Object[array.length*2];
            System.arraycopy(array, 0, temp, 0, array.length);
            array = temp;
        }
    }

    public T pop()
    {
        if(numOfElements>0) {
            T element = array[numOfElements - 1];
            numOfElements--;
            if (numOfElements == array.length / 4) {
                T[] temp = (T[]) new Object[array.length / 2];
                System.arraycopy(array, 0, temp, 0, numOfElements);
                array = temp;
            }
            return element;
        }
        else
        {
            return null;
        }
    }

    public T peek()
    {
        if(numOfElements>0)
            return array[numOfElements-1];
        else
            return null;
    }

    public void clear()
    {
        numOfElements = 0;
    }
}
