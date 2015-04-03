public class SingletonTest{
    final static double PI;
    static{
        PI = 3.1415;
        int i;
        for(i=0; i<5; i++){
            System.out.println(i);
        }
    }

    {
        System.out.println(PI);
    }
    public SingletonTest(){
        SimpleSingleton simple;
        System.out.println("Singleton Test create");
    }
    
    public static void main(String args[]){
        System.out.println("test start");
        SingletonTest st = new SingletonTest();        
        
        SimpleSingleton mSimple = SimpleSingleton.getInstance();
        Singleton mSingle = Singleton.getInstance();       
        
    }
}
