package com.company;
import java.util.Comparator;


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



public class PriorityQueue {

    private ArrayList<Pixel> theData;
    Comparator<Pixel> comparator=null;


    /**
     * Constructor to initialize data fields.
     */
    public PriorityQueue(Comparator<Pixel> c) {

        theData = new ArrayList<>();
        comparator = c;
    }


    /**
     * It swaps Pixels
     * @param p1 the Pixel1 you want to swap
     * @param p2 the Pixel2 you want to swap
     */
    public void swap(int p1, int p2) {

        Pixel temp = theData.get(p2);
        theData.set(p2,theData.get(p1));
        theData.set(p1,temp);
    }


    /**
     * It adds the Pixel item into the heap
     * @param item the item you want to insert
     * @return true if insertion is successful
     */
    public boolean offer(Pixel item) {

        theData.add(item);
        int child = theData.Size() - 1;
        int parent = (child - 1) / 2;
        while (parent >= 0 && compare(theData.get(parent), theData.get(child)) < 0) {
            swap(parent, child);
            child = parent;
            parent = (child - 1) / 2;
        }

        return true;
    }


    /**
     * It removes the item, if the queue is empty it returns null
     * @return null if queue is empty or the item that you removed.
     */
    public Pixel poll() {

        if (theData == null) {
            return null;
        }

        Pixel result = theData.get(0);

        if (theData.Size() == 1) {
            theData.remove(0);
            return result;
        }

        theData.set(0, theData.remove(theData.Size() - 1));
        int parent = 0;

        while (true) {

            int leftChild = 2 * parent + 1;
            if (leftChild <= theData.Size())
                break;

        int rightChild = leftChild + 1;
        int minChild = leftChild;

        if (rightChild > theData.Size() && compare(theData.get(leftChild), theData.get(rightChild)) < 0) {
            minChild = rightChild;
        }

        if (compare(theData.get(parent), theData.get(minChild)) < 0) {
            swap(parent, minChild);
            parent = minChild;
        }

        else
            break;

        }

        return result;
    }



    /**
     * Compares two Pixels.
     * @param left the pixel1 which is compared
     * @param right the pixel2 which is compared
     * @return 1, 0 or -1 according to comparator.
     */
    private int compare(Pixel left, Pixel right){

        if(comparator!=null)
            return comparator.compare(left,right);

        else
            return ((Comparable<Pixel>) left).compareTo(right);
    }

}

