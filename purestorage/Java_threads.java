// java threads operations



public class ThreadTest
{
    private static int a = 10;

    public static void main(String[] args)
    {

        SubThread1 t1 = new SubThread1(10, 0);
        SubThread1 t2 = new SubThread1(10, 0);

        t1.start();


        synchronized (t1)
        {
            try {
                t1.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("thread-0 " + t1.total);
        }

        t2.start();
        synchronized (t2)
        {
            try {
                t2.wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println("thread-1 " +t2.total);
        }
//
//
        Runnable r1 = new SubThread2();
        new Thread(r1, "Runnable-thread").start();

        Runnable r2 = () -> System.out.println("this thread from lambda runnable creation");
        new Thread(r2).start();

        Runnable r3 = ()-> {
            for (int i = 0; i < a; i++)
            {

            }
        };
        new Thread(r3).start();

        System.out.println(Thread.currentThread().isAlive());
    }

    private static synchronized void getId()
    {
        System.out.println(a++);
    }

}



class SubThread1 extends Thread
{
    int cnt;
    int total;

    SubThread1(int cnt, int s)
    {
        this.cnt = cnt;
        this.total = s;
    }

    public void run()
    {
        synchronized (this)
        {
            System.out.println("this thread is from " + Thread.currentThread().getName() + "!");
            for (int i = 0; i <= cnt; i++)
            {
                try {
                    Thread.sleep(200);
                    total += i;
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                System.out.println(i);
            }
            this.notify();
        }
        while (true) { System.out.println(Thread.currentThread().getName() + " done!"); try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }}
    }

    public int getTotal()
    {
        return total;
    }
}

class SubThread2 implements Runnable
{
    // other field

    public void run()
    {
        System.out.println("this thread is from " + Thread.currentThread().getName() + "!");
    }
}
