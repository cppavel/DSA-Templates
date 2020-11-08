package com.company;

import jdk.dynalink.linker.LinkerServices;

public class Main {

    public static void main(String[] args) {
        HashTableSeparateChaining<String, Integer>map = new HashTableSeparateChaining<>();
        map.add("this",1 );
        map.add("coder",2 );
        map.add("this",4 );
        map.add("hi",5 );
        System.out.println(map.size());
        System.out.println(map.remove("this"));
        System.out.println(map.remove("this"));
        System.out.println(map.size());
        System.out.println(map.isEmpty());
        System.out.println("\n\n\n");

        HashTableOpenAddressing<String, Integer> hashtable =
                new HashTableOpenAddressing<String, Integer>(50,'l');
        hashtable.insert("this",1);
        hashtable.insert("coder",2);
        hashtable.insert("this",4);
        hashtable.insert("hi",5);
        System.out.println(hashtable.size());
        System.out.println(hashtable.delete("this"));
        System.out.println(hashtable.delete("this"));
        System.out.println(hashtable.size());
        System.out.println(hashtable.isEmpty());

        System.out.println("\n\n\n");
        hashtable = new HashTableOpenAddressing<String, Integer>(50,'q');
        hashtable.insert("this",1);
        hashtable.insert("coder",2);
        hashtable.insert("this",4);
        hashtable.insert("hi",5);
        System.out.println(hashtable.size());
        System.out.println(hashtable.delete("this"));
        System.out.println(hashtable.delete("this"));
        System.out.println(hashtable.size());
        System.out.println(hashtable.isEmpty());

        System.out.println("\n\n\n");
        hashtable = new HashTableOpenAddressing<String, Integer>(50,'h');
        hashtable.insert("this",1);
        hashtable.insert("coder",2);
        hashtable.insert("this",4);
        hashtable.insert("hi",5);
        System.out.println(hashtable.size());
        System.out.println(hashtable.delete("this"));
        System.out.println(hashtable.delete("this"));
        System.out.println(hashtable.size());
        System.out.println(hashtable.isEmpty());



    }
}
