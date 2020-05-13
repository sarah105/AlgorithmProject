import java.util.Scanner;
import java.util.Vector;

public class Main {
    public  static Scanner input = new Scanner(System.in);
    public static void main(String[] arg){
        String vertixName;
        Graph graph;
        Vector <String> vertices = new Vector<>();
        System.out.print("Enter num of vertices : ");
        int verticesNumber = input.nextInt();
        for (int i = 0; i < verticesNumber; i++) {
            System.out.print("Enter name of vertex " + (i + 1) + " : ");
            vertixName = input.next();
            vertices.add(vertixName);
        }
        graph = new Graph(vertices);
        System.out.print("Enter num of Edge :");
        int numEdge = input.nextInt();
        for(int i = 0 ; i < numEdge ; i++) {
            System.out.print("Enter Initial Vertex : ");
            String initial = input.next();
            System.out.print("Enter Terminal  Vertex :");
            String terminal = input.next();
            System.out.print("Enter weight :");
            int weight = input.nextInt();
            graph.addEdge( initial, terminal,weight);
        }
        graph.print();
        Vector<Edge>edges = graph.getEdges();
        for(int i = 0 ; i < edges.size() ; i++)
            System.out.println(edges.get(i).initial+" "+edges.get(i).terminate+" "+edges.get(i).weight);


        ShortestPath t = new ShortestPath(graph.vertexNum,graph.vertices);
        t.dijkstra(graph.mat,0);

        maximumFlow maximumFlow = new maximumFlow(graph);
        System.out.print("start: ");
        String start = input.next();
        System.out.print("end: ");
        String end = input.next();
        System.out.println(maximumFlow.fordFulkerson(start,end));

    }
}
/*
7
a 1 2 3 4 5 b
a 1 3
a 2 3
1 3 4
2 3 6
2 5 1
3 4 2
3 5 2
4 b 5
5 b 3
a b
res = 5
 */
/*
6
s v w u z t
10
s v 6
s w 3
s u 5
v w 2
v t 3
u w 1
u z 2
w t 7
w z 9
z t 5
s t
res = 11
 */
/*
4
s 1 2 t
5
s 1 3
s 2 2
1 2 5
1 t 2
2 t 3
res = 5
 */