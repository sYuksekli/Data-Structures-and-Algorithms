import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NLP
{
    public Word_Map wmap;

    public NLP(Word_Map map){

        wmap=map;
    }

    /*You should not use File_Map class in this file since only word hash map is aware of it.
    In fact, you can define the File_Map class as a nested class in Word_Map,
     but for easy evaluation we defined it separately.
     If you need to access the File_Map instances, write wrapper methods in Word_Map class.
    * */

    /*Reads the dataset from the given dir and created a word map */
    public void readDataset(String dir)
    {


    }


    /*Finds all the bigrams starting with the given word*/
    public List<String> bigrams(String word){
        return null;
    }


    /*Calculates the tfIDF value of the given word for the given file */
    public float tfIDF(String word, String fileName)
    {
        return  wmap.getTFDIF(word, fileName);
    }

    /*Print the WordMap by using its iterator*/
    public  void printWordMap()
    {

        Iterator<Word_Map.Node> iter= wmap.iterator();
        while (iter.hasNext()){

            Word_Map.Node node= iter.next();
            System.out.println(node.getKey());
        }
    }

}
