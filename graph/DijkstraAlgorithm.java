package graph;

import java.util.*;

public class DijkstraAlgorithm {
	DijkstraVertex vertex;
	DijkstraEdge[] edges;

	public DijkstraAlgorithm(DijkstraEdge[] edges) {
		this.edges = edges;
	}

	public void getShortestPath(DijkstraVertex from, DijkstraVertex to) {
		setPoint(from);

		if (from != to) {
			for (int i = 0; i < edges.length; i++) {
				if (from.equals(edges[i].getFrom()) && from.getFrom() != (edges[i].getTo())) {
					if (from.getTotal() + edges[i].getWeight() < edges[i].getTo().getTotal()) {
						edges[i].getTo().setTotal(from.getTotal() + edges[i].getWeight());
						edges[i].getTo().setFrom(from);
					}
				}
			}
			getShortestPath(movePoint(from), to);
		}
	}

	public int setPoint(DijkstraVertex from) {
		if (from.getTotal() == (int)Double.POSITIVE_INFINITY || from.getTotal() < 0) {
			from.setTotal(0);
		}
		return from.getTotal();
	}

	public DijkstraVertex movePoint(DijkstraVertex from) {
		int currentTotal = from.getTotal();
		DijkstraVertex movePoint = from;
		movePoint.setTotal((int)Double.POSITIVE_INFINITY);

		for (int i = 0; i < edges.length; i++) {
			if (currentTotal < edges[i].getTo().getTotal() && edges[i].getTo().getTotal() < movePoint.getTotal() && from.getFrom() != edges[i].getTo()) {
				movePoint = edges[i].getTo();
			}
		}
		return movePoint;
	}

	
	ArrayList<DijkstraVertex> list = new ArrayList<DijkstraVertex>();
	
	public void printShortestPath(DijkstraVertex from, DijkstraVertex to) {
		list = setList(from, to);

		System.out.println("ç≈íZåoòH(" + from.getVertex() + " ÅÀ " + to.getVertex() + ") : " + to.getTotal());
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.remove(i).getVertex() + " ");
		}
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
