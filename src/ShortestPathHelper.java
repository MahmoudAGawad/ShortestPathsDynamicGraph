import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Mahmoud A.Gawad && Waleed Adel on 25/03/2016.
 */
public class ShortestPathHelper implements Runnable{

    private int src, dest, maxSeqno, result;
    private HashMap<Integer, ArrayList<Edge>> graph;

    public ShortestPathHelper(HashMap<Integer, ArrayList<Edge>> graph, int src, int dest,int maxSeqno){
        this.graph = graph;
        this.src = src;
        this.dest = dest;
        this.maxSeqno = maxSeqno;
        this.result = -2;
    }

    @Override
    public void run(){
        result = bfs();
    }

    public int getShortestPath(){
        return result;
    }

    private int bfs(){

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

                if(graph.containsKey(from)) {
                    adjList = graph.get(from);

                    for (Edge edge : adjList) {

                        if (isValidEdge(visited, edge)) {

                            if (edge.getDest() == dest) {
                                return distance;
                            }

                            queue.add(edge.getDest());
                            visited.put(edge.getDest(), true);
                        }
                    }
                }
            }
        }

        return -1;
    }

    private boolean isValidEdge(HashMap<Integer, Boolean> visited, Edge edge){

        LinkedList<Integer> modifications = edge.getModifications();
        int lastSeqno = 0;
        boolean flag = false;

        for(Integer seqno : modifications){
            if(Math.abs(seqno) <= maxSeqno){
                flag = true;
                lastSeqno = seqno;
            }
        }

        return !visited.containsKey(edge.getDest()) && (flag&&lastSeqno >= 0);
    }

}
