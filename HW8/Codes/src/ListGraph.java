import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ListGraph {


    private boolean directed;
    private int numV;
    private LinkedList<Edge>[] edges;



    public static class Edge{

        private int dest;
        private int source;

        public Edge(int Source, int Dest){

            dest=Dest;
            source=Source;
        }

        /**
         * It returns the dest
         * @return dets
         */
        public int getDest() {
            return dest;
        }

        /**
         * It returns source
         * @return source
         */
        public int getSource() {
            return source;
        }

        /**
         * It returns a string that "textually represents" this object.
         * @return a string representation of the object
         */
        @Override
        public String toString() {
            return source+" "+dest;
        }
    }


    public ListGraph(){

        this.directed=true;

        try {
            FileInputStream fstream = new FileInputStream("C:\\Users\\sila_\\HW8\\input.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;

            int i=0;
            while ((strLine = br.readLine()) != null) {
                String[] arr = strLine.split(" ");
                int source = Integer.parseInt(arr[0]);
                int dest = Integer.parseInt(arr[1]);
                if (i==0) {
                    this.numV = source;
                    this.edges = new LinkedList[this.numV + 1];
                    for (int j = 1; j < this.numV + 1; j++) {
                        this.edges[j] = new LinkedList();
                    }
                }

                if (i!=0){
                    Edge edge = new Edge(source, dest);
                    this.insert(edge);
                }

                i++;
            }

            this.FindNumOfPeople(this);
        }

        catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Constructor
     * @param numV number of the vertex
     * @param Directed list
     */
    public ListGraph(int numV, boolean Directed){

        numV=numV;
        directed=Directed;
        edges = new LinkedList[numV+1];
        for (int i = 1; i < numV+1; i++) {
            edges[i] = new LinkedList();
        }
    }

    /**
     * Returns the number of the vertex
     * @return numv
     */
    public int getNumV() {
        return numV;
    }

    /**
     * Returns if the graph is directed
     * @return true if the graph is directed
     */
    public boolean isDirected(){
        return directed;
    }


    /**
     * It returns true if there is a edge between given parameters
     * @param source source of the edge
     * @param dest dest of the edge
     * @return true if there is a edge between them
     */
    public boolean isEdge(int source, int dest) {


        if(!edges[source].isEmpty()) {
            LinkedList<Edge> edge = edges[source];
            return edge.contains(edge, dest);
        }

        else
            return false;
    }

    /**
     * It inserts a new edge
     * @param edge, we want to insert
     */
    public void insert(Edge edge) {

        int source= edge.getSource();
        int dest= edge.getDest();
        edges[source].add(source,dest);

    }


    /**
     * Returns an iterator over the List.
     * @param source
     * @param edge to indicate return type
     * @return Iterator for iterating over the List
     */
    public LinkedList.Iterator edgeIterator(int source, boolean edge) {

        if(!edges[source].isEmpty()) {
            return edges[source].iterator(edge);
        }
        return null;
    }

    /**
     * Returns the dge between given parameters
     * @param source the source of the edge
     * @param dest the desr of the edge
     * @return edge
     */
    public Edge getEdge(int source, int dest) {

        Edge target = new Edge(source, dest);
        LinkedList.Iterator iter= edgeIterator(source,true);

        while (iter.hasNext()) {

            Object obj = iter.next();
            if (obj.equals(target)) {
                return (Edge) obj;
            }
        }
        return target;
    }


    /**
     * Returns true if there is a path between given parameters(It searchs transitivity)
     * @param Source the source of the edge
     * @param Dest the dest of the edge
     * @return true is there is a path
     */
    public boolean IsPath(int Source, int Dest){

        Queue queue= new Queue();

        boolean[] identified= new  boolean[numV+1];
        identified[Source]=true;
        queue.offer(Source);

        while (!queue.isEmpty()){

            int current= (int) queue.poll();
            LinkedList.Iterator iter = edgeIterator(current,true);
            if (iter!=null){

                while (iter.hasNext()){

                    Object edge = iter.next();
                    if (edge instanceof ListGraph.Edge) {
                        int neighbor = ((ListGraph.Edge) edge).getDest();

                        if (neighbor==Dest)
                            return true;

                        if (!identified[neighbor]){

                            identified[neighbor]= true;
                            queue.offer(neighbor);
                        }
                    }
                }
            }
        }

        return false;
    }

    /**
     * Returns the number of the people who is considered popular by every other person)
     * @param graph graph
     * @return number the people
     */
    public int FindNumOfPeople(ListGraph graph) {

        LinkedList[] list = new LinkedList[graph.numV + 1];
        for (int i = 1; i < graph.numV + 1; i++) {
            list[i] = new LinkedList();
        }


        int j = 2;

        for (int i = 1; i < graph.numV +1; i++) {

            if (graph.edges[i] != null) {

                while (j <graph.numV +1) {

                    if (i == 1 && j == 1){
                        ++j;
                    }


                    else {

                        if (isEdge(j, i)) {
                            list[i].addLast(1);
                        } else {

                            if (graph.IsPath(j, i)) {
                                list[i].addLast(1);
                            } else
                                list[i].addLast(0);
                        }

                        if (j + 1 == i) {
                            j = j + 2;
                        }
                        else{
                            ++j;
                        }

                    }
                }
            }

            j = 1;
        }

        int people = 0;
        int sum=0;
        int i = 1;
        while (i<numV+1) {
            LinkedList.Node node = list[i].head;
            while (node != null) {
                if (node.data == 1) {
                    ++people;
                }

                if (people==graph.numV-1)
                    sum++;

                node=node.NextNode;
            }
            people=0;
            ++i;
        }

        return sum;
    }
}