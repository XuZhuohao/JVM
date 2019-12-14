package com.yui.study.jvm.juc.problem;

/**
 * 线程可见性,使用 volatile 解决问题
 * @author XuZhuohao
 * @date 2019/12/13
 */
public class Visibility {

    public static void main(String[] args) {
        final VisibilityRunnable v1 = new VisibilityRunnable();
        new Thread(v1).start();
        while (!v1.flag){
        }
        System.out.println("==============");
    }
    static class VisibilityRunnable implements Runnable{
        /**
         * volatile
         */
        private boolean flag = false;

        @Override
        public void run() {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            flag = true;
            System.out.println("flag=" + flag);
        }
    }
}

