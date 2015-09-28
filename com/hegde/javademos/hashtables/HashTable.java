package com.hegde.javademos.hashtables;

/**
 * Created by Hegde on 01-08-2015.
 */
public class HashTable {

    private DataItem[] hashArray; //array holds hash table
    private int arraySize;
    private DataItem nonItem; //for deleted item

    //----------------------------------------------------------------------------------------
    public HashTable(int size) {
        arraySize = size;
        hashArray = new DataItem[arraySize];
        nonItem = new DataItem(-1);// key is -1 for deleted items
    }
    //----------------------------------------------------------------------------------------

    public void displayTable() {
        System.out.print("Table: ");

        for (int j = 0; j < arraySize; j++) {
            if (hashArray[j] != null)
                System.out.print(hashArray[j].getKey() + " ");
            else
                System.out.print("** ");
        }
        System.out.println(" ");
    }
    //----------------------------------------------------------------------------------------

    public int hashFunc(int key) {
        return key % arraySize; //hash function
    }

    //---------------------------------------------------------------------------------------


}
