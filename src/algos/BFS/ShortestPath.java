package algos.BFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShortestPath extends BreadthFirstSearch {
  private HashMap<Vertex, Integer> levelsMap = new HashMap<Vertex, Integer>();
  private HashMap<Vertex, Vertex> parentMap = new HashMap<Vertex, Vertex>();

  /**
   * Assumes g is connected
   */
  public ShortestPath(Graph g) {
    super(g);

  }

  @Override
  protected void processEdge(Edge e) {
    super.processEdge(e);
    parentMap.put(e.u, e.v);
    levelsMap.put(e.u, levelsMap.get(e.v) + 1);
  }

  public List<Vertex> shortestPath(Vertex u, Vertex v){
    List<Vertex> shortestPath = new ArrayList<>();
    if(v.equals(u)){
      return shortestPath;
    }
    parentMap.put(u, u);
    levelsMap.put(u, 0);
    start(u);
    shortestPath.add(u);
    shortestPath.add(v);
    return shortestPath;
  }

}
