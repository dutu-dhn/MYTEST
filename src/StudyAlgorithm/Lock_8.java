package StudyAlgorithm;

/**
 * @author dutu
 * @date 2021-04-16 10:21
 */
class Phone {
    public synchronized void sendSMS() throws Exception {
        System.out.println("------sendSMS");
    }

//    public static synchronized void sendSMS() throws Exception {
//        System.out.println("------sendSMS");
//    }

    public synchronized void sendEmail() throws Exception {
        System.out.println("------sendEmail");
    }

    public void getHello() {
        System.out.println("------getHello");
    }
}

public class Lock_8 {
    public static void main(String[] args) throws Exception {
        Phone phone = new Phone();
        Phone phone2 = new Phone();
        new Thread(() -> {
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "AA").start();
        Thread.sleep(100);
        new Thread(() -> {
            try {
                phone.sendEmail();
                //phone.getHello();
                //phone2.sendEmail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "BB").start();
    }
}