

class Driver1{
    String name;
    Driver1(String name){//2
        this.name=name;//3
    }
    void drive(){//10
        System.out.println("Driver came.");//11
    }
}

class Car1{
    Driver1 d;
    Car1(Driver1 d){//5
        this.d=d;//6
    }
    void start(){//8
        d.drive();//9
        System.out.println("Car has been started.");//12
    }
}

class Aggregation {
    public static void main(String[] args){
        Driver1 d = new Driver1("John");//1
        Car1 c = new Car1(d);//4
        c.start();//7
    }
}