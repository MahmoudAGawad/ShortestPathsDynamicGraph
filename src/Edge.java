import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Mahmoud A.Gawad on 25/03/2016.
 */

public class Edge {

    private int src, dest;
    private Queue<Integer> modification;

    public Edge(int src, int dest){
        this.src = src;
        this.dest = dest;
        modification = new LinkedList<>();
        modification.add(0);
    }

    public void addModification(){

    }

    public void removeModification(){

    }

    public int getSrc() {
        return src;
    }

    public int getDest() {
        return dest;
    }
}
