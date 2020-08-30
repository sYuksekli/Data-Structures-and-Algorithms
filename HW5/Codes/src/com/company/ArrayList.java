package com.company;

/*
 *
 *******************
 *******************
 *   CSE 222 HW5   *
 * Sıla Bengisu Yüksekli*
 *******************
/**

 * @author Sıla Bengisu Yüksekli

 * @since 2019

 * @version HW5

 */




public class ArrayList<Pixel> {

    private static final int INITIAL_CAPACITY = 1000000;
    private Pixel[] Data;
    private int size = 0;
    private int capacity = 0;


    /**
     * Constructor for initializing data fields.
     */
    public ArrayList () {
        capacity = INITIAL_CAPACITY;
        Data = (Pixel []) new Object[capacity];
    }


    /**
     * It adds the item which is given.
     * @param anEntry the item you want to insert.
     * @return true if the insertion is successful
     */
    public boolean add(Pixel anEntry){

        if(size==capacity)
            reallocate();

        Data[size]=anEntry;
        ++size;
        return true;
    }


    /**
     * It returns the item in that given index.
     * @param index that you want to return
     * @return the item in that index.
     */
    public Pixel get (int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }

        return Data[index];
    }


    /**
     * It sets new item in that index that you give.
     * @param index you want to change
     * @param newValue the item you want to insert
     * @return the item that you change
     */
    public Pixel set (int index, Pixel newValue) {

        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }

        Pixel oldValue = Data[index];
        Data[index] = newValue;
        return oldValue;
    }


    /**
     * It removes the item in that index which you enter
     * @param index that you remove
     * @return the item that you remove
     */
    public Pixel remove (int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(index);
        }

        Pixel returnValue = Data[index];
        for (int i = index + 1; i < size; i++) {
            Data[i-1] = Data[i];
        }

        size--;
        return returnValue;

    }

    private void reallocate () {
        capacity *= 2;
        Pixel[] arr;
        arr= (Pixel[]) new Object[capacity];

        for (int i=0; i<size ; ++i){
            arr[i]= Data[i];
            Data=arr;
        }
    }


    /**
     * It returns the size of the list
     * @return size
     */
    public int Size(){
        return size;
    }
}
