import java.util.*;

public class File_Map implements Map
{
    /*
    For this hashmap, you will use arraylists which will provide easy but costly implementation.
    Your should provide and explain the complexities for each method in your report.
    * */
   ArrayList<String> fnames;
   ArrayList<List<Integer>> occurances;


    /**
     * Constructor
     */
   public File_Map(){

       fnames = new ArrayList<String>();
       occurances= new ArrayList<List<Integer>>();
   }


    @Override
    /**
     * It returns the size of the mappings
     */
    public int size() { return fnames.size(); }

    @Override
    /**
     * Returns true if this map contains no key-value mappings.
     */
    public boolean isEmpty() { return fnames.isEmpty(); }


    @Override
    /**
     * Returns true if this map contains a mapping for the specified key.
     */
    public boolean containsKey(Object key) {

        int index= fnames.indexOf(key);
        if (index!=-1 && occurances.get(index)!=null)
            return true;

        return false;
    }

    @Override
    /**
     * Returns true if this map maps one or more keys to the specified value.
     */
    public boolean containsValue(Object value) {

       int i=0;
       int counter=0;
       while (i<occurances.size()){

           Object obj= occurances.get(i);
           if (value.equals(obj)){
               ++counter;
           }

           ++i;
       }

       if(counter>1)
           return true;

       return false;
    }

    @Override
    /**
     * Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.
     */
    public Object get(Object key) {

        int index= fnames.indexOf(key);
        if (index!=-1)
            return occurances.get(index);

        return null;
    }

    @Override
    /*Each put operation will extend the occurance list*/
    /**
     * Associates the specified value with the specified key in this map
     */
    public Object put(Object key, Object value) {

        int index= fnames.indexOf(key);
        if (index==-1){

            String string = (String) key;
            fnames.add(string);
            List<Integer> list = (List<Integer>) value;
            occurances.add(list);
            return null;
        }


        Object oldVal= occurances.get(index);
        List<Integer> list2 = (List<Integer>) value;
        occurances.add(index,list2);
        return oldVal;
    }


    @Override
    /**
     *Removes the mapping for a key from this map if it is present
     */
    public Object remove(Object key) {

        int index=fnames.indexOf(key);
        if (index!=-1){

            fnames.remove(index);
            occurances.remove(index);

            return key;
        }

        return null;
    }

    @Override
    /**
     * Copies all of the mappings from the specified map to this map
     */
    public void putAll(Map m){
    }


    @Override
    /**
     * Removes all of the mappings from this map
     */
    public void clear() {

            fnames.clear();
            occurances.clear();
    }


    @Override
    /**
     * Returns a Set view of the keys contained in this map.
     */
    public Set keySet() {

        Set<Object> set= new HashSet<Object>();
        int i=0;
        int size=fnames.size();

        while (i<size){

            if (fnames.get(i)!=null){
                Object obj= fnames.get(i);
                set.add(obj);
                ++i;
            }
        }

        return set;

    }


    @Override
    /**
     * Returns a Collection view of the values contained in this map.
     */
    public Collection values() {

        Collection<List<Integer>> collection= new ArrayList<List<Integer>>();
        ((ArrayList<List<Integer>>) collection).addAll(occurances);
        return collection;
    }


    @Override
    public Set<Entry> entrySet() {
        return null;
    }







}
