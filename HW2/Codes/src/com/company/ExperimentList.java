package com.company;

import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 *
 *******************
 *******************
 *   CSE 222 HW2   *
 * Sıla Bengisu Yüksekli*
 *******************
/**

 * @author Sıla Bengisu Yüksekli

 * @since 2019

 * @version HW2

 */

public class ExperimentList implements Iterable<Experiment>  {

    private Node head=null;

    /**
     * It returns a node before a node that we want to reach.
     * @param experiment data information of node we want to reach
     * @return a node before a node that we want to reach.
     */
    public Node getNode(Experiment experiment){     //I use this to make easier remove method.

        Node node=head;

        while (node.NextNode.data!=experiment)
            node=node.NextNode;

        return node;
    }


    private static class Node {

        private Experiment data;
        private Node NextdayNode;
        private Node NextNode;


        /**
         * Creates a new node with a null next field
         *
         * @param dataItem The data stored
         */
        private Node(Experiment dataItem) {

            data = dataItem;
            NextdayNode = null;
            NextNode = null;


        }
    }


    /**
     * Returns an iterator over the ExperimentList.
     * @return Iterator for iterating over the ExperimentList
     */
    @Override
    public myIter iterator(){

        return new myIter();
    }


    //My Iterator class
    //It implements MyIter class, because I don't want other people to see my Iterator class.
    private class myIter implements MyIter {


        private Node next;
        private Node lastReturned;
        private int currentIndex;


        /**
         * myIter constructor for initialize.
         */
        private myIter(){

            lastReturned=null;
            currentIndex=0;
            next=head;
        }

        /**
         * Returns true if the iteration has more elements.
         * @return true if the iteration has more elements
         */
        @Override
        public boolean hasNext() {

            return (next!=null);
        }

        /**
         * Returns true if the iteration has more day elements.
         * @return true if the iteration has more day elements.
         */
        public boolean hasNextDay() {

            return (next.NextdayNode!=null);
        }

        /**
         * Returns the next element in the iteration.
         * @return Experiment ,the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        @Override
        public Experiment next() {

            if (!hasNext())
                throw new NoSuchElementException();

            lastReturned = next;
            next = next.NextNode;
            ++currentIndex;
            return lastReturned.data;
        }

        /**
         * Returns the next day element in the iteration.
         * @return Experiment, the next day element in the iteration
         * @throws NoSuchElementException if the iteration has no more day elements
         */
        public Experiment nextDay() {

            if (!hasNextDay())
                throw new NoSuchElementException();

            lastReturned = next;
            next=next.NextdayNode;


            return lastReturned.data;
        }

        /**
         * Removes the last element returned by the next method.
         * @throws IllegalStateException if the next method has not yet been called,
         * or the remove method has already been called after the last call to the next method.
         */
        @Override
        public void remove(){

            int index=0;
            int size=0;
            Node node=head;
            int Day=lastReturned.data.getDay();

            while(node.data.getDay()!=Day)
                node = node.NextdayNode;



            Node temp=node;

            if (node.NextdayNode==null) {
                while (node.NextNode != null) {
                    node = node.NextNode;
                    ++size;
                }
            }

            else {
                while (node.NextNode.data.getDay() == Day) {
                    node = node.NextNode;
                    ++size;
                }
            }

            for (int i=0; i<=size; ++i){
                if (temp==lastReturned)
                    removeExp(Day,i);

                temp=temp.NextNode;
            }
        }
    }

    /**
     *  It inserts experiment to the end of the day.
     * @param exp the experiment we want to insert in the ExperimentList
     */
    public void addExp(Experiment exp){

        int expDay=exp.getDay();

        Node temp=head;

        if (head==null) {   //If list is empty
            Node node1 = new Node(exp);
            head=node1;
            return;
        }

        Node add_before_node=head;

        Node newExp = new Node(exp);

        while(add_before_node.NextNode!=null){

            if (expDay>=add_before_node.NextNode.data.getDay())
                add_before_node=add_before_node.NextNode;

            else{
                if (add_before_node.data.getDay()==expDay){
                    newExp.NextNode=add_before_node.NextNode;
                    add_before_node.NextNode=newExp;
                }

                else if(expDay>add_before_node.data.getDay()){

                    Node new_node=head;
                    while (new_node.NextdayNode!=add_before_node.NextNode)
                        new_node=new_node.NextdayNode;

                    new_node.NextdayNode=newExp;
                    newExp.NextdayNode=add_before_node.NextNode;
                    newExp.NextNode=add_before_node.NextNode;
                    add_before_node.NextNode=newExp;
                }


                else {

                    if (expDay<head.data.getDay()){

                        newExp.NextNode=head;
                        head=newExp;
                        head.NextdayNode=newExp.NextNode;
                    }
                    else {
                        int last_Day = add_before_node.data.getDay();
                        while (temp.NextdayNode.data.getDay() != last_Day)
                            temp = temp.NextdayNode;
                        temp = temp.NextdayNode;

                        newExp.NextNode = add_before_node.NextNode;
                        add_before_node.NextNode = newExp;
                        newExp.NextdayNode = temp.NextdayNode;
                        temp.NextdayNode = newExp;
                    }
                }

                return;

            }

        }

        if (add_before_node.NextNode==null){

            if (add_before_node.data.getDay()==expDay)
                add_before_node.NextNode=newExp;

            else if (add_before_node.data.getDay()>expDay){
                head=newExp;
                head.NextNode=add_before_node;
                head.NextdayNode=add_before_node;
            }

            else {
                add_before_node.NextNode=newExp;

                int last_Day=add_before_node.data.getDay();
                while (temp.NextdayNode.data.getDay()!=last_Day)
                    temp=temp.NextdayNode;
                temp=temp.NextdayNode;

                temp.NextdayNode=newExp;
            }


        }
    }

