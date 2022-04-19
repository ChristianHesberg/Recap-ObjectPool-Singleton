package dk.easv;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class ObjectPool {

    private static ObjectPool instance;
    private Queue<SlowObject> queue;
    private int amount = 2;
    private int counter = 0;

    private ObjectPool() {
        this.queue = new ArrayBlockingQueue<SlowObject>(amount);
    }

    public SlowObject acquire() throws InterruptedException {
        if(queue.isEmpty() && counter <= amount)
        {
            SlowObject slowObject = new SlowObject();
            queue.add(slowObject);
            counter++;
            Thread.sleep(10);
        }
        while(queue.isEmpty())
        {
            Thread.sleep(50);
        }
        return queue.remove();
    }

    public void release(SlowObject reusable)
    {
        queue.add(reusable);
    }

    public static ObjectPool getInstance() {
        if(instance == null)
        {
            instance = new ObjectPool();
        }
        return instance;
    }
}
