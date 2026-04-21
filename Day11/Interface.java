
interface Mom{
    void hs();
}

interface Dad{
    void business();
}

class child implements Mom, Dad{
    @Override
    public void hs(){
        System.out.println("I will do Engineering.");
    }
    
    @Override
    public void business(){
        System.out.println("I will do MBA.");
    }
}

public class Interface {
    public static void main(String[] args){
        child John = new child();
        John.hs();
        John.business();
    }
}