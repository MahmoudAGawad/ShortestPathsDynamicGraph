import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Mahmoud A.Gawad on 25/03/2016.
 */
public class ShortestPathHelper {

    private int maxSeqno;
    private HashMap<Integer, ArrayList<Edge>> graph;

    public void setGraph(HashMap<Integer, ArrayList<Edge>> graph){
        this.graph = graph;
        this.maxSeqno = 0;
    }


    public int getShortestPath(int src, int dest, int maxSeqno){
        this.maxSeqno = maxSeqno;
        return bfs(src, dest);
    }

    private int bfs(int src, int dest){

        if(src == dest){
            return 0;
        }

        Queue<Integer> queue = new LinkedList<>();
        HashMap<Integer, Boolean> visited = new HashMap<>();
        ArrayList<Edge> adjList;

        int distance = 0;
        queue.add(src);
        visited.put(src, true);

        while(!queue.isEmpty()){
            distance++;
            int curLevel = queue.size();

            while(curLevel-->0){
                Integer from = queue.poll();

                adjList = graph.get(from);

                for (Edge edge : adjList){



                    if(isValidEdge(visited, edge)) {

                        if (edge.getDest() == dest) {
                            return distance;
                        }

                        queue.add(edge.getDest());
                        visited.put(edge.getDest(), true);
                    }
                }
            }
        }

        return -1;
    }

    private boolean isValidEdge(HashMap<Integer, Boolean> visited, Edge edge){
        // Should check also if the current edge is included in the calculations with respect to maxSeqno.
        return !visited.containsKey(edge.getDest());
    }


}
