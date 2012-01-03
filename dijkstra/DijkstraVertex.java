package dijkstra;

public class DijkstraVertex {
	private String vertex;
	private DijkstraVertex from;
	private int total;
	private boolean defineVertex = false;
	
	public DijkstraVertex(String vertex) {
		this.vertex = vertex;
		this.from = null;
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
	
	public void setDefineVertex() {
		this.defineVertex = true;
	}
	
	public boolean getDefineVertex() {
		return defineVertex;
	}
}
