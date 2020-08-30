package com.company;
import java.util.Comparator;


// This class compares the the pixels according to alphabetical order of their component letters.
public class LEX implements Comparator<Pixel> {


    @Override
    public int compare(Pixel p1, Pixel p2){

        if(p1.getRed()>p2.getRed())
            return 1;

        else if(p1.getRed()<p2.getRed())
            return -1;

        else if(p1.getRed()==p2.getRed() && p1.getGreen()>p2.getGreen())
            return 1;

        else if(p1.getRed()==p2.getRed() && p1.getGreen()<p2.getGreen())
            return -1;

        else if(p1.getRed()==p2.getRed() && p1.getGreen()==p2.getGreen() && p1.getBlue()>p2.getBlue())
            return 1;

        else if(p1.getRed()==p2.getRed() && p1.getGreen()==p2.getGreen() && p1.getBlue()<p2.getBlue())
            return -1;

        else
            return 0;

    }


}
