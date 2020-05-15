package algos.DFS;

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
public class DirectedPathExist extends DepthFirstSearch {
    private Vertex target;
    private boolean isPath = false;
    private int componentCount;

    /**
     * Assumption: g is a DAG. If not, there is no guarantee concerning
     * the nature of the output.
     */
    public DirectedPathExist(Digraph g) {
        super(g);
    }

    @Override
    protected void additionalProcessing() {
        componentCount++;
    }


    @Override
    protected void processVertex(Vertex w) {
       if(componentCount == 0 && w.equals(target)) isPath = true;
    }

    public boolean reaches(Vertex u, Vertex v) {
        target = v;
        start(u);
        return isPath;
    }
}
