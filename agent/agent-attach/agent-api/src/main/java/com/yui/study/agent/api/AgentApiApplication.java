package com.yui.study.agent.api;


import com.sun.tools.attach.VirtualMachine;

/**
 * @author XuZhuohao
 * @date 2019/10/29
 */
public class AgentApiApplication {
    public static void main(String[] args) throws Exception {
        VirtualMachine vm = null;
        //agentjar路径
        String agentJarPath = "D:\\Projects\\noChange\\jvm\\agent\\agent-attach\\agent-tool\\target\\agent-tool-1.0-SNAPSHOT.jar";
        //目标JVM的进程ID（PID） cmd - jps
        String targetPid = "11468";
        vm = VirtualMachine.attach(targetPid);
        vm.loadAgent(agentJarPath, "This is Args to the Agent.");
        vm.detach();
    }
}
