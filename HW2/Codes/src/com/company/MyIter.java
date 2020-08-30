package com.company;
import java.util.Iterator;

/**

 * MyIter class.This class extends Iterator for using in the main.

 * @author Sıla Bengisu Yüksekli

 * @since 2019

 * @version HW2

 */

public interface MyIter extends Iterator<Experiment> {

    public boolean hasNextDay();
    public Experiment nextDay();
}
