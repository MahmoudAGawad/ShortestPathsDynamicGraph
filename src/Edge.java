
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Mahmoud A.Gawad & Waleed Adel on 25/03/2016.
 */

public class Edge {

    private int src, dest;
    private LinkedList<Integer> modifications;

    public Edge(int src, int dest){
        this.src = src;
        this.dest = dest;
        this.modifications = new LinkedList<>();
    }

    public void addModification(int seqno){
        int last = modifications.isEmpty() ? seqno : modifications.pollLast();
        if(Math.abs(seqno) != Math.abs(last)){
            modifications.add(last);
        }
        if(modifications.size() == Main.CORES + 1){ // upper_bound
            modifications.pollFirst();
        }
        modifications.add(seqno);
    }


    @Override
    public boolean equals(Object o){
        Edge e = (Edge) o;
        return src == e.getSrc() && dest == e.getDest();
    }

    public int getSrc() {
        return src;
    }

    public int getDest() {
        return dest;
    }

    public LinkedList<Integer> getModifications() {
        return modifications;
    }
}
