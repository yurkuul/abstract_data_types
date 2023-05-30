public class Graph {
    public static void main(String[] args) {
        int[][] matrix1 = {{0,1,1},
                           {1,0,1},
                           {1,1,0}};
        
        int[][] matrix2 = {{0,1,0},
                           {0,0,1},
                           {1,0,0}};

        TheGraph graph1 = new TheGraph(matrix1);
        TheGraph graph2 = new TheGraph(matrix2);

        System.out.println("Checking for directed graphs:");
        System.out.println(graph1.isDirected());
        System.out.println(graph2.isDirected());

        System.out.println(); //Line Break

        System.out.println("Counting edges:");
        System.out.println(graph1.countEdges());
        System.out.println(graph2.countEdges());
    }
}

class TheGraph {
    private int[][] adjMatrix;

    public TheGraph( int[][] am ) {
        adjMatrix = am;
    } // end constructor

    /**
     * Determines if the graph is directed. The graph is directed if two
     * specific vertexes only connect one way, but not the other way around.
     * A graph is undirected if the matrix is symmetrical, and directed if the
     * matrix is asymmetrical.
     * 
     * @return true if graph is directed, false if undirected.
     */
    public boolean isDirected(){
        boolean isDirected = false;
        for (int i = 0; i < adjMatrix.length; i++) { //row
            for (int j = i; j < adjMatrix[0].length; j++) { //column
                if (adjMatrix[i][j] != adjMatrix[j][i]) { //not symmetrical
                    isDirected = true;
                    i = adjMatrix.length + 1; //break loop
                    j = adjMatrix[0].length + 1;
                }
            }
        }
        return isDirected;
    }
    /**
     * Counts the number of edges in a graph, taking into account if the graph
     * is undirected or directed.
     * 
     * For undirected: Number of edges = Number of edges / 2
     * For directed: Number of edges = Number of directed connections between vertices
     * 
     * @return The number of edges in the graph.
     */
    public int countEdges(){
        int numEdges = 0;

        for (int i = 0; i < adjMatrix.length; i++) {
            for (int j = 0; j < adjMatrix[i].length; j++) {
                if (adjMatrix[i][j] > 0) {
                    numEdges++;
                }
            }
        }

        if (!isDirected()) { //undirected graph.
            numEdges = numEdges / 2;
        }

        return numEdges;
    }

    public int getNumEdgesIn(int vertex){
        int numEdgesIn = 0;
        for (int i = 0; i < adjMatrix.length; i++) {
            if (adjMatrix[i][vertex] > 1) {
                numEdgesIn++;
            }
        }
        return numEdgesIn;
    }

    public int getNumEdgesOut(int vertex){
        int numEdgesOut = 0;
        for (int i = 0; i < adjMatrix[0].length; i++) {
            if (adjMatrix[vertex][i] > 1) {
                numEdgesOut++;
            }
        }
        return numEdgesOut;
    }
}