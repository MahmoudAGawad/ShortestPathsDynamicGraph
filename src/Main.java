import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main{

    final static int CORES;
    private int seqno;
    static{
        CORES = Runtime.getRuntime().availableProcessors();
    }

    private HashMap<Integer, ArrayList<Edge>> graph;
    private Input input;




    public Main() throws IOException {

        input = new Input();

        graph = input.readInput();
        seqno = 1;

        System.out.println("R");
        while(true){
            ArrayList<Query> batch = input.readBatch();
            processBatch(batch);
        }
    }

    public static void main(String[] args) throws IOException {
        new Main();
    }


    private void processBatch(ArrayList<Query> batch){


        ArrayList<Query> queries = new ArrayList<>();

        for(Query query : batch){
            if(queries.size() == CORES){
                processRound(queries);
                queries.clear();
            }

            switch(query.getType()){
                case Query.TYPE_ADD:
                    processAdd(query);
                    break;
                case Query.TYPE_REMOVE:
                    processRemove(query);
                    break;
                case Query.TYPE_QUERY:
                    query.setSeqno(seqno);
                    queries.add(query);
                    seqno++;
                    break;
            }

        }

        if(!queries.isEmpty()){
            processRound(queries);
        }
        System.out.println("#Batch Finished");

    /* tasks:
		1. Add edge.
      2. remove edge.
      3. round run.



        // initiallt seqno = 1;
        {add // add positive entry to edge.modification with current seqno.
                q // run thread with seqno then seqno++;
            remove // add negative entry to edge.modification with current seqno.
                    q // run thread with seqno then seqno++;
            remove // add negative entry to edge.modification with current seqno.
                    add  // if adding same edge that removed before so we override the modification
            q
                    q
        }// end round
        { // begin next round.
            q
                    add
            q
                    .
            .
            .
        }

        for (every 4 queries) do

       */

    }


    /**
     1. check if new node.
     2. compress modification record in edge if found.
     3. else add new entry in edge's modification queue.
     */
    private void processAdd(Query q){

        int src = q.getSrc();
        int dest = q.getDest();

        Edge e = new Edge(src, dest);

        if(!graph.containsKey(src)){ // new node

            ArrayList<Edge> adjList = new ArrayList<Edge>();
            e.addModification(seqno);
            adjList.add(e);
            graph.put(src, adjList);

        }

        else if (graph.get(src).contains(e)){  // we must add comparable to Edge class
            // there exists an old edge between the src,dst
            int idxOfObject= graph.get(src).indexOf(e);
            Edge oldEdge= graph.get(src).get(idxOfObject);
            oldEdge.addModification (seqno);
        }else{			// two nodes exist but without edge yet

            e.addModification(seqno);
            graph.get(src).add(e);

        }

        // get edge swa2 kan mawgood aw hat-create wa7ed

        // edge.addModification(seqno);


    }

  /*
  * if the edge doesn't exist
  * if edge exists and contains oldModification then compress modification
  * else if edge exists add new entry in edge's queue modification
  */

    private void processRemove(Query q){

        int src = q.getSrc();
        int dest = q.getDest();
        Edge e = new Edge(src, dest);

        if( graph.containsKey(src) && graph.get(src).contains(e) ){ // edge exists let's see if it has history or not

            int idxOfObject= graph.get(src).indexOf(e);
            Edge oldEdge= graph.get(src).get(idxOfObject);
            oldEdge.addModification(-1*seqno);

        }


    }

    private void processRound(ArrayList<Query> queries){
        ExecutorService executor = Executors.newFixedThreadPool(CORES);
        List<ShortestPathHelper> tasks = new ArrayList<>();
        for(Query query : queries){
            ShortestPathHelper task = new ShortestPathHelper(graph, query.getSrc(), query.getDest(), query.getSeqno());
            tasks.add(task);
            executor.execute(task);
        }

        executor.shutdown();

        while(!executor.isTerminated());

        for(ShortestPathHelper task : tasks){
            System.out.println(task.getShortestPath());
        }
    }

}