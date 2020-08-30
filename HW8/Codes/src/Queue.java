import java.util.NoSuchElementException;

public class Queue {

    private Node front;
    private Node rear;
    private int size;


    private static class Node {

        private Object data;
        private Node next;


        /**
         * Creates a new node with a null next field.
         * @param dataItem The data stored
         */
        private Node(Object dataItem) {
            data = dataItem;
            next = null;
        }

        /**
         * Creates a new node that references another node.
         * @param dataItem The data stored
         * @param nodeRef The node referenced by new node
         */
        private Node(Object dataItem, Node nodeRef) {
            data = dataItem;
            next = nodeRef;
        }
    }

    /**
     * Insert an item at the rear of the queue.
     * @param item The element to add
     * @return true
     */
    public boolean offer(Object item) {

        if (front == null) {
            rear = new Node(item);
            front = rear;
        }

        else {
            rear.next = new Node(item);
            rear = rear.next;
        }

        size++;
        return true;
    }

    /**
     ** Remove the entry at the front of the queue and return it
     * if the queue is not empty.
     * @return The item removed if successful, or null if not
     */
    public Object poll() {
        Object item = peek(); // Retrieve item at front.
        if (item == null) {
            return null;
        }

        front = front.next;
        size--;
        return item;
    }

    /**
     * Return the item at the front of the queue without removing it.
     * @return The item at the front of the queue if successful;
     * return null if the queue is empty
     */
    public Object peek() {

        if (size == 0) {
            return null;
        }

        else {
            return front.data;
        }
    }


    /**
     * Return the true if queue is empty.
     * return true if the queue is empty
     */
    public boolean isEmpty(){

        Object object= peek();
        if (object==null)
            return true;

        else
            return false;

    }
}
