import java.util.LinkedList;

public class Vertex {

    private LinkedList<AdjListNode> adjList;
    private int index;


    boolean visited;
    int predecessor;

    public int findSourceDistance() {
        return sourceDistance;
    }

    public void setSourceDistance(int sourceDistance) {
        this.sourceDistance = sourceDistance;
    }

    int sourceDistance = Integer.MAX_VALUE;

    public Vertex(int n) {
        adjList = new LinkedList<AdjListNode>();
        index = n;
        visited = false;

    }

    public LinkedList<AdjListNode> getAdjList() {
        return adjList;

    }

    public int findIndex() {
        return index;

    }

    public boolean findVisited() {
        return visited;

    }

    public void setVisited(boolean b) {
        visited = b;

    }

    public int findPredecessor() {
        return predecessor;

    }

    public void setPredecessor(int n) {
        predecessor = n;

    }

    public void addToAdjList(int j, int distance) {
    }

    // public void addToAdjList(int n, int d) {
        //adjList.addlast(new AdjListNode(n,d));
   // }

}
