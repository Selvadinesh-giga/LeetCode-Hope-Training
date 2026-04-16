import java.util.HashMap;

public class CacheNode {
    private HashMap<String, String> store;
    private int id;

    public CacheNode(int id) {
        this.id = id;
        this.store = new HashMap<>();
    }

    public void put(String key, String value) {
        store.put(key, value);
        System.out.println("Stored on Node " + id + ": " + key + " = " + value);
    }

    public String get(String key) {
        return store.get(key);
    }

    public int getId() {
        return id;
    }
}