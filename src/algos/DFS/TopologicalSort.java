package algos.DFS;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
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
public class TopologicalSort extends DepthFirstSearch {
    private Vertex[] sortedVertices;
    private Vertex startVertex = null;
    private int position;

    public Vertex getStartVertex() {
        return startVertex;
    }

    /**
     * Assumption: g is a DAG. If not, there is no guarantee concerning
     * the nature of the output.
     */
    public TopologicalSort(Digraph g) {
        super(g);
        computeTopStartVertex();
        sortedVertices = new Vertex[g.vertices.size()];
        position = sortedVertices.length - 1;

    }

    public List<Vertex> getTopologicalOrdering() {
        //warning: will return null until this class has been implemented!
        return Arrays.asList(sortedVertices);
    }

    @Override
    protected void processVertex(Vertex w) {
        sortedVertices[position] = w;
        position--;
    }

    /**
     * Finds, if possible, a vertex that has no in-vertices and sets this value
     * in startVertex
     * If not found, throws an IllegalStateException, indicating that
     * the input graph is not a DAG.
     */
    public void computeTopStartVertex() {
        HashMap<Vertex, LinkedList<Vertex>> inVertexMap = graph.inList;
        for (Vertex vertex : graph.vertices) {
            if (!inVertexMap.containsKey(vertex)) {
                startVertex = vertex;
                break;
            }
        }

        if (startVertex == null)
            throw new IllegalStateException("Graph is not DAG");
    }


}
