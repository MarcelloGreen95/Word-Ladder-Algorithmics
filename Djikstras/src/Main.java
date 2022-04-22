import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static int distance(String x, String y) {
        int Length_x = 0;
        int Length_y = 0;
        int n = x.length();
        for (int i = 0; i < n;i++){
            Length_x += x.charAt(i);
            Length_y += y.charAt(i);
        }
        return Math.abs(Length_x = Length_y);

    }

    public static boolean isAdjacent(String x, String y) {
        int count =0;
        int n = x.length();

        for (int i=0; i<n; i++) {
            if(x.charAt(i) != y.charAt(i)) count++;
            if (count > 1) return false;

        }
        return count ==1;

    }

    public static void main(String[] args) throws IOException {

        String inputFileName = args[0]; // dictionary
        String Word1 = args[1]; // first word
        String Word2 = args[2]; // second word

        FileReader reader = new FileReader(inputFileName);
        Scanner scanner = new Scanner(reader);
        // read in the data here
        List<String> wordList = new ArrayList<>();
        while (scanner.hasNext()) {
            wordList.add(scanner.next());

        }
        reader.close();
        int numVertices = wordList.size();


        // create graph here
        Graph G = new Graph(numVertices);
        for (int i = 0; i < numVertices; i++) {
            for (int j =0; j < numVertices; j++) {
                if (isAdjacent(wordList.get(i), wordList.get(j)) && i != j) {
                    G.findVertex(i).addToAdjList(j, (distance(wordList.get(i), wordList.get(j))));
                }
            }
        }

        System.out.println("size of dictionary: "+numVertices);
        System.out.println("start word: "+ Word1);
        System.out.println("end word: "+ Word2);
        long start = System.currentTimeMillis();




        // end timer and print total time
        G.bfs(wordList.indexOf(Word1), wordList.indexOf(Word2), wordList);
        long end = System.currentTimeMillis();
        System.out.println("\nElapsed time: " + (end - start) + " milliseconds");
    }
}