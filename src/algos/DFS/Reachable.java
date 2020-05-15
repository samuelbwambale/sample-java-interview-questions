package algos.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * This extension of DFS successfully outputs a topological ordering
 * as long as input graph is a DAG. If every vertex is reachable
 * from the starting vertex, the output will be a topological ordering
 * of the entire graph; if not, it will be a topological ordering
 * of all vertices in the graph that are reachable from the starting
 * vertex.  (As mentioned in the slides, this approach can be improved
 * so that all vertices are output in topologically sorted order.)
 * <p>
 * IMPLEMENT
 */
public class Reachable extends DepthFirstSearch {
    private boolean isPath = false;
    private int componentCount;
    private List<Vertex> vertsReachable;

    /**
     * Assumption: g is a DAG. If not, there is no guarantee concerning
     * the nature of the output.
     */
    public Reachable(Digraph g) {
        super(g);
        vertsReachable = new ArrayList<>();
    }

    @Override
    protected void additionalProcessing() {
        componentCount++;
    }


    @Override
    protected void processVertex(Vertex w) {
       if(componentCount == 0 ){
           vertsReachable.add(w);
       }
    }

    public List<Vertex> reachable(Vertex u) {
        start(u);
        return vertsReachable;
    }
}
