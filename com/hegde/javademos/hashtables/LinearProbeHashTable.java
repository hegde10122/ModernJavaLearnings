package com.hegde.javademos.hashtables;

import java.io.IOException;

/**
 * Created by Hegde on 29-07-2015.
 */
public class LinearProbeHashTable {
    //code
    public static void main(String[] args) throws IOException {

        DataItem mDataItem;

        int aKey, size, n, keysPerCell;

        System.out.print("Enter size of hash table:");
        size = new CommonMethods().getInt();

        System.out.print("Enter initial number of items:");
        n = new CommonMethods().getInt();

        keysPerCell = 10;

        HashTable theHashTable = new HashTable(size);
    }
}
