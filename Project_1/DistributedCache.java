public class DistributedCache {
    private CacheNode[] nodes;

    public DistributedCache(int numberOfNodes) {
        nodes = new CacheNode[numberOfNodes];
        for (int i = 0; i < numberOfNodes; i++) {
            nodes[i] = new CacheNode(i);
        }
    }

    // Simple logic: choose node based on hash % nodeCount
    private CacheNode getNode(String key) {
        int index = Math.abs(key.hashCode()) % nodes.length;
        return nodes[index];
    }

    public void put(String key, String value) {
        CacheNode node = getNode(key);
        node.put(key, value);
    }

    public String get(String key) {
        CacheNode node = getNode(key);
        return node.get(key);
    }
}