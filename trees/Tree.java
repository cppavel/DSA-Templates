package com.company;

import java.util.*;

public class Tree<T>
{
    public int size;
    Node<T> root;

    public Tree(T rootValue)
    {
        root = new Node<>(rootValue);
        size = 1;
    }

    static int search(int arr[], int x, int n)
    {
        for (int i = 0; i < n; i++)
            if (arr[i] == x)
                return i;
        return -1;
    }

    //similar idea is for constructing the tree, or getting preorder from postorder and inorder
    public static void post(int[] pre, int[] in, int n)
    {
        int root = search(in,pre[0],n); //index in in

        if(root !=0)
        {
            post(Arrays.copyOfRange(pre,1,n), in, root);
        }

        if(root !=n-1)
        {
            post(Arrays.copyOfRange(pre, 1+root, n),
                    Arrays.copyOfRange(in,root + 1, n), n-root-1);
        }

        System.out.print(pre[0]+ " ");
    }

    //dfs
    public void stackInorder()
    {
        Stack<Node> st = new Stack<>();
        Node current = root;

        while(!st.isEmpty()||current !=null) //stack might be empty, but right element not
        {
            //going down to the left
            while(current!=null)
            {
                st.push(current);
                current = current.left;
            }

            //getting left-most
            current = st.pop();
            //outputting
            System.out.print(current.value + " ");
            //if it has right child, do the same for it
            current = current.right;
        }
    }
    public void inorder()
    {
        inorderHelper(root);
    }

    private void inorderHelper(Node temp)
    {
        if(temp==null)
        {
            return;
        }

        inorderHelper(temp.left);
        System.out.print(temp.value+" ");
        inorderHelper(temp.right);

    }

    public void postorder()
    {
        postorderHelper(root);
    }

    private void postorderHelper(Node temp)
    {
        if(temp==null)
        {
            return;
        }

        postorderHelper(temp.left);
        postorderHelper(temp.right);
        System.out.print(temp.value+" ");

    }

    public void preorder()
    {
        preorderHelper(root);
    }

    private void preorderHelper(Node temp)
    {
        if(temp==null)
        {
            return;
        }
        System.out.print(temp.value+" ");
        preorderHelper(temp.left);
        preorderHelper(temp.right);
    }




    public void delete(T value)
    {
        Node toDelete = find(value);
        toDelete.value = deleteRightMostValue();
    }

    public Node find(T value)
    {
        return findHelper(value,root);
    }

    public Node findHelper(T value, Node current)
    {
        if(current == null)
        {
            return null;
        }
        else if(current.value.equals(value))
        {
            return current;
        }

        Node left = findHelper(value,current.left);
        Node right = findHelper(value,current.right);

        return left!=null?left:right;
    }



    public  T deleteRightMostValue()
    {
        Node temp = root;
        Node prev = root;
        while(temp.right!=null)
        {
            prev = temp;
            temp = temp.right;
        }
        T ans = (T)temp.value;
        if(temp.left!=null)
        {
            prev = temp;
            temp = temp.left;
            ans = (T)temp.value;
            prev.left= null;
            return ans;

        }
        else
        {
            ans = (T)temp.value;
            prev.right = null;
            return ans;
        }
    }

    public void bfs()
    {
        Queue<Node> level = new LinkedList<>();
        level.add(root);

        while(!level.isEmpty())
        {
            Node current = level.poll();

            System.out.print(current.value+ " ");

            if(current.left!=null)
                level.add(current.left);
            if(current.right!=null)
                level.add(current.right);
        }
    }




    public void add(T value)
    {
        size++;
        Queue<Node> level = new LinkedList<>();
        Node current = root;

        while(current.left!=null&&current.right!=null)
        {
            level.add(current.left);
            level.add(current.right);
            current = level.poll();
        }

        if(current.left==null)
        {
            current.left = new Node(value);
        }
        else if(current.right==null)
        {
            current.right = new Node(value);
        }

    }


}
