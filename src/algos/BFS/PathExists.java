package algos.BFS;

public class PathExists extends BreadthFirstSearch {
	private Boolean doesPathExist;
	private Vertex searchVertex;
	public PathExists(Graph graph) {
		super(graph);
	}
	protected void processVertex(Vertex v)
	{
		if(v.equals(searchVertex) && doesPathExist == null)
		{
			doesPathExist = true;
		}
	}

	@Override
	protected void additionalProcessing() {
		if(doesPathExist == null || !doesPathExist)
		{
			doesPathExist = false;
		}
	}

	public boolean pathExists(Vertex u, Vertex v) {
		searchVertex = v;
		start(u);
		return doesPathExist == null ? false : doesPathExist;
	}
}

