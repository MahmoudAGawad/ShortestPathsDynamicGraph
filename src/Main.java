import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main{

    final static int CORES;
    static{
        CORES = Runtime.getRuntime().availableProcessors();
    }

    private HashMap<Integer, ArrayList<Edge>> graph;

    public Main(){



        readInput();

        System.out.println("R");

        while(true){
            ArrayList<Query> batch = readBatch();
            processBatch(batch);
        }
    }

    public static void main(String[] args) {
        new Main();
    }


    private void readInput(){

    }

    private ArrayList<Query> readBatch(){
        return new ArrayList<Query>();
    }

    private void processBatch(ArrayList<Query> batch){
//        ExecutorService executor = Executors.newFixedThreadPool(CORES);

        
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

    private void processAdd(){

    }

    private void processRemove(){

    }

    private void processRound(){

    }

}
