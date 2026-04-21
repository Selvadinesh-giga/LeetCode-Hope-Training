class Data1{
    int a = 10;
}

class D1 extends Data1{
    void display(){
        System.out.println(a);
    }
}

public class Super_demo1 {
    public static void main(String[] args){
        D1 d = new D1();
        d.display();
    }
}