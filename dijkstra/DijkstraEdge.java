package dijkstra;

public class DijkstraEdge {
	private DijkstraVertex from;
	private DijkstraVertex to;
	private int weight;
	
	public DijkstraEdge(DijkstraVertex from, DijkstraVertex to, int weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
	
	public void setFrom(DijkstraVertex from) {
		this.from = from;
	}
	
	public DijkstraVertex getFrom() {
		return from;
	}
	
	public void setTo(DijkstraVertex to) {
		this.to= to;
	}
	
	public DijkstraVertex getTo() {
		return to;
	}
	
	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public int getWeight() {
		return weight;
	}
}
