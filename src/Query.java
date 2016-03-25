/**
 * Created by Mahmoud A.Gawad on 25/03/2016.
 */
public class Query {

    final static int TYPE_ADD    = 1;
    final static int TYPE_REMOVE = 2;
    final static int TYPE_QUERY  = 3;

    private int src, dest;
    private int type;
    private int seqno;

    public void setSrc(int src) {
        this.src = src;
    }

    public void setDest(int dest) {
        this.dest = dest;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setSeqno(int seqno) {
        this.seqno = seqno;
    }

    public int getSrc() {
        return src;
    }

    public int getDest() {
        return dest;
    }

    public int getType() {
        return type;
    }

    public int getSeqno() {
        return seqno;
    }
}
