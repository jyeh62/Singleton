public class Singleton {
    private static class Helper{
        static Singleton mInstance = new Singleton();
    }

    private Singleton(){
    }

    public static Singleton getInstance(){
        return Helper.mInstance;
    }
}
