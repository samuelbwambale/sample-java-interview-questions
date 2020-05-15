package algos.BFS;

public class IsConnected extends BreadthFirstSearch {
	public IsConnected(Graph graph) {
		super(graph);
	}
	private int count = 0;
	@Override
	protected void additionalProcessing() {
		count++;
	}

	public boolean isConnected()
	{
		start();
		return count == 1;
	}

	public int getCount() {
		return count;
	}
}
