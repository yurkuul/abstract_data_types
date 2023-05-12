public class Graph {
    public static void main(String[] args) {
        int[][] matrix1 = {{0,1,1},
                           {1,0,1},
                           {1,1,0}};
        
        int[][] matrix2 = {{0,1,0},
                           {0,0,1},
                           {1,0,0}};

        Graph graph1 = new Graph(matrix1);
        Graph graph2 = new Graph(matrix2);

        System.out.println("Checking for directed graphs:");
        System.out.println(graph1.isDirected());
        System.out.println(graph2.isDirected());

        System.out.println(); //Line Break

        System.out.println("Counting edges:");
        System.out.println(graph1.countEdges());
        System.out.println(graph2.countEdges());
    }
}