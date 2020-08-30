package com.company;
import java.util.EmptyStackException;

/*
 *
 *******************
 *******************
 *   CSE 222 HW3   *
 * Sıla Bengisu Yüksekli*
 *******************
/**

 * @author Sıla Bengisu Yüksekli

 * @since 2019

 * @version HW3

 */


//My own Stack implementation
public class MyStack<E>
{

    public static class Node<E> {

        public E data;
        private Node<E> next;

        /**
         * Creates a new node
         * @param Data, the data stored
         * @param Next, reference to the next node
         */
        private Node(E Data, Node<E> Next){

            data=Data;
            next=Next;
        }
    }

    private Node<E> topOfStackRef;

    /**
     * Creates a new stack.
     */
    public MyStack(){
        this.topOfStackRef=null;
    }


    /**
     * It adds an item in the stack and returns the item added.
     * @param object, which you want to add in the stack.
     * @return the item that was added in the stack.
     */
    public E push(E object){

        topOfStackRef= new Node<E>(object,topOfStackRef);
        return object;
    }


    /**
     * It indicates if the stack is empty.
     * @return true, if stack is empty.
     */
    public boolean Empty(){

        return  (topOfStackRef==null);
    }


    /**
     * If it is not empty, then it returns the top item and removes it.
     * @return the data of top item in the stack
     * @throws EmptyStackException if the stack is empty
     */
    public E pop(){

        if (Empty())
            throw new EmptyStackException();

        else {
            E temp = topOfStackRef.data;
            topOfStackRef = topOfStackRef.next;
            return temp;
        }
    }


    /**
     * If it is not empty, then it returns the top item in the stack
     * @return the data of top item in the stack
     * @throws EmptyStackException if the stack is empty
     */
    public E peek(){

        if (Empty())
            throw new EmptyStackException();

        else{
            return topOfStackRef.data;
        }

    }

}