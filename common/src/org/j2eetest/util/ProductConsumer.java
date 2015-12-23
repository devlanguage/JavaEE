package org.j2eetest.util;

import java.util.concurrent.Semaphore;

class ProductThread extends Thread {
    java.util.concurrent.Semaphore semaphore;

    public ProductThread(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        while (true) {
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Get:" + semaphore.availablePermits());
        }
    }
}

class ConsumerThread extends Thread {
    java.util.concurrent.Semaphore semaphore;

    public ConsumerThread(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {
        while (true) {
            // 2. P操作：
            // P操作等待信号量的值变为正数，而后减少信号量的值，并将此进程列入等待进程列表，阻塞当前进程
            semaphore.release();
            System.out.println("Release:" + semaphore.availablePermits());
        }
    }
}

public class ProductConsumer {
//    a. P操作：也称Down操作。等待信号量变为正数，而后减少信号量；
//    b. V操作：也称Up操作。增加信号量，唤醒等待队列中的进程。
    public static void main(String[] args) {
        int maxPermits = 10;
        boolean fair = true;
        java.util.concurrent.Semaphore semaphore = new Semaphore(maxPermits, fair);
        ProductThread p = new ProductThread(semaphore);
        ConsumerThread c = new ConsumerThread(semaphore);
        p.start();
        c.start();
    }
}
