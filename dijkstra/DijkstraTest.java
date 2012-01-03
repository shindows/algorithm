package dijkstra;

public class DijkstraTest {

	/**
	 * @param argsa
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DijkstraVertex[] vertices = {
				new DijkstraVertex("a"),
				new DijkstraVertex("b"),
				new DijkstraVertex("c"),
				new DijkstraVertex("d"),
				new DijkstraVertex("e"),
				new DijkstraVertex("f"),
		};
		
		DijkstraVertex a = vertices[0];
		DijkstraVertex b = vertices[1];
		DijkstraVertex c = vertices[2];
		DijkstraVertex d = vertices[3];
		DijkstraVertex e = vertices[4];
		DijkstraVertex f = vertices[5];
		
		DijkstraEdge[] eges = {
				new DijkstraEdge(a, b, 5),
				new DijkstraEdge(b, a, 5),
				new DijkstraEdge(a, c, 4),
				new DijkstraEdge(c, a, 4),
				new DijkstraEdge(a, d, 2),
				new DijkstraEdge(d, a, 2),
				new DijkstraEdge(b, c, 2),
				new DijkstraEdge(c, b, 2),
				new DijkstraEdge(c, d, 3),
				new DijkstraEdge(d, c, 3),
				new DijkstraEdge(d, e, 6),
				new DijkstraEdge(e, d, 6),
				new DijkstraEdge(c, e, 2),
				new DijkstraEdge(e, c, 2),
				new DijkstraEdge(b, f, 6),
				new DijkstraEdge(f, b, 6),
				new DijkstraEdge(f, e, 4),
				new DijkstraEdge(e, f, 4),
		};
		
		DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(vertices, eges);
		dijkstra.getShortestPath(e, b);
		dijkstra.printShortestPath(e, b);
		
	}
}
