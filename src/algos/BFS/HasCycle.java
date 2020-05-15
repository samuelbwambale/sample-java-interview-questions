package algos.BFS;

import java.util.ArrayList;

public class HasCycle extends BreadthFirstSearch {
  private ArrayList<Edge> tree = new ArrayList<Edge>();
  public HasCycle(Graph graph) {
    super(graph);
  }

  protected void processEdge(Edge e) {
    tree.add(e);
  }

  public boolean hasCycle() {
    start();
    return this.graph.edges.size() > tree.size();
  }
}

