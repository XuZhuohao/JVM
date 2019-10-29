package com.yui.study.jvm.agent.demo;

import java.util.concurrent.TimeUnit;

/**
 * @author XuZhuohao
 * @date 2019/10/29
 */
public class AgentDemoApplication {
    public static void main(String[] args) throws InterruptedException {
        // -javaagent:agent-premain-1.0-SNAPSHOT.jar
        for (String arg : args) {
            System.out.println(arg);
        }
        System.out.println(AgentDemoApplication.class.getName() + " start!");
        TimeUnit.MINUTES.sleep(60);
    }
}
