package com.company;
/*
 *
 *******************
 *******************
 *   CSE 222 HW5   *
 * Sıla Bengisu Yüksekli *
 *******************
 *******************

 * @author Sıla Bengisu Yüksekli

 * @since 2019

 * @version HW5

 */


public class Pixel {

    private int red;
    private int green;
    private int blue;


    /**
     *
     * @param color1 the first dimension that represents the red color
     * @param color2 the second dimension that represents the green color
     * @param color3 the third dimension that represents the blue color
     */
    public Pixel(int color1, int color2, int color3){

        red=color1;
        green=color2;
        blue=color3;
    }

    /**
     * It returns the number of the red color
     * @return the number of red
     */
    public int getRed() {
        return red;
    }

    /**
     * It returns the number of the green color
     * @return the number of green.
     */
    public int getGreen(){
        return green;
    }

    /**
     * It returns the number of the blue color
     * @return the number of blue.
     */
    public int getBlue() {
        return blue;
    }

    /**
     * It returns a string that "textually represents" this object.
     * @return a string representation of the object
     */
    @Override
    public String toString() {
        return red+" "+green+" "+blue;
    }
}

