package dijkstra;

import java.util.*;

public class DijkstraAlgorithm {
	DijkstraVertex vertex;
	DijkstraEdge[] edges;
	ArrayList<DijkstraVertex> list = new ArrayList<DijkstraVertex>();

	public DijkstraAlgorithm(DijkstraVertex[] vertices, DijkstraEdge[] edges) {
		this.edges = edges;	
		for (int i = 0; i < vertices.length; i++) {
			list.add(vertices[i]);
		}
	}

	public void getShortestPath(DijkstraVertex from, DijkstraVertex to) {
		while (from.getDefineVertex() == false) {
			setPoint(from);
			for (int i = 0; i < edges.length; i++) {
				if (from.equals(edges[i].getFrom()) && from.getFrom() != (edges[i].getTo())) {
					if (from.getTotal() + edges[i].getWeight() < edges[i].getTo().getTotal()) {
						edges[i].getTo().setTotal(from.getTotal() + edges[i].getWeight());
						edges[i].getTo().setFrom(from);
					}
				}
			}
			from.setDefineVertex();
			from = movePoint(from, to);
		}
	}

	public int setPoint(DijkstraVertex from) {
		if (from.getTotal() == (int)Double.POSITIVE_INFINITY || from.getTotal() < 0) {
			from.setTotal(0);
		}
		return from.getTotal();
	}

	public DijkstraVertex movePoint(DijkstraVertex from, DijkstraVertex to) {
		DijkstraVertex movePoint = from;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getDefineVertex() == false) {
				movePoint = list.get(i);
				break;
			}
		}
		for (int j = 0; j < list.size(); j++) {
			if (list.get(j).getDefineVertex() == false) {
				if (list.get(j).getTotal() < movePoint.getTotal()) {
					movePoint = list.get(j);
				}
			}
		}

		return movePoint;
	}

	public void printShortestPath(DijkstraVertex from, DijkstraVertex to) {
		System.out.println("Shortest distance (" + from.getVertex() + " ... " + to.getVertex() + ") : " + to.getTotal());
	}

	public ArrayList<DijkstraVertex> setList(DijkstraVertex from, DijkstraVertex to) {
		list.add(0, to);

		while (to != null) {
			list.add(0, to);
			to = to.getFrom();
		}	
		return list;
	}
}
