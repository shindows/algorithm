package graph;

public class DijkstraVertex {
	private String vertex;
	private DijkstraVertex from;
	private int total;

	public DijkstraVertex(String vertex) {
		this.vertex = vertex;
		this.from = null;
		this.total = (int) Double.POSITIVE_INFINITY;
	}

	
	public DijkstraVertex(String vertex, DijkstraVertex from) {
		this.vertex = vertex;
		this.from = from;
		this.total = (int) Double.POSITIVE_INFINITY;
	}
	
	public void setVertex(String vertex) {
		this.vertex = vertex;
	}
	
	
	public String getVertex() {
		return vertex;
	}
	
	
	public void setFrom(DijkstraVertex from) {
		this.from = from;
	}
	
	public DijkstraVertex getFrom() {
		return from;
	}
	
	public void setTotal(int total) {
		this.total = total;
	}
	
	public int getTotal() {
		return total;
	}
}
