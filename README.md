singleton 
1. �������� ���
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
��Ƽ ������ ȯ�濡�� �����

2. double checked locked
��Ƽ ������ ȯ���� ����� ����ȭ(synchronized) �� ���, ����ȭ �� �ȿ��� instance ���� �߿� �޸� �Ҵ縦 �޾� mInstance�� ���̻� null�� �ƴϰ� �ȴ�. �׶� �ٸ� �����尡 getInstance �� ȣ�� �� ���..null�� �ƴϸ鼭 ���������� �ʴ� instance�� ���ϵȴ�.
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
getInstance�� ���� ȣ�� �ϴ� �������� �ʱ�ȭ(new Singleton)�� �����. ���� ���ÿ� getInstance�� ȣ���ص� �Ѱ��� instance�� ������ 

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
3���� ������ ����. static ���� �ѹ��� ����Ǳ� ������ ��Ƽ �����忡���� OK. �ٸ� Ư�� ��� ������ �߻��Ǿ��ٰ� �����(�������� �Ϻ� �ڵ���� �׻� ������� �ʴ� ����..)

public class Singleton {   
   private static final Singleton _theInstance = new Singleton();
 
   private Singleton() {
   }
   
   public static Singleton getInstance() {
      return _theInstance;
   }
  }


  ���..
  1. 3��° ����� ��������� ���� �Ϻ��ϴٰ� �˷��� ������  ���ɵ� ����. �ٸ� �ڹٿ����� ����Ǵ� ������.
  2. singleton ����(instance ���� ����, �ӵ�)�� ���ؼ� �׽�Ʈ �ϴ� �����..����..