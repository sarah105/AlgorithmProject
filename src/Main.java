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
        Vector<Integer>adj = graph.getAdj("1");
        for(int i = 0 ; i < adj.size(); i++)
            System.out.print(adj.get(i)+" ");
    }
}
