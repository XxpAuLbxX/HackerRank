import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the findShortest function below.

    /*
     * For the unweighted graph, <name>:
     *
     * 1. The number of nodes is <name>Nodes.
     * 2. The number of edges is <name>Edges.
     * 3. An edge exists between <name>From[i] to <name>To[i].
     * You don't have to do BFS for every node separately, you can do them all in once. 
     */
    
    static class Node {
        public long colour;
        public List<Integer> neighbours;
        public Node(long colour) {
            this.colour = colour;
            neighbours = new ArrayList<Integer>();
        }
    }

    static class Graph {
        Map<Integer, Node> nodes;
        Map<Long, List<Integer>> colours;
        public Graph(int len, int[] graphFrom, int[] graphTo, long[] ids) {
            nodes = new HashMap<Integer, Node>();
            colours = new HashMap<Long, List<Integer>>();
            // Initialize nodes and create colour list
            for(int i = 0; i < len; i++) {
                nodes.put(i+1, new Node(ids[i]));
                colours.putIfAbsent(ids[i], new ArrayList<Integer>());
                colours.get(ids[i]).add(i+1);
            }
            // Create node connections
            for(int i = 0; i < graphFrom.length; i++) {
                nodes.get(graphFrom[i]).neighbours.add(graphTo[i]);
                nodes.get(graphTo[i]).neighbours.add(graphFrom[i]);
            }
        }
    }

    static int findShortest(int graphNodes, int[] graphFrom, int[] graphTo, long[] ids, int val) {
        // Create graph with nodes
        Graph graph = new Graph(graphNodes, graphFrom, graphTo, ids);
        
        // If only 0 or 1 colours, no match
        if(graph.colours.get((long)val).size() < 2) {
            return -1;
        }
        
        // Mark which node visited and length
        int visited[][] = new int[graphNodes + 1][2]; 
  
        // Create a queue for BFS 
        LinkedList<Integer> queue = new LinkedList<Integer>(); 
  
        // Queue all nodes of target colour
        for(int n : graph.colours.get((long)val)) {
            visited[n][0] = n; // node visited
            visited[n][1] = 0; // length
            queue.add(n);
        }
  
        // BFS separately with each node of target colour
        while(queue.size() != 0) { 
            // Dequeue
            int s = queue.poll(); 
            System.out.print(s + ": " + visited[s][1] + ", "); 
  
            // Get all adjacent vertices of the target coloured nodes 
            // If a adjacent has not been visited, then mark it 
            // visited, increment length and enqueue it 
            for(int n : graph.nodes.get(s).neighbours) { 
                // Unvisited node
                if(visited[n][0] == 0) { 
                    visited[n][0] = visited[s][0];
                    visited[n][1] = visited[s][1] + 1; // increment length
                    queue.add(n); 
                // Collision with another node's BFS
                } else if(visited[n][0] != visited[s][0]) {
                    // Each BFS node length +1 for connection
                    int len = visited[n][1] + visited[s][1] + 1;
                    return len;
                }
            } 
        } 
        return -1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] graphNodesEdges = scanner.nextLine().split(" ");
        int graphNodes = Integer.parseInt(graphNodesEdges[0].trim());
        int graphEdges = Integer.parseInt(graphNodesEdges[1].trim());

        int[] graphFrom = new int[graphEdges];
        int[] graphTo = new int[graphEdges];

        for (int i = 0; i < graphEdges; i++) {
            String[] graphFromTo = scanner.nextLine().split(" ");
            graphFrom[i] = Integer.parseInt(graphFromTo[0].trim());
            graphTo[i] = Integer.parseInt(graphFromTo[1].trim());
        }

        long[] ids = new long[graphNodes];

        String[] idsItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < graphNodes; i++) {
            long idsItem = Long.parseLong(idsItems[i]);
            ids[i] = idsItem;
        }

        int val = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int ans = findShortest(graphNodes, graphFrom, graphTo, ids, val);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
