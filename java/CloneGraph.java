import java.util.*;

class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;

	UndirectedGraphNode(int label) {
		this.label = label;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
}

public class CloneGraph {
	private Map<UndirectedGraphNode, UndirectedGraphNode> nodeMap;

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if (node == null) return null;

		nodeMap = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		return dfsCloneRec(node);
	}

	private UndirectedGraphNode dfsCloneRec(UndirectedGraphNode node) {
		UndirectedGraphNode cloneNode = nodeMap.get(node); 

		if (cloneNode == null) {
			//only clone the node when there is no map. Otherwise there will be stack overflow. Because a node can connected to itself.
			cloneNode = new UndirectedGraphNode(node.label);
			nodeMap.put(node,cloneNode);
			for (UndirectedGraphNode neighbor : node.neighbors) {
				cloneNode.neighbors.add(dfsCloneRec(neighbor));
			}
		}

		return cloneNode;
	}

	private UndirectedGraphNode bfsCloneIter(UndirectedGraphNode node) {
		Map<UndirectedGraphNode, UndirectedGraphNode> nodeMap = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
		Queue<UndirectedGraphNode> que = new ArrayDeque<UndirectedGraphNode>();
		UndirectedGraphNode cloned = new UndirectedGraphNode(node.label);
		nodeMap.put(node, cloned);

		do {
			UndirectedGraphNode cloneNode = nodeMap.get(node);
			for (UndirectedGraphNode neighbor : node.neighbors) {
				UndirectedGraphNode cloneNeighbor = nodeMap.get(neighbor);
				if (cloneNeighbor == null) {
					//new node need to clone and put into map
					cloneNeighbor = new UndirectedGraphNode(neighbor.label);
					nodeMap.put(neighbor, cloneNeighbor);
					que.offer(neighbor);
				}
				cloneNode.neighbors.add(cloneNeighbor);
			}
		} while (!que.isEmpty() && (node = que.poll()) != null);

		return cloned;
	}

}