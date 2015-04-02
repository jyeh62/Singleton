public class Singleton {
    //JVM에 의해 inner static class는 해당 class가 최초 사용 될 때
    //(아래 예에선 getInstance 호출시) load됨
    //따라서 getInstance동기화가 필요 없음(Initialization on Demand Holder)
    private static class Helper{ 
        static Singleton mInstance = new Singleton();
    }

    private Singleton(){
        //생성자..
    }

    public static Singleton getInstance(){
        return Helper.mInstance; 
    }
}
