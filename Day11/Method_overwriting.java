class Amazon2{
    void delivery(){
        System.out.println("product will be delivered");
    }
}

class StandardDelivery extends Amazon2 {
    void delivery(){
        System.out.println("product will be delivered in 5 days");
    }
}
class ExpressDelivery extends Amazon2 {
    void delivery(){
        System.out.println("product will be delivered in 2 days");
    }
}
class PrimeDelivery extends Amazon2 {
    void delivery(){
        System.out.println("product will be delivered in 1 days");
    }
}

public class Method_overwriting {
    public static void main(String[] arg){
        Amazon2 a;
        a=new Amazon2();
        a.delivery();
         a=new StandardDelivery();
        a.delivery();
         a=new ExpressDelivery();
        a.delivery();
         a=new PrimeDelivery();
        a.delivery();
    }
}