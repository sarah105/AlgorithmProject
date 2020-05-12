import java.lang.*;
import java.util.Vector;

public class ShortestPath {
    int vertexNum ;
    int[] distance;
    Vector<String> vertexNames;
    int src;


    int findMinDist(int[] dist, Boolean[] sptSet)
    {
        int minimum = Integer.MAX_VALUE, minIndex = -1;

        for (int i = 0; i < vertexNum; i++)
            if (!sptSet[i] && dist[i] <= minimum) {
                minimum = dist[i];
                minIndex = i;
            }

        return minIndex;
    }

    ShortestPath(int vertexNum, Vector<String> vertexNames){
        this.vertexNum = vertexNum;
        this.vertexNames = vertexNames;
    }
    ShortestPath(){}

    void printDijkstra(int[] dist)
    {
        System.out.println("Vertex \t\t Distance from "+ vertexNames.get(src));
        for (int i = 0; i < vertexNum; i++)
            System.out.println(vertexNames.get(i) + " \t\t\t\t " + dist[i]);
    }


    int[] dijkstra(int[][] graphMatrix, int src)
    {
        distance = new int[vertexNum];
        this.src = src;
        Boolean[] spSet = new Boolean[vertexNum];

        for (int i = 0; i < vertexNum; i++) {
            distance[i] = Integer.MAX_VALUE;
            spSet[i] = false;
        }

        distance[src] = 0;

        for (int c = 0; c < vertexNum - 1; c++) {
            int i = findMinDist(distance, spSet);
            spSet[i] = true;
            for (int j = 0; j < vertexNum; j++) {
                if (!spSet[j] && graphMatrix[i][j] != 0 && distance[i] + graphMatrix[i][j] < distance[j] && distance[i] != Integer.MAX_VALUE )
                    distance[j] = distance[i] + graphMatrix[i][j];

            }
        }

        for (int i = 0; i < vertexNum; i++) {
            if (distance[i] == Integer.MAX_VALUE)
                distance[i] = -1;
        }

        printDijkstra(distance);
        return  distance;
    }


}
