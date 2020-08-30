import java.util.NoSuchElementException;

public class LinkedList<Edge> {

    public Node head=null;
    private int size;

    public static class Node {

        public int data;
        public Node NextNode;


        /**
         * Creates a new node with a null next field
         * @param dataItem The data stored
         */
        private Node(int dataItem) {

            data = dataItem;
            NextNode = null;
        }
    }

    /**
     * It returns the node
     * @param index the node index
     * @return the node in a given index
     */
    private Node getNode(int index){

        if (index<0 || index>=size){
            throw  new IndexOutOfBoundsException();
        }

        Node node=head;
        for (int i=0; i<index && node!=null; ++i){
            node=node.NextNode;
        }

        return node;
    }

    /**
     * It returns the size of the list
     * @return the list
     */
    public int Size(){

        return size;
    }


    /**
     * Returns true if the list is empty
     * @return true if the list is empty
     */
    public boolean isEmpty(){

        if (size==0)
            return true;

        else
            return false;
    }


    /**
     * It inserts the given item at the end of the list
     * @param result the item which is given
     * @return true
     */
    public boolean addLast(int result){

        if (size==0) {
            head = new Node(result);
            ++size;
        }

        else{
            Node node= this.getNode(size-1);
            node.NextNode= new Node(result);
            ++size;
        }

        return true;
    }


    /**
     * It inserts a new edge
     * @param data1 data of the source
     * @param data2 data of the dest
     * @return true
     */
    public boolean add(int data1, int data2) {

        //System.out.println("kll");
        if (size==0){
            head= new Node(data1);
            ++size;

            head.NextNode= new Node(data2);
            size++;
        }

        else{
            Node node= this.getNode(size-1);
            node.NextNode= new Node(data2);
            ++size;
        }
        return true;
    }


    /**
     * Returns true if it contains the given element
     * @param edge the edge
     * @param dest the destination
     * @return true if it contain this element
     */
    public boolean contains(LinkedList edge, int dest){

        boolean result=false;
        Node node = edge.head;
        while (node.NextNode!=null){

            if (node.NextNode.data==dest){
                return true;
            }

            node=node.NextNode;
        }

        return result;
    }


    /**
     * Returns an iterator over the List.
     * @return Iterator for iterating over the List
     */
    public Iterator iterator(boolean edge){

        return new Iterator(edge);
    }

    public class Iterator{


        private Node next;
        private Node lastReturned;
        private int currentIndex;
        private boolean isedge;

        /**
         * Iterator constructor for initialize.
         */
        public Iterator(boolean edge) {

            lastReturned = null;
            currentIndex = 0;
            next = head;
            isedge=edge;
        }

        /**
         * Returns true if the iteration has more elements.
         * @return true if the iteration has more elements
         */

        public boolean hasNext() {

            return (next != null);
        }


        /**
         * Returns the next element in the iteration.
         * @return Object ,the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        public Object next() {

            if (!hasNext())
                throw new NoSuchElementException();

            lastReturned = next;
            next = next.NextNode;
            ++currentIndex;

            if (next!=null && isedge==true)
                return new ListGraph.Edge(lastReturned.data, next.data);

            else
                return lastReturned.data;

        }

    }

}
