import java.util.LinkedList;

public class Vertex {

    private LinkedList<AdjListNode> adjList;
    private int Index;

    boolean visited;
    int predecessor;

    //Create new Vertex

    public Vertex(int n) {

        adjList = new LinkedList<AdjListNode>();
        Index = n;
        visited = false;

    }

    public LinkedList<AdjListNode> getAdjList() {
        return adjList;
    }

    public int getIndex() {
        return Index;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean b) {
        visited = b;
    }

    public int getPredecessor() {
        return predecessor;
    }

    public void setPredecessor(int n) {
        predecessor = n;
    }

    public void addToAdjList(int n) {
        adjList.addLast(new AdjListNode(n));
    }

}
