package io.github.qxqrose;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author: qiu
 * 2021/9/19
 */
public class MyLock extends AbstractQueuedSynchronizer {

    public void lock() {
        // 尝试加锁
        if (compareAndSetState(0, 1)) {
            // 设置成功， 说明当前没有线程获得这把锁
            setExclusiveOwnerThread(Thread.currentThread());
        } else {
            acquire(1);
        }
    }

    public void unlock() {
        release(1);
    }

    /**
     * 尝试获取锁
     * @param arg
     * @return true if acquire success, else false
     */
    @Override
    protected boolean tryAcquire(int arg) {
//        return super.tryAcquire(arg);
        final Thread current = Thread.currentThread();
        int c = getState();
        // 0 表示为 锁还空闲
        if (c == 0) {
            // 设置状态为 1
            if (compareAndSetState(0, 1)) {
                // 当前线程独占锁
                setExclusiveOwnerThread(current);
                return true;
            }
        } else if (current == getExclusiveOwnerThread()) {
            // 当前线程 直接设置
            setState(1);
            return true;
        }

        return false;
    }

    @Override
    public boolean tryRelease(int releases) {
        if (Thread.currentThread() != getExclusiveOwnerThread())
            throw new IllegalMonitorStateException();
        boolean free = false;
        if (getState() == 1) {
            free = true;
            setExclusiveOwnerThread(null);
            setState(0);
        }
        return free;
    }
}
