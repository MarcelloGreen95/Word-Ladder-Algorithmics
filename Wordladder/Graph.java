import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

// class for graph using the adjacency lists

public class Graph {

    private Vertex[] vertices;
    private int numVertices = 0;

    public Graph(int n) {
        numVertices = n;
        vertices = new Vertex[n];
        for (int i = 0; i < n; i ++)
            vertices[i] = new Vertex(i);

    }

    public int size() {
        return numVertices;

    }

    public Vertex getVertex(int i) {
        return vertices[i];

    }

    //search from first word until end word or until all nodes are visited

    public void bfs(int s, int e, List<String> wordList) {

        for (Vertex v : vertices) v.setVisited(false);
        LinkedList<Vertex> queue = new LinkedList<Vertex>();

        Vertex v = vertices[s];
        v.setVisited(true);
        v.setPredecessor(v.findIndex());
        queue.add(v);

        while (!queue.isEmpty()) {
            Vertex u = queue.remove();
            LinkedList<AdjListNode> list = u.getAdjList();

            for (AdjListNode node : list) {
                Vertex w = vertices[node.getVertexIndex()];

                if (!w.isVisited()) { // if vertex isn't visited
                    w.setVisited(true);
                    w.setPredecessor(u.findIndex());
                    queue.add(w); //add to queue

                    List<String> wordLadder = new ArrayList<String>(); // store path start to end

                    if (w.findIndex() == e) { //target reached

                        wordLadder.add(wordList.get(w.findIndex()));
                        int i = w.findPredecessor();

                        while (i != s) {
                            wordLadder.add(wordList.get(i));
                            i = vertices[i].findPredecessor();

                        }

                        wordLadder.add(wordList.get(s));
                        Collections.reverse(wordLadder);
                        for (String word : wordLadder) {
                            System.out.println(word);

                        }

                        System.out.println("Smallest ladder length " + wordLadder.size());
                        return;

                    }

                }

            }
        }
        System.out.println("Ladder from " + wordList.get(s) + "to " + wordList.get(e) + " this action isn't possible");
        return;
    }

}
