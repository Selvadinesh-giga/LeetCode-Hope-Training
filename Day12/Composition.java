class Engine2{
    void on(){
        System.out.println("Engine has been turned on.");
    }

}

class Car2{
    Engine2 e;
    Car2(){
        e = new Engine2();
    }
    void start(){
        e.on();
        System.out.println("The car has been started.");
    }
}

public class Composition {
    public static void main(String[] args){
        Car2 Audi = new Car2();
        Audi.start();
    }
}