    /**
     * It gets the experiment according to Day and the Index information.
     * @param Day the day of experiment that we want to get.
     * @param Index the index of the experiment that we want to get. Index starts from 0.
     * @return an object of Experiment
     * @throws IndexOutOfBoundsException if the Index is less than zero or there is no node with the given index.
     */
    public Experiment getExp(int Day, int Index){

        if (Index<0)
            throw new IndexOutOfBoundsException();

        Node node=head;

        while (node.data.getDay()!=Day)
            node=node.NextdayNode;

        for (int i=0; i<Index; ++i){

            if (node.data.getDay()==node.NextNode.data.getDay())
                node=node.NextNode;

            //If you enter a index greater than number of index you have you will get IndexOutOfBoundsException.
            else throw new IndexOutOfBoundsException();
        }

        return node.data;
    }

    /**
     * It sets the experiment according to Day and the Index information.
     * @param Day the day of experiment that we want to set.
     * @param Index the index of the experiment that we want to set. Index starts from 0.
     * @param exp Experiment we want to set according to day and index information.
     * @throws IndexOutOfBoundsException if Index is less than zero.
     */
    public void setExp(int Day, int Index, Experiment exp){

        if (Index<0)
            throw new IndexOutOfBoundsException();

        if (Index>=0 && exp.getDay()!=Day)
            throw new NoSuchElementException("You can't set a experiment which has a different day!");

        Node node = head;

        while (node.data.getDay() != Day)
            node = node.NextdayNode;

        for (int i = 0; i < Index; ++i) {

            if (node.data.getDay() == node.NextNode.data.getDay())
                node = node.NextNode;

            //If you enter a index greater than number of index you have you will get IndexOutOfBoundsException.
            else throw new IndexOutOfBoundsException();
        }

        node.data = exp;
    }

    /**
     * It lists all completed experiments in a given day.
     * @param Day we want to know which experiments completed successfully.
     * @throws if there is no such day in the list.
     */
    public void listExp(int Day){

        boolean Completed;
        Node node=head;

        while (node.data.getDay()!=Day) {
            node = node.NextdayNode;
        }

        int numberOfTrue=0;
        while (node.data.getDay()==Day){

            Completed=node.data.getCompleted();

            if (Completed==true) {
                System.out.println(node.data);
                ++numberOfTrue;
            }

            if (node.NextNode!=null)
                node=node.NextNode;

            if(node.NextNode==null) {
                if (numberOfTrue == 0)
                    System.out.println("None of this experiments was completed in this day!");
                else
                    System.out.println(node.data);

                return;
            }
        }
    }

    /**
     * It removes the experiment according to the day and index information that you have entered.
     * @param Day the day we want to remove
     * @param Index the index we want to remove
     * @throws NoSuchElementException if list is empty.
     */
    public void removeExp(int Day, int Index){

        if(head==null)
            throw new NoSuchElementException("List is empty!");

        Node node2=head;
        Experiment parameter_exp=getExp(Day,Index);

        if (node2.data==parameter_exp){

            if (node2.NextNode==null) {
                head = null;
            }

            else {
                if (head.data.getDay()==head.NextNode.data.getDay())
                    head.NextNode.NextdayNode = head.NextdayNode;

                head=head.NextNode;
            }

            return;
        }

        Node node=getNode(getExp(Day,Index));

        if (node.NextNode.NextNode==null){
            node.NextNode=null;
            node.NextdayNode=null;

        }

        else {

            if (node.NextdayNode == null) {

                Node node1=head;
                if (node1.NextdayNode==node.NextNode)
                    node1.NextdayNode=node.NextNode.NextNode;

                else
                    while (node1.NextdayNode!=node.NextNode) {
                        node1 = node1.NextdayNode;
                        node1.NextdayNode = node.NextNode.NextNode;
                    }

                node.NextNode.NextdayNode = null;
                node.NextNode = node.NextNode.NextNode;
            }

            else {
                Node temp_nexDayNode=node.NextdayNode.NextdayNode;
                node.NextNode = node.NextNode.NextNode;

                if (node.data.getDay() != node.NextNode.data.getDay()) {
                    node.NextdayNode = node.NextNode;
                    node.NextdayNode.NextdayNode = temp_nexDayNode;
                }
            }
        }
    }

