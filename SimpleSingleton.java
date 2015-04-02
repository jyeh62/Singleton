public class SimpleSingleton{
    private static final SimpleSingleton instance;

    static{
        System.out.println("SimpleSingleton static block");
        instance = new SimpleSingleton();        
    }

    
    private SimpleSingleton()
    {
        System.out.println("SimpleSingleton create");
    }

    public static SimpleSingleton getInstance(){
        return instance;
    }

}
