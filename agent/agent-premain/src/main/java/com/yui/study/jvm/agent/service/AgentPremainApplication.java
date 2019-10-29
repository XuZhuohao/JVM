package com.yui.study.jvm.agent.service;

/**
 * @author XuZhuohao
 * @date 2019/10/29
 */
public class AgentPremainApplication {
    public static void main(String[] args) {
        System.out.println(AgentPremainApplication.class.getName() + " start");
    }

    /**
     * JVM能识别的premain方法接收的是字符串类型的参数，并非类似main方法的字符串数组
     * @param args 参数
     */
    public static void premain(String args) {
        System.out.println("premain");
    }
}
