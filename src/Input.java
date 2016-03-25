import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by wido on 3/25/2016.
 */


public class Input {

    private BufferedReader br;

    public Input(){
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public  HashMap<Integer,ArrayList<Edge>> readInput() throws IOException {

        HashMap<Integer,ArrayList<Edge>> graph= new HashMap<>();

        String line = "";
        while ((line = br.readLine()) != null && !line.equals("S") ){

            String [] parameters= line.split(" ");
            int src= Integer.parseInt(parameters[0]);
            int dst=Integer.parseInt(parameters[1]);
            Edge edge=new Edge(src,dst);
            edge.addModification(0);

            if(graph.containsKey(src)){
                graph.get(src).add(edge);  // not sure
            }
            else{
                ArrayList<Edge> neighbours=new ArrayList<>();
                neighbours.add(edge);
                graph.put(src,neighbours);
            }
        }

        return graph;
    }



    public  ArrayList<Query> readBatch() throws IOException {

        ArrayList<Query> batchCommands=new ArrayList<>();
        String line = "";
        while ((line = br.readLine()) != null && !line.equals("F") ) {
            String[] parameters = line.split(" ");
            String type = parameters[0];
            int src = Integer.parseInt(parameters[1]);
            int dst = Integer.parseInt(parameters[2]);
            Query q=new Query();
            q.setSrc(src); q.setDest(dst);
            switch (type) {
                case "Q":
                    q.setType(Query.TYPE_QUERY);
                    break;
                case "A":
                    q.setType(Query.TYPE_ADD);
                    break;
                case "D":
                    q.setType(Query.TYPE_REMOVE);
                    break;
            }
            batchCommands.add(q);
        }

        return batchCommands;
    }



}
