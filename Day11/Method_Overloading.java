 class Amazon1 {
    
    void search(String product){
        System.out.println("product: "+product);
    }
    void search(String product, int price){
        System.out.println("product: " + product + " | price: " + price);
    }
    void search(String product, String category){
        System.out.println("product: " + product + " | category: " + category);
    }
}

class Method_overloading{
    public static void main(String args[]){
        Amazon1 s1 = new Amazon1();
        s1.search("laptop");
        s1.search("Phone", 10000);
        s1.search("Headphones", "Wired");
    }
}