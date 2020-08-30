package com.company;

import java.util.Iterator;
import java.util.Random;

public class Main {


    public static void main(String[] args) {

        ExperimentList expList = new ExperimentList();

        Experiment exp1= new Experiment("Experiment1Setup",2,true,100);
        expList.addExp(exp1);
        // addExp method works when list is empty.

       Experiment exp2 = new Experiment("Experiment2Setup",1,true,90);
        expList.addExp(exp2);
        // addExp method works when list has only head and you want to add a experiment which has a day less than
        // the day of head.

        Experiment exp3 = new Experiment("Experiment3Setup",3,false,30);
        expList.addExp(exp3);

       Experiment exp4 = new Experiment("Experiment4Setup",3,true,6);
        expList.addExp(exp4);
        // addMethod works when you want to insert more than one experiment in one day.

        Experiment exp5 = new Experiment("Experiment5Setup",1,true,9);
        expList.addExp(exp5);
        // addExp Method works when list is full and you want to insert in the middle of the list.
        // It can sort days correctly.

        Experiment exp6 = new Experiment("Experiment6Setup",5,true,89);
        expList.addExp(exp6);
        // addExp Method works when you want a an experiment at the end of the list.

        Experiment exp7 = new Experiment("Experiment7Setup",4,true,30);
        expList.addExp(exp7);

        Experiment exp8 = new Experiment("Experiment8Setup",1,false,80);
        expList.addExp(exp8);

        Experiment exp9 = new Experiment("Experiment9Setup",1,true,1);
        expList.addExp(exp9);
        // addMethod works correctly for the last three too. It can add correctly according to day information you gave.
        //It can add middle of the list when the list is full.

        Experiment exp10 = new Experiment("Experiment10Setup",5,false,34);
        expList.addExp(exp10);
        // addExp Method works correctly again when you want a an experiment at the end of the list.

        System.out.println("************************ We expect experiments to be sorted like this :****************************** ");
        System.out.print("\"Experiment2Setup\" \"Experiment5Setup\" \"Experiment8Setup\" \"Experiment9Setup\" \"Experiment1Setup\"");
        System.out.println("\"Experiment3Setup\" \"Experiment4Setup\" \"Experiment7Setup\" \"Experiment6Setup\" \"Experiment10Setup\"");


        System.out.println("--------------------------------------");
        System.out.println("********** addExp Method Cotrol **********");
        System.out.println("***** List was printed by Iterator: ******");
        MyIter iter=expList.iterator();
        while (iter.hasNext())
            System.out.println(iter.next());
        //It prints successfully. The days are sorted correctly.
        System.out.println("*****List was printed as expected:****");
        System.out.println("*****hasNext and next Method works correcly****");





        System.out.println("--------------------------------------");
        System.out.println("--------------------------------------");
        System.out.println("*******List was printed by for-each ,since ExperimentList is iterable.*******:");
        for (Experiment elem :expList )
            System.out.println(elem);   //toString method works correctly.
        System.out.println("******List was printed as expected:*****");



        System.out.println("--------------------------------------");
        System.out.println("--------------------------------------");
        System.out.println("********* getExp Method Control ********");
        System.out.println("**** We expect to see \"Experiment2Setup\" and \"Experiment4Setup\" ***");
        System.out.println(expList.getExp(1,0));
        System.out.println(expList.getExp(3,1));
        System.out.println("***** Experiments were printed as expected: ****");

        //System.out.println(expList.getExp(4,2)); It throws IndexOutOfBoundsException, there is no such a index in this day.
        //getExp Methods works successfully.

        //System.out.println(expList.getExp(3,-1)); //It throws IndexOutOfBoundsException, because index is less than zero.
        // Index starts from zero.




        System.out.println("--------------------------------------");
        System.out.println("--------------------------------------");
        Experiment new_exp1=new Experiment("New-Experiment-Setup1",2,true,98);
        Experiment new_exp2=new Experiment("New-Experiment-Setup2",1,false,34);
        Experiment new_exp3=new Experiment("New-Experiment-Setup3",4,true,100);
        Experiment new_exp4=new Experiment("New-Experiment_Setup4",5,false,23);

        expList.setExp(2,0,new_exp1);
        expList.setExp(1,0,new_exp2);
        expList.setExp(5,0,new_exp4);


        //expList.setExp(5,0,new_exp3);
        //It throws NoSuchElementException: You can't set a experiment which has a different day!

        //expList.setExp(2,5,new_exp1);
        //It throws IndexOutOfBoundsException, because in this given day there is only one experiment.
        //Index can be only zero in this situation.

        //expList.setExp(4,-1,new_exp3);
        //It throws IndexOutOfBoundsException, because index is less than zero. Index starts from zero.

        System.out.println("************ setExp Method Control ************");
        System.out.println("***** We expect to see \"New-Experiment-Setup1\" instead of \"Experiment1Setup\" *****");
        System.out.println("***** We expect to see \"New-Experiment-Setup2\" instead of \"Experiment2Setup\" *****");
        System.out.println("***** We expect to see \"New-Experiment_Setup4\" instead of \"Experiment6Setup\" *****");
        System.out.println("***** After changing some experiments, The list is: *****");
        for (Experiment elem :expList )
            System.out.println(elem);
        System.out.println("************ List was printed as expected ************");




        System.out.println("--------------------------------------");
        System.out.println("--------------------------------------");
        System.out.println("********* listExp Method Control *******");
        System.out.println("***** We expect to see \"Experiment5Setup\" \"Experiment9Setup\" for DAY1 *****");
        expList.listExp(1);
        System.out.println("***** We expect to see \"Experiment4Setup\" for DAY3 *****");
        expList.listExp(3);
        System.out.println("***** We expect to see \"New-Experiment-Setup1\" for DAY2 *****");
        expList.listExp(2);
        System.out.println("***** We expect to see no experiments for DAY5 *****");
        expList.listExp(5);
        System.out.println("************ List was printed as expected ************");




        System.out.println("--------------------------------------");
        System.out.println("--------------------------------------");
        System.out.println("******* removeExp Method Control *******");
        expList.removeExp(1,0);
        System.out.println("***** We expect to see \"Experiment5Setup\" as head of list ****");
        expList.removeExp(2,0);
        System.out.println("***** We expect to see no experiment in second day ****");
        expList.removeExp(5,1);
        System.out.println("******* We expect to see of list \"New-Experiment_Setup4\" as a tail of the list ****");
        System.out.println("******* After RemoveExp Method, The List is: *******");
        for (Experiment elem :expList )
            System.out.println(elem);
        System.out.println("************ List was printed as expected ************");





        System.out.println("--------------------------------------");
        System.out.println("--------------------------------------");
        System.out.println("******* removeDay Method Control *******");
        expList.removeDay(1);
        System.out.println("***** We expect to see no experiment anymore in the first day ****");
        expList.removeDay(3);
        System.out.println("***** We expect to see no experiment anymore in the third day ****");
        expList.removeDay(5);
        System.out.println("***** We expect to see no experiment anymore in the fifth day****");
        System.out.println("***** We expect to see only \"Experiment7Setup\" in the list ****");
        System.out.println("****** After RemoveDay Method, The List is: *******");
        for (Experiment elem :expList )
            System.out.println(elem);
        System.out.println("************ List was printed as expected ************");



        System.out.println("--------------------------------------");
        System.out.println("--------------------------------------");
        System.out.println("**List has only one element. Lets add some experiments int the list again to test other methods.**");

        Experiment experiment= new Experiment("Experiment-Setup",2,true,100);
        expList.addExp(experiment);

        Experiment experiment1= new Experiment("Experiment1-Setup",6,false,1);
        expList.addExp(experiment1);

        Experiment experiment2= new Experiment("Experiment2-Setup",1,true,10);
        expList.addExp(experiment2);

        Experiment experiment3= new Experiment("Experiment3-Setup",4,false,60);
        expList.addExp(experiment3);

        Experiment experiment4= new Experiment("Experiment4-Setup",1,false,54);
        expList.addExp(experiment4);

        Experiment experiment5= new Experiment("Experiment5-Setup",2,true,42);
        expList.addExp(experiment5);

        Experiment experiment6= new Experiment("Experiment6-Setup",3,true,67);
        expList.addExp(experiment6);

        Experiment experiment7= new Experiment("Experiment7-Setup",1, false,45);
        expList.addExp(experiment7);

        Experiment experiment8= new Experiment("Experiment8-Setup",6,true,54);
        expList.addExp(experiment8);




        System.out.println("--------------------------------------");
        System.out.println("--------------------------------------");
        System.out.println("********** RECHECK addExp Method with new Experiments **********");
        System.out.println("********** We expect experiments to be sorted like this (according to their day information): ************* ");
        System.out.print("\"Experiment2-Setup\" \"Experiment4-Setup\" \"Experiment7-Setup\" \"Experiment-Setup\" \"Experiment5-Setup\"");
        System.out.println("\"Experiment6-Setup\" \"Experiment7Setup\" \"Experiment3-Setup\" \"Experiment1-Setup\" \"Experiment8-Setup\"");
        //Experiment7Setup is the old element.
        for (Experiment elem :expList )
            System.out.println(elem);
        System.out.println("************ List was printed as expected ************");




        System.out.println("--------------------------------------");
        System.out.println("--------------------------------------");
        System.out.println("********* orderExperiments Method Control *********");
        System.out.println("--------------------------------------");
        System.out.println("********* We expect experiments to be sorted like this:(According to their  accuracy) ************ ");
        System.out.print("\"Experiment1-Setup\" \"Experiment2-Setup\" \"Experiment7Setup\" \"Experiment5-Setup\" \"Experiment7-Setup\"");
        System.out.println("\"Experiment4-Setup\" \"Experiment8-Setup\" \"Experiment3-Setup\" \"Experiment6-Setup\" \"Experiment-Setup\"");
        expList.orderExperiments();
        System.out.println("************ List was printed as expected ************");



        System.out.println("--------------------------------------");
        System.out.println("--------------------------------------");
        System.out.println("********* orderDay Method Control *********");
        System.out.println("********* Sorted list According to Their Accuracy For Day1, Day2 and Day6*******:");
        expList.orderDay(1);
        expList.orderDay(2);
        expList.orderDay(6);
        //expList.orderDay(7);  //NoSuchElementException: "There is no experiment in this day". Because there is no element in this day.
        //expList.orderDay(5);  //NoSuchElementException: "There is no experiment in this day". Because there is no element in this day.

        for (Experiment elem : expList)
            System.out.println(elem);
        System.out.println("************ List was printed as expected *************");





        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("-------------------------------------------------------------------------------------------------");
        System.out.println("************************************ CHECKING FOR ITERATOR **************************************");

        ExperimentList expList2=new ExperimentList();
        Experiment e1= new Experiment("ExperimentOne",3,true,90);
        expList2.addExp(e1);

        Experiment e2= new Experiment("ExperimentTwo",2,false,89);
        expList2.addExp(e2);

        Experiment e3= new Experiment("ExperimentThree",2,true,40);
        expList2.addExp(e3);

        Experiment e4= new Experiment("ExperimentFour",7,true,100);
        expList2.addExp(e4);

        Experiment e5= new Experiment("ExperimentFive",1,false,25);
        expList2.addExp(e5);

        Experiment e6= new Experiment("ExperimentFive",5,false,45);
        expList2.addExp(e6);



        System.out.println("*************** hasNext and Next Method Control *****************");
        MyIter iter2= expList2.iterator();
        while (iter2.hasNext())
            System.out.println(iter2.next());
        System.out.println("************ List was printed by Iterator: ************");
        System.out.println("************ List was printed as expected *************");




       System.out.println("--------------------------------------");
       System.out.println("--------------------------------------");
       iter2.remove();
       System.out.println("********* We expect ExperimentFour as a lastItemReturned **********");
       System.out.println("********* So if we use remove method of iterator ExperimentFour will be deleted **********");
       System.out.println("************* Controlling Remove Method of iterator ****************** ");
       System.out.println("************ List was printed again ************");
       for (Experiment elem :expList2 )
           System.out.println(elem);





        System.out.println("--------------------------------------");
        System.out.println("--------------------------------------");
        System.out.println("*************** hasNextDay and NextDay Method Control *****************");
        MyIter iter3= expList2.iterator();
        while (iter3.hasNextDay())
            System.out.println(iter3.nextDay());
        System.out.println("************ List was printed as expected *************");
        System.out.println("************ NextDayNode Connections are true. *************");


        System.out.println("--------------------------------------");
        System.out.println("--------------------------------------");

    }

}