    /**
     * It removes all experiments in a given day.
     * @param Day we want to remove all experiments in this day.
     * @throws NoSuchElementException if there no experiment in this day.
     */
    public void removeDay(int Day){

        int counter=0;
        Node node=head;

        while (node.data.getDay()!=Day){

            node=node.NextdayNode;
            if (node.data.getDay()>Day)
                throw new NoSuchElementException();
        }

        node=head;
        while (node.data.getDay()!=Day)
            node=node.NextdayNode;

        if (node.NextNode!=null){

            while (node.data.getDay()==node.NextNode.data.getDay()){

                ++counter;
                node=node.NextNode;
            }

            for (int i=0; i<=counter; ++i)
                this.removeExp(Day,0);
        }

        else
            removeExp(Day,0);
    }


    /**
     * It sorts all the experiments in the list according to the accuracy.
     * @return Experiment which is the data of head.
     */
    public ExperimentList orderExperiments() {

        int k = 0;
        int size=0;

        Node node = head;
        while (node != null) {
            ++size;
            node = node.NextNode;
        }

        Experiment[] exp_array = new Experiment[size+1];

        Node add;
        myIter it = this.iterator();
        int x=0;
        while(it.hasNext()){
            add=it.next;
            exp_array[x] = new Experiment(add.data.getSetup(),add.data.getDay(),add.data.getCompleted(),add.data.getAccuracy());
            it.next();
            ++x;
        }

        Experiment temp;
        int i, j;
        for (i = 0; i < size-1; i++){
            for (j = 0; j < size-i-1; j++){
                if (exp_array[j].getAccuracy() > exp_array[j+1].getAccuracy()){
                    temp=exp_array[j];
                    exp_array[j]=exp_array[j+1];
                    exp_array[j+1]=temp;
                }
            }
        }


        ExperimentList sortedList = new ExperimentList();

        int t=0;
        sortedList.head = new Node(exp_array[t]);
        Node temp_head = sortedList.head;

        t = 1;
        while(t<size){
            sortedList.head.NextNode=new Node(exp_array[t]);
            sortedList.head=sortedList.head.NextNode;
            ++t;
        }
        sortedList.head = temp_head;

        for (Experiment elem : sortedList) {
            System.out.println(elem);
        }

        return sortedList;

    }


    /**
     * It sorts the experiments in a given day according to the accuracy
     * @param Day we want to sort.
     * @throws NoSuchElementException if there is  no experiment in this day
     */
    public void orderDay(int Day){

        Node nd=head;
        while (nd.NextdayNode!=null)
            nd = nd.NextdayNode;

        if (nd.NextdayNode==null && nd.data.getDay()<Day)
            throw new NoSuchElementException("There is no experiment in this day");


        int check=0;
        Node nde=head;
        while (nde!=null){
            if (nde.data.getDay()==Day)
                check=1;

            if(nde.data.getDay()>Day && check!=1)
                throw new NoSuchElementException("There is no experiment in this day");

            nde=nde.NextNode;
        }

        Node node=head;
        int size=0;

        while (node.data.getDay()!=Day)
            node = node.NextdayNode;

        if (node.data.getDay()<Day)
            throw new NoSuchElementException("There is no experiment in this day");


        if (node.NextdayNode==null){    //If day ,we want to sort, is the last day int the list

            Node node1=node;
            while (node1.NextNode!=null){
                node1=node1.NextNode;
                ++size;
            }

            Experiment[] experiments = new Experiment[size+1];

            Node node2=node;
            for (int i=0;i<=size; ++i){

                experiments[i]=node2.data;
                if (node2.NextNode!=null)
                    node2=node2.NextNode;
            }

            Experiment temp;
            int i,j;
            for (i = 0; i < size-1; i++){
                for (j = 0; j < size-i-1; j++){
                    if (experiments[j].getAccuracy() > experiments[j+1].getAccuracy()){
                        temp=experiments[j];
                        experiments[j]=experiments[j+1];
                        experiments[j+1]=temp;
                    }
                }
            }

            Node node4=node;
            for(i=0; i<size; ++i){
                node4.data=experiments[i];
                node4=node4.NextNode;
            }

        }

        else {

            Node node2 = node;
            while (node2.data.getDay() == Day) {
                node2 = node2.NextNode;
                ++size;
            }

            Experiment[] experiments = new Experiment[size];

            Node node3 = node;
            for (int i = 0; i < size; ++i) {
                experiments[i]=node3.data;
                node3 = node3.NextNode;
            }

            Experiment temp;
            int i, j;

            for (i = 0; i < size-1; i++){
                for (j = 0; j < size-i-1; j++){
                    if (experiments[j].getAccuracy() > experiments[j+1].getAccuracy()){
                        temp=experiments[j];
                        experiments[j]=experiments[j+1];
                        experiments[j+1]=temp;
                    }
                }
            }

            Node node4=node;
            for(i=0; i<size; ++i){
                node4.data=experiments[i];
                node4=node4.NextNode;
            }

        }
    }


    public void listAll()
    {
        System.out.println("List experiment view:");
        Node last = head;
        while( last != null) {
            System.out.println(last.data.toString());
            last = last.NextNode;
        }
        System.out.println("List day view:");
        last = head;
        while( last != null) {
            System.out.println(last.data.toString());
            last = last.NextdayNode;
        }
    }

}
