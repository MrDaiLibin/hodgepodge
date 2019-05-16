package com.awakeee.hodgepodge.thread.semaphore;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

//信号量 是一个线程同步结构，用于在线程间传递信号，以避免线程中出现信号丢失
//信号量常用场景：比方购买火车票，现在有五个窗口，十个人，那么一次最多同时可以处理五个人，另外五个人将处于等待状态
//下面到例子中，十个人排队买票，但是每次最多只能处理三个人，后面的人必须等待前面的人处理完后，才能继续处理
public class SemaphoreBounded {

    private int signal = 0;

    private int bound = 0;

    protected SemaphoreBounded(int bound) {
        this.bound = bound;
    }

    public SemaphoreBounded() {
    }

    public synchronized void take() throws InterruptedException {
        while (signal == bound) {
            wait();
        }
        signal++;
        notify();
    }


    public synchronized void release() throws InterruptedException {
        while (signal == 0) {
            wait();
        }
        signal--;
        notify();
    }

    public synchronized boolean availablePermits(){
        if(signal == bound){
            return false;
        }
        return true;
    }


    public int getSignal() {
        return signal;
    }

    public int getBound() {
        return bound;
    }

    @Test
    public void test() throws InterruptedException {
        SemaphoreBounded semaphore = new SemaphoreBounded(3);
        List<Thread> threadList = new ArrayList<>();
        for(int i=1;i<10;i++){
            Thread thread = new Thread(new process(semaphore),"第"+i+"个人");
            threadList.add(thread);
            thread.start();
        }
        for(Thread thread : threadList){
            thread.join();
        }

    }

    class process implements Runnable{

        private SemaphoreBounded semaphoreBounded;

        public process(SemaphoreBounded semaphoreBounded) {
            this.semaphoreBounded = semaphoreBounded;
        }

        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            boolean availablePermits = semaphoreBounded.availablePermits();
            if(availablePermits){
                System.out.println(name + "无人，可用");
            }else {
                System.out.println(name + "有人，请排队。。");
            }

            try {
                semaphoreBounded.take();
                System.out.println(name + "轮到我了");
                Thread.sleep(1000);
                System.out.println(name + "使用完毕");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                try {
                    semaphoreBounded.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}