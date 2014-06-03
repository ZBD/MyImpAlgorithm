import java.util.HashMap;

class CacheNode {
	CacheNode younger;
	CacheNode older;
	int key, value;

	CacheNode(int k, int v) {
		key = k;
		value = v;
	}
}


public class LRUCache {
	private int capacity;
	private HashMap<Integer, CacheNode> cache;
	CacheNode oldest, youngest;


	public LRUCache(int capacity) {
		this.capacity = capacity;
		cache = new HashMap<Integer, CacheNode>();
	}

	public int get(int key) {
		if (cache.size() < 1)
			return -1;

		CacheNode node = cache.get(key);
		if (node != null) {
			if (node != youngest) {
				if (node != oldest) {
					node.younger.older = node.older;
					node.older.younger = node.younger;
					node.younger = null;
					node.older = youngest;
					youngest.younger = node;
					youngest = node;
				}
				else {
					node.younger.older = null;
					oldest = node.younger;
					node.younger = null;
					node.older = youngest;
					youngest.younger = node;
					youngest = node;
				}
			}
			return node.value;
		}
		else {
			return -1;
		}
	}

	public void set(int key, int value) {
		if (cache.size() < 1) {
			CacheNode newNode = new CacheNode(key, value);
			youngest = newNode;
			oldest = newNode;
			cache.put(key,newNode);
		}
		else {
			CacheNode node = cache.get(key);
			if (node != null) {
				node.value = value;
				get(key);
			} else {
				CacheNode newNode = new CacheNode(key, value);
				newNode.older = youngest;
				youngest.younger = newNode;
				youngest = newNode;
				cache.put(key, newNode);
				if (cache.size() > capacity) {
					cache.remove(oldest.key);
					oldest = oldest.younger;
					oldest.older = null;
				}
			}
		}
	}
	
}