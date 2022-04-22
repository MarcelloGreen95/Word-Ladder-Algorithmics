import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {


    public static boolean isadjacent(String a, String b){
        int count = 0;
        int n = a.length();

        for (int i=0; i<n; i++){
            if (a.charAt(i) != b.charAt(i)) count ++;
            if (count > 1) return false;

        }

        return count == 1;
    }

    public static void main(String[] args) throws IOException {

        String inputFileName = args [0]; // dictionary
        String Word1 = args[1]; // first word
        String Word2 = args[2]; // second word

        FileReader reader = new FileReader(inputFileName);
        Scanner scanner = new Scanner(reader);

        //Read in data here

        List<String> wordList = new ArrayList<>();
        while (scanner.hasNext()){
            wordList.add(scanner.next());

        }
        reader.close();
        int numVertices = wordList.size();

        // create graph here

        Graph G = new Graph(numVertices);

        for (int i = 0; i < numVertices; i ++) {
            for (int j = 0; j < numVertices; j ++) {
                if (isadjacent(wordList.get(i), wordList.get(j)) && i !=j){
                    G.getVertex(i).addToAdjList(j);

                }
            }
        }

        System.out.println("size of dictionary: "+numVertices);
        System.out.println("start word: "+ Word1);
        System.out.println("end word: "+ Word2);
        long start = System.currentTimeMillis();

        G.bfs(wordList.indexOf(Word1), wordList.indexOf(Word2), wordList);
        long end = System.currentTimeMillis();
        System.out.println("elapsed time: " + (end - start) + " milliseconds");
    }

}
