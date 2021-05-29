package test;

/**
 * @author dutu
 * @date 2021-05-17 15:56
 */
public class M2 {

}

class Singleton{
    private Singleton singleton;

    public Singleton getInstance(){
        if (singleton == null){
            synchronized (Singleton.class){
                if (singleton == null){
                    return new Singleton();
                }
            }
        }
        return singleton;
    }
}

class Singleton1{
    




}