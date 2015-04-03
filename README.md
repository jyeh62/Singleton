singleton 
1. 개념적인 방법
public class Singleton{
    private static Singleton mInstance;

    private Singleton(){
    }

    public static Singleton getInstance(){
        if(mInstance == null){
            mInstance = new Singleton();
        }
        return mInstance;
    }
}
멀티 쓰레드 환경에서 취약함

2. double checked locked
멀티 쓰레드 환경을 고려해 동기화(synchronized) 블럭 사용, 동기화 블럭 안에서 instance 생성 중에 메모리 할당를 받아 mInstance는 더이상 null이 아니게 된다. 그때 다른 쓰레드가 getInstance 를 호출 할 경우..null도 아니면서 정상적이지 않는 instance가 리턴된다.
public class Singleton{
    private static Singleton mInstance;

    private Singleton(){
    }

    public static Singleton getInstance(){
        if(mInstance == null){
            synchronized(this) {
                if(mInstance == null){
                    mInstance = new Singleton();
                }
            }
        }
        return mInstance;
    }
}

3. Initialization on Demand Holder
getInstance를 최초 호출 하는 순간에만 초기화(new Singleton)이 실행됨. 따라서 동시에 getInstance를 호출해도 한개의 instance가 유지됨 

public final class Singleton{
    private static final class SingletonHolder{
        static final Singleton INSTANCE = new Singleton();
    }

    private Singeton(){
    }

    public static Singleton getInstance(){
        return SingletonHolder.INSTANCE;
    }
}

4. simple
3번과 유사한 컨셉. static 블럭은 한번만 실행되기 때문에 멀티 쓰레드에서도 OK. 다만 특정 경우 문제가 발생되었다고 보고됨(생성자의 일부 코드들이 항상 실행되지 않는 문제..)

public class Singleton {   
   private static final Singleton _theInstance = new Singleton();
 
   private Singleton() {
   }
   
   public static Singleton getInstance() {
      return _theInstance;
   }
  }


  결론..
  1. 3번째 방법이 현재까지는 가장 완벽하다고 알려져 있으며  성능도 좋음. 다만 자바에서만 보장되는 내용임.
  2. singleton 성능(instance 갯수 보장, 속도)에 대해서 테스트 하는 방법은..뭘까..