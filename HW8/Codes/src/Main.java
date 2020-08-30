import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {


        ListGraph graph= new ListGraph();
        int num = graph.FindNumOfPeople(graph);
        System.out.print("The number of the people/person: ");
        System.out.println(num);


    }
}
