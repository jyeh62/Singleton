public class Singleton {
    //JVM에 의해 inner static class는 해당 class가 최초 사용 될 때
    //(아래 예에선 getInstance 호출시) load됨
    //따라서 getInstance동기화가 필요 없음(Initialization on Demand Holder)
    private static class Helper{ 
        static Singleton mInstance = new Singleton();
        private Helper()
        {
            System.out.println("Helper create");
        }
    }

    private Singleton(){
<<<<<<< HEAD
        System.out.println("Singleton create");
=======
        //생성자..
>>>>>>> c082df309f7f9f4d95f1d2bc7d9fc6484e65cf6b
    }

    public static Singleton getInstance(){
        return Helper.mInstance; 
    }
}
