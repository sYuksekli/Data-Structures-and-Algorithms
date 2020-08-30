package com.company;
import java.util.Comparator;


// This class compares the Pixels according to euclid.
public class EUC implements Comparator<Pixel> {


    @Override
    public int compare(Pixel p1, Pixel p2) {

        double result1 = p1.getRed() * p1.getRed() + p1.getBlue() * p1.getBlue() + p1.getGreen() * p1.getGreen();
        double result2 = Math.sqrt(result1);

        double result3 = p2.getRed() * p2.getRed() + p2.getBlue() * p2.getBlue() + p2.getGreen() * p2.getGreen();
        double result4 = Math.sqrt(result3);

        if (result2 == result4)
            return 0;

        else if (result2 > result4)
            return 1;
        else
            return -1;
    }

 }

