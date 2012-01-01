package graph;

public class DijkstraTest {

	/**
	 * @param argsa
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DijkstraVertex a = new DijkstraVertex("a");
		DijkstraVertex b = new DijkstraVertex("b");
		DijkstraVertex c = new DijkstraVertex("c");
		DijkstraVertex d = new DijkstraVertex("d");
		DijkstraVertex e = new DijkstraVertex("e");
		DijkstraVertex f = new DijkstraVertex("f");
		
		DijkstraEdge[] eges = {
				new DijkstraEdge(a, b, 5),
				new DijkstraEdge(a, c, 4),
				new DijkstraEdge(b, c, 2),
				new DijkstraEdge(d, c, 3),
				new DijkstraEdge(d, e, 6),
				new DijkstraEdge(c, e, 2),
				new DijkstraEdge(b, f, 6),
				new DijkstraEdge(e, f, 4),
				new DijkstraEdge(b, a, 5),
				new DijkstraEdge(c, a, 4),
				new DijkstraEdge(c, b, 2),
				new DijkstraEdge(c, d, 3),
				new DijkstraEdge(e, d, 6),
				new DijkstraEdge(e, c, 2),
				new DijkstraEdge(f, b, 6),
				new DijkstraEdge(f, e, 4),
		};
		
		DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(eges);
		dijkstra.getShortestPath(a, f);
		dijkstra.printShortestPath(a, f);
		
	}
}
