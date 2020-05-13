import java.util.Vector;

class Edge {
    String initial;
    String terminate;
    int weight;
    Edge(String initial, String terminate, int weight){
        this.initial = initial;
        this.terminate = terminate;
        this.weight = weight;
    }
}

public class Graph {
    Vector<String> vertices;
    int mat[][];
    int vertexNum ;

    public Graph(Vector <String> vertices){
        vertexNum = vertices.size();
        this.vertices = new Vector<>();
        mat = new int[vertexNum][vertexNum];
        builtMatrix();
        for ( int i = 0 ; i < vertexNum ; i++)
            this.vertices.add(vertices.get(i));
    }

    public Graph(Graph graph){
        this.copy(graph);
    }

    public void addEdge(String initialVertex , String terminalVertex,int weight){
        int init = vertices.indexOf(initialVertex);
        int ter = vertices.indexOf(terminalVertex);
        mat[init][ter] = weight;
    }

    public Vector<Edge> getEdges() {
        Vector <Edge> edges = new Vector<>();
        for(int i = 0 ; i < vertexNum ; i++){
            for (int j = 0 ; j < vertexNum ; j++){
                if(mat[i][j] > 0){
                    edges.add(new Edge(vertices.get(i),vertices.get(j),mat[i][j]));
                }
            }
        }
        return edges;
    }

    public Vector<String> getVertices() {
        return vertices;
    }

    public int[][] getMat(){
        return mat;
    }

    public Vector<Integer> getAdj(int row){
        //int row = vertices.indexOf(vertex);
        Vector <Integer> res = new Vector<>();
        for ( int i = 0 ; i < vertexNum ; i++){
            if(mat[row][i] > 0)
                res.add(i);
        }
        return res;
    }

    private void builtMatrix(){
        for(int i = 0 ; i < vertexNum ; i++)
            for(int j = 0 ; j < vertexNum ; j++)
                mat[i][j] = 0;
    }

    void print(){
        for(int i = 0 ; i < vertexNum ; i++){
            System.out.print(vertices.get(i)+ ": ");
            for (int j = 0 ; j < vertexNum ; j++){
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void copy(Graph graph){
        vertexNum = graph.vertexNum;
        vertices = new Vector<>();
        for(int i = 0 ; i < vertexNum ; i++)
            vertices.add(graph.getVertices().get(i));
        mat = new int[vertexNum][vertexNum];
        for(int i = 0 ; i < vertexNum ; i++)
            for(int j = 0 ; j < vertexNum ; j++)
                mat[i][j] = graph.getMat()[i][j];
    }

}
