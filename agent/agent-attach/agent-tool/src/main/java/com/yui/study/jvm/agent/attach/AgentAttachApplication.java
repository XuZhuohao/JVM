package com.yui.study.jvm.agent.attach;

import java.lang.instrument.Instrumentation;

/**
 * @author XuZhuohao
 * @date 2019/10/29
 */
public class AgentAttachApplication {
    public static void agentmain(String args) {
        System.out.println("agentmain");
    }
    public static void agentmain(String args, Instrumentation inst) throws Exception {
        System.out.println("Args:" + args);
    }
}
