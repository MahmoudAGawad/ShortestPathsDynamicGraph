import java.util.ArrayList;

public class Main {

    final static int CORES;
    static{
        CORES = Runtime.getRuntime().availableProcessors();
    }

    private ArrayList<ArrayList<Edge>> graph;

    public static void main(String[] args) {

    }


    private void readInput(){


    }

    private void readBatch(){

    }

    private void processBatch(){
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
