package chapter4;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import util.Graph;
import util.GraphNode;
import util.NodeState;

/***
 * 
 * Given a directed graph, design an algorithm to find out 
 * whether there is a route between two nodes.
 *
 */
public class Question2 {

	public static boolean checkPathExists(Graph g, GraphNode start, GraphNode end) {
		
		List<GraphNode> visitingList = new ArrayList<GraphNode>();
		visitingList.add(start);
			
		while (!visitingList.isEmpty()) {
			GraphNode current = visitingList.remove(0);
			current.state = NodeState.Visited;
			
			if (current == end) { 
				return true;
			} else {
				List<GraphNode> connections = g.getNodeConnections(current);

				List<GraphNode> unvisitedConnections = new ArrayList<GraphNode>();
				
				for (GraphNode n : connections) {
					if (n.state == NodeState.Unvisited) {
						unvisitedConnections.add(n);
					}
				}
				
				visitingList.addAll(unvisitedConnections);
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		
		
		GraphNode a = new GraphNode(1);
		GraphNode b = new GraphNode(2);
		GraphNode c = new GraphNode(3);
		GraphNode d = new GraphNode(4);
		GraphNode e = new GraphNode(5);
		GraphNode f = new GraphNode(6);
		
		Hashtable<GraphNode,GraphNode[]> nodeConnections = new Hashtable<GraphNode, GraphNode[]>();
		
		nodeConnections.put(a, new GraphNode[]{b,c});
		nodeConnections.put(b, new GraphNode[]{c,e});
		nodeConnections.put(c, new GraphNode[]{});
		nodeConnections.put(d, new GraphNode[]{e});
		nodeConnections.put(e, new GraphNode[]{f});
		nodeConnections.put(f, new GraphNode[]{});
		
		Graph g = new Graph(nodeConnections);
		System.out.println(checkPathExists(g, a, d));
	}

}
