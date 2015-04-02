public class Singleton {
    private static class Helper{
        static Singleton mInstance = new Singleton();
        private Helper()
        {
            System.out.println("Helper create");
        }
    }

    private Singleton(){
        System.out.println("Singleton create");
    }

    public static Singleton getInstance(){
        return Helper.mInstance;
    }
}
