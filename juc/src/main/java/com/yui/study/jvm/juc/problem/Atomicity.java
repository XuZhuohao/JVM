package com.yui.study.jvm.juc.problem;

import java.util.ArrayList;
import java.util.List;

/**
 * 线程原子性,
 * i++ -> i = i + 1; 分为取值，和赋值两个操作，操作间不具备有原子性
 * 使用 AtomicInteger 自增，内部有自旋锁来保证，操作的原子性
 *
 * @author XuZhuohao
 * @date 2019-12-14 10:52
 */
public class Atomicity {
    public static void main(String[] args) {
        /// i = i++ 输出为什么是 0？
        /*int i = 0;
        i = i++; // i++ temp = i; i= i+1; i = temp;
        System.out.println(i);*/
        AtomicityRunnable atomicity = new AtomicityRunnable();
        List<Thread> threads= new ArrayList<>();
        for (int i =0 ; i < 1000; i++){
            Thread e = new Thread(atomicity);
            threads.add(e);
            e.start();
        }
        threads.forEach(temp -> {
            try {
                temp.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(atomicity.getI());
    }

    static class AtomicityRunnable implements Runnable{
        private int i = 0;
//        private AtomicInteger i = new AtomicInteger(0);
        @Override
        public void run() {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            increment();
        }

        public void increment(){
            i++;
//            i.getAndIncrement();
        }

        public int getI() {
            return i;
//            return i.get();
        }
    }

}
