class worker
{
    worker(f)
    {
        // ... f is function
    }

    start(callback)
    {
        // run f then callback
    }
}

class multiworker
{
    static Queue<f> que = new LinkedList<>();

    mulitworker()
    {}

    insert(f)
    {}

    start(callback)
    {
        // create thread to execute function in queue?
        // 注意，是所有函数考开始执行，不是执行结束后再执行callback
        int i = 0;
        FunThread[] arr = new FunThread[que.size()];
        while (!que.isEmpty())
        {
            f fun = que.poll();
            // create new thread with fun f which implements runnable interface
            FunThread[i] = new FunThread(f);
            FunThread[i++].start();
        }

        // join these threads(这是执行结束后)

        // thread 创建后不一定执行的！不知道什么时候执行
        // check thread state, runnable, a thread executing in JVM -----> busy waiting
        // should use
        synchronized (this)
        {
            // loop FunThread[i];
            t1.wait();
            t2.wait();
            t3.wait();
            // ...
        }
        run(callback);
        // then execute callback?
    }
}


// synchronized keyword or block

