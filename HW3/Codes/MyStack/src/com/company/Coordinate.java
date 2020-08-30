package com.company;

/*
 *
 *******************
 *******************
 *   CSE 222 HW3   *
 * Sıla Bengisu Yüksekli *
 *******************
 *******************

 * @author Sıla Bengisu Yüksekli

 * @since 2019

 * @version HW3

 */


// It is used for keeping the array coordinates.
public class Coordinate {

    private int row;
    private int column;

    /**
     * Creates a new coordinate.
     * @param X, indicates row
     * @param Y, indicates column
     */
    public Coordinate(int X, int Y){

        this.row=X;
        this.column=Y;
    }

    /**
     * It returns the value of row
     * @return row
     */
    public int getRow() {
        return row;
    }

    /**
     * It returns the value of column
     * @return column
     */
    public int getColumn() {
        return column;
    }

    /**
     * It returns a string that "textually represents" this object.
     * @return a string representation of the object
     */
    @Override
    public String toString() {
            return row+" "+column;
    }

}
