package util;

public class GraphNode {
	
	public int value;
	public NodeState state;
	
	public GraphNode(int value){
		this.value = value;
		this.state = NodeState.Unvisited;
	}

}
