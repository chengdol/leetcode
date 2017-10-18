boolean fire = false;
Queue<cb_t> que = new LinkedList<>();

class Mechanism
{

    public void register_callback(cb_t cb)
    {
        if (!fire)
        {
            que.offer(cb)
            return;
        }

        // 这部分后加
        while (!que.isEmpty())
        {
            run(que.poll());
        }
        run(cb);

    }

    public void event_fired()
    {
        synchronized(que)
        {
            while (!que.isEmpty())
            {
                run(que.poll());
            }
        }

        fire = true;
    }
}

// race conditions:
// before set fire = true, another thread call register_acllback(cb), when stuck in queue
// never be executed

// synchronized keywords or block
// I don't think this can cause deadlock, 4 necessary condition:
1. mutual exclusion
2. hold and wait or resource holding
3. no preemption
4. circular wait

// fire event once， after fire, no need to do synchronization, we shoud execute
// threads concurrently, to run(cb)

// no need lock at all
