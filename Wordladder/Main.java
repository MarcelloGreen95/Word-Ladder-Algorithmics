import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    //Determine word proximity
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

        String inputFileName = args [0];
        String startWord = args[1];
        String endWord = args[2];
        FileReader reader = new FileReader(inputFileName);
        Scanner scanner = new Scanner(reader);

        //Function to add all words to List

        List<String> wordList = new ArrayList<>();
        while (scanner.hasNext()){
            wordList.add(scanner.next());

        }
        reader.close();
        int numVertices = wordList.size();

        //Graph from input file

        Graph G = new Graph(numVertices);

        for (int i = 0; i < numVertices; i ++) {
            for (int j = 0; j < numVertices; j ++) {
                if (isadjacent(wordList.get(i), wordList.get(j)) && i !=j){
                    G.getVertex(i).addToAdjList(j);

                }
            }
        }

        System.out.println("size of dictionary: "+numVertices);
        System.out.println("start word: "+ startWord);
        System.out.println("end word: "+ endWord);
        long start = System.nanoTime();

        G.bfs(wordList.indexOf(startWord), wordList.indexOf(endWord), wordList);
        long end = System.currentTimeMillis();
        System.out.println("elapsed time: " + (end - start) + " milliseconds");
    }

}
