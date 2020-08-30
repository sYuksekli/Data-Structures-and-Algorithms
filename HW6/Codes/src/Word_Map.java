import java.util.*;

public class Word_Map implements Map, Iterable {

    final static int INITCAP = 10;  //initial capacity
    int CURRCAP = INITCAP;   //current capacity
    final static float LOADFACT = 0.75f;
    private int numKeys;
    private int numDeletes;
    private final Node DELETED=new Node(null,null);
    private int lastInserted;
    private int FirstInserted;
    private Node table[];


    /**
     * Constructor
     */
    public Word_Map() {
        this.table = new Node[INITCAP];
    }

    /**
     * It returns the mapping
     * @return mappings
     */
    public Node[] getTable() {
        return table;
    }

    @Override
    public Iterator iterator() {

        return new MyIterator();
    }

    public class MyIterator implements Iterator{

        private Node next;
        private Node lastReturned;
        private int currentIndex;


        private MyIterator(){

            lastReturned=null;
            currentIndex=0;
            next=table[FirstInserted];
        }


        /**
         * Returns true if the iteration has more Node elements.
         * @return true if the iteration has more Node elements.
         */
        public boolean hasNext() {

            return (next!=null);
        }


        /**
         * Returns the next element in the iteration.
         * @return Node ,the next element in the iteration
         * @throws NoSuchElementException if the iteration has no more elements
         */
        public Node next() {

            if (!hasNext())
                throw new NoSuchElementException();

            lastReturned = next;
            next = next.Next;
            ++currentIndex;
            return lastReturned;
        }

    }



    static class Node {
        // complete this class according to the given structure in homework definition

        private Object key;
        private Object value;
        private Node Next;


        /**
         * Constructor
         * @param Key to initialize
         * @param Value to initialize
         */
        public Node(Object Key, Object Value) {

            key = Key;
            value = Value;
            Next = null;
        }


        /**
         * It returns the key
         * @return key
         */
        public Object getKey() {
            return key;
        }


        /**
         * It returns value
         * @return value
         */
        public Object getValue() {
            return value;
        }


        /**
         * It sets the value
         * @param value
         */
        public void setValue(Object value) {
            this.value = value;
        }

        /**
         * It returns a string that "textually represents" this object.
         * @return a string representation of the object
         */
        @Override
        public String toString() {
            return key+" "+value;
        }

    }


    /**
     * It calculates the TFIDF
     * @param Word , the word
     * @param Fname, the filename
     * @return the TFIDF value
     */
    public float getTFDIF(String Word, String Fname){

        int size=0;
        int max=1;
        int i=0;

        Iterator<Node> iter2 = this.iterator();
        while (iter2.hasNext()) {
            Node node = iter2.next();
            File_Map f = (File_Map) node.getValue();

            if (max < f.fnames.size()) {
                max = f.fnames.size();
            }
        }


        int index = find(Word);
        File_Map file_map= (File_Map) table[index].getValue();
        int size3= file_map.fnames.size();

        double IDF= Math.log(max/size3);

        while (i<size3){

            if (file_map.fnames.get(i).equals(Fname)){
                size=file_map.occurances.size();
            }

            ++i;
        }

        i=0;
        int j=0;
        int counter=0;
        while (i<table.length){
            if (table[i].getValue()!=null){

                File_Map file_map1= (File_Map) table[i].getValue();
                while (j<file_map1.size()){
                    if (file_map1.fnames.get(i).equals(Fname)){
                        counter=counter+file_map1.occurances.size();
                    }

                    ++j;
                }
            }
            ++i;
        }

        double TF= size/counter;
        float result= (float) (TF*IDF);
        return result;

    }



    @Override
    /**
     * It returns the size of the mappings
     */
    public int size() {
        return numKeys;
    }


    @Override
    /**
     * Returns true if this map contains no key-value mappings.
     */
    public boolean isEmpty() {

        return numKeys == 0;
    }



    @Override
    /*Use linked structure instead of table index
    to perform search operation effectively
     * */
    /**
     * Returns true if this map contains a mapping for the specified key.
     */
    public boolean containsKey(Object key) {

        boolean result=false;
        Iterator<Node> iter= this.iterator();
        while (iter.hasNext()){

            Node lastRet = iter.next();
            if (lastRet.getKey().equals(key)){

                if(lastRet.getValue()!=null)
                    result= true;

            }

        }

        return result;
    }



