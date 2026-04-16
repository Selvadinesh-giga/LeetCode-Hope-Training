public class Main {
    public static void main(String[] args) {

        DistributedCache cache = new DistributedCache(3);

        cache.put("A", "Apple");
        cache.put("B", "Banana");
        cache.put("C", "Cat");

        System.out.println("\nFetching Values:");
        System.out.println("A → " + cache.get("A"));
        System.out.println("B → " + cache.get("B"));
        System.out.println("C → " + cache.get("C"));
    }
}