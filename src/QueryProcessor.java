import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Mahmoud A.Gawad on 25/03/2016.
 */
public class QueryProcessor implements Runnable{

    private int maxAbsoluteSeqno;
    private ShortestPathHelper spc;
    private Query query;
    private int queryAnswer;

    public QueryProcessor(HashMap<Integer, ArrayList<Edge>> graph){
        super();

        spc = new ShortestPathHelper();
        spc.setGraph(graph);
    }

    @Override
    public void run() {
        queryAnswer = spc.getShortestPath(query.getSrc(), query.getDest(), maxAbsoluteSeqno);
    }

    public int getQueryAnswer(){
        return queryAnswer;
    }

    public void setQuery(Query query) {
        this.query = query;
    }

    public void setGraph(HashMap<Integer, ArrayList<Edge>> graph) {
        spc.setGraph(graph);
    }

    public void setMaxAbsoluteSeqno(int seqno){
        maxAbsoluteSeqno = seqno;
    }

    public int getMaxAbsoluteSeqno() {
        return maxAbsoluteSeqno;
    }


}
