import java.util.*;

public class Graph {

    private Vertex[] vertices;
    private int numVertices;

    //Create new graph

    public Graph(int n) {
        numVertices = n;
        vertices = new Vertex[n];
        for (int i = 0; i < n; i++)
            vertices[i] = new Vertex(i);

    }

    public Vertex findVertex(int i) {
        return vertices[i];

    }

    public Vertex findClosest(Set<Vertex> unvisited) {
        Vertex closest = unvisited.iterator().next();
        int smallestDistance = Integer.MAX_VALUE;
        for (Vertex v : unvisited) {
            if (v.findSourceDistance() < smallestDistance) {
                closest = v;
                smallestDistance = v.findSourceDistance();
            }
        }
        return closest;

    }
    //Dijkstras algo
    public void bfs(int s, int e, List<String> wordList) {

        Set<Vertex> visited = new HashSet<>();
        Set<Vertex> unvisited = new HashSet<>();

        vertices[s].setPredecessor(-1);
        vertices[s].setSourceDistance(0);
        visited.add(vertices[s]);
        Vertex v = vertices[s];

        for (AdjListNode node : v.getAdjList()) {
            unvisited.add(vertices[node.getVertexIndex()]);
            vertices[node.getVertexIndex()].setPredecessor(v.findIndex());
            vertices[node.getVertexIndex()].setSourceDistance(node.getDistance());

        }

        while (!unvisited.isEmpty()) {
            v = findClosest(unvisited);

            for (AdjListNode node : v.getAdjList()) {
                if (!visited.contains(vertices[node.getVertexIndex()])) {
                    unvisited.add(vertices[node.getVertexIndex()]);

                }

                if (vertices[node.getVertexIndex()].findSourceDistance() > (v.sourceDistance + node.getDistance())) {
                    vertices[node.getVertexIndex()].setPredecessor(v.findIndex());
                    vertices[node.getVertexIndex()].setSourceDistance(v.sourceDistance + node.getDistance());

                }

                visited.add(vertices[v.findIndex()]);
                unvisited.remove(vertices[v.findIndex()]);

            }

            if (vertices[e].findSourceDistance() == Integer.MAX_VALUE) {
                System.out.print("Word Ladder: " + wordList.get(s) + " to " + wordList.get(e) + " cannot be done");
                return;
            }

            else {
                List<String> wordLadder = new ArrayList<String>();
                Vertex w = vertices[e];
                wordLadder.add(wordList.get(w.findIndex()));
                int i = w.findPredecessor();
                while (i!=-1) {
                    w = vertices[i];
                    wordLadder.add(wordList.get(w.findIndex()));
                    i = w.findPredecessor();

                }

                Collections.reverse(wordList);
                for(String word : wordLadder) {
                    System.out.println(word);

                }

                System.out.println("Shortest path algo result: " + vertices[e].sourceDistance);
                return;
            }
        }

    }
}