    @Override
    /*Use linked structure instead of table index
    to perform search operation effectively
     * */
    /**
     * Returns true if this map maps one or more keys to the specified value.
     */
    public boolean containsValue(Object value) {

        int counter=0;
        Iterator<Node> iter= this.iterator();
        while (iter.hasNext()){

            Node lastRet = iter.next();
            if (lastRet.getValue()== value){

                Object Key=lastRet.getKey();
                if (Key!=null)
                    ++counter;
            }
        }

        if (counter>1)
            return true;

        else
            return false;

    }


    @Override
    /**
     * Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.
     */
    public Object get(Object key) {

        int index = find(key);

        if (table[index] != null)
            return table[index].getValue();

        else
            return null;

    }



    @Override
    /*
    Use linear probing in case of collision
    * */
    /**
     * Associates the specified value with the specified key in this map
     */
    public Object put (Object key, Object value){


        int index = find(key);
        if (table[index]==null) {

                table[index] = new Node(key, value);
                numKeys++;

                if (numKeys == 1) {
                    FirstInserted = index;
                    lastInserted = index;
                }

                if (numKeys != 1) {
                    table[lastInserted].Next = table[index];
                    lastInserted = index;
                }


                double loadFactor =
                        (double) (numKeys + numDeletes) / table.length;
                if (loadFactor > LOADFACT) {
                    rehash();
                }

                return null;
        }

        Object oldVal = table[index].value;

        ArrayList Key1 = new ArrayList();
        Key1= ((File_Map) value).fnames;
        ArrayList Key2=new ArrayList();
        Key2 = ((File_Map) table[index].getValue()).fnames;

        if (Key1.equals(Key2)){

            File_Map file_map = (File_Map) table[index].getValue();
            ArrayList arr= new ArrayList();
            arr= file_map.occurances;
            arr.add(((File_Map) value).occurances);

            return oldVal;
        }

        File_Map fmap =((File_Map) table[index].getValue());
        ArrayList arr1= new ArrayList();
        ArrayList arr2= new ArrayList();
        arr1= fmap.fnames;
        arr2= fmap.occurances;
        arr1.add(Key1);
        arr2.add(((File_Map) value).occurances);

        return oldVal;
    }



    @Override
    /*You do not need to implement remove function
    * */
    public Object remove (Object key){
        return null;
    }



    @Override
    /**
     * Copies all of the mappings from the specified map to this map
     */
    public void putAll (Map m){

    }


    @Override
    /**
     * Removes all of the mappings from this map
     */
    public void clear () {

        int counter=0;
        int i=0;
        while (i<table.length){

            if(table[i]!=null){
                table[i]=null;
                counter++;
            }

            ++i;
        }

        numKeys=0;
        numDeletes=counter;
    }


    @Override
    /*Use linked structure instead of table index
    for efficiency
     * */

    /**
     * Returns a Set view of the keys contained in this map.
     */
    public Set keySet () {

        Set<Object> set= new HashSet<Object>();
        Iterator<Node> iter = this.iterator();

        while (iter.hasNext()){

            Node lastRet = iter.next();
            set.add(lastRet.getKey());
        }

        return set;
    }



    @Override
    /*Use linked structure instead of table index
    for efficiency
     * */
    /**
     * Returns a Collection view of the values contained in this map.
     */
    public Collection values () {

        Collection<Object> collection= new ArrayList<Object>();
        Iterator<Node> iter = this.iterator();

        while (iter.hasNext()){

            Node lastRet = iter.next();
            collection.add(lastRet.getValue());
        }

        return collection;

    }

    @Override
    /*You do not need to implement entrySet function
    * */
    public Set<Entry> entrySet () {
        return null;
    }


    /**
     * Finds either the target key or the first empty slot in the search chain ubing linear probing
     * @param key The key of the target objecy
     * @return the positon of the target or the first empty slot
     */
    private int find(Object key){

        int Index = key.hashCode() % table.length;
        if (Index < 0) {
            Index += table.length;
        }

        while ((table[Index] != null)
                && (!key.equals(table[Index].key))) {

            Index++;
            if (Index >= table.length) {
                Index = 0;
            }
        }

        return Index;
    }


    /**
     * It expands the table size.
     */
    private void rehash() {

        Node[] oldTable = table;

        table = new Node[2 * oldTable.length + 1];

        numKeys = 0;
        numDeletes = 0;
        for (int i = 0; i < oldTable.length; i++) {
            if ((oldTable[i] != null) && (oldTable[i] != DELETED)) {
                put(oldTable[i].key, oldTable[i].value);
            }
        }
    }


}

