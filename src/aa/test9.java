package aa;

public class test9 {
    static Object obj = new Object();
    public static void main(String[] args) throws InterruptedException {
        Thread a = new Bathing(obj);
        a.start();
        Thread.sleep(100);
//        a.join(100);
        synchronized (obj) {
            obj.wait();
        }
        System.out.println("B can bath");
    }
    static class Bathing extends Thread{
        Object obj;
        Bathing(Object obj){
            this.obj = obj;
        }
        public void run(){
            try {
                bathing();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        private void bathing() throws InterruptedException {
            System.out.println("A is bathing");
            synchronized (obj){
                try {
                    obj.wait();
//                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                obj.notify();
            }

            System.out.println("A has bathed");
        }
    }
}
