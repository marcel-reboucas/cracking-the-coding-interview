package util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;

public class Graph {

	Hashtable<GraphNode, GraphNode[]> nodeConnections;

	public Graph(Hashtable<GraphNode, GraphNode[]> nodeConnections) {
		this.nodeConnections = nodeConnections;
	}

	public List<GraphNode> getNodes() {
		return new ArrayList<GraphNode>(nodeConnections.keySet());
	}

	public List<GraphNode> getNodeConnections(GraphNode n) {
		return new ArrayList<GraphNode>(Arrays.asList(nodeConnections.get(n)));
	}
}
